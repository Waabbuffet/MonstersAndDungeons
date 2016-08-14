package com.waabbuffet.MonstersAndDungeons.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.waabbuffet.MonstersAndDungeons.blocks.MaDBlocksHandler;
import com.waabbuffet.MonstersAndDungeons.blocks.dungeonBuilder.BlockExit;
import com.waabbuffet.MonstersAndDungeons.world.dungeons.IDungeonRoom;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DungeonRoom implements IDungeonRoom {

	StructureData roomStructure = new StructureData();
	ResourceLocation filename;


	List<DungeonExit> exits = new ArrayList<DungeonExit>();

	public DungeonRoom(ResourceLocation FileName) {
		// TODO Auto-generated constructor stub
		this.filename = FileName;

	}

	@Override
	public boolean isLoaded()
	{
		boolean Yes = false;

		if(this.roomStructure != null)
		{
			return this.roomStructure.isLoaded;
		}

		return Yes;
	}


	public StructureData getRoomStructure() {
		return roomStructure;
	}

	public ResourceLocation getFilename() {
		return filename;
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
							world.setBlockState(new BlockPos(startPos.getX() + x, startPos.getY() + y,startPos.getZ() - z), this.roomStructure.blocks[x][y][z]);
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
						}
					}
				}
			}


		}
	}


	@Override
	public boolean loadRoom() {
		// TODO Auto-generated method stub
		File dungeonRoom = new File(this.getFilename().getResourcePath());
	
		
		
		if(dungeonRoom != null)
		{
		
			this.roomStructure.isLoaded = true;
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

					
						if(!Block.getStateById(ID).getBlock().equals(MaDBlocksHandler.BlockExit))
						{
							this.roomStructure.blocks[x][y][z] = Block.getStateById(ID);
						}else
						{
						
							this.getExits().add(new DungeonExit(new BlockPos(x,y,z), this.getDirectionBasedOnState(Block.getStateById(ID))));
							this.roomStructure.blocks[x][y][z] = Blocks.AIR.getDefaultState();
						}
					}
				}
			}
		}

		return false;
	}


	public static String getDirectionBasedOnState(IBlockState state)
	{
		int meta = state.getBlock().getMetaFromState(state);
		String Direction = "";


		// 0 = east
		// 1 = west
		// 2 = south
		// 3 = north

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

	/**
	 * @return returns a dungeonExit however is the starting location/direction on where/how to build the room that is provided
	 */
	@Override
	public DungeonExit alignWithRoom(DungeonRoom Nextroom, DungeonRoom PreviousRoom, DungeonExit PreviousEntrance, BlockPos StartingPosition) {

		/*This method has to do two things...return the starting location where the next room has to be built, and 
		 * return which direction the next room has to build in order to match the previousEntrance
		 */
		BlockPos RealWorldExitPosition = null; 
		String Direction = "WEST";

		if(PreviousEntrance.getDirection().contains("EAST"))
		{
			RealWorldExitPosition = new BlockPos(StartingPosition.getX() + PreviousEntrance.getPos().getX(), StartingPosition.getY() + PreviousEntrance.getPos().getY(), StartingPosition.getZ() + PreviousEntrance.getPos().getZ());

		}else if(PreviousEntrance.getDirection().contains("WEST"))
		{
			RealWorldExitPosition = new BlockPos(StartingPosition.getX() - PreviousEntrance.getPos().getX(), StartingPosition.getY() + PreviousEntrance.getPos().getY(), StartingPosition.getZ() + PreviousEntrance.getPos().getZ());
		}else if(PreviousEntrance.getDirection().contains("NORTH"))
		{
			RealWorldExitPosition = new BlockPos(StartingPosition.getX() + PreviousEntrance.getPos().getX(), StartingPosition.getY() + PreviousEntrance.getPos().getY(), StartingPosition.getZ() - PreviousEntrance.getPos().getZ());
		}else if(PreviousEntrance.getDirection().contains("SOUTH"))
		{
			RealWorldExitPosition = new BlockPos(StartingPosition.getX() + PreviousEntrance.getPos().getX(), StartingPosition.getY() + PreviousEntrance.getPos().getY(), StartingPosition.getZ() + PreviousEntrance.getPos().getZ());
		}

		int j =0;
		do{

			for(int i = 0; i < Nextroom.getExits().size(); i ++)
			{
				if(Nextroom.getExits().get(i).getDirectionWithRotation(j).contains(PreviousEntrance.getDirection()))
				{
					if(j == 0)
					{
						//on west take its z position and subtract
						Direction = "WEST";
						RealWorldExitPosition.south(Nextroom.getExits().get(i).getPos().getZ());
					}else if(j == 1)
					{
						//on north take its x position and add
						Direction = "NORTH";
						RealWorldExitPosition.west(Nextroom.getExits().get(i).getPos().getX());
					}else if(j == 2)
					{
						//on east take its z position and 
						Direction = "EAST";
						RealWorldExitPosition.north(Nextroom.getExits().get(i).getPos().getZ());
					}else if(j == 3)
					{
						///on south take its x and subtract
						Direction = "SOUTH";
						RealWorldExitPosition.east(Nextroom.getExits().get(i).getPos().getX());

					}

					break;
				}
			}

			j++;
		}while(j < 4);




		return new DungeonExit(RealWorldExitPosition, Direction);
	}

	@Override
	public void unloadRoom() {
		this.roomStructure = null;
		this.exits.clear();
	}

	@Override
	public void setCorrectPath() {
		// TODO Auto-generated method stub
		Random Rand = new Random();
		
		this.getExits().get(Rand.nextInt(this.getExits().size())).setCorrectPath(true);

	}


}
