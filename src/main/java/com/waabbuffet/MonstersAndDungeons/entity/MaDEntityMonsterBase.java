package com.waabbuffet.MonstersAndDungeons.entity;

import java.util.List;

import com.waabbuffet.MonstersAndDungeons.blocks.MaDBlocksHandler;
import com.waabbuffet.MonstersAndDungeons.tileentity.miscellaneous.TileEntityMonsterStatue;

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
		// TODO Auto-generated constructor stub
	}
		
	@Override
	protected boolean canDespawn() {
		// TODO Auto-generated method stub
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
