package com.waabbuffet.MonstersAndDungeons.items.weapon;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemQuartzWarHammer extends ItemAxe{

	public ItemQuartzWarHammer(ToolMaterial material, String name) {
		super(material, 9, -3.2F);

		this.setCreativeTab(CreativeTabs.COMBAT);
				
		setUnlocalizedName(name);
		setRegistryName(name);
		
		GameRegistry.register(this);
	}
}
