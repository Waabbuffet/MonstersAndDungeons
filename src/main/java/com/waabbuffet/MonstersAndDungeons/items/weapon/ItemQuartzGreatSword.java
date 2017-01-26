package com.waabbuffet.MonstersAndDungeons.items.weapon;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemQuartzGreatSword extends ItemSword {

	
	public ItemQuartzGreatSword(ToolMaterial material, String name) {
		super(material);

		this.setCreativeTab(CreativeTabs.COMBAT);
		setUnlocalizedName(name);
		setRegistryName(name);
		
		GameRegistry.register(this);
	}
	
	
	
	
}
