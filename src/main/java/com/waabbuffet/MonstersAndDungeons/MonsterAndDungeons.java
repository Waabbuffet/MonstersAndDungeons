package com.waabbuffet.MonstersAndDungeons;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.waabbuffet.MonstersAndDungeons.proxy.CommonProxy;
import com.waabbuffet.MonstersAndDungeons.util.Reference;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class MonsterAndDungeons 
{
	@Instance(Reference.MODID)
	public static MonsterAndDungeons instance;
	
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.COMMON_PROXY)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		proxy.PreInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) 
	{
		proxy.Init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) 
	{
		proxy.PostInit(event);
	}
}
