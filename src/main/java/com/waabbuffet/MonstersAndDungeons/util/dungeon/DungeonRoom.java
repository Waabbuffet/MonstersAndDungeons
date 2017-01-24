package com.waabbuffet.MonstersAndDungeons.util.dungeon;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.waabbuffet.MonstersAndDungeons.blocks.MaDBlocksHandler;
import com.waabbuffet.MonstersAndDungeons.blocks.dungeonBuilder.BlockExit;
import com.waabbuffet.MonstersAndDungeons.entity.automatons.EntityWitePawns;
import com.waabbuffet.MonstersAndDungeons.util.StructureData;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DungeonRoom implements IDungeonRoom {

	StructureData roomStructure = new StructureData();
	String filename;
	String PrevBuiltDIRECTION;

	List<DungeonExit> exits = new ArrayList<DungeonExit>();
	Random rand = new Random();

	public DungeonRoom(String FileName) {
		// TODO Auto-generated constructor stub
		this.filename = FileName;
	}

	@Override
	public boolean isLoaded()
	{
		boolean Yes = false;

		if(this.roomStructure != null)
		{
			return this.roomStructure.getIsLoaded();
		}

		return Yes;
	}

	public void setPrevBuiltDIRECTION(String prevBuiltDIRECTION) {
		PrevBuiltDIRECTION = prevBuiltDIRECTION;
	}


	public StructureData getRoomStructure() {
		return roomStructure;
	}

	public List<DungeonExit> getExits() {
		return exits;
	}

	public void setExits(List<DungeonExit> exits) {
		this.exits = exits;
	}

	@Override
	public void buildRoom(BlockPos startPos, World world, String Direction) {
		// TODO Auto-generated method stub

		if(this.isLoaded())
		{
			if(Direction.contains("EAST"))
			{
				for(int x = 0; x < this.roomStructure.blocks.length; x ++)
				{
					for(int y = 0; y < this.roomStructure.blocks[0].length; y ++)
					{
						for(int z = 0; z < this.roomStructure.blocks[0][0].length; z ++)
						{
							world.setBlockState(new BlockPos(startPos.getX() + x, startPos.getY() + y,startPos.getZ() + z), this.roomStructure.blocks[x][y][z]);
							if(rand.nextInt(300) == 0 && canSpawnWite(x, y, z) && (!world.getBlockState(new BlockPos(startPos.getX() + x, startPos.getY() + y,startPos.getZ() + z)).equals(Blocks.AIR)))
							{

								EntityWitePawns pawn = new EntityWitePawns(world);
								pawn.setPosition(startPos.getX() + x, startPos.getY() + y + 2,startPos.getZ() + z);
								world.spawnEntityInWorld(pawn);

							}
						}
					}
				}
			}else if(Direction.contains("WEST"))
			{
				for(int x = 0; x < this.roomStructure.blocks.length; x ++)
				{
					for(int y = 0; y < this.roomStructure.blocks[0].length; y ++)
					{
						for(int z = 0; z < this.roomStructure.blocks[0][0].length; z ++)
						{
							world.setBlockState(new BlockPos(startPos.getX() - x, startPos.getY() + y,startPos.getZ() - z), this.roomStructure.blocks[x][y][z]);
							if(rand.nextInt(300) == 0 && canSpawnWite(x, y, z) && (!world.getBlockState(new BlockPos(startPos.getX() - x, startPos.getY() + y,startPos.getZ() - z)).equals(Blocks.AIR)))
							{

								EntityWitePawns pawn = new EntityWitePawns(world);
								pawn.setPosition(startPos.getX() - x, startPos.getY() + y + 2,startPos.getZ() - z);
								world.spawnEntityInWorld(pawn);

							}
						}	
					}
				}

			}else if(Direction.contains("NORTH"))
			{

				for(int x = 0; x < this.roomStructure.blocks.length; x ++)
				{
					for(int y = 0; y < this.roomStructure.blocks[0].length; y ++)
					{
						for(int z = 0; z < this.roomStructure.blocks[0][0].length; z ++)
						{
							world.setBlockState(new BlockPos(startPos.getX() + z, startPos.getY() + y,startPos.getZ() - x), this.roomStructure.blocks[x][y][z]);
							if(rand.nextInt(300) == 0 && canSpawnWite(x, y, z) && (!world.getBlockState(new BlockPos(startPos.getX() + z, startPos.getY() + y,startPos.getZ() - x)).equals(Blocks.AIR)))
							{

								EntityWitePawns pawn = new EntityWitePawns(world);
								pawn.setPosition(startPos.getX() + z, startPos.getY() + y + 2,startPos.getZ() - x);
								world.spawnEntityInWorld(pawn);

							}
						}	
					}
				}
			}else if(Direction.contains("SOUTH"))
			{
				for(int x = 0; x < this.roomStructure.blocks.length; x ++)
				{
					for(int y = 0; y < this.roomStructure.blocks[0].length; y ++)
					{
						for(int z = 0; z < this.roomStructure.blocks[0][0].length; z ++)
						{
							world.setBlockState(new BlockPos(startPos.getX() - z, startPos.getY() + y,startPos.getZ() + x), this.roomStructure.blocks[x][y][z]);

							if(rand.nextInt(300) == 0 && canSpawnWite(x, y, z) && (!world.getBlockState(new BlockPos(startPos.getX() - z, startPos.getY() + y,startPos.getZ() + x)).equals(Blocks.AIR)))
							{
								EntityWitePawns pawn = new EntityWitePawns(world);
								pawn.setPosition(startPos.getX() - z, startPos.getY() + y + 2,startPos.getZ() + x);
								world.spawnEntityInWorld(pawn);
							}
						}
					}
				}
			}
		}
	}
	
	private boolean canSpawnWite(int x, int y, int z)
	{
		
		if(x != this.roomStructure.blocks.length && x != 0)
		{
			if(y == 1)
			{
				if(z != this.roomStructure.blocks[0][0].length && z != 0)
				{
					return true;
				}
			}
		}
		
		return false;
	}
			

	@Override
	public boolean loadRoom() {
		// TODO Auto-generated method stub
		InputStream dungeonRoom = getClass().getClassLoader().getResourceAsStream(this.filename);
		int HowManyExits;			
		if(dungeonRoom != null)
		{
			this.roomStructure.setLoaded(true);
			NBTTagCompound cmp = DungeonNBTTag.getTagCompoundInFile(dungeonRoom);

			this.roomStructure.xSize = cmp.getInteger("MaxXValue");
			this.roomStructure.ySize = cmp.getInteger("MaxYValue");
			this.roomStructure.zSize = cmp.getInteger("MaxZValue");
			


			this.roomStructure.blocks = new IBlockState[this.roomStructure.xSize][this.roomStructure.ySize][this.roomStructure.zSize];

			for(int x = 0; x < this.roomStructure.blocks.length; x ++)
			{
				for(int y = 0; y < this.roomStructure.blocks[0].length; y ++)
				{
					for(int z = 0; z < this.roomStructure.blocks[0][0].length; z ++)
					{
						int ID = cmp.getInteger(x + "," + y + "," + z);
						this.roomStructure.blocks[x][y][z] = Block.getStateById(ID);
					}
				}
			}


			HowManyExits = cmp.getInteger("TotalExits");
			for(int i = 0; i < HowManyExits; i ++)
			{
				int X =	cmp.getInteger("ExitNumberX" + i);
				int Y =	cmp.getInteger("ExitNumberY" + i);
				int Z =	cmp.getInteger("ExitNumberZ" + i);
				String dir = cmp.getString("ExitDirection" + i);

				this.getExits().add(new DungeonExit(new BlockPos(X,Y,Z), dir));
				this.roomStructure.blocks[X][Y][Z] = Blocks.AIR.getDefaultState();
			}
		}		
		return false;
	}


	public static String getDirectionBasedOnState(IBlockState state)
	{
		int meta = state.getBlock().getMetaFromState(state);
		String Direction = "";

		if(meta == 0)
		{
			Direction = "NORTH";
		}else if(meta == 1)
		{
			Direction = "EAST";
		}else if(meta == 2)
		{
			Direction = "SOUTH";
		}else if(meta == 3)
		{
			Direction = "WEST";
		}
		return Direction;

	}


	@Override
	public DungeonExit alignWithRoom(DungeonRoom Nextroom, DungeonRoom PreviousRoom, DungeonExit PreviousEntrance, BlockPos StartingPosition) {

		BlockPos RealPrevEntrance = null;
		String PreviousBuiltDirection = PreviousRoom.getPrevBuiltDIRECTION();
		String Direction = "";
		DungeonExit exit = null;

		int j =0;
		here:
			do{
				for(int i = 0; i < Nextroom.getExits().size(); i ++)// 0 = west, 1 = north, 2 = east, 3 = south
				{
					if(Nextroom.getExits().get(i).getDirectionWithRotation(j).contains(PreviousEntrance.getOppositeDirection()))
					{
						if(j == 0)
						{
							//on west take its z position and subtract
							Direction = "WEST";
						}else if(j == 1)
						{
							//on north take its x position and add
							Direction = "NORTH";
						}else if(j == 2)
						{
							//on east take its z position and 
							Direction = "EAST";
						}else if(j == 3)
						{
							///on south take its x and subtract
							Direction = "SOUTH";
						}
						exit = Nextroom.getExits().get(i);

						for(int l = 0; l < Nextroom.getExits().size(); l ++)
						{
							Nextroom.getExits().get(l).setRotation(j);
						}

						break here;
					}
				}

				j++;
			}while(j < 4);



		if(PreviousBuiltDirection.contains("WEST")) // gets the entrance actual position
		{
			RealPrevEntrance = new BlockPos(StartingPosition.getX() - PreviousEntrance.getPos().getX(), StartingPosition.getY(), StartingPosition.getZ() - PreviousEntrance.getPos().getZ());
		}else if(PreviousBuiltDirection.contains("EAST"))
		{
			RealPrevEntrance = new BlockPos(StartingPosition.getX() + PreviousEntrance.getPos().getX(), StartingPosition.getY(), StartingPosition.getZ() + PreviousEntrance.getPos().getZ());
		}else if(PreviousBuiltDirection.contains("NORTH"))
		{
			RealPrevEntrance = new BlockPos(StartingPosition.getX() + PreviousEntrance.getPos().getZ(), StartingPosition.getY(), StartingPosition.getZ() - PreviousEntrance.getPos().getX());
		}else if(PreviousBuiltDirection.contains("SOUTH"))
		{
			RealPrevEntrance = new BlockPos(StartingPosition.getX() - PreviousEntrance.getPos().getZ(), StartingPosition.getY(), StartingPosition.getZ() + PreviousEntrance.getPos().getX());
		}

		if(PreviousEntrance.getDirection().contains("EAST"))
		{
			if(Direction.contains("NORTH"))
			{
				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX(), RealPrevEntrance.getY(), RealPrevEntrance.getZ() + this.roomStructure.zSize);
			}else if(Direction.contains("SOUTH"))
			{
				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX() + this.roomStructure.xSize, RealPrevEntrance.getY(), RealPrevEntrance.getZ());
			}else if(Direction.contains("WEST"))
			{
				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX() + this.roomStructure.xSize, RealPrevEntrance.getY(), RealPrevEntrance.getZ() + this.roomStructure.zSize);
			}

		}else if(PreviousEntrance.getDirection().contains("WEST"))
		{
			if(Direction.contains("EAST"))
			{
				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX() - this.roomStructure.xSize , RealPrevEntrance.getY(), RealPrevEntrance.getZ() - this.roomStructure.zSize);
			}else if(Direction.contains("SOUTH"))
			{
				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX() - this.roomStructure.zSize, RealPrevEntrance.getY(), RealPrevEntrance.getZ());
			}else if(Direction.contains("NORTH"))
			{
				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX(), RealPrevEntrance.getY(), RealPrevEntrance.getZ() - this.roomStructure.zSize);
			}

		}else if(PreviousEntrance.getDirection().contains("NORTH"))
		{
			//RealPrevEntrance = new BlockPos(RealPrevEntrance.getX() - this.roomStructure.xSize, RealPrevEntrance.getY(), RealPrevEntrance.getZ() - this.roomStructure.zSize);
			if(Direction.contains("EAST"))
			{
				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX(), RealPrevEntrance.getY(), RealPrevEntrance.getZ() - this.roomStructure.zSize);
			}else if(Direction.contains("SOUTH"))
			{

				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX() + this.roomStructure.zSize, RealPrevEntrance.getY(), RealPrevEntrance.getZ() - this.roomStructure.xSize);
			}else if(Direction.contains("WEST"))
			{
				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX() + this.roomStructure.xSize, RealPrevEntrance.getY(), RealPrevEntrance.getZ());
			}

		}else if(PreviousEntrance.getDirection().contains("SOUTH"))
		{
			if(Direction.contains("EAST"))
			{
				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX() - this.roomStructure.xSize, RealPrevEntrance.getY(), RealPrevEntrance.getZ());
			}else if(Direction.contains("NORTH"))
			{
				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX() - this.roomStructure.zSize, RealPrevEntrance.getY(), RealPrevEntrance.getZ() + this.roomStructure.xSize);
			}else if(Direction.contains("WEST"))
			{
				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX(), RealPrevEntrance.getY(), RealPrevEntrance.getZ() + this.roomStructure.zSize);
			}

		}
		if(exit != null)
		{
			if(PreviousEntrance.getDirection().contains("WEST"))
			{
				RealPrevEntrance = RealPrevEntrance.south(j % 2 == 0 ? exit.getPos().getZ() : exit.getPos().getX());
	
			}else if(PreviousEntrance.getDirection().contains("NORTH"))
			{
				RealPrevEntrance =	RealPrevEntrance.west(j % 2 == 0 ? exit.getPos().getX() : exit.getPos().getZ());
	
			}else if(PreviousEntrance.getDirection().contains("EAST"))
			{
				RealPrevEntrance = RealPrevEntrance.north(j % 2 == 0 ? exit.getPos().getZ() : exit.getPos().getX());
	
			}else if(PreviousEntrance.getDirection().contains("SOUTH"))
			{
				RealPrevEntrance =RealPrevEntrance.east(j % 2 == 0 ? exit.getPos().getX() : exit.getPos().getZ());
	
			}
		}
		
		return new DungeonExit(RealPrevEntrance, Direction);
	}
	
	//only method that uses this is close, but is just for testing purposes
	public DungeonExit TESTalignWithRoom(DungeonRoom Nextroom, DungeonRoom PreviousRoom, DungeonExit PreviousEntrance, BlockPos StartingPosition) {

		BlockPos RealPrevEntrance = StartingPosition;
		String PreviousBuiltDirection = PreviousRoom.getPrevBuiltDIRECTION();
		String Direction = "";
		DungeonExit exit = null;

		int j =0;
		here:
			do{
				for(int i = 0; i < Nextroom.getExits().size(); i ++)// 0 = west, 1 = north, 2 = east, 3 = south
				{
					if(Nextroom.getExits().get(i).getDirectionWithRotation(j).contains(PreviousEntrance.getOppositeDirection()))
					{
						if(j == 0)
						{
							//on west take its z position and subtract
							Direction = "WEST";
						}else if(j == 1)
						{
							//on north take its x position and add
							Direction = "NORTH";
						}else if(j == 2)
						{
							//on east take its z position and 
							Direction = "EAST";
						}else if(j == 3)
						{
							///on south take its x and subtract
							Direction = "SOUTH";
						}
						exit = Nextroom.getExits().get(i);

						for(int l = 0; l < Nextroom.getExits().size(); l ++)
						{
							Nextroom.getExits().get(l).setRotation(j);
						}

						break here;
					}
				}

				j++;
			}while(j < 4);

		if(PreviousEntrance.getDirection().contains("EAST"))
		{
			if(Direction.contains("NORTH"))
			{
				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX(), RealPrevEntrance.getY(), RealPrevEntrance.getZ() + this.roomStructure.zSize);
			}else if(Direction.contains("SOUTH"))
			{
				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX() + this.roomStructure.xSize, RealPrevEntrance.getY(), RealPrevEntrance.getZ());
			}else if(Direction.contains("WEST"))
			{
				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX() + this.roomStructure.xSize, RealPrevEntrance.getY(), RealPrevEntrance.getZ() + this.roomStructure.zSize);
			}

		}else if(PreviousEntrance.getDirection().contains("WEST"))
		{
			if(Direction.contains("EAST"))
			{
				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX() - this.roomStructure.xSize , RealPrevEntrance.getY(), RealPrevEntrance.getZ() - this.roomStructure.zSize);
			}else if(Direction.contains("SOUTH"))
			{
				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX() - this.roomStructure.zSize, RealPrevEntrance.getY(), RealPrevEntrance.getZ());
			}else if(Direction.contains("NORTH"))
			{
				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX(), RealPrevEntrance.getY(), RealPrevEntrance.getZ() - this.roomStructure.zSize);
			}

		}else if(PreviousEntrance.getDirection().contains("NORTH"))
		{
			//RealPrevEntrance = new BlockPos(RealPrevEntrance.getX() - this.roomStructure.xSize, RealPrevEntrance.getY(), RealPrevEntrance.getZ() - this.roomStructure.zSize);
			if(Direction.contains("EAST"))
			{
				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX(), RealPrevEntrance.getY(), RealPrevEntrance.getZ() - this.roomStructure.zSize);
			}else if(Direction.contains("SOUTH"))
			{

				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX() + this.roomStructure.zSize, RealPrevEntrance.getY(), RealPrevEntrance.getZ() - this.roomStructure.xSize);
			}else if(Direction.contains("WEST"))
			{
				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX() + this.roomStructure.xSize, RealPrevEntrance.getY(), RealPrevEntrance.getZ());
			}

		}else if(PreviousEntrance.getDirection().contains("SOUTH"))
		{
			if(Direction.contains("EAST"))
			{
				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX() - this.roomStructure.xSize, RealPrevEntrance.getY(), RealPrevEntrance.getZ());
			}else if(Direction.contains("NORTH"))
			{
				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX() - this.roomStructure.zSize, RealPrevEntrance.getY(), RealPrevEntrance.getZ() + this.roomStructure.xSize);
			}else if(Direction.contains("WEST"))
			{
				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX(), RealPrevEntrance.getY(), RealPrevEntrance.getZ() + this.roomStructure.zSize);
			}

		}

		if(exit != null)
		{
			if(PreviousEntrance.getDirection().contains("WEST"))
			{
				RealPrevEntrance = RealPrevEntrance.south(j % 2 == 0 ? exit.getPos().getZ() : exit.getPos().getX());

			}else if(PreviousEntrance.getDirection().contains("NORTH"))
			{
				RealPrevEntrance =	RealPrevEntrance.west(j % 2 == 0 ? exit.getPos().getX() : exit.getPos().getZ());

			}else if(PreviousEntrance.getDirection().contains("EAST"))
			{
				RealPrevEntrance = RealPrevEntrance.north(j % 2 == 0 ? exit.getPos().getZ() : exit.getPos().getX());

			}else if(PreviousEntrance.getDirection().contains("SOUTH"))
			{
				RealPrevEntrance =RealPrevEntrance.east(j % 2 == 0 ? exit.getPos().getX() : exit.getPos().getZ());

			}
		}

		return new DungeonExit(RealPrevEntrance, Direction);
	}

	@Override
	public void unloadRoom() {
		this.roomStructure = null;
		this.exits.clear();
	}

	@Override
	public DungeonExit setCorrectPath() {
		// TODO Auto-generated method stub
		Random Rand = new Random();
		int RandomNumber = 0;


		if(this.getExits().size() > 0)
		{
			RandomNumber = Rand.nextInt(this.getExits().size());
			this.getExits().get(RandomNumber).setCorrectPath(true);
			return this.getExits().get(RandomNumber);
		}

		return null;
	}
	
	public DungeonExit setCorrectPath(String Direction) {
		// TODO Auto-generated method stub

		for(DungeonExit tree : exits)
		{
			if(tree.getDirection().equals(Direction))
			{
				tree.setCorrectPath(true);
				return tree;
			}
		}

		return setCorrectPath();
	}


	public void removeOppositeExit(DungeonExit oppositeExit)
	{
		for(int i = 0 ; i < this.exits.size(); i ++)
		{
			if(this.exits.get(i).getDirection().equals(oppositeExit.getOppositeDirection()))
			{
				this.exits.remove(i);
				return;
			}
		}
	}

	public String getPrevBuiltDIRECTION() {
		return PrevBuiltDIRECTION;
	}


}
