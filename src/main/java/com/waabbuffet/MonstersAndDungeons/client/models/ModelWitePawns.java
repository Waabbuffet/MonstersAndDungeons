package com.waabbuffet.MonstersAndDungeons.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelWitePawns extends ModelBase {

	ModelRenderer Head;
	ModelRenderer Neck1;
	ModelRenderer Body;
	ModelRenderer Neck2;
	ModelRenderer Nose;
	ModelRenderer EyePiece;
	ModelRenderer EyePieceTwo;
	ModelRenderer EyePieceThree;
	ModelRenderer EyePieceFour;
	ModelRenderer rightFoot;
	ModelRenderer leftFoot;
	ModelRenderer rightArm;
	ModelRenderer leftArm;
	ModelRenderer RightKnee;
	ModelRenderer leftKnee;

	public ModelWitePawns()
	{
		textureWidth = 128;
		textureHeight = 128;

		Head = new ModelRenderer(this, 0, 0);
		Head.addBox(-4F, -8F, -4F, 8, 7, 8);
		Head.setRotationPoint(0F, 10F, 0F);
		Head.setTextureSize(128, 128);
		Head.mirror = true;
		setRotation(Head, 0F, 0F, 0F);
		Neck1 = new ModelRenderer(this, 32, 0);
		Neck1.addBox(-6F, -5F, -6F, 12, 3, 12);
		Neck1.setRotationPoint(0F, 15F, 0F);
		Neck1.setTextureSize(128, 128);
		Neck1.mirror = true;
		setRotation(Neck1, 0F, 0F, 0F);
		Body = new ModelRenderer(this, 30, 15);
		Body.addBox(-4.5F, -4F, -4.5F, 9, 8, 9);
		Body.setRotationPoint(0F, 16F, 0F);
		Body.setTextureSize(128, 128);
		Body.mirror = true;
		setRotation(Body, 0F, 0F, 0F);
		Neck2 = new ModelRenderer(this, 0, 15);
		Neck2.addBox(-4F, -1F, -3F, 8, 1, 7);
		Neck2.setRotationPoint(0F, 10F, 0F);
		Neck2.setTextureSize(128, 128);
		Neck2.mirror = true;
		setRotation(Neck2, 0F, 0F, 0F);
		Nose = new ModelRenderer(this, 0, 23);
		Nose.addBox(-1F, -1F, -4F, 2, 1, 1);
		Nose.setRotationPoint(0F, 10F, 0F);
		Nose.setTextureSize(128, 128);
		Nose.mirror = true;
		setRotation(Nose, 0F, 0F, 0F);
		EyePiece = new ModelRenderer(this, 6, 23);
		EyePiece.addBox(3F, -1F, -4F, 1, 1, 1);
		EyePiece.setRotationPoint(0F, 10F, 0F);
		EyePiece.setTextureSize(128, 128);
		EyePiece.mirror = true;
		setRotation(EyePiece, 0F, 0F, 0F);
		EyePieceTwo = new ModelRenderer(this, 6, 23);
		EyePieceTwo.addBox(-4F, -1F, -4F, 1, 1, 1);
		EyePieceTwo.setRotationPoint(0F, 10F, 0F);
		EyePieceTwo.setTextureSize(128, 128);
		EyePieceTwo.mirror = true;
		setRotation(EyePieceTwo, 0F, 0F, 0F);
		EyePieceThree = new ModelRenderer(this, 0, 25);
		EyePieceThree.addBox(-3F, -1F, -3.5F, 2, 1, 1);
		EyePieceThree.setRotationPoint(0F, 10F, 0F);
		EyePieceThree.setTextureSize(128, 128);
		EyePieceThree.mirror = true;
		setRotation(EyePieceThree, 0F, 0F, 0F);
		EyePieceFour = new ModelRenderer(this, 0, 25);
		EyePieceFour.addBox(1F, -1F, -3.5F, 2, 1, 1);
		EyePieceFour.setRotationPoint(0F, 10F, 0F);
		EyePieceFour.setTextureSize(128, 128);
		EyePieceFour.mirror = true;
		setRotation(EyePieceFour, 0F, 0F, 0F);
		rightFoot = new ModelRenderer(this, 80, 0);
		rightFoot.addBox(-1.7F, 1F, -1.5F, 3, 3, 3);
		rightFoot.setRotationPoint(-2F, 20F, 0F);
		rightFoot.setTextureSize(128, 128);
		rightFoot.mirror = true;
		setRotation(rightFoot, 0F, 0F, 0F);
		leftFoot = new ModelRenderer(this, 80, 0);
		leftFoot.addBox(-1.3F, 1F, -1.5F, 3, 3, 3);
		leftFoot.setRotationPoint(2F, 20F, 0F);
		leftFoot.setTextureSize(128, 128);
		leftFoot.mirror = true;
		setRotation(leftFoot, 0F, 0F, 0F);
		rightArm = new ModelRenderer(this, 80, 6);
		rightArm.addBox(-2.5F, -1F, -1.5F, 3, 8, 3);
		rightArm.setRotationPoint(-5F, 12.5F, 0F);
		rightArm.setTextureSize(128, 128);
		rightArm.mirror = true;
		setRotation(rightArm, 0F, 0F, 0F);
		leftArm = new ModelRenderer(this, 92, 6);
		leftArm.addBox(-0.5F, -1F, -1.5F, 3, 8, 3);
		leftArm.setRotationPoint(5F, 12.5F, 0F);
		leftArm.setTextureSize(128, 128);
		leftArm.mirror = true;
		setRotation(leftArm, 0F, 0F, 0F);
		RightKnee = new ModelRenderer(this, 80, 17);
		RightKnee.addBox(-2.2F, -0.5F, -2F, 4, 2, 4);
		RightKnee.setRotationPoint(-2F, 20F, 0F);
		RightKnee.setTextureSize(128, 128);
		RightKnee.mirror = true;
		setRotation(RightKnee, 0F, 0F, 0F);
		leftKnee = new ModelRenderer(this, 80, 17);
		leftKnee.addBox(-1.8F, -0.5F, -2F, 4, 2, 4);
		leftKnee.setRotationPoint(2F, 20F, 0F);
		leftKnee.setTextureSize(128, 128);
		leftKnee.mirror = true;
		setRotation(leftKnee, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		
		Head.render(f5);
		Neck1.render(f5);
		Body.render(f5);
		Neck2.render(f5);
		Nose.render(f5);
		EyePiece.render(f5);
		EyePieceTwo.render(f5);
		EyePieceThree.render(f5);
		EyePieceFour.render(f5);
		rightFoot.render(f5);
		leftFoot.render(f5);
		rightArm.render(f5);
		leftArm.render(f5);
		RightKnee.render(f5);
		leftKnee.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) 
	{
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
		float  f = 1f;
		this.rightFoot.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
		this.leftFoot.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount / f;
	}
}
