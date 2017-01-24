package com.waabbuffet.MonstersAndDungeons.entity;

import net.minecraft.entity.Entity;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.waabbuffet.MonstersAndDungeons.MonstersAndDungeons;
import com.waabbuffet.MonstersAndDungeons.client.models.ModelAutomatonsRook;
import com.waabbuffet.MonstersAndDungeons.client.models.ModelWitePawns;
import com.waabbuffet.MonstersAndDungeons.client.renderer.RenderAutomatonsRook;
import com.waabbuffet.MonstersAndDungeons.client.renderer.RenderWitePawns;
import com.waabbuffet.MonstersAndDungeons.entity.automatons.EntityAutomatonsRook;
import com.waabbuffet.MonstersAndDungeons.entity.automatons.EntityWhitePawns;

public class MaDEntityHandler {
	
	private static int entityID = 0;
	
	public static void registerEntities() {
		registerEntity(EntityAutomatonsRook.class, "AutomatonsRook", 80, 3, false);
		registerEntity(EntityWhitePawns.class, "WitePawns", 80, 3, false);
		
	}
	private static void registerEntity(Class<? extends Entity> entityClass, String entityName, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates) {
		EntityRegistry.registerModEntity(entityClass, entityName, entityID++, MonstersAndDungeons.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityAutomatonsRook.class, new RenderAutomatonsRook(new ModelAutomatonsRook()));
		RenderingRegistry.registerEntityRenderingHandler(EntityWhitePawns.class, new RenderWitePawns(new ModelWitePawns()));
		
	}
}
