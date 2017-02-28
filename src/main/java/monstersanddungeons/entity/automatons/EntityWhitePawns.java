package monstersanddungeons.entity.automatons;

import monstersanddungeons.entity.MaDEntityMonsterBase;
import monstersanddungeons.sound.MaDSoundsHandler;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityWhitePawns extends MaDEntityMonsterBase {

	public EntityWhitePawns(World worldIn) {
		super(worldIn);

		this.setHealth(15);
		
		this.tasks.addTask(0, new EntityAIAttackMelee(this, 0.7D, false));
		this.tasks.addTask(1, new EntityAIWander(this, 0.7D));
		this.tasks.addTask(2, new EntityAILookIdle(this));
		
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[] {EntityWhitePawns.class}));
	}

	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
	}
	
	@Override
	protected SoundEvent getHurtSound() {
		return MaDSoundsHandler.automatonHurtStone;
	}


	@Override
	public NBTTagCompound getNBTData() {
		
		NBTTagCompound compound = new NBTTagCompound();
		
		compound.setFloat("Health", this.getHealth());
		compound.setInteger("EntityID", 1);
			
		return compound;
	}
	
	
	@Override
	protected void damageEntity(DamageSource damageSrc, float damageAmount) {
	
		if(damageSrc != damageSrc.inWall)
		{
			super.damageEntity(damageSrc, damageAmount);
		}
	}
}
