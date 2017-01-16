package com.waabbuffet.MonstersAndDungeons.world;

import java.util.Random;

import com.waabbuffet.MonstersAndDungeons.util.dungeon.DungeonExit;
import com.waabbuffet.MonstersAndDungeons.util.dungeon.DungeonRoom;
import com.waabbuffet.MonstersAndDungeons.world.dungeons.DungeonAutomatons;

import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class MaDWorldGenerationHandler implements IWorldGenerator {



	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {


<<<<<<< HEAD
		if(random.nextInt(1000) == 31)
=======
		if(random.nextInt(100) == 0 && false)
>>>>>>> 25bdae1c78d9f4310ef6b72aa0f5102d77b2e274
		{
			int posX = chunkX * 16 + random.nextInt(16);
			int posZ = chunkZ * 16 + random.nextInt(16);
			int posY = random.nextInt(30)  + 10;
				
<<<<<<< HEAD
			DungeonAutomatons dungeon = new DungeonAutomatons(15);
			dungeon.ConstructDungeon(world, new BlockPos(posX, posY, posZ), dungeon.getDungeonSize());			
=======
			DungeonAutomatons dungeon = new DungeonAutomatons(7);
			dungeon.ConstructDungeon(world, new BlockPos(posX, posY + 40, posZ), dungeon.getDungeonSize());
>>>>>>> 25bdae1c78d9f4310ef6b72aa0f5102d77b2e274
		}
	}

}
