package com.waabbuffet.MonstersAndDungeons.blocks.dungeonBuilder;

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

public class BlockRotten extends Block{

	public BlockRotten(String name) {
		super(Material.WOOD);
		
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
		GameRegistry.register(this);
		GameRegistry.register(new ItemBlock(this), getRegistryName());
		
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		
		if(entityIn instanceof EntityPlayer)
		{
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
		}
	
		super.onEntityWalk(worldIn, pos, entityIn);
	}

}
