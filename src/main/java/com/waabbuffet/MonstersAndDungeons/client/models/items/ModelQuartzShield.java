package com.waabbuffet.MonstersAndDungeons.client.models.items;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelQuartzShield extends ModelBiped {


	ModelRenderer ShieldHolster;
	ModelRenderer ShieldPlate;
	ModelRenderer ShieldPlate1;
	ModelRenderer ShieldPlate2;
	ModelRenderer ShieldPlate3;
	ModelRenderer ShieldPlate4;
	ModelRenderer ShieldPlate5;
	ModelRenderer ShieldPlate6;

	public ModelQuartzShield(float f)
	{
		textureWidth = 128;
		textureHeight = 128;

		ShieldHolster = new ModelRenderer(this, 0, 23);
		ShieldHolster.addBox(-0.5F, -2.5F, -0.5F, 1, 5, 4);
		ShieldHolster.setRotationPoint(0F, 2F, 0F);
		ShieldHolster.setTextureSize(128, 128);
		ShieldHolster.mirror = true;
		setRotation(ShieldHolster, 0F, 0F, 0F);
		ShieldPlate = new ModelRenderer(this, 0, 0);
		ShieldPlate.addBox(-3F, -8F, -1F, 6, 22, 1);
		ShieldPlate.setRotationPoint(0F, 0F, 0F);
		ShieldPlate.setTextureSize(128, 128);
		ShieldPlate.mirror = true;
		setRotation(ShieldPlate, 0F, 0F, 0F);
		ShieldPlate1 = new ModelRenderer(this, 16, 0);
		ShieldPlate1.addBox(-5.5F, -8F, -1.2F, 3, 22, 1);
		ShieldPlate1.setRotationPoint(0F, 0F, 0F);
		ShieldPlate1.setTextureSize(128, 128);
		ShieldPlate1.mirror = true;
		setRotation(ShieldPlate1, 0F, 0.0872665F, 0F);
		ShieldPlate2 = new ModelRenderer(this, 16, 23);
		ShieldPlate2.addBox(2.5F, -8F, -1.2F, 3, 22, 1);
		ShieldPlate2.setRotationPoint(0F, 0F, 0F);
		ShieldPlate2.setTextureSize(128, 128);
		ShieldPlate2.mirror = true;
		setRotation(ShieldPlate2, 0F, -0.0872665F, 0F);
		ShieldPlate3 = new ModelRenderer(this, 44, 0);
		ShieldPlate3.addBox(3.7F, -9F, -1.4F, 2, 24, 1);
		ShieldPlate3.setRotationPoint(0F, 0F, 0F);
		ShieldPlate3.setTextureSize(128, 128);
		ShieldPlate3.mirror = true;
		setRotation(ShieldPlate3, 0F, -0.0872665F, 0F);
		ShieldPlate4 = new ModelRenderer(this, 26, 0);
		ShieldPlate4.addBox(-5.7F, -9F, -1.4F, 2, 24, 1);
		ShieldPlate4.setRotationPoint(0F, 0F, 0F);
		ShieldPlate4.setTextureSize(128, 128);
		ShieldPlate4.mirror = true;
		setRotation(ShieldPlate4, 0F, 0.0872665F, 0F);
		ShieldPlate5 = new ModelRenderer(this, 32, 0);
		ShieldPlate5.addBox(-2F, -9F, -1.2F, 2, 24, 1);
		ShieldPlate5.setRotationPoint(0F, 0F, 0F);
		ShieldPlate5.setTextureSize(128, 128);
		ShieldPlate5.mirror = true;
		setRotation(ShieldPlate5, 0F, 0F, 0F);
		ShieldPlate6 = new ModelRenderer(this, 38, 0);
		ShieldPlate6.addBox(0F, -9F, -1.2F, 2, 24, 1);
		ShieldPlate6.setRotationPoint(0F, 0F, 0F);
		ShieldPlate6.setTextureSize(128, 128);
		ShieldPlate6.mirror = true;
		setRotation(ShieldPlate6, 0F, 0F, 0F);
		ShieldPlate6.mirror = false;



	}

	//setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);



		GlStateManager.pushMatrix();

		if (entity.isSneaking())
		{
			GlStateManager.translate(0.0F, 0.2F, 0.0F);
		}

		ShieldHolster.render(f5);
		ShieldPlate.render(f5);
		ShieldPlate1.render(f5);
		ShieldPlate2.render(f5);
		ShieldPlate3.render(f5);
		ShieldPlate4.render(f5);
		ShieldPlate5.render(f5);
		ShieldPlate6.render(f5);
		GlStateManager.popMatrix();
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}


	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float f2, float f3, float f4, float f5)
	{

		super.setRotationAngles(limbSwing, limbSwingAmount, f2, f3, f4, f5, entity);
	}



}
