package com.waabbuffet.MonstersAndDungeons.entity.automatons;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.waabbuffet.MonstersAndDungeons.entity.MaDEntityMonsterBase;
import com.waabbuffet.MonstersAndDungeons.items.MaDItemsHandler;
import com.waabbuffet.MonstersAndDungeons.packet.MaDPacketHandler;
import com.waabbuffet.MonstersAndDungeons.packet.UpdateClientEntityAnimation;



public class EntityAutomatonsRook extends MaDEntityMonsterBase {


	@SideOnly(Side.CLIENT)
	int animationCycle = 0, TickCount = 0;
	public boolean SlamAttack, PunchMode;


	public EntityAutomatonsRook(World worldIn) {
		super(worldIn);
		this.setSize(1.4f, 3.4f);

		this.setHealth(300);

		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[] {EntityPigZombie.class}));
	}
	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		// TODO Auto-generated method stub
		return super.attackEntityAsMob(entityIn);
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();

		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(300D);

		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(5D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(7.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
	}



	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		switch(rand.nextInt(15))
		{
		case 0:
			this.dropItem(MaDItemsHandler.quartzBoots, 1);
			break;
		case 1:
			this.dropItem(MaDItemsHandler.quartzLegs, 1);
			break;
		case 2:
			this.dropItem(MaDItemsHandler.quartzChest, 1);
			break;
		case 3:
			this.dropItem(MaDItemsHandler.quartzHelmet, 1);
			break;
		case 4:
			this.dropItem(MaDItemsHandler.quartzShield, 1);
			break;
		case 5:
			this.dropItem(MaDItemsHandler.quartzGreatSword, 1);
			break;
		case 6:
			this.dropItem(MaDItemsHandler.quartzWarhammer, 1);
			break;
		default:
		}
	}

	public int getAnimationCycle() {
		return animationCycle;
	}

	public void setAnimationCycle(int number)
	{
		this.animationCycle = number;
	}

	/**
	 * @param animationID - 0 = slam, 1 = punch, 2 = half hp animation, 3 = death animation
	 */
	public void acivateAnimationby(int animationID)
	{
		switch(animationID)
		{
		case 0:
			this.setSlamAttack(true);
			break;
		case 1:
			this.setPunchMode(true);
			break;
		case 2:
			break;
		}
	}

	@Override
	protected void damageEntity(DamageSource damageSrc, float damageAmount) {

		if(!damageSrc.isExplosion() && !damageSrc.isFireDamage() && !damageSrc.isProjectile() && !damageSrc.isMagicDamage())
		{
			super.damageEntity(damageSrc, damageAmount);
		}
	}

	/** 0 = slam, 1 = punch
	 * @param attackNumber
	 */
	public void activateAttack(int attackNumber)
	{
		//slam
		if(attackNumber == 0)
		{
			List<Entity> entities = worldObj.getEntitiesWithinAABBExcludingEntity(this, new AxisAlignedBB(this.getPosition().getX() - 5, this.getPosition().getY() - 5, this.getPosition().getZ() - 5, this.getPosition().getX() + 5, this.getPosition().getY() + 5, this.getPosition().getZ() + 5));

			for(Entity entity : entities)
			{
				if(entity != null)
				{
					this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(15.0D);
					this.attackEntityAsMob(entity);
				}
			}
		}else if (attackNumber == 1) // punch 
		{
			if(this.getAttackTarget() != null)
			{
				if(this.getAttackTarget().getDistanceToEntity(this) <= 3)
				{
					this.attackEntityAsMob(this.getAttackTarget());
				}
			}
		}
	}

	public void setSlamAttack(boolean slamAttack) {
		SlamAttack = slamAttack;
	}

	public void setPunchMode(boolean punchMode) {
		PunchMode = punchMode;
	}
	/**
	 * @param animationID - 0 = slam, 1 = punch, 2 = half hp animation, 3 = death animation
	 */
	public void startAnimation(int animation)
	{
		if(!worldObj.isRemote)
		{	
			MaDPacketHandler.INSTANCE.sendToAll(new UpdateClientEntityAnimation(this, animation));
		}
	}

	public void inAnimation()
	{
		if(this.SlamAttack)
		{
			if(TickCount == 0)
			{
				TickCount = 1;
				if(animationCycle < 26)
				{
					animationCycle ++;

					if(animationCycle >= 14 && animationCycle <= 17)
					{
						this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 3, false);
						this.activateAttack(0);
					}
				}
				else
				{
					animationCycle = 0;
					this.SlamAttack = false;
				}
			}else
			{
				TickCount --;
			}
		}else
			if(this.PunchMode)
			{
				if(TickCount == 0)
				{
					TickCount = 1;
					if(animationCycle < 24)
					{
						animationCycle ++;

						if((animationCycle >= 8 && animationCycle <= 10) || (animationCycle >= 20 && animationCycle <= 22))
						{
							this.activateAttack(1);
						}
					}
					else
					{
						animationCycle = 0;
						this.PunchMode = false;
					}
				}else
				{
					TickCount --;
				}
			}
	}


	@Override
	public void onUpdate() {
		super.onUpdate();

		if(this.getAttackTarget() != null)
		{
			BlockPos pos = this.getAttackTarget().getPosition();

			if(this.getPosition().distanceSq(pos.getX(), pos.getY(), pos.getZ()) <= 15)
			{
				if(this.getAnimationCycle() == 0)
				{
					if(this.getHealth() <= 150)
					{
						this.startAnimation(0);
						this.setSlamAttack(true);
					}else
					{
						this.startAnimation(1);
						this.setPunchMode(true);
					}
	
					if(!this.PunchMode && !this.SlamAttack)
						this.getLookHelper().setLookPositionWithEntity(this.getAttackTarget(), 30.0F, 30.0F);
				}
			}else
			{
				if(!this.PunchMode && !this.SlamAttack)
					this.getNavigator().setPath(this.getNavigator().getPathToEntityLiving(this.getAttackTarget()), this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
			}
		}
		inAnimation();
	}


	@Override
	public NBTTagCompound getNBTData() {

		NBTTagCompound compound = new NBTTagCompound();

		compound.setFloat("Health", this.getHealth());
		compound.setInteger("EntityID", 0);

		return compound;
	}
}

