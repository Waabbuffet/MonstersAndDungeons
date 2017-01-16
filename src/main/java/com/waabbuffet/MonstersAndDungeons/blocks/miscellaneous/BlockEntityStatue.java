package com.waabbuffet.MonstersAndDungeons.blocks.miscellaneous;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
<<<<<<< HEAD
import net.minecraft.block.state.IBlockState;
=======
>>>>>>> 25bdae1c78d9f4310ef6b72aa0f5102d77b2e274
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
<<<<<<< HEAD
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
=======
import net.minecraft.util.math.BlockPos;
>>>>>>> 25bdae1c78d9f4310ef6b72aa0f5102d77b2e274
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
<<<<<<< HEAD
	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, World worldIn, BlockPos pos)
	{
		return NULL_AABB;
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState iBlockState) {
		return EnumBlockRenderType.INVISIBLE;
	}

=======
>>>>>>> 25bdae1c78d9f4310ef6b72aa0f5102d77b2e274
}

