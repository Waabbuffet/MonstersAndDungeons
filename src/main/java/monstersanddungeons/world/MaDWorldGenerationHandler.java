package monstersanddungeons.world;

import java.util.Random;

import monstersanddungeons.world.dungeons.DungeonAutomatons;
import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class MaDWorldGenerationHandler implements IWorldGenerator {


	boolean isConstructing = false;

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

		if(random.nextInt(1300) == 31 && !this.isConstructing)
		{
			int posX = chunkX * 16 + random.nextInt(16);
			int posZ = chunkZ * 16 + random.nextInt(16);
			int posY = random.nextInt(30)  + 10;

			Biome biome = world.getBiomeGenForCoords(new BlockPos(posX, posY, posZ));

			if(!biome.equals(Biomes.DEEP_OCEAN) && !biome.equals(Biomes.OCEAN))
			{
				this.isConstructing = true;
				DungeonAutomatons dungeon = new DungeonAutomatons(12);
				dungeon.ConstructDungeon(world, new BlockPos(posX, posY, posZ), dungeon.getDungeonSize());		
			}
			
			this.isConstructing = false;
		}
	}
}
