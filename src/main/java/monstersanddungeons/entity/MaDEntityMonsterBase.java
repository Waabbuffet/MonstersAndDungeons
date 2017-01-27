package monstersanddungeons.entity;

import java.util.List;

import monstersanddungeons.blocks.MaDBlocksHandler;
import monstersanddungeons.tileentity.miscellaneous.TileEntityMonsterStatue;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public abstract class MaDEntityMonsterBase extends EntityMob
{

	int playerCheckCD;
	
	public MaDEntityMonsterBase(World worldIn) {
		super(worldIn);
	}
		
	@Override
	protected boolean canDespawn() {
		return false;
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		
		if(playerCheckCD == 0)
		{
			playerCheckCD = 20;
			
			if(!isPlayerNearby())
			{
				TileEntityMonsterStatue statue = new TileEntityMonsterStatue(this);
			
				
				worldObj.setBlockState(this.getPosition().up(), MaDBlocksHandler.BlockEntityStatue.getDefaultState());
				worldObj.setTileEntity(this.getPosition().up(), statue);
				
				this.setDead();
			}
		}else
		{
			playerCheckCD --;
		}
		
	}
	
	public boolean isPlayerNearby()
	{
		List<EntityPlayer> entities = worldObj.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB(this.getPosition().getX() - 25, this.getPosition().getY() - 25, this.getPosition().getZ() - 25, this.getPosition().getX() + 25, this.getPosition().getY() + 25, this.getPosition().getZ() + 25));

        if (entities.isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
	}
	
	public abstract NBTTagCompound getNBTData();
}
