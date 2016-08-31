package com.waabbuffet.MonstersAndDungeons.client.models.items;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelQuartzArmor extends ModelBiped {

	ModelRenderer head;
	ModelRenderer head1;
	ModelRenderer head2;
	ModelRenderer head3;
	ModelRenderer head4;
	ModelRenderer head5;
	ModelRenderer head6;
	ModelRenderer head7;
	ModelRenderer head8;
	ModelRenderer head9;
	ModelRenderer head10;
	ModelRenderer head11;
	ModelRenderer head12;
	ModelRenderer head13;
	ModelRenderer head14;
	ModelRenderer head15;

	ModelRenderer leftarm;
	ModelRenderer RightarmArmour;
	ModelRenderer RightarmArmour1;
	ModelRenderer RightarmArmour2;
	ModelRenderer RightarmArmour3;
	ModelRenderer BodyArmour;
	ModelRenderer body;
	ModelRenderer BodyArmour1;
	ModelRenderer leftarm1;
	ModelRenderer leftarm2;
	ModelRenderer leftarm3;
	ModelRenderer leftarm4;
	ModelRenderer leftarm5;
	ModelRenderer leftarm6;
	ModelRenderer leftarm7;
	ModelRenderer leftarm8;
	ModelRenderer BodyArmour2;
	ModelRenderer BodyArmour3;
	ModelRenderer BodyArmour4;
	ModelRenderer BodyArmour5;
	ModelRenderer BodyArmour6;
	ModelRenderer BodyArmour7;
	ModelRenderer LeftarmArmour;
	ModelRenderer RightarmArmour5;
	ModelRenderer LeftarmArmour1;
	ModelRenderer RightarmArmour4;
	ModelRenderer body1;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer leftleg1;
	ModelRenderer body2;
	ModelRenderer leftleg2;
	ModelRenderer body5;
	ModelRenderer body3;
	ModelRenderer body4;
	ModelRenderer leftleg4;
	ModelRenderer leftleg3;
	ModelRenderer Shape1;
	ModelRenderer leftarm9;
	ModelRenderer leftarm10;
	ModelRenderer leftarm11;
	ModelRenderer leftarm12;
	ModelRenderer leftarm13;
	ModelRenderer leftarm14;

	int Which;

	public ModelQuartzArmor(float f, int whichPiece)
	{
		textureWidth = 128;
		textureHeight = 128;

		Which = whichPiece;

		head = new ModelRenderer(this, 62, 16);
		head.addBox(2.5F, -10F, -4.5F, 2, 6, 1);
		head.setRotationPoint(0F, 0F, 0F);
		head.setTextureSize(128, 128);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		//	this.bipedHead.addChild(head);

		head1 = new ModelRenderer(this, 56, 16);
		head1.addBox(-1F, -11F, -4.5F, 2, 10, 1);
		head1.setRotationPoint(0F, 0F, 0F);
		head1.setTextureSize(128, 128);
		head1.mirror = true;
		setRotation(head1, 0F, 0F, 0F);
		//	this.bipedHead.addChild(head1);

		head2 = new ModelRenderer(this, 64, 0);
		head2.addBox(3F, -3F, -4F, 1, 1, 7);
		head2.setRotationPoint(0F, 0F, 0F);
		head2.setTextureSize(128, 128);
		head2.mirror = true;
		setRotation(head2, 0F, 0F, 0F);
		//	this.bipedHead.addChild(head2);

		head3 = new ModelRenderer(this, 64, 0);
		head3.addBox(-4F, -3F, -4F, 1, 1, 7);
		head3.setRotationPoint(0F, 0F, 0F);
		head3.setTextureSize(128, 128);
		head3.mirror = true;
		setRotation(head3, 0F, 0F, 0F);
		//	this.bipedHead.addChild(head3);

		head4 = new ModelRenderer(this, 0, 14);
		head4.addBox(-4F, -3F, 3F, 8, 1, 1);
		head4.setRotationPoint(0F, 0F, 0F);
		head4.setTextureSize(128, 128);
		head4.mirror = true;
		setRotation(head4, 0F, 0F, 0F);
		//	this.bipedHead.addChild(head4);

		head5 = new ModelRenderer(this, 0, 0);
		head5.addBox(-4F, -9F, -4F, 8, 6, 8);
		head5.setRotationPoint(0F, 0F, 0F);
		head5.setTextureSize(128, 128);
		head5.mirror = true;
		setRotation(head5, 0F, 0F, 0F);
		//	this.bipedHead.addChild(head5);

		head6 = new ModelRenderer(this, 68, 16);
		head6.addBox(-1F, -10F, 3.5F, 2, 6, 1);
		head6.setRotationPoint(0F, 0F, 0F);
		head6.setTextureSize(128, 128);
		head6.mirror = true;
		setRotation(head6, 0F, 0F, 0F);
		//	this.bipedHead.addChild(head6);

		head7 = new ModelRenderer(this, 74, 23);
		head7.addBox(2.5F, -10F, 3.5F, 2, 6, 1);
		head7.setRotationPoint(0F, 0F, 0F);
		head7.setTextureSize(128, 128);
		head7.mirror = true;
		setRotation(head7, 0F, 0F, 0F);
		//	this.bipedHead.addChild(head7);

		head8 = new ModelRenderer(this, 68, 23);
		head8.addBox(-4.5F, -10F, 3.5F, 2, 6, 1);
		head8.setRotationPoint(0F, 0F, 0F);
		head8.setTextureSize(128, 128);
		head8.mirror = true;
		setRotation(head8, 0F, 0F, 0F);
		//	this.bipedHead.addChild(head8);

		head9 = new ModelRenderer(this, 74, 15);
		head9.addBox(3.5F, -10F, -1F, 1, 6, 2);
		head9.setRotationPoint(0F, 0F, 0F);
		head9.setTextureSize(128, 128);
		head9.mirror = true;
		setRotation(head9, 0F, 0F, 0F);
		//	this.bipedHead.addChild(head9);

		head10 = new ModelRenderer(this, 80, 15);
		head10.addBox(-4.5F, -10F, -1F, 1, 6, 2);
		head10.setRotationPoint(0F, 0F, 0F);
		head10.setTextureSize(128, 128);
		head10.mirror = true;
		setRotation(head10, 0F, 0F, 0F);
		//	this.bipedHead.addChild(head10);

		head11 = new ModelRenderer(this, 80, 23);
		head11.addBox(-4.5F, -10F, -3.5F, 1, 6, 1);
		head11.setRotationPoint(0F, 0F, 0F);
		head11.setTextureSize(128, 128);
		head11.mirror = true;
		setRotation(head11, 0F, 0F, 0F);
		//	this.bipedHead.addChild(head11);

		head12 = new ModelRenderer(this, 80, 23);
		head12.addBox(-4.5F, -10F, 2.5F, 1, 6, 1);
		head12.setRotationPoint(0F, 0F, 0F);
		head12.setTextureSize(128, 128);
		head12.mirror = true;
		setRotation(head12, 0F, 0F, 0F);
		//	this.bipedHead.addChild(head12);

		head13 = new ModelRenderer(this, 62, 23);
		head13.addBox(-4.5F, -10F, -4.5F, 2, 6, 1);
		head13.setRotationPoint(0F, 0F, 0F);
		head13.setTextureSize(128, 128);
		head13.mirror = true;
		setRotation(head13, 0F, 0F, 0F);
		//	this.bipedHead.addChild(head13);

		head14 = new ModelRenderer(this, 80, 23);
		head14.addBox(3.5F, -10F, -3.5F, 1, 6, 1);
		head14.setRotationPoint(0F, 0F, 0F);
		head14.setTextureSize(128, 128);
		head14.mirror = true;
		setRotation(head14, 0F, 0F, 0F);
		//	this.bipedHead.addChild(head14);

		head15 = new ModelRenderer(this, 80, 23);
		head15.addBox(3.5F, -10F, 2.5F, 1, 6, 1);
		head15.setRotationPoint(0F, 0F, 0F);
		head15.setTextureSize(128, 128);
		head15.mirror = true;
		setRotation(head15, 0F, 0F, 0F);
		//	this.bipedHead.addChild(head15);

		//body
		leftarm = new ModelRenderer(this, 40, 16);
		leftarm.addBox(-1F, -2F, -2F, 4, 7, 4);
		leftarm.setRotationPoint(5F, 2F, 0F);
		leftarm.setTextureSize(128, 128);
		leftarm.mirror = true;
		setRotation(leftarm, 0F, 0F, 0F);
		//	this.bipedLeftArm.addChild(leftarm);

		RightarmArmour = new ModelRenderer(this, 34, 48);
		RightarmArmour.addBox(-0.9F, -6.5F, -1F, 2, 1, 2);
		RightarmArmour.setRotationPoint(-5F, 2F, 0F);
		RightarmArmour.setTextureSize(128, 128);
		RightarmArmour.mirror = true;
		setRotation(RightarmArmour, 0F, 0F, -0.0872665F);
		//	this.bipedRightArm.addChild(RightarmArmour);

		RightarmArmour1 = new ModelRenderer(this, 0, 53);
		RightarmArmour1.addBox(-0.9F, -5.5F, -3.5F, 2, 6, 7);
		RightarmArmour1.setRotationPoint(-5F, 2F, 0F);
		RightarmArmour1.setTextureSize(128, 128);
		RightarmArmour1.mirror = true;
		setRotation(RightarmArmour1, 0F, 0F, -0.0872665F);
		//	this.bipedRightArm.addChild(RightarmArmour1);

		RightarmArmour2 = new ModelRenderer(this, 34, 48);
		RightarmArmour2.addBox(-0.9F, -6.5F, 1.5F, 2, 1, 2);
		RightarmArmour2.setRotationPoint(-5F, 2F, 0F);
		RightarmArmour2.setTextureSize(128, 128);
		RightarmArmour2.mirror = true;
		setRotation(RightarmArmour2, 0F, 0F, -0.0872665F);
		//	this.bipedRightArm.addChild(RightarmArmour2);

		RightarmArmour3 = new ModelRenderer(this, 34, 43);
		RightarmArmour3.addBox(-4.5F, 1.5F, -2F, 5, 1, 4);
		RightarmArmour3.setRotationPoint(-5F, 2F, 0F);
		RightarmArmour3.setTextureSize(128, 128);
		RightarmArmour3.mirror = true;
		setRotation(RightarmArmour3, 0F, 0F, 0F);
		//	this.bipedRightArm.addChild(RightarmArmour3);

		BodyArmour = new ModelRenderer(this, 32, 0);
		BodyArmour.addBox(3.3F, 0.1F, -2.5F, 1, 4, 4);
		BodyArmour.setRotationPoint(0F, 0F, 0F);
		BodyArmour.setTextureSize(128, 128);
		BodyArmour.mirror = true;
		setRotation(BodyArmour, 0.0872665F, 0F, 0F);
		//	this.bipedBody.addChild(BodyArmour);

		body = new ModelRenderer(this, 16, 28);
		body.addBox(-3F, 8F, -2F, 6, 1, 4);
		body.setRotationPoint(0F, 0F, 0F);
		body.setTextureSize(128, 128);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		//	this.bipedBody.addChild(body);

		BodyArmour1 = new ModelRenderer(this, 32, 0);
		BodyArmour1.addBox(-4.3F, 0.1F, -2.3F, 1, 4, 4);
		BodyArmour1.setRotationPoint(0F, 0F, 0F);
		BodyArmour1.setTextureSize(128, 128);
		BodyArmour1.mirror = true;
		setRotation(BodyArmour1, 0.0872665F, 0F, 0F);
		//	this.bipedBody.addChild(BodyArmour1);

		leftarm1 = new ModelRenderer(this, 42, 8);
		leftarm1.addBox(-1.2F, 5F, -2.2F, 4, 1, 4);
		leftarm1.setRotationPoint(5F, 2F, 0F);
		leftarm1.setTextureSize(128, 128);
		leftarm1.mirror = true;
		setRotation(leftarm1, 0F, 0F, 0F);
		//	this.bipedLeftArm.addChild(leftarm1);

		leftarm2 = new ModelRenderer(this, 42, 8);
		leftarm2.addBox(-0.8F, 3F, -2.2F, 4, 1, 4);
		leftarm2.setRotationPoint(5F, 2F, 0F);
		leftarm2.setTextureSize(128, 128);
		leftarm2.mirror = true;
		setRotation(leftarm2, 0F, 0F, 0F);
		//	this.bipedLeftArm.addChild(leftarm2);

		leftarm3 = new ModelRenderer(this, 42, 8);
		leftarm3.addBox(-1.2F, 5F, -1.8F, 4, 1, 4);
		leftarm3.setRotationPoint(5F, 2F, 0F);
		leftarm3.setTextureSize(128, 128);
		leftarm3.mirror = true;
		setRotation(leftarm3, 0F, 0F, 0F);
		//	this.bipedLeftArm.addChild(leftarm3);

		leftarm4 = new ModelRenderer(this, 42, 8);
		leftarm4.addBox(-0.8F, 5F, -1.8F, 4, 1, 4);
		leftarm4.setRotationPoint(5F, 2F, 0F);
		leftarm4.setTextureSize(128, 128);
		leftarm4.mirror = true;
		setRotation(leftarm4, 0F, 0F, 0F);
		//	this.bipedLeftArm.addChild(leftarm4);

		leftarm5 = new ModelRenderer(this, 42, 8);
		leftarm5.addBox(-0.8F, 5F, -2.2F, 4, 1, 4);
		leftarm5.setRotationPoint(5F, 2F, 0F);
		leftarm5.setTextureSize(128, 128);
		leftarm5.mirror = true;
		setRotation(leftarm5, 0F, 0F, 0F);
		//	this.bipedLeftArm.addChild(leftarm5);

		leftarm6 = new ModelRenderer(this, 42, 8);
		leftarm6.addBox(-1.2F, 3F, -1.8F, 4, 1, 4);
		leftarm6.setRotationPoint(5F, 2F, 0F);
		leftarm6.setTextureSize(128, 128);
		leftarm6.mirror = true;
		setRotation(leftarm6, 0F, 0F, 0F);
		//	this.bipedLeftArm.addChild(leftarm6);

		leftarm7 = new ModelRenderer(this, 42, 8);
		leftarm7.addBox(-1.2F, 3F, -2.2F, 4, 1, 4);
		leftarm7.setRotationPoint(5F, 2F, 0F);
		leftarm7.setTextureSize(128, 128);
		leftarm7.mirror = true;
		setRotation(leftarm7, 0F, 0F, 0F);
		//	this.bipedLeftArm.addChild(leftarm7);

		leftarm8 = new ModelRenderer(this, 42, 8);
		leftarm8.addBox(-0.8F, 3F, -1.8F, 4, 1, 4);
		leftarm8.setRotationPoint(5F, 2F, 0F);
		leftarm8.setTextureSize(128, 128);
		leftarm8.mirror = true;
		setRotation(leftarm8, 0F, 0F, 0F);
		//	this.bipedLeftArm.addChild(leftarm8);

		BodyArmour2 = new ModelRenderer(this, 16, 42);
		BodyArmour2.addBox(-3F, 3.9F, 1.5F, 6, 2, 1);
		BodyArmour2.setRotationPoint(0F, 0F, 0F);
		BodyArmour2.setTextureSize(128, 128);
		BodyArmour2.mirror = true;
		setRotation(BodyArmour2, 0F, 0F, 0F);
		//	this.bipedBody.addChild(BodyArmour2);

		BodyArmour3 = new ModelRenderer(this, 16, 42);
		BodyArmour3.addBox(-3F, 4.9F, -2.5F, 6, 3, 1);
		BodyArmour3.setRotationPoint(0F, 0F, 0F);
		BodyArmour3.setTextureSize(128, 128);
		BodyArmour3.mirror = true;
		setRotation(BodyArmour3, 0F, 0F, 0F);
		//	this.bipedBody.addChild(BodyArmour3);

		BodyArmour4 = new ModelRenderer(this, 16, 51);
		BodyArmour4.addBox(-4F, -0.1F, -2.5F, 2, 1, 1);
		BodyArmour4.setRotationPoint(0F, 0F, 0F);
		BodyArmour4.setTextureSize(128, 128);
		BodyArmour4.mirror = true;
		setRotation(BodyArmour4, 0F, 0F, 0F);
		//	this.bipedBody.addChild(BodyArmour4);

		BodyArmour5 = new ModelRenderer(this, 22, 51);
		BodyArmour5.addBox(2F, -0.1F, -2.5F, 2, 1, 1);
		BodyArmour5.setRotationPoint(0F, 0F, 0F);
		BodyArmour5.setTextureSize(128, 128);
		BodyArmour5.mirror = true;
		setRotation(BodyArmour5, 0F, 0F, 0F);
		//	this.bipedBody.addChild(BodyArmour5);

		BodyArmour6 = new ModelRenderer(this, 16, 46);
		BodyArmour6.addBox(-4F, -0.1F, 1.5F, 8, 4, 1);
		BodyArmour6.setRotationPoint(0F, 0F, 0F);
		BodyArmour6.setTextureSize(128, 128);
		BodyArmour6.mirror = true;
		setRotation(BodyArmour6, 0F, 0F, 0F);
		//	this.bipedBody.addChild(BodyArmour6);

		BodyArmour7 = new ModelRenderer(this, 16, 46);
		BodyArmour7.addBox(-4F, 0.9F, -2.5F, 8, 4, 1);
		BodyArmour7.setRotationPoint(0F, 0F, 0F);
		BodyArmour7.setTextureSize(128, 128);
		BodyArmour7.mirror = true;
		setRotation(BodyArmour7, 0F, 0F, 0F);
		//	this.bipedBody.addChild(BodyArmour7);

		LeftarmArmour = new ModelRenderer(this, 0, 42);
		LeftarmArmour.addBox(-1.1F, -4.5F, -3F, 2, 5, 6);
		LeftarmArmour.setRotationPoint(5F, 2F, 0F);
		LeftarmArmour.setTextureSize(128, 128);
		LeftarmArmour.mirror = true;
		setRotation(LeftarmArmour, 0F, 0F, 0.0872665F);
		//	this.bipedLeftArm.addChild(LeftarmArmour);

		RightarmArmour5 = new ModelRenderer(this, 34, 48); 
		RightarmArmour5.addBox(-0.9F, -6.5F, -3.5F, 2, 1, 2);
		RightarmArmour5.setRotationPoint(-5F, 2F, 0F);
		RightarmArmour5.setTextureSize(128, 128);
		RightarmArmour5.mirror = true;
		setRotation(RightarmArmour5, 0F, 0F, -0.0872665F);
		//	this.bipedRightArm.addChild(RightarmArmour3);

		LeftarmArmour1 = new ModelRenderer(this, 0, 32);
		LeftarmArmour1.addBox(-1F, -3.5F, -2.5F, 5, 5, 5);
		LeftarmArmour1.setRotationPoint(5F, 2F, 0F);
		LeftarmArmour1.setTextureSize(128, 128);
		LeftarmArmour1.mirror = true;
		setRotation(LeftarmArmour1, 0F, 0F, 0.0872665F);
		//	this.bipedLeftArm.addChild(LeftarmArmour1);

		RightarmArmour4 = new ModelRenderer(this, 34, 32);
		RightarmArmour4.addBox(-5F, -4.5F, -2.5F, 6, 6, 5);
		RightarmArmour4.setRotationPoint(-5F, 2F, 0F);
		RightarmArmour4.setTextureSize(128, 128);
		RightarmArmour4.mirror = true;
		setRotation(RightarmArmour4, 0F, 0F, -0.0872665F);
		//	this.bipedRightArm.addChild(RightarmArmour4);

		body1 = new ModelRenderer(this, 16, 16);
		body1.addBox(-4F, 0F, -2F, 8, 8, 4);
		body1.setRotationPoint(0F, 0F, 0F);
		body1.setTextureSize(128, 128);
		body1.mirror = true;
		setRotation(body1, 0F, 0F, 0F);
		//	this.bipedRightArm.addChild(body1);

		rightleg = new ModelRenderer(this, 0, 18);
		rightleg.addBox(-2F, 0F, -2F, 1, 7, 4);
		rightleg.setRotationPoint(-2F, 10F, 0F);
		rightleg.setTextureSize(128, 128);
		rightleg.mirror = true;
		setRotation(rightleg, 0F, 0F, 0.0872665F);
		//	this.bipedRightLeg.addChild(rightleg);

		leftleg = new ModelRenderer(this, 0, 18);
		leftleg.addBox(1F, 0F, -2F, 1, 7, 4);
		leftleg.setRotationPoint(2F, 10F, 0F);
		leftleg.setTextureSize(128, 128);
		leftleg.mirror = true;
		setRotation(leftleg, 0F, 0F, -0.0872665F);
		//	this.bipedLeftLeg.addChild(leftleg1);

		leftleg1 = new ModelRenderer(this, 80, 0);
		leftleg1.addBox(-2F, -1.5F, -2.6F, 4, 10, 1);
		leftleg1.setRotationPoint(0F, 10F, 0F);
		leftleg1.setTextureSize(128, 128);
		leftleg1.mirror = true;
		setRotation(leftleg1, -0.0523599F, 0F, 0F);
		//	this.bipedLeftLeg.addChild(leftleg1);

		body2 = new ModelRenderer(this, 40, 27);
		body2.addBox(-4F, 8.5F, 1.3F, 8, 2, 1);
		body2.setRotationPoint(0F, 0F, 0F);
		body2.setTextureSize(128, 128);
		body2.mirror = true;
		setRotation(body2, 0F, 0F, 0F);
		//	this.bipedBody.addChild(body2);

		leftleg2 = new ModelRenderer(this, 80, 0);
		leftleg2.addBox(-2F, -1.5F, 1.6F, 4, 10, 1);
		leftleg2.setRotationPoint(0F, 10F, 0F);
		leftleg2.setTextureSize(128, 128);
		leftleg2.mirror = true;
		setRotation(leftleg2, 0.0523599F, 0F, 0F);
		//	this.bipedLeftLeg.addChild(leftleg2);

		body5 = new ModelRenderer(this, 20, 33);
		body5.addBox(3.3F, 8.5F, -2F, 1, 2, 4);
		body5.setRotationPoint(0F, 0F, 0F);
		body5.setTextureSize(128, 128);
		body5.mirror = true;
		setRotation(body5, 0F, 0F, 0F);
		//	this.bipedBody.addChild(body5);

		body3 = new ModelRenderer(this, 40, 27);
		body3.addBox(-4F, 8.5F, -2.3F, 8, 2, 1);
		body3.setRotationPoint(0F, 0F, 0F);
		body3.setTextureSize(128, 128);
		body3.mirror = true;
		setRotation(body3, 0F, 0F, 0F);
		//	this.bipedBody.addChild(body3);

		body4 = new ModelRenderer(this, 20, 33);
		body4.addBox(-4.3F, 8.5F, -2F, 1, 2, 4);
		body4.setRotationPoint(0F, 0F, 0F);
		body4.setTextureSize(128, 128);
		body4.mirror = true;
		setRotation(body4, 0F, 0F, 0F);
		//		this.bipedBody.addChild(body4);

		leftleg4 = new ModelRenderer(this, 42, 0);
		leftleg4.addBox(-3.5F, 0F, -2F, 7, 7, 1);
		leftleg4.setRotationPoint(0F, 10F, 0F);
		leftleg4.setTextureSize(128, 128);
		leftleg4.mirror = true;
		setRotation(leftleg4, -0.0872665F, 0F, 0F);
		//		this.bipedLeftLeg.addChild(leftleg4);

		leftleg3 = new ModelRenderer(this, 42, 0);
		leftleg3.addBox(-3.5F, 0F, 1F, 7, 7, 1);
		leftleg3.setRotationPoint(0F, 10F, 0F);
		leftleg3.setTextureSize(128, 128);
		leftleg3.mirror = true;
		setRotation(leftleg3, 0.0872665F, 0F, 0F);
		//		this.bipedLeftLeg.addChild(leftleg3);

		//Boots
		leftarm9 = new ModelRenderer(this, 90, 0);
		leftarm9.addBox(-2F, 9F, -2F, 4, 3, 4);
		leftarm9.setRotationPoint(2F, 12F, 0F);
		leftarm9.setTextureSize(128, 128);
		leftarm9.mirror = true;
		setRotation(leftarm9, 0F, 0F, 0F);
		//	this.bipedLeftLeg.addChild(leftarm9);

		leftarm10 = new ModelRenderer(this, 106, 10);
		leftarm10.addBox(-1F, 8F, -2.2F, 2, 2, 1);
		leftarm10.setRotationPoint(-2F, 12F, 0F);
		leftarm10.setTextureSize(128, 128);
		leftarm10.mirror = true;
		setRotation(leftarm10, 0F, 0F, 0F);
		//	this.bipedLeftLeg.addChild(leftarm10);

		leftarm11 = new ModelRenderer(this, 106, 10);
		leftarm11.addBox(-1F, 8F, -2.2F, 2, 2, 1);
		leftarm11.setRotationPoint(-2F, 12F, 0F);
		leftarm11.setTextureSize(128, 128);
		leftarm11.mirror = true;
		setRotation(leftarm11, 0F, 0F, 0F);
		//	this.bipedLeftLeg.addChild(leftarm11);

		leftarm12 = new ModelRenderer(this, 106, 5);
		leftarm12.addBox(-2F, 7.5F, -2F, 4, 1, 4);
		leftarm12.setRotationPoint(2F, 12F, 0F);
		leftarm12.setTextureSize(128, 128);
		leftarm12.mirror = true;
		setRotation(leftarm12, 0F, 0F, 0F);
		//	this.bipedLeftLeg.addChild(leftarm12);

		leftarm13 = new ModelRenderer(this, 90, 7);
		leftarm13.addBox(-2F, 9F, -2F, 4, 3, 4);
		leftarm13.setRotationPoint(-2F, 12F, 0F);
		leftarm13.setTextureSize(128, 128);
		leftarm13.mirror = true;
		setRotation(leftarm13, 0F, 0F, 0F);
		//	this.bipedLeftLeg.addChild(leftarm13);

		leftarm14 = new ModelRenderer(this, 106, 0);
		leftarm14.addBox(-2F, 7.5F, -2F, 4, 1, 4);
		leftarm14.setRotationPoint(-2F, 12F, 0F);
		leftarm14.setTextureSize(128, 128);
		leftarm14.mirror = true;
		setRotation(leftarm14, 0F, 0F, 0F);
		//	this.bipedLeftLeg.addChild(leftarm14);


		this.bipedHead.cubeList.clear();
		this.bipedHeadwear.cubeList.clear();
		this.bipedBody.cubeList.clear();
		this.bipedRightArm.cubeList.clear();
		this.bipedLeftArm.cubeList.clear();
		this.bipedLeftLeg.cubeList.clear();
		this.bipedRightLeg.cubeList.clear();


	}

	//setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		GlStateManager.pushMatrix();
		GlStateManager.scale(1.05f, 1.05f, 1.05f);

		if (entity.isSneaking())
		{
			GlStateManager.translate(0.0F, 0.2F, 0.0F);
		}

		if(this.Which == 0)
		{
			copyModelAngles(this.bipedHead, this.head);
			copyModelAngles(this.bipedHead, this.head1);
			copyModelAngles(this.bipedHead, this.head2);
			copyModelAngles(this.bipedHead, this.head3);
			copyModelAngles(this.bipedHead, this.head4);
			copyModelAngles(this.bipedHead, this.head5);
			copyModelAngles(this.bipedHead, this.head6);
			copyModelAngles(this.bipedHead, this.head7);
			copyModelAngles(this.bipedHead, this.head8);
			copyModelAngles(this.bipedHead, this.head9);
			copyModelAngles(this.bipedHead, this.head10);
			copyModelAngles(this.bipedHead, this.head11);
			copyModelAngles(this.bipedHead, this.head12);
			copyModelAngles(this.bipedHead, this.head13);
			copyModelAngles(this.bipedHead, this.head14);
			copyModelAngles(this.bipedHead, this.head15);

			head.render(f5);
			head1.render(f5);
			head2.render(f5);
			head3.render(f5);
			head4.render(f5);
			head5.render(f5);
			head6.render(f5);
			head7.render(f5);
			head8.render(f5);
			head9.render(f5);
			head10.render(f5);
			head11.render(f5);
			head12.render(f5);
			head13.render(f5);
			head14.render(f5);
			head15.render(f5);

		}else if(this.Which == 1)
		{
			copyModelAngles(this.bipedLeftArm, this.leftarm);
			copyModelAngles(this.bipedLeftArm, this.leftarm1);
			copyModelAngles(this.bipedLeftArm, this.leftarm2);
			copyModelAngles(this.bipedLeftArm, this.leftarm3);
			copyModelAngles(this.bipedLeftArm, this.leftarm4);
			copyModelAngles(this.bipedLeftArm, this.leftarm5);
			copyModelAngles(this.bipedLeftArm, this.leftarm6);
			copyModelAngles(this.bipedLeftArm, this.leftarm7);
			copyModelAngles(this.bipedLeftArm, this.leftarm9);
			copyModelAngles(this.bipedLeftArm, this.LeftarmArmour);
			copyModelAngles(this.bipedLeftArm, this.LeftarmArmour1);
			copyModelAngles(this.bipedRightArm, this.RightarmArmour);
			copyModelAngles(this.bipedRightArm, this.RightarmArmour1);
			copyModelAngles(this.bipedRightArm, this.RightarmArmour2);
			copyModelAngles(this.bipedRightArm, this.RightarmArmour3);
			copyModelAngles(this.bipedRightArm, this.RightarmArmour4);
			copyModelAngles(this.bipedRightArm, this.RightarmArmour5);

			copyModelAngles(this.bipedBody, this.body);
			copyModelAngles(this.bipedBody, this.body1);

			copyModelAngles(this.bipedBody, this.BodyArmour);
			copyModelAngles(this.bipedBody, this.BodyArmour2);
			copyModelAngles(this.bipedBody, this.BodyArmour3);
			copyModelAngles(this.bipedBody, this.BodyArmour4);
			copyModelAngles(this.bipedBody, this.BodyArmour5);
			copyModelAngles(this.bipedBody, this.BodyArmour6);
			copyModelAngles(this.bipedBody, this.BodyArmour7);



			leftarm.render(f5);
			RightarmArmour.render(f5);
			RightarmArmour1.render(f5);
			RightarmArmour2.render(f5);
			RightarmArmour3.render(f5);
			BodyArmour.render(f5);
			body.render(f5);
			BodyArmour1.render(f5);
			leftarm1.render(f5);
			leftarm2.render(f5);
			leftarm3.render(f5);
			leftarm4.render(f5);
			leftarm5.render(f5);
			leftarm6.render(f5);
			leftarm7.render(f5);
			leftarm8.render(f5);
			BodyArmour2.render(f5);
			BodyArmour3.render(f5);
			BodyArmour4.render(f5);
			BodyArmour5.render(f5);
			BodyArmour6.render(f5);
			BodyArmour7.render(f5);
			LeftarmArmour.render(f5);
			RightarmArmour4.render(f5);
			LeftarmArmour1.render(f5);
			RightarmArmour5.render(f5);
			body1.render(f5);


		}else if(this.Which == 2)
		{

			this.rightleg.rotateAngleX  =  MathHelper.cos(f * 0.6662F) * 1.4F * f1 / 1.0f;
			this.leftleg.rotateAngleX =  MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1 / 1.0f;
			
			this.leftleg1.rotateAngleX =  MathHelper.cos(f * 0.6662F) * 1.4F * f1 / 1.0f;
			this.leftleg2.rotateAngleX =  MathHelper.abs(MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1 / 1.0f);
			
			this.leftleg4.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1 / 1.0f;
			this.leftleg3.rotateAngleX =  MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1 / 1.0f;
		
			
			copyModelAngles(this.bipedBody, this.body2);
			copyModelAngles(this.bipedBody, this.body3);
			copyModelAngles(this.bipedBody, this.body4);
			copyModelAngles(this.bipedBody, this.body5);


			rightleg.render(f5);
			leftleg.render(f5);
			leftleg1.render(f5);
			body2.render(f5);
			leftleg2.render(f5);
			body5.render(f5);
			body3.render(f5);
			body4.render(f5);
			leftleg4.render(f5);
			leftleg3.render(f5);

		}else if(this.Which == 3)
		{

			copyModelAngles(this.bipedLeftLeg, this.leftarm9);
			copyModelAngles(this.leftarm9, this.leftarm10);

			copyModelAngles(this.bipedRightLeg, this.leftarm11);
			copyModelAngles(this.bipedLeftLeg, this.leftarm12);

			copyModelAngles(this.bipedRightLeg, this.leftarm13);
			copyModelAngles(this.bipedRightLeg, this.leftarm14);


			leftarm9.render(f5);
			leftarm10.render(f5);
			leftarm11.render(f5);
			leftarm12.render(f5);
			leftarm13.render(f5);
			leftarm14.render(f5);
		}

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

