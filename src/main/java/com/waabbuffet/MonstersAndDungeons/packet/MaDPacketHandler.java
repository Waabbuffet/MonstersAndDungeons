package com.waabbuffet.MonstersAndDungeons.packet;

import com.waabbuffet.MonstersAndDungeons.util.Reference;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;





public class MaDPacketHandler {

	 public static SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MODID); 
	    
	 public static void init() 
	 {
		//  INSTANCE.registerMessage(PlaceBlock.class, PlaceBlock.class, 0, Side.SERVER);
	    
	 }	
}
