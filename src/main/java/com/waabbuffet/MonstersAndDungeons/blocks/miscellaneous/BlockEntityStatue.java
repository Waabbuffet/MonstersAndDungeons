package com.waabbuffet.MonstersAndDungeons.blocks.miscellaneous;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockEntityStatue extends Block{

	public BlockEntityStatue(String name) {
		super(Material.WOOD);
		
		
		setUnlocalizedName(name);
		setRegistryName(name);
		
		GameRegistry.register(this);
		
		// TODO Auto-generated constructor stub
	}
}

