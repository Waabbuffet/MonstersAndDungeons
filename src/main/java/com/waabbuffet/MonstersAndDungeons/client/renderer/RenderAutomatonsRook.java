package com.waabbuffet.MonstersAndDungeons.client.renderer;

import com.waabbuffet.MonstersAndDungeons.client.models.ModelAutomatonsRook;
import com.waabbuffet.MonstersAndDungeons.entity.automatons.EntityAutomatonsRook;
import com.waabbuffet.MonstersAndDungeons.util.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderAutomatonsRook extends RenderLiving<EntityAutomatonsRook>{

	
	ResourceLocation location = new ResourceLocation(Reference.MODID + ":textures/models/Rook Automaton.png");
	protected ModelBase modelEntity;
	

	public RenderAutomatonsRook(ModelBase base) {
		super(Minecraft.getMinecraft().getRenderManager(), base,1f);
		modelEntity = ((ModelBase) mainModel);
	}
		
	public void renderAutomatonsRook(EntityAutomatonsRook entity, double x, double y, double z, float u, float v){
		super.doRender(entity, x, y, z, u, v);
	}
	
	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v){
		renderAutomatonsRook((EntityAutomatonsRook)entityLiving, x, y, z, u , v);
	}
	
	public void doRender(EntityAutomatonsRook entity, double x, double y, double z, float u, float v){
		renderAutomatonsRook((EntityAutomatonsRook)entity, x, y, z, u , v);
	}

	@Override
	public void bindTexture(ResourceLocation location) {
		  this.renderManager.renderEngine.bindTexture(location);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityAutomatonsRook entity) {
		// TODO Auto-generated method stub
		return location;
	}
}
