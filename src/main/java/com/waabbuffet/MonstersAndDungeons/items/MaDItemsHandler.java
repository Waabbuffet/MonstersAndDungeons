package com.waabbuffet.MonstersAndDungeons.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.waabbuffet.MonstersAndDungeons.items.armor.ItemQuartzArmor;
import com.waabbuffet.MonstersAndDungeons.items.armor.ItemQuartzShield;



public class MaDItemsHandler 
{
	public static ArmorMaterial QuartzArmorExample = EnumHelper.addArmorMaterial("RomanSpartanArmorExample", "wc:RomanArmor",16, new int[] {3, 8, 6, 3}, 30, null, 1f);

	public static Item QuartzHelmet, QuartzChest, QuartzLegs, QuartzBoots, QuartzShield;

	public static void init()
	{
		QuartzHelmet = new ItemQuartzArmor(QuartzArmorExample , 1,  EntityEquipmentSlot.HEAD).setUnlocalizedName( "QuartzHelmet");
		QuartzChest  = new ItemQuartzArmor(QuartzArmorExample , 1, EntityEquipmentSlot.CHEST).setUnlocalizedName( "QuartzChest");
		QuartzLegs =  new ItemQuartzArmor(QuartzArmorExample , 1, EntityEquipmentSlot.LEGS).setUnlocalizedName( "QuartzLegs");
		QuartzBoots = new ItemQuartzArmor(QuartzArmorExample , 1, EntityEquipmentSlot.FEET).setUnlocalizedName( "QuartzBoots");
		QuartzShield = new ItemQuartzShield().setUnlocalizedName("QuartzShield");





	}

	public static void register()
	{
		GameRegistry.registerItem(QuartzHelmet, QuartzHelmet.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(QuartzChest, QuartzChest.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(QuartzLegs, QuartzLegs.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(QuartzBoots, QuartzBoots.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(QuartzShield, QuartzShield.getUnlocalizedName().substring(5));
		
		
	}


	public static void registerRenders()
	{
		registerRender(QuartzHelmet);
		registerRender(QuartzChest);
		registerRender(QuartzLegs);
		registerRender(QuartzBoots);
		registerRender(QuartzShield);
		
	}

	
	public static void registerRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation("Monsteranddungeons:" + item.getUnlocalizedName().substring(5),"inventory"));
	}

}
