package com.waabbuffet.MonstersAndDungeons.items.armor;

import com.waabbuffet.MonstersAndDungeons.client.models.items.ModelQuartzArmor;
import com.waabbuffet.MonstersAndDungeons.util.Reference;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemQuartzArmor extends ItemArmor {





	public ItemQuartzArmor(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, String name) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		// TODO Auto-generated constructor stub
		
		setUnlocalizedName(name);
		setRegistryName(name);
		
		GameRegistry.register(this);
	}

	@SideOnly(Side.CLIENT)
	public ModelBiped model;

	@SideOnly(Side.CLIENT)
	@Override
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {

		

		if (model == null) 
		{

			if (armorSlot.getSlotIndex() == 4) model = new ModelQuartzArmor(1.1F, 0);
			else if (armorSlot.getSlotIndex() == 3) model = new ModelQuartzArmor(1.1F, 1);
			else if (armorSlot.getSlotIndex() == 2) model = new ModelQuartzArmor(1.1F, 2);
			else model = new ModelQuartzArmor(1.1F, 3);


		}

		this.model.bipedHead.showModel = (armorSlot.getSlotIndex() == 0);
		this.model.bipedHeadwear.showModel = (armorSlot.getSlotIndex() == 0);
		this.model.bipedBody.showModel = ((armorSlot.getSlotIndex() == 1) || (armorSlot.getSlotIndex() == 2));
		this.model.bipedLeftArm.showModel = (armorSlot.getSlotIndex() == 1);
		this.model.bipedRightArm.showModel = (armorSlot.getSlotIndex() == 1);
		this.model.bipedLeftLeg.showModel = (armorSlot.getSlotIndex() == 2 || armorSlot.getSlotIndex() == 3);
		this.model.bipedRightLeg.showModel = (armorSlot.getSlotIndex() == 2 || armorSlot.getSlotIndex() == 3);

		if (entityLiving == null) return model;

		this.model.isSneak = entityLiving.isSneaking();
		this.model.isRiding = entityLiving.isRiding();
		this.model.isChild = entityLiving.isChild();

		
		return model;
	}






	@Override
	public String getArmorTexture(ItemStack stack, Entity entity,
			EntityEquipmentSlot slot, String type) {
		// TODO Auto-generated method stub
		return Reference.MODID + ":textures/armor/Quartz Armour.png";
	}







}
