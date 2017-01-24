package com.waabbuffet.MonstersAndDungeons.client.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import com.waabbuffet.MonstersAndDungeons.entity.automatons.EntityWhitePawns;
import com.waabbuffet.MonstersAndDungeons.util.Reference;

public class RenderWitePawns extends RenderLiving<EntityWhitePawns>{

	
	ResourceLocation location = new ResourceLocation(Reference.MODID + ":textures/models/Wite Pawn.png");
	protected ModelBase modelEntity;
	

	public RenderWitePawns(ModelBase base) {
		super(Minecraft.getMinecraft().getRenderManager(), base,1f);
		modelEntity = ((ModelBase) mainModel);
	}
		
	public void renderAutomatonsRook(EntityWhitePawns entity, double x, double y, double z, float u, float v){
		super.doRender(entity, x, y, z, u, v);
	}
	
	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v){
		renderAutomatonsRook((EntityWhitePawns)entityLiving, x, y, z, u , v);
	}
	
	public void doRender(EntityWhitePawns entity, double x, double y, double z, float u, float v){
		renderAutomatonsRook((EntityWhitePawns)entity, x, y, z, u , v);
	}

	@Override
	public void bindTexture(ResourceLocation location) {
		  this.renderManager.renderEngine.bindTexture(location);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityWhitePawns entity) {
		// TODO Auto-generated method stub
		return location;
	}
}
