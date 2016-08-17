package com.waabbuffet.MonstersAndDungeons.world.dungeons;

import java.io.File;
import java.util.Random;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.waabbuffet.MonstersAndDungeons.util.Reference;
import com.waabbuffet.MonstersAndDungeons.util.dungeon.DungeonExit;
import com.waabbuffet.MonstersAndDungeons.util.dungeon.DungeonNBTTag;
import com.waabbuffet.MonstersAndDungeons.util.dungeon.DungeonRoom;
import com.waabbuffet.MonstersAndDungeons.util.dungeon.IDungeonBuilder;

public class DungeonAutomatons  implements IDungeonBuilder {

	//Example set 
	public 	DungeonRoom Room = new DungeonRoom(new ResourceLocation(Reference.MODID + ":DungeonAutomatonsRoom1"));
	public DungeonRoom Room1 = new DungeonRoom(new ResourceLocation(Reference.MODID + ":DungeonAutomatonsRoom2"));
	public DungeonRoom Room2 = new DungeonRoom(new ResourceLocation(Reference.MODID + ":DungeonAutomatonsRoom3"));
	public DungeonRoom Room3 = new DungeonRoom(new ResourceLocation(Reference.MODID + ":DungeonAutomatonsRoom4"));


	boolean useDefaultValues;
	int dungeonSize;

	public DungeonAutomatons(int dungeonSize, boolean useDefaultValues)
	{
		this.dungeonSize = dungeonSize;
		this.useDefaultValues = useDefaultValues;
	}

	public int getDungeonSize() {
		return dungeonSize;
	}

	
	public DungeonRoom selectRandomRoom()
	{
		Random rand = new Random();

		switch(rand.nextInt(4))
		{
		case 1:
			return new DungeonRoom(new ResourceLocation(Reference.MODID + ":DungeonAutomatonsRoom1"));
		case 2:
			return new DungeonRoom(new ResourceLocation(Reference.MODID + ":DungeonAutomatonsRoom2"));
		case 3:
			return new DungeonRoom(new ResourceLocation(Reference.MODID + ":DungeonAutomatonsRoom3"));
		case 4:
			return new DungeonRoom(new ResourceLocation(Reference.MODID + ":DungeonAutomatonsRoom4"));
		default:
			return new DungeonRoom(new ResourceLocation(Reference.MODID + ":DungeonAutomatonsRoom2"));
		}
	}

	/* 1. place first random room
	 * 2. set correct path for the previous room
	 * 3. if not correct path then place branch (Code that is not implemented yet)
	 * 4. if correct path then place random room again
	 * 5.
	 * 6.  
	 */  


	@Override
	public void constructDungeon(World world, BlockPos startingLocation, String Direction) {
		//Dungeon Logic will go here!

		DungeonRoom PreviousRoom = null;
		DungeonRoom NextRoom = this.selectRandomRoom();
		BlockPos UpdatedLocation = startingLocation;

		for(int i = 0; i < this.getDungeonSize(); i ++)
		{
			if(PreviousRoom != null)
			{
				
				DungeonExit ExitToRemove = PreviousRoom.setCorrectPath();
				for(int j = 0; j < PreviousRoom.getExits().size(); j ++)
				{
					if(!PreviousRoom.getExits().get(j).getCorrectPath())
					{
						/*
						//for now I am going to just throw in 1 room and thats it
						DungeonRoom TempNextRoom = this.selectRandomRoom();
						if(!TempNextRoom.isLoaded())
						{
							TempNextRoom.loadRoom();
						}
						
						
						if(TempNextRoom.isLoaded())
						{
							DungeonExit TempExit = TempNextRoom.alignWithRoom(TempNextRoom, PreviousRoom, PreviousRoom.getExits().get(j), UpdatedLocation);
							TempNextRoom.buildRoom(TempExit.getPos(), world, TempExit.getDirection());
						}
						*/
					}else
					{
						//if it is the correct path then load room, then align room, then build room!
						if(!NextRoom.isLoaded())
						{
							NextRoom.loadRoom();
						}

						DungeonExit TempExit = NextRoom.alignWithRoom(NextRoom, PreviousRoom, PreviousRoom.getExits().get(j), UpdatedLocation);
						
						
		
						NextRoom.setPrevBuiltDIRECTION(TempExit.getDirection());
						NextRoom.buildRoom(TempExit.getPos(), world, TempExit.getDirection());
						NextRoom.removeOppositeExit(ExitToRemove);	
						UpdatedLocation = TempExit.getPos();
					}
				}
			
			}else
			{
				if(!NextRoom.isLoaded())
				{
					NextRoom.loadRoom();
				}
				
				NextRoom.buildRoom(startingLocation, world, Direction);
				NextRoom.setPrevBuiltDIRECTION(Direction);
				
			}
			
			PreviousRoom = null;
			PreviousRoom = NextRoom;
			NextRoom = this.selectRandomRoom();

		}


		//Add boss room here! 

	}

	@Override
	public void unloadDungeon() {
		// TODO Auto-generated method stub
		this.Room.unloadRoom();
		this.Room1.unloadRoom();
		this.Room2.unloadRoom();
		this.Room3.unloadRoom();
	}




}
