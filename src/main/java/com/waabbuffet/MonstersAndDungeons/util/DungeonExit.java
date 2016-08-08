package com.waabbuffet.MonstersAndDungeons.util;

import net.minecraft.util.math.BlockPos;

public class DungeonExit {

	
	String Direction;
	BlockPos pos;
	

	
	public DungeonExit(BlockPos pos, String Direction)
	{
		this.Direction = Direction;
		this.pos = pos;
		
	}
			
}
