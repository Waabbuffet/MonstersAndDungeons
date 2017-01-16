package com.waabbuffet.MonstersAndDungeons.util.dungeon;

import net.minecraft.util.math.BlockPos;

public class ExitData
{
	BlockPos pos;
	String Direction;
	DungeonRoom previousRoom;
	DungeonExit RealExit;
	
	public ExitData(BlockPos pos, String Direction) 
	{
		this.pos = pos;
		this.Direction = Direction;
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
	
	public String getDirection() {
		return Direction;
	}
	
	public DungeonRoom getPreviousRoom() {
		return previousRoom;
	}
	
	public DungeonExit getRealExit() {
		return RealExit;
	}
}