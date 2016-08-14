package com.waabbuffet.MonstersAndDungeons.util;

import net.minecraft.util.math.BlockPos;

public class DungeonExit {


	String Direction;
	BlockPos pos; //Not this is only the distance from the starting point to the exit (0, 0, 0) Not actual position
	boolean isCorrectPath;



	public DungeonExit(BlockPos pos, String Direction)
	{
		this.Direction = Direction;
		this.pos = pos;

	}

	public void setCorrectPath(boolean isCorrectPath) {
		this.isCorrectPath = isCorrectPath;
	}

	public boolean getCorrectPath()
	{
		return this.isCorrectPath;
	}


	public String getDirection() {
		return Direction;
	}

	/**
	 * Rotates in a clockwise direction
	 */
	public String getDirectionWithRotation(int Times)
	{
		String RotatedDirection = this.getDirection();
		
		for(int i =0; i < Times; i ++)
		{
			if(this.getDirection().contains("EAST"))
			{
				RotatedDirection = "SOUTH";
			}else if(this.getDirection().contains("WEST"))
			{
				RotatedDirection = "NORTH";
			}else if(this.getDirection().contains("NORTH"))
			{
				RotatedDirection = "EAST";
			}else if(this.getDirection().contains("SOUTH"))
			{
				RotatedDirection = "WEST";
			}
					
		}
		return RotatedDirection;
	}
	
	
	public void setDirection(String direction) {
		Direction = direction;
	}

	public BlockPos getPos() {
		return pos;
	}

	public void setPos(BlockPos pos) {
		this.pos = pos;
	}

}
