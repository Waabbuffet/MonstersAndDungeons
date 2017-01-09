package com.waabbuffet.MonstersAndDungeons.entity.automatons;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityAutomatonsRook extends EntityMob{

	
	@SideOnly(Side.CLIENT)
	int animationCycle, TickCount = 0;
	
	
	public EntityAutomatonsRook(World worldIn) {
		super(worldIn);
		// TODO Auto-generated constructor stub
		
		
	}
	
	public int getAnimationCycle() {
		return animationCycle;
	}
	
	@Override
	public void onUpdate() {
	
		if(TickCount == 0)
		{
			TickCount = 1;
			if(animationCycle < 16)
				animationCycle ++;
			else
				animationCycle = 0;
		}else
		{
			TickCount --;
		}
		
		super.onUpdate();
	}

}
