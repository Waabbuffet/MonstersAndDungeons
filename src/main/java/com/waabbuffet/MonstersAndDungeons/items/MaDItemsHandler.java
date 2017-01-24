package com.waabbuffet.MonstersAndDungeons.items;

import com.waabbuffet.MonstersAndDungeons.items.armor.ArmorStat;
import com.waabbuffet.MonstersAndDungeons.items.armor.ItemQuartzArmor;
import com.waabbuffet.MonstersAndDungeons.items.armor.ItemQuartzShield;
import com.waabbuffet.MonstersAndDungeons.items.weapon.ItemQuartzGreatSword;
import com.waabbuffet.MonstersAndDungeons.items.weapon.ItemQuartzWarHammer;
import com.waabbuffet.MonstersAndDungeons.stats.Stats;
import com.waabbuffet.MonstersAndDungeons.util.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;



public class MaDItemsHandler 
{
	public static ToolMaterial toolMaterialQuartz = EnumHelper.addToolMaterial("RomanSpartanExample", 3, 1000, 15.0F, 4.0F, 30);
	
	public static ArmorMaterial armorMaterialQuartz = EnumHelper.addArmorMaterial("RomanSpartanArmorExample", "wc:RomanArmor", 16, new int[] {3, 8, 6, 3}, 20, null, 1f);

	public static Item quartzHelmet, quartzChest, quartzLegs, quartzBoots, quartzShield, quartzWarhammer, quartzGreatSword;

	public static void init()
	{
		quartzHelmet = new ItemQuartzArmor(armorMaterialQuartz , 1,  EntityEquipmentSlot.HEAD, "quartzHelmet", new ArmorStat[]{new ArmorStat(Stats.strength), new ArmorStat(Stats.wisdom)});
		quartzChest  = new ItemQuartzArmor(armorMaterialQuartz , 1, EntityEquipmentSlot.CHEST, "quartzChest", new ArmorStat[]{new ArmorStat(Stats.strength, 3)});
		quartzLegs =  new ItemQuartzArmor(armorMaterialQuartz , 1, EntityEquipmentSlot.LEGS, "quartzLegs", new ArmorStat[]{new ArmorStat(Stats.strength, 2)});
		quartzBoots = new ItemQuartzArmor(armorMaterialQuartz , 1, EntityEquipmentSlot.FEET, "quartzBoots", new ArmorStat[]{new ArmorStat(Stats.strength)});
		quartzShield = new ItemQuartzShield("quartzShield");
		
		quartzWarhammer = new ItemQuartzWarHammer(toolMaterialQuartz, "quartzWarhammer");
		quartzGreatSword = new ItemQuartzGreatSword(toolMaterialQuartz, "quartzGreatSword");

	}

	public static void registerRenders()
	{

		registerRender(quartzHelmet);
		registerRender(quartzChest);
		registerRender(quartzLegs);
		registerRender(quartzBoots);
		registerRender(quartzShield);
		
		registerRender(quartzWarhammer);
		registerRender(quartzGreatSword);

	}

	public static void registerRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5),"inventory"));
	}

}
