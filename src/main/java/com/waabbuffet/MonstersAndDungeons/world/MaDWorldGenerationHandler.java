package com.waabbuffet.MonstersAndDungeons.world;

import java.util.Random;

import com.waabbuffet.MonstersAndDungeons.util.dungeon.DungeonExit;
import com.waabbuffet.MonstersAndDungeons.util.dungeon.DungeonRoom;
import com.waabbuffet.MonstersAndDungeons.world.dungeons.DungeonAutomatons;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class MaDWorldGenerationHandler implements IWorldGenerator {



	boolean spawnOnce = true;



	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {


		if(random.nextInt(100) == 0 && false)
		{
			this.spawnOnce = false;
			int posX = chunkX * 16 + random.nextInt(16);
			int posZ = chunkZ * 16 + random.nextInt(16);
			int posY = world.getTopSolidOrLiquidBlock(new BlockPos(posX, 0, posZ)).getY();
				
			DungeonAutomatons dungeon = new DungeonAutomatons(7);
			dungeon.ConstructDungeon(world, new BlockPos(posX, posY + 40, posZ), dungeon.getDungeonSize());
		}
	}

}
