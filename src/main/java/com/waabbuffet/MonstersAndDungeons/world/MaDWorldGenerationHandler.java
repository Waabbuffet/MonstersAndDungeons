package com.waabbuffet.MonstersAndDungeons.world;

import java.util.Random;

import com.waabbuffet.MonstersAndDungeons.world.dungeons.DungeonAutomatons;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class MaDWorldGenerationHandler implements IWorldGenerator {

	
	boolean isConstructing = false;
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

		if(random.nextInt(1300) == 31 && !this.isConstructing)
		{
			this.isConstructing = true;
			int posX = chunkX * 16 + random.nextInt(16);
			int posZ = chunkZ * 16 + random.nextInt(16);
			int posY = random.nextInt(30)  + 10;
			
			DungeonAutomatons dungeon = new DungeonAutomatons(12);
			dungeon.ConstructDungeon(world, new BlockPos(posX, posY, posZ), dungeon.getDungeonSize());		
			this.isConstructing = false;
		}
	}
}
