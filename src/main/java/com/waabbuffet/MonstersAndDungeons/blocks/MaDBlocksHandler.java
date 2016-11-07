package com.waabbuffet.MonstersAndDungeons.blocks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ImageBufferDownload;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.waabbuffet.MonstersAndDungeons.blocks.dungeonBuilder.BlockExit;
import com.waabbuffet.MonstersAndDungeons.blocks.dungeonBuilder.GenBlocks.GenBlockStairs;
import com.waabbuffet.MonstersAndDungeons.client.ClientProxy;
import com.waabbuffet.MonstersAndDungeons.proxy.CommonProxy;
import com.waabbuffet.MonstersAndDungeons.util.Reference;



public class MaDBlocksHandler {

	public static Block BlockExit;

	public static List<Block> genBlocks = new ArrayList<Block>();

	public static void init()
	{
		BlockExit = new BlockExit().setUnlocalizedName("BlockExit");			
	}

	public static void register()
	{		
		GameRegistry.registerBlock(BlockExit, BlockExit.getUnlocalizedName().substring(5));	

		for(int i  = 0; i < genBlocks.size() ; i ++)
		{
			GameRegistry.registerBlock(genBlocks.get(i), genBlocks.get(i).getUnlocalizedName().substring(5));
		}
	}

	public static void registerRenders()
	{
		registerRender(BlockExit);

		for(int i  = 0; i < genBlocks.size() ; i ++)
		{
			registerRender(genBlocks.get(i));	
		}
	}



	public static void registerRender(Block block)
	{

		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MODID +":" + item.getUnlocalizedName().substring(5),"inventory"));

	}
	
	public static void genBlocks(String Directory) throws IOException 
	{
		ZipFile zipDirectory = new ZipFile(Directory + "/Monster and Dungeons/madresources.zip");

		Enumeration <? extends ZipEntry > enumeration = zipDirectory.entries();

		while (enumeration.hasMoreElements()) 
		{
			ZipEntry entry = (ZipEntry)enumeration.nextElement();

			if(entry != null)
			{
				if(entry.getName().contains("/textures"))
				{
					if(entry.getName().endsWith(".png"))
					{

						if(hasModel(entry.getName().substring(35, entry.getName().length()- 4), zipDirectory, Directory + "/Monster and Dungeons/madresources.zip")) //checks to see if a model is located else loads a default value
						{

							Block block = new Block(Material.CLOTH).setUnlocalizedName(entry.getName().substring(35, entry.getName().length()- 4)).setCreativeTab(CreativeTabs.DECORATIONS);
							BlockStairs block_stairs = new GenBlockStairs(block.getDefaultState());
							block_stairs.setUnlocalizedName(entry.getName().substring(35, entry.getName().length()- 4)).setCreativeTab(CreativeTabs.DECORATIONS);

							//	genBlocks.add(block);
							genBlocks.add(block_stairs);
						}
					}
				}
			}
		}

		zipDirectory.close();
	}

	private static boolean hasModel(String name, ZipFile zipDirectory, String directory) throws IOException
	{
		Enumeration <? extends ZipEntry > enumeration = zipDirectory.entries();
	
		boolean needsBlockState = true, needsModel = true;

		while (enumeration.hasMoreElements()) 
		{
			ZipEntry entry = (ZipEntry)enumeration.nextElement();

			if(entry != null)
			{
				if(entry.getName().contains(name))
				{
					if(entry.getName().contains("/blockstates"))
					{
						needsBlockState = false;

					}
					else
						if(entry.getName().contains("/models"))
						{
							needsModel = false;
						}
				}
			}
		}

		if(needsBlockState)
		{
			File f = new File(directory);
			StringBuilder sb = new StringBuilder();
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(f));

			ZipEntry newEntry = new ZipEntry("assets/" + Reference.MOD_ID_GenBlocks + "/blockstates/" + name + ".json");
			out.putNextEntry(newEntry);

			if(name.contains("_stairs"))
			{
				String blockstatejsonFile = Reference.genBlock_Stairs_Blockstate;

				blockstatejsonFile = blockstatejsonFile.replace("oak_stairs", Reference.MOD_ID_GenBlocks + ":" +name);
				blockstatejsonFile = blockstatejsonFile.replace("oak_outer_stairs", Reference.MOD_ID_GenBlocks + ":" +name + "_outer");
				blockstatejsonFile = blockstatejsonFile.replace("oak_inner_stairs", Reference.MOD_ID_GenBlocks + ":" +name + "_inner");

				sb.append(blockstatejsonFile);

				byte[] data = sb.toString().getBytes();
				out.write(data, 0, data.length);
				out.closeEntry();


			}else if(name.contains("_slab"))
			{

			}else
			{

			}
			if(needsModel)
			{

				ZipEntry newEntry1 = new ZipEntry("assets/" + Reference.MOD_ID_GenBlocks + "/models/block/" + name + ".json");
				out.putNextEntry(newEntry1);

				if(name.contains("_stairs"))
				{
					String stairreg = Reference.genBlocks_Stairs_model_reg;
					String stairInner = Reference.genBlocks_Stairs_model_inner;
					String stairOuter = Reference.genBlocks_Stairs_model_outer;

					StringBuilder sb1 = new StringBuilder();
					StringBuilder sb2 = new StringBuilder();
					StringBuilder sb3 = new StringBuilder();

					ZipEntry newEntryInner = new ZipEntry("assets/" + Reference.MOD_ID_GenBlocks + "/models/block/" + name + "_inner" + ".json");
					ZipEntry newEntryOuter = new ZipEntry("assets/" + Reference.MOD_ID_GenBlocks + "/models/block/" + name + "_outer" +".json");

					stairreg = stairreg.replace("blocks/planks_oak", Reference.MOD_ID_GenBlocks + ":" + name);
					sb1.append(stairreg);

					stairInner = stairInner.replace("blocks/planks_oak", Reference.MOD_ID_GenBlocks + ":" + name);
					sb2.append(stairInner);

					stairOuter = stairOuter.replace("blocks/planks_oak", Reference.MOD_ID_GenBlocks + ":" + name);
					sb3.append(stairOuter);


					byte[] data1 = sb1.toString().getBytes();
					byte[] data2 = sb2.toString().getBytes();
					byte[] data3 = sb3.toString().getBytes();

					out.write(data1, 0, data1.length);
					out.closeEntry();

					out.putNextEntry(newEntryInner);
					out.write(data2, 0, data2.length);
					out.closeEntry();

					out.putNextEntry(newEntryOuter);
					out.write(data3, 0, data3.length);
					out.closeEntry();


				}else if(name.contains("_slab"))
				{

				}else
				{

				}


			}
			
		
			out.close();
		}

		return true;
	}



	/* Use for dungeon loader after
protected void readArrays(String parName)
{

    BufferedReader readIn = null;
	try 
    {

        readIn = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("assets/monsterannnddungeons/blocks/customBlocks/"+ parName), "UTF-8"));

        System.out.println("Chicken" + readIn );

    } 
    catch (IOException e) 
    {

        // replace this with better exception handling



        e.printStackTrace();

    }

    // remember to close the stream to avoid memory leaks     



    try 
    {
        readIn.close();

    } 
    catch (IOException e)
    {

       // replace this with better exception handling



        e.printStackTrace();

    }
}
	 */


}
