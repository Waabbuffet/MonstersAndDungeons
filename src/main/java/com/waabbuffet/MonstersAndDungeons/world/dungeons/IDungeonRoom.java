package com.waabbuffet.MonstersAndDungeons.world.dungeons;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.waabbuffet.MonstersAndDungeons.blocks.dungeonBuilder.BlockExit;
import com.waabbuffet.MonstersAndDungeons.util.DungeonExit;
import com.waabbuffet.MonstersAndDungeons.util.DungeonRoom;

public interface IDungeonRoom
{
	
	public void buildRoom(BlockPos startPos, World world, String Direction);
	public boolean loadRoom();
	public void unloadRoom();
	public boolean isLoaded();
	public void setCorrectPath();
	
	public DungeonExit alignWithRoom(DungeonRoom NextRoom, DungeonRoom PreviousRoom, DungeonExit PreviousEntrance, BlockPos RealWorldPosition);
	
	
}
