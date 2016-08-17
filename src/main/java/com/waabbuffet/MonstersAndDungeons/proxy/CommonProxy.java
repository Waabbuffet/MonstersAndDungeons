package com.waabbuffet.MonstersAndDungeons.proxy;

import com.waabbuffet.MonstersAndDungeons.blocks.MaDBlocksHandler;
import com.waabbuffet.MonstersAndDungeons.packet.MaDPacketHandler;
import com.waabbuffet.MonstersAndDungeons.world.MaDWorldGenerationHandler;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;




public class CommonProxy {



	public void PreInit(FMLPreInitializationEvent event) {
		// TODO Auto-generated method stub

		MaDBlocksHandler.init();
		MaDBlocksHandler.register();
		
		MaDPacketHandler.init();
		
		
	}

	public void Init(FMLInitializationEvent event) {
		// TODO Auto-generated method stub


		GameRegistry.registerWorldGenerator(new MaDWorldGenerationHandler(), 9000);

	}

	public void PostInit(FMLPostInitializationEvent event) {
		// TODO Auto-generated method stub


	}

	//load schematic 
	


}
