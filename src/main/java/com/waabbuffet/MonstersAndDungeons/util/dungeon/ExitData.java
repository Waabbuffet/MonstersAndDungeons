package com.waabbuffet.MonstersAndDungeons.util.dungeon;

import net.minecraft.util.math.BlockPos;

public class ExitData
{
	BlockPos pos;
	EnumDirection direction;
	DungeonRoom previousRoom;
	DungeonExit RealExit;
	
	public ExitData(BlockPos pos, EnumDirection enumDirection) 
	{
		this.pos = pos;
		this.direction = enumDirection;
	}
	
	public ExitData(BlockPos pos, DungeonExit exit, DungeonRoom room)
	{
		this(pos, exit.getDirection());
		previousRoom = room;
		RealExit = exit;
	}
	
	public BlockPos getPos() {
		return pos;
	}
	
	public EnumDirection getDirection() {
		return direction;
	}
	
	public DungeonRoom getPreviousRoom() {
		return previousRoom;
	}
	
	public DungeonExit getRealExit() {
		return RealExit;
	}
}