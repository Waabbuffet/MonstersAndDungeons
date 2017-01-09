package com.waabbuffet.MonstersAndDungeons.client;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.waabbuffet.MonstersAndDungeons.blocks.MaDBlocksHandler;
import com.waabbuffet.MonstersAndDungeons.client.events.ClientEventHandler;
import com.waabbuffet.MonstersAndDungeons.client.events.ClientTickEventHandler;
import com.waabbuffet.MonstersAndDungeons.client.models.items.ModelQuartzArmor;
import com.waabbuffet.MonstersAndDungeons.entity.MaDEntityHandler;
import com.waabbuffet.MonstersAndDungeons.events.KeyBindEvent;
import com.waabbuffet.MonstersAndDungeons.items.MaDItemsHandler;
import com.waabbuffet.MonstersAndDungeons.proxy.CommonProxy;
import com.waabbuffet.MonstersAndDungeons.util.Reference;
import com.waabbuffet.MonstersAndDungeons.util.ResourceLoader;



public class ClientProxy extends CommonProxy {

	
	public static File dataDirectory;
	public static BlockPos BlockPos1;
	public static BlockPos BlockPos2;
	
	public static List<IResourcePack> rPacks;
	

	
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		
		dataDirectory = new File(event.getModConfigurationDirectory(), Reference.NAME);
		
		
		try
		{
			Field field = Minecraft.class.getDeclaredField("defaultResourcePacks");
			field.setAccessible(true);
			
			rPacks =  (List<IResourcePack>) field.get(Minecraft.getMinecraft());
			rPacks.add(new ResourceLoader(new File(dataDirectory.getAbsolutePath() + "/madresources.zip")));
			Minecraft.getMinecraft().refreshResources();
			
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		
		

	}

	public void init(FMLInitializationEvent event) {
		super.init(event);
	
		MinecraftForge.EVENT_BUS.register(new KeyBindEvent());
		MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
		
	
		this.RegisterRenders();
	}

	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
		
		
	}
	
	@Override
	public void RegisterRenders() {
		
		MaDBlocksHandler.registerRenders();
		MaDItemsHandler.registerRenders();
		MaDEntityHandler.registerRenders();
	}
		
	@Override
	public ModelBiped getArmorModel(int id) {
		return new ModelQuartzArmor(id);
	}
}
