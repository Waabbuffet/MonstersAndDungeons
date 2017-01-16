package com.waabbuffet.MonstersAndDungeons.tileentity.miscellaneous;

import java.util.Collections;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;

import com.waabbuffet.MonstersAndDungeons.entity.MaDEntityMonsterBase;
import com.waabbuffet.MonstersAndDungeons.entity.automatons.EntityAutomatonsRook;
import com.waabbuffet.MonstersAndDungeons.entity.automatons.EntityWitePawns;

public class TileEntityMonsterStatue extends TileEntity implements ITickable { 

	
	NBTTagCompound storedDATA;
	int checkPlayerCD;
	boolean spawnOnce = true;
	
	public TileEntityMonsterStatue(MaDEntityMonsterBase entity) {
		// TODO Auto-generated constructor stub
		storedDATA = entity.getNBTData();
	}
	
	
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {

		compound.setTag("storedDATA", storedDATA);
		
		return super.writeToNBT(compound);
	}
	
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		
		storedDATA = (NBTTagCompound) compound.getTag("storedDATA");
		
		super.readFromNBT(compound);
	}

	public boolean isPlayerNearby()
	{
		List<EntityPlayer> entities = worldObj.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB(this.getPos().getX() - 25, this.getPos().getY() - 25, this.getPos().getZ() - 25, this.getPos().getX() + 25, this.getPos().getY() + 25, this.getPos().getZ() + 25));

        if (entities.isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
	}
	
			
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		if(this.checkPlayerCD == 0)
		{
			this.checkPlayerCD = 20;
				if(isPlayerNearby())
				{
					if(storedDATA != null)
					{
						int EntityID = storedDATA.getInteger("EntityID");
						Entity entityToSpawn = null;
						
						switch(EntityID)
						{
						case 0:
							entityToSpawn = new EntityAutomatonsRook(this.worldObj);
							
							break;
						case 1:
							entityToSpawn = new EntityWitePawns(this.worldObj);
							break;
						}
						
						entityToSpawn.setPosition(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ());
						
						if(spawnOnce)
						{
							if(!this.worldObj.isRemote)
								this.worldObj.spawnEntityInWorld(entityToSpawn);
						
							this.spawnOnce = false;
						}
						
<<<<<<< HEAD
						this.worldObj.setBlockToAir(this.getPos());
						this.worldObj.removeTileEntity(this.getPos());
					}else
					{
						this.worldObj.setBlockToAir(this.getPos());
						this.worldObj.removeTileEntity(this.getPos());
=======
						this.worldObj.removeTileEntity(this.getPos());
						this.worldObj.setBlockToAir(this.getPos());
>>>>>>> 25bdae1c78d9f4310ef6b72aa0f5102d77b2e274
					}
				}
		}else
			this.checkPlayerCD--;
	}	
}
