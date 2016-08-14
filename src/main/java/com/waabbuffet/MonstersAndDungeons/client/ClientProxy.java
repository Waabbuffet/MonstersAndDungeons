package com.waabbuffet.MonstersAndDungeons.client;

import java.io.File;

import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.waabbuffet.MonstersAndDungeons.client.events.ClientTickEventHandler;
import com.waabbuffet.MonstersAndDungeons.events.KeyBindEvent;
import com.waabbuffet.MonstersAndDungeons.proxy.CommonProxy;
import com.waabbuffet.MonstersAndDungeons.util.Reference;



public class ClientProxy extends CommonProxy {

	
	public static File dataDirectory;
	public static BlockPos BlockPos1;
	public static BlockPos BlockPos2;
	
	public void PreInit(FMLPreInitializationEvent event) {
		super.PreInit(event);
		dataDirectory = new File(event.getModConfigurationDirectory(), Reference.MODID);
		
	}

	public void Init(FMLInitializationEvent event) {
		super.Init(event);
	
		MinecraftForge.EVENT_BUS.register(new KeyBindEvent());
	}

	public void PostInit(FMLPostInitializationEvent event) {
		super.PostInit(event);
		
		
	}
	
	
	
}
