package com.waabbuffet.MonstersAndDungeons.util.dungeon;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.waabbuffet.MonstersAndDungeons.blocks.dungeonBuilder.BlockExit;

public interface IDungeonRoom
{
	
	public void buildRoom(BlockPos startPos, World world, String Direction);
	public boolean loadRoom();
	public void unloadRoom();
	public boolean isLoaded();
	public DungeonExit setCorrectPath();
	
	public DungeonExit alignWithRoom(DungeonRoom NextRoom, DungeonRoom PreviousRoom, DungeonExit PreviousEntrance, BlockPos RealWorldPosition);
	
	
}
