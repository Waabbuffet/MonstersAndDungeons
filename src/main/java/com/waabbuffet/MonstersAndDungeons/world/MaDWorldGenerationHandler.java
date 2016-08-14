package com.waabbuffet.MonstersAndDungeons.world;

import java.util.Random;

import com.waabbuffet.MonstersAndDungeons.world.dungeons.DungeonAutomatons;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class MaDWorldGenerationHandler implements IWorldGenerator {

	
	
	
	boolean SpawnOnce = true;
	
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
	
		
		if(this.SpawnOnce)
		{
		
			int posX = chunkX * 16 + random.nextInt(16);
			int posZ = chunkZ * 16 + random.nextInt(16);
			int posY = world.getTopSolidOrLiquidBlock(new BlockPos(posX, 0, posZ)).getY();
			
			this.SpawnOnce = false;
			DungeonAutomatons dungeon = new DungeonAutomatons(10, true);
			dungeon.constructDungeon(world, new BlockPos(posX, posY + 40, posZ), "EAST");
			
		}
	
	}
	
}
