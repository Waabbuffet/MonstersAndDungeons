package com.waabbuffet.MonstersAndDungeons.util.dungeon;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IDungeonBuilder {

	
	public void constructDungeon(World world, BlockPos startingLocation, String direction);
	public void unloadDungeon();
}
