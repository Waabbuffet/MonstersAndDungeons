package com.waabbuffet.MonstersAndDungeons.entity.automatons;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.waabbuffet.MonstersAndDungeons.entity.MaDEntityMonsterBase;

public class EntityWitePawns extends MaDEntityMonsterBase {

	public EntityWitePawns(World worldIn) {
		super(worldIn);
		// TODO Auto-generated constructor stub
		
		this.setHealth(50);
		
		this.tasks.addTask(0, new EntityAIAttackMelee(this, 0.7D, false));
		this.tasks.addTask(7, new EntityAIWander(this, 0.7D));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[] {EntityPigZombie.class}));
	}

	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
	}


	@Override
	public NBTTagCompound getNBTData() {
		
		NBTTagCompound compound = new NBTTagCompound();
		
		compound.setFloat("Health", this.getHealth());
		compound.setInteger("EntityID", 1);
		
		
		return compound;
	}
}
