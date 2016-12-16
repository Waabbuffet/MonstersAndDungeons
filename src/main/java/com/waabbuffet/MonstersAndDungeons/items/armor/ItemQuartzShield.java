package com.waabbuffet.MonstersAndDungeons.items.armor;

import com.waabbuffet.MonstersAndDungeons.util.Reference;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemQuartzShield extends ItemShield {



	public ItemQuartzShield(String name) {
		
		setUnlocalizedName(name);
		setRegistryName(name);
		
		GameRegistry.register(this);
	}
}
