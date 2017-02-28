package monstersanddungeons.blocks.miscellaneous;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.AxisAlignedBB;
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

	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, World worldIn, BlockPos pos)
	{
		return NULL_AABB;
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState iBlockState) {
		return EnumBlockRenderType.INVISIBLE;
	}

}

