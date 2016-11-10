package com.waabbuffet.MonstersAndDungeons.proxy;

import java.io.File;
import java.io.IOException;

import com.waabbuffet.MonstersAndDungeons.blocks.MaDBlocksHandler;
import com.waabbuffet.MonstersAndDungeons.client.events.ClientEventHandler;
import com.waabbuffet.MonstersAndDungeons.items.MaDItemsHandler;
import com.waabbuffet.MonstersAndDungeons.packet.MaDPacketHandler;
import com.waabbuffet.MonstersAndDungeons.world.MaDWorldGenerationHandler;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;




public class CommonProxy {

	public static File ConfigDir;

	public void PreInit(FMLPreInitializationEvent event) {
		// TODO Auto-generated method stub

		this.ConfigDir = event.getModConfigurationDirectory();
		
		try {
			MaDBlocksHandler.genBlocks(ConfigDir.getPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MaDBlocksHandler.init();
		MaDItemsHandler.init();
		MaDPacketHandler.init();
	}

	public void Init(FMLInitializationEvent event) {
		// TODO Auto-generated method stub


		GameRegistry.registerWorldGenerator(new MaDWorldGenerationHandler(), 9000);
		
	}

	public void PostInit(FMLPostInitializationEvent event) {
		// TODO Auto-generated method stub


	}

	public void RegisterRenders() {
		// TODO Auto-generated method stub
		
	}


	


}
