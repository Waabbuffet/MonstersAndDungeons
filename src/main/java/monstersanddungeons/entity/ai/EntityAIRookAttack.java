package monstersanddungeons.entity.ai;

import monstersanddungeons.entity.automatons.EntityAutomatonsRook;
import net.minecraft.entity.ai.EntityAIAttackMelee;

@Deprecated
public class EntityAIRookAttack extends EntityAIAttackMelee{

	EntityAutomatonsRook rook;

	public EntityAIRookAttack(EntityAutomatonsRook creature, double speedIn, boolean useLongMemory) {
		super(creature, speedIn, useLongMemory);
		rook = creature;
	}

	@Override
	public void startExecuting() {

		if(this.rook.getAnimationCycle() == 0)
		{
			if(this.rook.getHealth() <= 250)
			{
				this.rook.startAnimation(0);
				this.rook.setSlamAttack(true);
			}else
			{
				this.rook.startAnimation(1);
				this.rook.setPunchMode(true);
			}
		}
		super.startExecuting();
	}

	@Override
	public void resetTask() {
		super.resetTask();

		this.rook.setAnimationCycle(0);
		this.rook.setPunchMode(false);
		this.rook.setSlamAttack(false);
	}
}
