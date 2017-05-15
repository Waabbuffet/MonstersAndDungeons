package monstersanddungeons.entity;

import monstersanddungeons.MonstersAndDungeons;
import monstersanddungeons.client.models.ModelAutomatonsRook;
import monstersanddungeons.client.models.ModelAutomatonsRookBoss;
import monstersanddungeons.client.models.ModelWitePawns;
import monstersanddungeons.client.models.items.ModelQuartzBigSword;
import monstersanddungeons.client.renderer.RenderAutomatonsRook;
import monstersanddungeons.client.renderer.RenderAutomatonsRookBoss;
import monstersanddungeons.client.renderer.RenderFlyingSword;
import monstersanddungeons.client.renderer.RenderSafeZone;
import monstersanddungeons.client.renderer.RenderWhitePawns;
import monstersanddungeons.entity.automatons.EntityAutomatonsRook;
import monstersanddungeons.entity.automatons.EntityAutomatonsRookBoss;
import monstersanddungeons.entity.automatons.EntityTameablePawn;
import monstersanddungeons.entity.automatons.EntityWhitePawns;
import monstersanddungeons.entity.miscellaneous.EntityFlyingSword;
import monstersanddungeons.entity.miscellaneous.EntitySafeZone;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MaDEntityHandler {
	

	private static int entityID = 0;
	
	public static void registerEntities() {
		registerEntity(EntityAutomatonsRook.class, "AutomatonsRook", 80, 3, false);
		registerEntity(EntityAutomatonsRookBoss.class, "AutomatonsRookBoss", 80, 3, false);
		registerEntity(EntitySafeZone.class, "EntitySafeZone", 80, 3, false);
		registerEntity(EntityFlyingSword.class, "EntityFlyingSword", 80, 3, false);
		
		
		registerEntity(EntityWhitePawns.class, "WhitePawns", 80, 3, false);
		registerEntity(EntityTameablePawn.class, "tameablePawn", 80, 3, false);
	}
	
	private static void registerEntity(Class<? extends Entity> entityClass, String entityName, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates) {
		EntityRegistry.registerModEntity(entityClass, entityName, entityID++, MonstersAndDungeons.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerRenders(){
		RenderingRegistry.registerEntityRenderingHandler(EntityAutomatonsRook.class, new RenderAutomatonsRook(new ModelAutomatonsRook()));
		RenderingRegistry.registerEntityRenderingHandler(EntityAutomatonsRookBoss.class, new RenderAutomatonsRookBoss(new ModelAutomatonsRookBoss()));
		RenderingRegistry.registerEntityRenderingHandler(EntitySafeZone.class, new RenderSafeZone());
		RenderingRegistry.registerEntityRenderingHandler(EntityFlyingSword.class, new RenderFlyingSword(new ModelQuartzBigSword()));
		
	
		RenderingRegistry.registerEntityRenderingHandler(EntityWhitePawns.class, new RenderWhitePawns(new ModelWitePawns()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTameablePawn.class, new RenderWhitePawns(new ModelWitePawns()));		
	}
}
