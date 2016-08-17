package com.waabbuffet.MonstersAndDungeons.util.dungeon;

import net.minecraft.util.math.BlockPos;

public class DungeonExit {


	String Direction;
	BlockPos pos; //Not this is only the distance from the starting point to the exit (0, 0, 0) Not actual position
	boolean isCorrectPath;
	int rotation;



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
		return this.Direction;
	}
	
	public void setRotation(int rotation)
	{
		this.rotation = rotation;
		this.Direction = this.getDirectionWithRotation(rotation);
		
	}

	/**
	 * Rotates in a clockwise direction
	 */
	public String getDirectionWithRotation(int Times)
	{
		String RotatedDirection = this.getDirection(); //WEST
		
		for(int i =0; i < Times; i ++)
		{
			if(RotatedDirection.contains("EAST"))
			{
				RotatedDirection = "SOUTH";
			}else if(RotatedDirection.contains("WEST"))
			{
				RotatedDirection = "NORTH";
			}else if(RotatedDirection.contains("NORTH"))
			{
				RotatedDirection = "EAST";
			}else if(RotatedDirection.contains("SOUTH"))
			{
				RotatedDirection = "WEST";
			}
					
		}
		return RotatedDirection;
	}
	
	
	public String getOppositeDirection()
	{
		String RotatedDirection = this.getDirection();
		
		if(RotatedDirection .contains("EAST"))
		{
			RotatedDirection = "WEST";
		}else if(RotatedDirection .contains("WEST"))
		{
			RotatedDirection = "EAST";
		}else if(RotatedDirection .contains("NORTH"))
		{
			RotatedDirection = "SOUTH";
		}else if(RotatedDirection .contains("SOUTH"))
		{
			RotatedDirection = "NORTH";
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
