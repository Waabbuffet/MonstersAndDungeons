package com.waabbuffet.MonstersAndDungeons.items.weapon;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSword;

public class ItemQuartzWarHammer extends ItemAxe{

	public ItemQuartzWarHammer(ToolMaterial material) {
		super(material, material.getDamageVsEntity(), 1.0f);

		this.setCreativeTab(CreativeTabs.COMBAT);
	}

}
