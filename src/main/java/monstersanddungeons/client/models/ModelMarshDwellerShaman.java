package monstersanddungeons.client.models;

import monstersanddungeons.entity.marshdwellers.EntityMarshDweller;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelMarshDwellerShaman extends MaDEntityModelBase{

	ModelRenderer belly;
	ModelRenderer upperChest;
	ModelRenderer leftboob;
	ModelRenderer rightboob;
	ModelRenderer mouth;
	ModelRenderer rightknee;
	ModelRenderer leftknee;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer lefteye;
	ModelRenderer righteye;
	ModelRenderer rightshoulder;
	ModelRenderer leftshoulder;
	ModelRenderer righthand;
	ModelRenderer lefthand;
	ModelRenderer leftfinger;
	ModelRenderer leftfinger1;
	ModelRenderer leftfinger2;
	ModelRenderer leftfinger3;
	ModelRenderer rightfinger;
	ModelRenderer rightfinger1;
	ModelRenderer rightfinger2;
	ModelRenderer rightfinger3;
	ModelRenderer leftToe;
	ModelRenderer leftToe1;
	ModelRenderer leftToe2;
	ModelRenderer rightToe;
	ModelRenderer rightToe1;
	ModelRenderer rightToe2;
	ModelRenderer middlechest;
	ModelRenderer leftshoulderband;
	ModelRenderer leftshoulderband1;
	ModelRenderer righthandband;
	ModelRenderer rightshoulderband;
	ModelRenderer lefthandband;
	ModelRenderer neck;
	ModelRenderer neck1;
	ModelRenderer neck2;
	ModelRenderer neck3;
	ModelRenderer neck4;
	ModelRenderer neck5;
	ModelRenderer neck6;
	ModelRenderer neck7;
	ModelRenderer neck8;
	ModelRenderer neck9;
	ModelRenderer neck10;
	ModelRenderer neck11;
	ModelRenderer neck12;
	ModelRenderer neck13;
	ModelRenderer skullhead;
	ModelRenderer skullhead1;
	ModelRenderer skullhead2;
	ModelRenderer skullhead3;
	ModelRenderer skullhead4;
	ModelRenderer skullhead5;
	ModelRenderer head;
	ModelRenderer skullhead6;
	ModelRenderer skullhead7;
	ModelRenderer skullhead8;
	ModelRenderer skullhead9;
	ModelRenderer skullhead10;
	ModelRenderer skullhead11;
	ModelRenderer legCover;
	ModelRenderer legCover1;
	ModelRenderer legCover2;
	ModelRenderer legCover3;
	ModelRenderer legCover4;
	ModelRenderer legCover5;
	ModelRenderer legCover6;
	ModelRenderer legCover7;
	ModelRenderer legCover8;
	ModelRenderer legCover9;

	public ModelMarshDwellerShaman()
	{
		textureWidth = 128;
		textureHeight = 128;

		belly = new ModelRenderer(this, 0, 0);
		belly.addBox(-8F, -6F, -8F, 16, 12, 15);
		belly.setRotationPoint(0F, 6F, 0F);
		belly.setTextureSize(128, 128);
		belly.mirror = true;
		setRotation(belly, -0.1745329F, 0F, 0F);
		upperChest = new ModelRenderer(this, 64, 0);
		upperChest.addBox(-7F, -14F, -4.5F, 14, 10, 11);
		upperChest.setRotationPoint(0F, 6F, 0F);
		upperChest.setTextureSize(128, 128);
		upperChest.mirror = true;
		setRotation(upperChest, 0F, 0F, 0F);
		leftboob = new ModelRenderer(this, 64, 22);
		leftboob.addBox(-7.3F, -12F, -7F, 7, 5, 1);
		leftboob.setRotationPoint(0F, 6F, 0F);
		leftboob.setTextureSize(128, 128);
		leftboob.mirror = true;
		setRotation(leftboob, -0.1919862F, 0F, 0.0174533F);
		rightboob = new ModelRenderer(this, 90, 22);
		rightboob.addBox(0.3F, -12F, -7F, 7, 5, 1);
		rightboob.setRotationPoint(0F, 6F, 0F);
		rightboob.setTextureSize(128, 128);
		rightboob.mirror = true;
		setRotation(rightboob, -0.1919862F, 0F, -0.0174533F);
		mouth = new ModelRenderer(this, 38, 28);
		mouth.addBox(-5F, 0F, -8F, 10, 7, 8);
		mouth.setRotationPoint(0F, -12F, 2F);
		mouth.setTextureSize(128, 128);
		mouth.mirror = true;
		setRotation(mouth, -0.0523599F, 0F, 0F);
		rightknee = new ModelRenderer(this, 0, 46);
		rightknee.addBox(-3F, -1F, -5.5F, 6, 7, 9);
		rightknee.setRotationPoint(4F, 12F, 0F);
		rightknee.setTextureSize(128, 128);
		rightknee.mirror = true;
		setRotation(rightknee, -0.2617994F, 0F, -0.0872665F);
		leftknee = new ModelRenderer(this, 29, 46);
		leftknee.addBox(-3F, -1F, -5.5F, 6, 7, 9);
		leftknee.setRotationPoint(-4F, 12F, 0F);
		leftknee.setTextureSize(128, 128);
		leftknee.mirror = true;
		setRotation(leftknee, -0.2617994F, 0F, 0.0872665F);
		rightleg = new ModelRenderer(this, 28, 62);
		rightleg.addBox(-3.7F, -1F, -2.5F, 7, 9, 7);
		rightleg.setRotationPoint(4.5F, 16F, 1F);
		rightleg.setTextureSize(128, 128);
		rightleg.mirror = true;
		setRotation(rightleg, 0F, -0.0872665F, 0F);
		leftleg = new ModelRenderer(this, 0, 62);
		leftleg.addBox(-3.3F, -1F, -2.5F, 7, 9, 7);
		leftleg.setRotationPoint(-4.5F, 16F, 1F);
		leftleg.setTextureSize(128, 128);
		leftleg.mirror = true;
		setRotation(leftleg, 0F, 0.0872665F, 0F);
		lefteye = new ModelRenderer(this, 80, 22);
		lefteye.addBox(-6.5F, -5.5F, -4.5F, 2, 3, 3);
		lefteye.setRotationPoint(0F, -9F, 2F);
		lefteye.setTextureSize(128, 128);
		lefteye.mirror = true;
		setRotation(lefteye, 0F, -0.1745329F, 0F);
		righteye = new ModelRenderer(this, 106, 22);
		righteye.addBox(4.5F, -5.5F, -4.5F, 2, 3, 3);
		righteye.setRotationPoint(0F, -9F, 2F);
		righteye.setTextureSize(128, 128);
		righteye.mirror = true;
		setRotation(righteye, 0F, 0.1745329F, 0F);
		rightshoulder = new ModelRenderer(this, 96, 28);
		rightshoulder.addBox(-1F, -3F, -3F, 5, 10, 6);
		rightshoulder.setRotationPoint(8F, -4F, 1.5F);
		rightshoulder.setTextureSize(128, 128);
		rightshoulder.mirror = true;
		setRotation(rightshoulder, 0F, 0F, -0.1745329F);
		leftshoulder = new ModelRenderer(this, 74, 28);
		leftshoulder.addBox(-4F, -3F, -3F, 5, 10, 6);
		leftshoulder.setRotationPoint(-8F, -4F, 1.5F);
		leftshoulder.setTextureSize(128, 128);
		leftshoulder.mirror = true;
		setRotation(leftshoulder, 0F, 0F, 0.1745329F);
		righthand = new ModelRenderer(this, 86, 44);
		righthand.addBox(-3F, 0F, -3.5F, 6, 8, 7);
		righthand.setRotationPoint(11F, 2F, 1.5F);
		righthand.setTextureSize(128, 128);
		righthand.mirror = true;
		setRotation(righthand, 0F, 0F, 0F);
		lefthand = new ModelRenderer(this, 60, 44);
		lefthand.addBox(-3F, 0F, -3.5F, 6, 8, 7);
		lefthand.setRotationPoint(-11F, 2F, 1.5F);
		lefthand.setTextureSize(128, 128);
		lefthand.mirror = true;
		setRotation(lefthand, 0F, 0F, 0F);
		leftfinger = new ModelRenderer(this, 60, 59);
		leftfinger.addBox(-1F, -1F, -1F, 4, 2, 2);
		leftfinger.setRotationPoint(-13F, 11F, 1.5F);
		leftfinger.setTextureSize(128, 128);
		leftfinger.mirror = true;
		setRotation(leftfinger, 0F, 0F, 0.1745329F);
		leftfinger1 = new ModelRenderer(this, 60, 63);
		leftfinger1.addBox(-1F, -1F, -1F, 4, 2, 2);
		leftfinger1.setRotationPoint(-13F, 11F, 3.7F);
		leftfinger1.setTextureSize(128, 128);
		leftfinger1.mirror = true;
		setRotation(leftfinger1, 0F, 0F, 0.0872665F);
		leftfinger2 = new ModelRenderer(this, 60, 67);
		leftfinger2.addBox(-1F, -1F, -1F, 4, 2, 2);
		leftfinger2.setRotationPoint(-13F, 11F, -0.7F);
		leftfinger2.setTextureSize(128, 128);
		leftfinger2.mirror = true;
		setRotation(leftfinger2, 0F, 0F, 0.2617994F);
		leftfinger3 = new ModelRenderer(this, 60, 71);
		leftfinger3.addBox(-1F, -1F, -1F, 2, 2, 4);
		leftfinger3.setRotationPoint(-9F, 11F, -0.7F);
		leftfinger3.setTextureSize(128, 128);
		leftfinger3.mirror = true;
		setRotation(leftfinger3, -0.2617994F, 0F, 0F);
		rightfinger = new ModelRenderer(this, 72, 59);
		rightfinger.addBox(-3F, -1F, -1F, 4, 2, 2);
		rightfinger.setRotationPoint(13F, 11F, 1.5F);
		rightfinger.setTextureSize(128, 128);
		rightfinger.mirror = true;
		setRotation(rightfinger, 0F, 0F, -0.1745329F);
		rightfinger1 = new ModelRenderer(this, 72, 67);
		rightfinger1.addBox(-3F, -1F, -1F, 4, 2, 2);
		rightfinger1.setRotationPoint(13F, 11F, -0.7F);
		rightfinger1.setTextureSize(128, 128);
		rightfinger1.mirror = true;
		setRotation(rightfinger1, 0F, 0F, -0.2617994F);
		rightfinger2 = new ModelRenderer(this, 72, 63);
		rightfinger2.addBox(-3F, -1F, -1F, 4, 2, 2);
		rightfinger2.setRotationPoint(13F, 11F, 3.7F);
		rightfinger2.setTextureSize(128, 128);
		rightfinger2.mirror = true;
		setRotation(rightfinger2, 0F, 0F, -0.0872665F);
		rightfinger3 = new ModelRenderer(this, 72, 71);
		rightfinger3.addBox(-1F, -1F, -1F, 2, 2, 4);
		rightfinger3.setRotationPoint(9F, 11F, -0.7F);
		rightfinger3.setTextureSize(128, 128);
		rightfinger3.mirror = true;
		setRotation(rightfinger3, -0.2617994F, 0F, 0F);
		leftToe = new ModelRenderer(this, 0, 78);
		leftToe.addBox(-3.3F, 6.5F, -6.5F, 2, 2, 5);
		leftToe.setRotationPoint(-4.5F, 16F, 1F);
		leftToe.setTextureSize(128, 128);
		leftToe.mirror = true;
		setRotation(leftToe, -0.0872665F, 0.1745329F, 0F);
		leftToe1 = new ModelRenderer(this, 28, 78);
		leftToe1.addBox(1.7F, 6.5F, -6.5F, 2, 2, 5);
		leftToe1.setRotationPoint(-4.5F, 16F, 1F);
		leftToe1.setTextureSize(128, 128);
		leftToe1.mirror = true;
		setRotation(leftToe1, -0.0872665F, 0F, 0F);
		leftToe2 = new ModelRenderer(this, 14, 78);
		leftToe2.addBox(-0.7F, 6.5F, -6.5F, 2, 2, 5);
		leftToe2.setRotationPoint(-4.5F, 16F, 1F);
		leftToe2.setTextureSize(128, 128);
		leftToe2.mirror = true;
		setRotation(leftToe2, -0.0872665F, 0.0872665F, 0F);
		rightToe = new ModelRenderer(this, 0, 85);
		rightToe.addBox(1.3F, 6.5F, -6.5F, 2, 2, 5);
		rightToe.setRotationPoint(4.5F, 16F, 1F);
		rightToe.setTextureSize(128, 128);
		rightToe.mirror = true;
		setRotation(rightToe, -0.0872665F, -0.1745329F, 0F);
		rightToe1 = new ModelRenderer(this, 28, 85);
		rightToe1.addBox(-3.7F, 6.5F, -6.5F, 2, 2, 5);
		rightToe1.setRotationPoint(4.5F, 16F, 1F);
		rightToe1.setTextureSize(128, 128);
		rightToe1.mirror = true;
		setRotation(rightToe1, -0.0872665F, 0F, 0F);
		rightToe2 = new ModelRenderer(this, 14, 85);
		rightToe2.addBox(-1.3F, 6.5F, -6.5F, 2, 2, 5);
		rightToe2.setRotationPoint(4.5F, 16F, 1F);
		rightToe2.setTextureSize(128, 128);
		rightToe2.mirror = true;
		setRotation(rightToe2, -0.0872665F, -0.0872665F, 0F);
		middlechest = new ModelRenderer(this, 84, 59);
		middlechest.addBox(-6.5F, -5F, -9F, 13, 3, 2);
		middlechest.setRotationPoint(0F, 6F, 0F);
		middlechest.setTextureSize(128, 128);
		middlechest.mirror = true;
		setRotation(middlechest, -0.6108652F, 0F, 0F);
		leftshoulderband = new ModelRenderer(this, 0, 92);
		leftshoulderband.addBox(-4.5F, -1F, -3.5F, 6, 3, 7);
		leftshoulderband.setRotationPoint(-8F, -4F, 1.5F);
		leftshoulderband.setTextureSize(128, 128);
		leftshoulderband.mirror = true;
		setRotation(leftshoulderband, 0F, 0F, 0.1745329F);
		leftshoulderband1 = new ModelRenderer(this, 26, 92);
		leftshoulderband1.addBox(-4.5F, 3F, -3.5F, 6, 1, 7);
		leftshoulderband1.setRotationPoint(-8F, -4F, 1.5F);
		leftshoulderband1.setTextureSize(128, 128);
		leftshoulderband1.mirror = true;
		setRotation(leftshoulderband1, 0F, 0F, 0.1745329F);
		righthandband = new ModelRenderer(this, 0, 102);
		righthandband.addBox(-3.5F, 1F, -4F, 7, 4, 8);
		righthandband.setRotationPoint(11F, 2F, 1.5F);
		righthandband.setTextureSize(128, 128);
		righthandband.mirror = true;
		setRotation(righthandband, 0F, 0F, 0F);
		rightshoulderband = new ModelRenderer(this, 52, 92);
		rightshoulderband.addBox(-1.5F, 3.5F, -3.5F, 6, 2, 7);
		rightshoulderband.setRotationPoint(8F, -4F, 1.5F);
		rightshoulderband.setTextureSize(128, 128);
		rightshoulderband.mirror = true;
		setRotation(rightshoulderband, 0F, 0F, -0.1745329F);
		lefthandband = new ModelRenderer(this, 30, 102);
		lefthandband.addBox(-3.5F, 1F, -4F, 7, 3, 8);
		lefthandband.setRotationPoint(-11F, 2F, 1.5F);
		lefthandband.setTextureSize(128, 128);
		lefthandband.mirror = true;
		setRotation(lefthandband, 0F, 0F, 0F);
		neck = new ModelRenderer(this, 0, 114);
		neck.addBox(-1.5F, -9.5F, -8.5F, 3, 3, 3);
		neck.setRotationPoint(0F, 6F, 0F);
		neck.setTextureSize(128, 128);
		neck.mirror = true;
		setRotation(neck, -0.1745329F, 0F, 0F);
		neck1 = new ModelRenderer(this, 0, 114);
		neck1.addBox(-8.5F, -8.7F, -7.5F, 3, 3, 3);
		neck1.setRotationPoint(0F, 6F, 0F);
		neck1.setTextureSize(128, 128);
		neck1.mirror = true;
		setRotation(neck1, -0.0872665F, 0F, 0.3490659F);
		neck2 = new ModelRenderer(this, 0, 114);
		neck2.addBox(5.5F, -8.7F, -7.5F, 3, 3, 3);
		neck2.setRotationPoint(0F, 6F, 0F);
		neck2.setTextureSize(128, 128);
		neck2.mirror = true;
		setRotation(neck2, -0.0872665F, 0F, -0.3490659F);
		neck3 = new ModelRenderer(this, 0, 114);
		neck3.addBox(-14.5F, -3F, -7F, 3, 3, 3);
		neck3.setRotationPoint(0F, 6F, 0F);
		neck3.setTextureSize(128, 128);
		neck3.mirror = true;
		setRotation(neck3, -0.0872665F, 0.1745329F, 0.9599311F);
		neck4 = new ModelRenderer(this, 0, 114);
		neck4.addBox(11.5F, -3F, -7F, 3, 3, 3);
		neck4.setRotationPoint(0F, 6F, 0F);
		neck4.setTextureSize(128, 128);
		neck4.mirror = true;
		setRotation(neck4, -0.0872665F, -0.1745329F, -0.9599311F);
		neck5 = new ModelRenderer(this, 0, 114);
		neck5.addBox(13.5F, 1F, -3.5F, 3, 3, 3);
		neck5.setRotationPoint(0F, 6F, 0F);
		neck5.setTextureSize(128, 128);
		neck5.mirror = true;
		setRotation(neck5, -0.0872665F, -0.0872665F, -1.22173F);
		neck6 = new ModelRenderer(this, 0, 114);
		neck6.addBox(-16.5F, 1F, -3.5F, 3, 3, 3);
		neck6.setRotationPoint(0F, 6F, 0F);
		neck6.setTextureSize(128, 128);
		neck6.mirror = true;
		setRotation(neck6, -0.0872665F, 0.0872665F, 1.22173F);
		neck7 = new ModelRenderer(this, 0, 114);
		neck7.addBox(-16.5F, 1F, 0.8F, 3, 3, 3);
		neck7.setRotationPoint(0F, 6F, 0F);
		neck7.setTextureSize(128, 128);
		neck7.mirror = true;
		setRotation(neck7, -0.0872665F, 0.1745329F, 1.22173F);
		neck8 = new ModelRenderer(this, 0, 114);
		neck8.addBox(13.5F, 1F, 0.8F, 3, 3, 3);
		neck8.setRotationPoint(0F, 6F, 0F);
		neck8.setTextureSize(128, 128);
		neck8.mirror = true;
		setRotation(neck8, -0.0872665F, -0.1745329F, -1.22173F);
		neck9 = new ModelRenderer(this, 0, 114);
		neck9.addBox(-1.5F, -9F, 6.5F, 3, 3, 3);
		neck9.setRotationPoint(0F, 6F, 0F);
		neck9.setTextureSize(128, 128);
		neck9.mirror = true;
		setRotation(neck9, 0.0872665F, 0F, 0F);
		neck10 = new ModelRenderer(this, 0, 114);
		neck10.addBox(-8F, -8.7F, 5.5F, 3, 3, 3);
		neck10.setRotationPoint(0F, 6F, 0F);
		neck10.setTextureSize(128, 128);
		neck10.mirror = true;
		setRotation(neck10, 0F, 0F, 0.3490659F);
		neck11 = new ModelRenderer(this, 0, 114);
		neck11.addBox(5F, -8.7F, 5.5F, 3, 3, 3);
		neck11.setRotationPoint(0F, 6F, 0F);
		neck11.setTextureSize(128, 128);
		neck11.mirror = true;
		setRotation(neck11, 0F, 0F, -0.3490659F);
		neck12 = new ModelRenderer(this, 0, 114);
		neck12.addBox(12F, -4F, 4F, 3, 3, 3);
		neck12.setRotationPoint(0F, 6F, 0F);
		neck12.setTextureSize(128, 128);
		neck12.mirror = true;
		setRotation(neck12, -0.1745329F, 0F, -0.9599311F);
		neck13 = new ModelRenderer(this, 0, 114);
		neck13.addBox(-15F, -4F, 4F, 3, 3, 3);
		neck13.setRotationPoint(0F, 6F, 0F);
		neck13.setTextureSize(128, 128);
		neck13.mirror = true;
		setRotation(neck13, -0.1745329F, 0F, 0.9599311F);
		skullhead = new ModelRenderer(this, 42, 81);
		skullhead.addBox(-3.5F, -11.5F, -7.5F, 7, 6, 5);
		skullhead.setRotationPoint(0F, -9F, 2F);
		skullhead.setTextureSize(128, 128);
		skullhead.mirror = true;
		setRotation(skullhead, -0.2617994F, 0F, 0F);
		skullhead1 = new ModelRenderer(this, 66, 81);
		skullhead1.addBox(-3.5F, -11.5F, -2.5F, 7, 5, 2);
		skullhead1.setRotationPoint(0F, -9F, 2F);
		skullhead1.setTextureSize(128, 128);
		skullhead1.mirror = true;
		setRotation(skullhead1, -0.2617994F, 0F, 0F);
		skullhead2 = new ModelRenderer(this, 42, 79);
		skullhead2.addBox(-2F, -5.5F, -7.5F, 4, 1, 1);
		skullhead2.setRotationPoint(0F, -9F, 2F);
		skullhead2.setTextureSize(128, 128);
		skullhead2.mirror = true;
		setRotation(skullhead2, -0.2617994F, 0F, 0F);
		skullhead3 = new ModelRenderer(this, 58, 79);
		skullhead3.addBox(-1F, -6.5F, -7.6F, 2, 1, 1);
		skullhead3.setRotationPoint(0F, -9F, 2F);
		skullhead3.setTextureSize(128, 128);
		skullhead3.mirror = true;
		setRotation(skullhead3, -0.2617994F, 0F, 0F);
		skullhead4 = new ModelRenderer(this, 52, 79);
		skullhead4.addBox(-3F, -7.5F, -7.6F, 2, 1, 1);
		skullhead4.setRotationPoint(0F, -9F, 2F);
		skullhead4.setTextureSize(128, 128);
		skullhead4.mirror = true;
		setRotation(skullhead4, -0.2617994F, 0F, 0F);
		skullhead5 = new ModelRenderer(this, 52, 79);
		skullhead5.addBox(1F, -7.5F, -7.6F, 2, 1, 1);
		skullhead5.setRotationPoint(0F, -9F, 2F);
		skullhead5.setTextureSize(128, 128);
		skullhead5.mirror = true;
		setRotation(skullhead5, -0.2617994F, 0F, 0F);
		head = new ModelRenderer(this, 0, 28);
		head.addBox(-4.5F, -6F, -7F, 9, 8, 10);
		head.setRotationPoint(0F, -9F, 2F);
		head.setTextureSize(128, 128);
		head.mirror = true;
		setRotation(head, -0.0523599F, 0F, 0F);
		skullhead6 = new ModelRenderer(this, 12, 114);
		skullhead6.addBox(-9.633333F, -10.5F, -2.5F, 6, 1, 1);
		skullhead6.setRotationPoint(0F, -9F, 2F);
		skullhead6.setTextureSize(128, 128);
		skullhead6.mirror = true;
		setRotation(skullhead6, 0F, 0F, 0.122173F);
		skullhead7 = new ModelRenderer(this, 12, 116);
		skullhead7.addBox(-6.633333F, -9.5F, -3.5F, 5, 1, 1);
		skullhead7.setRotationPoint(0F, -9F, 2F);
		skullhead7.setTextureSize(128, 128);
		skullhead7.mirror = true;
		setRotation(skullhead7, 0F, 0F, -0.122173F);
		skullhead8 = new ModelRenderer(this, 12, 118);
		skullhead8.addBox(-7.633333F, -9.5F, -1.5F, 5, 1, 1);
		skullhead8.setRotationPoint(0F, -9F, 2F);
		skullhead8.setTextureSize(128, 128);
		skullhead8.mirror = true;
		setRotation(skullhead8, -0.0523599F, 0.0349066F, 0.0349066F);
		skullhead9 = new ModelRenderer(this, 12, 114);
		skullhead9.addBox(1.366667F, -9.5F, -3.5F, 6, 1, 1);
		skullhead9.setRotationPoint(0F, -9F, 2F);
		skullhead9.setTextureSize(128, 128);
		skullhead9.mirror = true;
		setRotation(skullhead9, 0F, 0F, 0.122173F);
		skullhead10 = new ModelRenderer(this, 12, 116);
		skullhead10.addBox(4.366667F, -10.5F, -3.5F, 5, 1, 1);
		skullhead10.setRotationPoint(0F, -9F, 2F);
		skullhead10.setTextureSize(128, 128);
		skullhead10.mirror = true;
		setRotation(skullhead10, 0F, 0F, -0.122173F);
		skullhead11 = new ModelRenderer(this, 12, 118);
		skullhead11.addBox(2.366667F, -9.5F, -1.5F, 5, 1, 1);
		skullhead11.setRotationPoint(0F, -9F, 2F);
		skullhead11.setTextureSize(128, 128);
		skullhead11.mirror = true;
		setRotation(skullhead11, -0.0523599F, 0.0349066F, -0.0349066F);
		legCover = new ModelRenderer(this, 0, 120);
		legCover.addBox(-7.5F, 5.5F, -7F, 15, 1, 1);
		legCover.setRotationPoint(0F, 6F, 0F);
		legCover.setTextureSize(128, 128);
		legCover.mirror = true;
		setRotation(legCover, -0.1745329F, 0F, 0F);
		legCover1 = new ModelRenderer(this, 32, 113);
		legCover1.addBox(-7.5F, 5.5F, -6F, 1, 1, 11);
		legCover1.setRotationPoint(0F, 6F, 0F);
		legCover1.setTextureSize(128, 128);
		legCover1.mirror = true;
		setRotation(legCover1, -0.1745329F, 0F, 0F);
		legCover2 = new ModelRenderer(this, 0, 120);
		legCover2.addBox(-7.5F, 5.5F, 5F, 15, 1, 1);
		legCover2.setRotationPoint(0F, 6F, 0F);
		legCover2.setTextureSize(128, 128);
		legCover2.mirror = true;
		setRotation(legCover2, -0.1745329F, 0F, 0F);
		legCover3 = new ModelRenderer(this, 32, 113);
		legCover3.addBox(6.5F, 5.5F, -6F, 1, 1, 11);
		legCover3.setRotationPoint(0F, 6F, 0F);
		legCover3.setTextureSize(128, 128);
		legCover3.mirror = true;
		setRotation(legCover3, -0.1745329F, 0F, 0F);
		legCover4 = new ModelRenderer(this, 56, 113);
		legCover4.addBox(-3F, 0F, -0.5F, 6, 8, 1);
		legCover4.setRotationPoint(0F, 11F, 5F);
		legCover4.setTextureSize(128, 128);
		legCover4.mirror = true;
		setRotation(legCover4, 0F, 0F, 0F);
		legCover5 = new ModelRenderer(this, 56, 113);
		legCover5.addBox(-3F, 0F, -0.5F, 6, 8, 1);
		legCover5.setRotationPoint(0F, 11F, -7F);
		legCover5.setTextureSize(128, 128);
		legCover5.mirror = true;
		setRotation(legCover5, 0F, 0F, 0F);
		legCover6 = new ModelRenderer(this, 60, 106);
		legCover6.addBox(2F, 0F, 0F, 4, 7, 0);
		legCover6.setRotationPoint(0F, 11F, -7F);
		legCover6.setTextureSize(128, 128);
		legCover6.mirror = true;
		setRotation(legCover6, 0F, 0F, -0.0872665F);
		legCover7 = new ModelRenderer(this, 60, 106);
		legCover7.addBox(-6F, 0F, 0F, 4, 7, 0);
		legCover7.setRotationPoint(0F, 11F, -7F);
		legCover7.setTextureSize(128, 128);
		legCover7.mirror = true;
		setRotation(legCover7, 0F, 0F, 0.0872665F);
		legCover8 = new ModelRenderer(this, 60, 106);
		legCover8.addBox(-6F, 0F, 0F, 4, 7, 0);
		legCover8.setRotationPoint(0F, 11F, 5F);
		legCover8.setTextureSize(128, 128);
		legCover8.mirror = true;
		setRotation(legCover8, 0F, 0F, 0.0872665F);
		legCover9 = new ModelRenderer(this, 60, 106);
		legCover9.addBox(2F, 0F, 0F, 4, 7, 0);
		legCover9.setRotationPoint(0F, 11F, 5F);
		legCover9.setTextureSize(128, 128);
		legCover9.mirror = true;
		setRotation(legCover9, 0F, 0F, -0.0872665F);
		
		
		convertToChild(head, mouth);
		convertToChild(head, lefteye);
		convertToChild(head, righteye);
		convertToChild(head, skullhead);
		convertToChild(head, skullhead1);
		convertToChild(head, skullhead2);
		convertToChild(head, skullhead3);
		convertToChild(head, skullhead4);
		convertToChild(head, skullhead5);
		convertToChild(head, skullhead6);
		convertToChild(head, skullhead7);
		convertToChild(head, skullhead8);
		convertToChild(head, skullhead9);
		convertToChild(head, skullhead10);
		convertToChild(head, skullhead11);
		
		
		convertToChild(righthand, righthandband);
		convertToChild(righthand, rightfinger);
		convertToChild(righthand, rightfinger1);
		convertToChild(righthand, rightfinger2);
		convertToChild(righthand, rightfinger3);
		
		convertToChild(rightshoulder, righthand);
		convertToChild(rightshoulder, rightshoulderband);
		
		convertToChild(lefthand, lefthandband);
		convertToChild(lefthand, leftfinger);
		convertToChild(lefthand, leftfinger1);
		convertToChild(lefthand, leftfinger2);
		convertToChild(lefthand, leftfinger3);
		
		convertToChild(leftshoulder, lefthand);
		convertToChild(leftshoulder, leftshoulderband);
		convertToChild(leftshoulder, leftshoulderband1);
		
		convertToChild(upperChest, leftshoulder);
		convertToChild(upperChest, rightshoulder);
		convertToChild(upperChest, head);
		convertToChild(upperChest, leftboob);
		convertToChild(upperChest, rightboob);
		
		convertToChild(upperChest, neck);
		convertToChild(upperChest, neck1);
		convertToChild(upperChest, neck2);
		convertToChild(upperChest, neck3);
		convertToChild(upperChest, neck4);
		convertToChild(upperChest, neck5);
		convertToChild(upperChest, neck6);
		convertToChild(upperChest, neck7);
		convertToChild(upperChest, neck8);
		convertToChild(upperChest, neck9);
		convertToChild(upperChest, neck10);
		convertToChild(upperChest, neck11);
		convertToChild(upperChest, neck12);
		convertToChild(upperChest, neck13);
		
		convertToChild(belly, upperChest);
		convertToChild(belly, middlechest);
		convertToChild(belly, legCover);
		convertToChild(belly, legCover1);
		convertToChild(belly, legCover2);
		convertToChild(belly, legCover3);
		convertToChild(belly, legCover4);
		convertToChild(belly, legCover5);
		convertToChild(belly, legCover6);
		convertToChild(belly, legCover7);
		convertToChild(belly, legCover8);
		convertToChild(belly, legCover9);
		
		
		convertToChild(leftleg, leftToe);
		convertToChild(leftleg, leftToe1);
		convertToChild(leftleg, leftToe2);
		
		convertToChild(leftknee, leftleg);
		
		convertToChild(rightleg, rightToe);
		convertToChild(rightleg, rightToe1);
		convertToChild(rightleg, rightToe2);
		
		convertToChild(rightknee, rightleg);
	
		
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		
		belly.render(f5);
		rightknee.render(f5);
		leftknee.render(f5);
		
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	public void sitDown()
	{
		movePiece(this.leftshoulder, 1f, -45f, 0f, 0f);
		movePiece(this.rightshoulder, 1f, -45f, 0f, 0f);
		
		movePiece(this.leftknee, 1f, -90f, 10f, 0f);
		movePiece(this.rightknee, 1f, -90f, -10f, 0f);
		movePiece(this.belly, 1f, 0f, 0f, 0f);
		
		moveoffSet(this.leftknee, 0.01f, 0.4f);
		moveoffSet(this.rightknee, 0.01f, 0.4f);
		moveoffSet(this.belly, 0.01f, 0.4f);
	}

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
	{
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);

		EntityMarshDweller dweller = (EntityMarshDweller) entityIn;

		if(!dweller.isSittingDown())
		{
			float  f = 1f;
			this.head.rotateAngleY = netHeadYaw * 0.017453292F;
			this.head.rotateAngleX = headPitch * 0.017453292F;

			this.rightknee.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
			this.leftknee.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount / f;

			this.rightshoulder.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
			this.leftshoulder.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount / f;

			moveoffSet(this.leftknee, 0.01f, 0f);
			moveoffSet(this.rightknee, 0.01f, 0f);
			moveoffSet(this.belly, 0.01f, 0f);
		}else
		{
			this.sitDown();
		}
	}

}
