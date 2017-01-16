package com.waabbuffet.MonstersAndDungeons.util.dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.waabbuffet.MonstersAndDungeons.blocks.dungeonBuilder.BlockExit;
import com.waabbuffet.MonstersAndDungeons.util.Reference;

public abstract class Dungeon {

	int dungeonSize;
	List<ExitData> totalExits = new ArrayList<ExitData>(); 

	public Dungeon(int dungeonSize)
	{
		this.dungeonSize = dungeonSize;
	}

	public int getDungeonSize() {
		return dungeonSize;
	}

	public List<ExitData> getTotalExits() {
		return totalExits;
	}

	/**
	 * This method will create a random branch at a starting location heading in a specific direction
	 * @param world
	 * @param startingLocation - "WEST" , "EAST", "NORTH", "SOUTH";
	 * @param Direction
	 */
	public void createBranch(World world, BlockPos startingLocation, int DungeonSize, DungeonRoom PreviousRoom, String Direction) {

		DungeonRoom NextRoom = this.selectRandomRoom();
		BlockPos UpdatedLocation = startingLocation;
		
		for(int i = 0; i < DungeonSize; i ++)
		{
			if(PreviousRoom != null)
			{
				DungeonExit ExitToRemove = PreviousRoom.setCorrectPath(Direction);
				DungeonExit TempExit = null;
				for(int j = 0; j < PreviousRoom.getExits().size(); j ++)
				{
					if(!PreviousRoom.getExits().get(j).getCorrectPath())
					{
						//stores the actual coordinates in world inside the exit blockPos, Now can do real calculations to determine path connections
						totalExits.add(new ExitData(getExitActualCoord(PreviousRoom.getExits().get(j), UpdatedLocation, PreviousRoom), PreviousRoom.getExits().get(j), PreviousRoom));	
					}else
					{
						if(!NextRoom.isLoaded())
						{
							NextRoom.loadRoom();
						}
						TempExit = NextRoom.alignWithRoom(NextRoom, PreviousRoom, PreviousRoom.getExits().get(j), UpdatedLocation);
						NextRoom.setPrevBuiltDIRECTION(TempExit.getDirection());
						NextRoom.buildRoom(TempExit.getPos(), world, TempExit.getDirection());
						NextRoom.removeOppositeExit(ExitToRemove);	
					}

				}
				UpdatedLocation = TempExit.getPos();	
			}else
			{
				if(!NextRoom.isLoaded())
				{
					NextRoom.loadRoom();
				}
				NextRoom.buildRoom(startingLocation, world, "WEST");
				NextRoom.setPrevBuiltDIRECTION("WEST");
			}
			PreviousRoom = NextRoom;
			NextRoom = this.selectRandomRoom();
		}
	}

	private BlockPos getExitActualCoord(DungeonExit exit, BlockPos tempExit, DungeonRoom previousRoom)
	{
		String PreviousBuiltDirection = previousRoom.getPrevBuiltDIRECTION();
		BlockPos RealPrevEntrance = null;

		if(PreviousBuiltDirection.contains("WEST")) // gets the entrance actual position
		{
			RealPrevEntrance = new BlockPos(tempExit.getX() - exit.getPos().getX(), tempExit.getY(), tempExit.getZ() - exit.getPos().getZ());
		}else if(PreviousBuiltDirection.contains("EAST"))
		{
			RealPrevEntrance = new BlockPos(tempExit.getX() + exit.getPos().getX(), tempExit.getY(), tempExit.getZ() + exit.getPos().getZ());
		}else if(PreviousBuiltDirection.contains("NORTH"))
		{
			RealPrevEntrance = new BlockPos(tempExit.getX() + exit.getPos().getZ(), tempExit.getY(), tempExit.getZ() - exit.getPos().getX());
		}else if(PreviousBuiltDirection.contains("SOUTH"))
		{
			RealPrevEntrance = new BlockPos(tempExit.getX() - exit.getPos().getZ(), tempExit.getY(), tempExit.getZ() + exit.getPos().getX());
		}
		return RealPrevEntrance;
	}

	private ExitData FindCandidate(ExitData data)
	{
		//Need to pair exits together to process them efficiently...
		//Before anything check to see if we have space(dont know how to do this)
		/* Step One: Determine Likely candidates 
		 *  1. Select all the exits that can be seen from looking at the exits point of view...Only look backwards for maybe 5 blocks	
		 *  2. Select the closest distance (maybe might mean all paths are small and short)
		 *  3. If there are no exits that are good, and has space then chance to create branch from that point
		 *  4. This method will keep running until the size of the list is zero
		 */
		ExitData mostProbable = null;
		int closestValue = 0;
		int tempClosestValue;

		for(ExitData exit : totalExits)
		{	
			if(data.getDirection().equals("WEST"))
			{
				if(exit.getPos().getX() < data.getPos().getX())
				{
					tempClosestValue = Math.abs(exit.getPos().getX());

					if(tempClosestValue < closestValue || closestValue == 0)
					{
						closestValue = tempClosestValue;
						mostProbable = exit;
					}
				}

			}else if(data.getDirection().equals("EAST"))
			{
				if(exit.getPos().getX() > data.getPos().getX())
				{
					tempClosestValue = Math.abs(exit.getPos().getX());

					if(tempClosestValue < closestValue || closestValue == 0)
					{
						closestValue = tempClosestValue;
						mostProbable = exit;
					}
				}

			}else if(data.getDirection().equals("NORTH"))
			{
				if(exit.getPos().getZ() < data.getPos().getZ())
				{
					mostProbable = exit;
				}

			}else if(data.getDirection().equals("SOUTH"))
			{
				if(exit.getPos().getZ() > data.getPos().getZ())
				{
					mostProbable = exit;
				}
			}

		}

		return mostProbable;
	}



	/** Places 1 single room
	 * core meaning the direction stored inside the exit data
	 * @param firstExit
	 */
	public void createBranch(ExitData firstExit, World world, int DungeonSize)
	{
		DungeonRoom PreviousRoom = firstExit.getPreviousRoom();
		DungeonRoom NextRoom = this.selectRandomRoom(); NextRoom.loadRoom();
		BlockPos RealPrevEntrance = firstExit.getPos();
		DungeonExit PreviousEntrance = firstExit.getRealExit(); // this is the exit we need to work with

		String Direction = getRoomRotationRoom(NextRoom, PreviousEntrance.getDirection(),PreviousEntrance.getOppositeDirection());
		if(Direction == null)
		{
			closeBranch(firstExit, world);
			return;
		}
		if(PreviousEntrance.getDirection().contains("EAST"))
		{
			if(Direction.contains("NORTH"))
			{
				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX(), RealPrevEntrance.getY(), RealPrevEntrance.getZ() + NextRoom.getRoomStructure().zSize);
			}else if(Direction.contains("SOUTH"))
			{
				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX() + NextRoom.getRoomStructure().xSize, RealPrevEntrance.getY(), RealPrevEntrance.getZ());
			}else if(Direction.contains("WEST"))
			{
				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX() + NextRoom.getRoomStructure().xSize, RealPrevEntrance.getY(), RealPrevEntrance.getZ() + NextRoom.getRoomStructure().zSize);
			}

		}else if(PreviousEntrance.getDirection().contains("WEST"))
		{
			if(Direction.contains("EAST"))
			{
				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX() - NextRoom.getRoomStructure().xSize , RealPrevEntrance.getY(), RealPrevEntrance.getZ() - NextRoom.getRoomStructure().zSize);
			}else if(Direction.contains("SOUTH"))
			{
				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX() - NextRoom.getRoomStructure().zSize, RealPrevEntrance.getY(), RealPrevEntrance.getZ());
			}else if(Direction.contains("NORTH"))
			{
				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX(), RealPrevEntrance.getY(), RealPrevEntrance.getZ() - NextRoom.getRoomStructure().zSize);
			}

		}else if(PreviousEntrance.getDirection().contains("NORTH"))
		{
			//RealPrevEntrance = new BlockPos(RealPrevEntrance.getX() - NextRoom.getRoomStructure().xSize, RealPrevEntrance.getY(), RealPrevEntrance.getZ() - NextRoom.getRoomStructure().zSize);
			if(Direction.contains("EAST"))
			{
				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX(), RealPrevEntrance.getY(), RealPrevEntrance.getZ() - NextRoom.getRoomStructure().zSize);
			}else if(Direction.contains("SOUTH"))
			{

				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX() + NextRoom.getRoomStructure().zSize, RealPrevEntrance.getY(), RealPrevEntrance.getZ() - NextRoom.getRoomStructure().xSize);
			}else if(Direction.contains("WEST"))
			{
				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX() + NextRoom.getRoomStructure().xSize, RealPrevEntrance.getY(), RealPrevEntrance.getZ());
			}

		}else if(PreviousEntrance.getDirection().contains("SOUTH"))
		{
			if(Direction.contains("EAST"))
			{
				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX() - NextRoom.getRoomStructure().xSize, RealPrevEntrance.getY(), RealPrevEntrance.getZ());
			}else if(Direction.contains("NORTH"))
			{
				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX() - NextRoom.getRoomStructure().zSize, RealPrevEntrance.getY(), RealPrevEntrance.getZ() + NextRoom.getRoomStructure().xSize);
			}else if(Direction.contains("WEST"))
			{
				RealPrevEntrance = new BlockPos(RealPrevEntrance.getX(), RealPrevEntrance.getY(), RealPrevEntrance.getZ() + NextRoom.getRoomStructure().zSize);
			}

		}
		int j = 0;
		if(Direction.equals("WEST"))
		{
			//on west take its z position and subtract
			j = 0;
		}else if(Direction.equals("NORTH"))
		{
			//on north take its x position and add
			j = 1;
		}else if(Direction.equals("EAST"))
		{
			//on east take its z position and
			j = 2;
		}else if(Direction.equals("SOUTH"))
		{
			///on south take its x and subtract
			j = 3;
		}

		if(firstExit.getRealExit().getDirection() != null)
		{
			if(firstExit.getDirection().contains("WEST"))
			{
				RealPrevEntrance = RealPrevEntrance.south(j % 2 == 0 ? firstExit.getRealExit().getPos().getZ() : firstExit.getRealExit().getPos().getX());

			}else if(firstExit.getDirection().contains("NORTH"))
			{
				RealPrevEntrance =	RealPrevEntrance.west(j % 2 == 0 ? firstExit.getRealExit().getPos().getX() : firstExit.getRealExit().getPos().getZ());

			}else if(firstExit.getDirection().contains("EAST"))
			{
				RealPrevEntrance = RealPrevEntrance.north(j % 2 == 0 ? firstExit.getRealExit().getPos().getZ() : firstExit.getRealExit().getPos().getX());

			}else if(firstExit.getDirection().contains("SOUTH"))
			{
				RealPrevEntrance =RealPrevEntrance.east(j % 2 == 0 ? firstExit.getRealExit().getPos().getX() : firstExit.getRealExit().getPos().getZ());

			}
		}
		NextRoom.removeOppositeExit(PreviousEntrance);
		NextRoom.buildRoom(RealPrevEntrance, world, Direction);
		NextRoom.setPrevBuiltDIRECTION(Direction);

		createBranch(world, RealPrevEntrance, DungeonSize, NextRoom, firstExit.getDirection());
	}

	/** DOES NOT WORK YET!
	 * @param startingPoint - will create branch path that has a desired location, startingPoint must always be behind or equal to finishingPoint
	 * @param finishingPoint
	 */
	public void createBranch(ExitData startingPoint, ExitData finishingPoint, World world) // exit data contains the room the exit belongs to
	{

		String facingDirection = startingPoint.getDirection();
		String goingDirection = finishingPoint.getDirection();

		BlockPos currentLocation = startingPoint.getPos();
		//how far on the x and z, choose random room see if possible then build it, re check how far on x and z, choose random room

		int disX = Math.abs(startingPoint.getPos().getX() - startingPoint.getPos().getZ());
		int disY = Math.abs(startingPoint.getPos().getZ() - startingPoint.getPos().getZ());

		if(facingDirection.equals("WEST") || facingDirection.equals("EAST"))
		{
			DungeonRoom PreviousRoom = startingPoint.getPreviousRoom();
			DungeonRoom NextRoom = this.selectRandomRoom();
			BlockPos UpdatedLocation = startingPoint.getPos();
		}
		/*
			while(disX >= 5)
			{
				if(PreviousRoom != null)
				{
					DungeonExit ExitToRemove = PreviousRoom.setCorrectPath(facingDirection);
					DungeonExit TempExit = null;
					for(int j = 0; j < PreviousRoom.getExits().size(); j ++)
					{
						if(!PreviousRoom.getExits().get(j).getCorrectPath())
						{
							//stores the actual coordinates in world inside the exit blockPos, Now can do real calculations to determine path connections
						//	totalExits.add(new ExitData(getExitActualCoord(PreviousRoom.getExits().get(j), UpdatedLocation, PreviousRoom), PreviousRoom.getExits().get(j), PreviousRoom));	
						}else
						{
							if(!NextRoom.isLoaded())
							{
								NextRoom.loadRoom();
							}
							TempExit = NextRoom.alignWithRoom(NextRoom, PreviousRoom, PreviousRoom.getExits().get(j), UpdatedLocation);
							String direction = getRoomRotationRoom(NextRoom, startingPoint.getRealExit().getOppositeDirection(), goingDirection);

							if(direction != null)
								TempExit.setDirection(direction);

							NextRoom.setPrevBuiltDIRECTION(TempExit.getDirection());
							NextRoom.buildRoom(TempExit.getPos(), world, TempExit.getDirection());
							NextRoom.removeOppositeExit(ExitToRemove);	
						}
					}
					UpdatedLocation = TempExit.getPos();	
					disX -= NextRoom.roomStructure.xSize;
				}
			}
		}
		 */
	}

	/*
	 * This method will the return the rotation that has both exits or null if not possible...Also this method prepares the room
	 * by rotating all of the exits when the value is found. Easier to build
	 */
	private String getRoomRotationRoom(DungeonRoom Nextroom, String firstExit, String secondExit)
	{
		String Direction = null;

		int j =0;
		here:
			do{
				boolean hasFirstExit = false, hasSecondExit = false;

				for(int i = 0; i < Nextroom.getExits().size(); i ++)// 0 = west, 1 = north, 2 = east, 3 = south
				{
					if(Nextroom.getExits().get(i).getDirectionWithRotation(j).contains(firstExit))
					{
						hasFirstExit =  true;
					}else
						if(Nextroom.getExits().get(i).getDirectionWithRotation(j).contains(secondExit))
						{
							hasSecondExit = true;
						}

					if(hasFirstExit && hasSecondExit)
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

						for(int l = 0; l < Nextroom.getExits().size(); l ++)
						{
							Nextroom.getExits().get(l).setRotation(j);
						}
						break here;
					}
				}
				j++;
			}while(j < 4);
		return Direction;
	}

	private boolean hasEnoughRoom(ExitData exit)
	{
		String direction = exit.getDirection();

		int posX = exit.getPos().getX();
		int posZ = exit.getPos().getZ();

		if(direction.equals("WEST")) //negative x direction 
		{
			for(ExitData data: totalExits)
			{
				if(posX > data.getPos().getX())
				{
					if(Math.abs((posX - data.getPos().getX())) < 15)
					{
						if(Math.abs((posZ - data.getPos().getZ())) < 8)
						{
							return false;
						}
					}
				}
			}	
		}else if(direction.equals("EAST"))//positive x direction
		{
			for(ExitData data: totalExits)
			{
				if(posX < data.getPos().getX())
				{
					if(Math.abs((posX - data.getPos().getX())) < 15)
					{
						if(Math.abs((posZ - data.getPos().getZ())) < 8)
						{
							return false;
						}
					}
				}
			}	

		}else if(direction.equals("NORTH"))//negative z direction
		{
			for(ExitData data: totalExits)
			{
				if(posZ > data.getPos().getZ())
				{
					if(posZ - data.getPos().getZ() < 10)
					{
						if(Math.abs((posX - data.getPos().getX())) < 10)
						{
							return false;
						}
					}
				}
			}	
		}else if(direction.equals("SOUTH"))//positive z direction
		{
			for(ExitData data: totalExits)
			{
				if(posZ < data.getPos().getZ())
				{
					if(Math.abs((posZ - data.getPos().getZ())) < 15)
					{
						if(Math.abs((posX - data.getPos().getX())) < 8)
						{
							return false;
						}
					}
				}
			}
		}

		return true;
	}

	//working
	public void closeBranch(ExitData startingPoint, World world)
	{
		if(hasEnoughRoom(startingPoint))
		{
			DungeonRoom exit = selectRandomExit();
			exit.loadRoom();

			DungeonExit tempExit = startingPoint.getPreviousRoom().TESTalignWithRoom(exit, startingPoint.getPreviousRoom(), startingPoint.getRealExit(), startingPoint.getPos());
			exit.buildRoom(tempExit.getPos(), world, tempExit.getDirection());
		}		
	}


	public abstract DungeonRoom selectRandomRoom();
	public abstract DungeonRoom selectRandomExit();
	public abstract void ConstructDungeon(World world, BlockPos startingLocation, int DungeonSize);

}
