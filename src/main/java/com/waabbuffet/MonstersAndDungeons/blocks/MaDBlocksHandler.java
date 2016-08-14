package com.waabbuffet.MonstersAndDungeons.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.waabbuffet.MonstersAndDungeons.blocks.dungeonBuilder.BlockExit;
import com.waabbuffet.MonstersAndDungeons.util.Reference;



public class MaDBlocksHandler {

	public static Block BlockExit;
	
	public static void init()
	{
		BlockExit = new BlockExit().setUnlocalizedName("BlockExit");
	}
	
	public static void register()
	{		
		GameRegistry.registerBlock(BlockExit, BlockExit.getUnlocalizedName().substring(5));	
	}
	
	public static void registerRenders()
	{
		registerRender(BlockExit);
	}
	
	public static void registerRender(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MODID +":" + item.getUnlocalizedName().substring(5),"inventory"));
	}
	
}
