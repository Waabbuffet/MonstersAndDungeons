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


<<<<<<< HEAD
		if(random.nextInt(100) == 0 && false)
=======
		if(random.nextInt(100) == 0)
>>>>>>> 8b6081fe644657aac12a7ecef2a0266a4ca3032b
		{
			this.spawnOnce = false;
			int posX = chunkX * 16 + random.nextInt(16);
			int posZ = chunkZ * 16 + random.nextInt(16);
			int posY = world.getTopSolidOrLiquidBlock(new BlockPos(posX, 0, posZ)).getY();
				
<<<<<<< HEAD
			DungeonAutomatons dungeon = new DungeonAutomatons(7);
			dungeon.ConstructDungeon(world, new BlockPos(posX, posY + 40, posZ), dungeon.getDungeonSize());
=======
			
			DungeonAutomatons dungeon = new DungeonAutomatons(12, true);
			dungeon.constructDungeon(world, new BlockPos(posX, posY + 40, posZ), "WEST");
			dungeon.unloadDungeon();	
>>>>>>> 8b6081fe644657aac12a7ecef2a0266a4ca3032b
		}
	}

}
