package com.waabbuffet.MonstersAndDungeons.world.dungeons;

import net.minecraft.util.math.BlockPos;

import com.waabbuffet.MonstersAndDungeons.util.DungeonRoom;

public interface IDungeonRoom
{
	
	public void buildRoom(BlockPos startPos);
	public boolean loadRoom();
	public void unloadRoom();
	
	public BlockPos alignWithRoom(DungeonRoom entrance);
	
	
}
