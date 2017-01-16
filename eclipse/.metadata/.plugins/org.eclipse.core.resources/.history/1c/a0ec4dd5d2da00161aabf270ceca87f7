package com.waabbuffet.MonstersAndDungeons.client.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import com.waabbuffet.MonstersAndDungeons.entity.automatons.EntityWitePawns;
import com.waabbuffet.MonstersAndDungeons.util.Reference;

public class RenderWitePawns extends RenderLiving<EntityWitePawns>{

	
	ResourceLocation location = new ResourceLocation(Reference.MODID + ":textures/models/Wite Pawn.png");
	protected ModelBase modelEntity;
	

	public RenderWitePawns(ModelBase base) {
		super(Minecraft.getMinecraft().getRenderManager(), base,1f);
		modelEntity = ((ModelBase) mainModel);
	}
		
	public void renderAutomatonsRook(EntityWitePawns entity, double x, double y, double z, float u, float v){
		super.doRender(entity, x, y, z, u, v);
	}
	
	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v){
		renderAutomatonsRook((EntityWitePawns)entityLiving, x, y, z, u , v);
	}
	
	public void doRender(EntityWitePawns entity, double x, double y, double z, float u, float v){
		renderAutomatonsRook((EntityWitePawns)entity, x, y, z, u , v);
	}

	@Override
	public void bindTexture(ResourceLocation location) {
		  this.renderManager.renderEngine.bindTexture(location);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityWitePawns entity) {
		// TODO Auto-generated method stub
		return location;
	}
}
