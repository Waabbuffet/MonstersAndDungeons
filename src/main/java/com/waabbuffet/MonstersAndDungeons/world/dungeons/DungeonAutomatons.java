package com.waabbuffet.MonstersAndDungeons.world.dungeons;

import java.io.File;
import java.util.Random;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.waabbuffet.MonstersAndDungeons.util.DungeonExit;
import com.waabbuffet.MonstersAndDungeons.util.DungeonNBTTag;
import com.waabbuffet.MonstersAndDungeons.util.DungeonRoom;
import com.waabbuffet.MonstersAndDungeons.util.Reference;

public class DungeonAutomatons  implements IDungeonBuilder {

	//Example set 
	DungeonRoom Room = new DungeonRoom(new ResourceLocation(Reference.MODID + ":DungeonAutomatonsRoom1"));
	DungeonRoom Room1 = new DungeonRoom(new ResourceLocation(Reference.MODID + ":DungeonAutomatonsRoom2"));
	DungeonRoom Room2 = new DungeonRoom(new ResourceLocation(Reference.MODID + ":DungeonAutomatonsRoom3"));
	DungeonRoom Room3 = new DungeonRoom(new ResourceLocation(Reference.MODID + ":DungeonAutomatonsRoom4"));
//	DungeonRoom Room4 = new DungeonRoom(new ResourceLocation(Reference.MODID + ":NYI"));
//	DungeonRoom Room5 = new DungeonRoom(new ResourceLocation(Reference.MODID + ":NYI"));

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
			return this.Room;
		case 2:
			return this.Room1;
		case 3:
			return this.Room2;
		case 4:
			return this.Room3;
		default:
			return this.Room3;
		}
	}



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
				
				PreviousRoom.setCorrectPath();
				for(int j = 0; j < PreviousRoom.getExits().size(); j ++)
				{
					if(!PreviousRoom.getExits().get(j).getCorrectPath())
					{
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
					}else
					{
						//if it is the correct path then load room, then align room, then build room!
						if(!NextRoom.isLoaded())
						{
							NextRoom.loadRoom();
						}

						DungeonExit TempExit = NextRoom.alignWithRoom(NextRoom, PreviousRoom, PreviousRoom.getExits().get(j), UpdatedLocation);
						NextRoom.buildRoom(TempExit.getPos(), world, TempExit.getDirection());
						NextRoom.getExits().remove(TempExit);
						
						if(PreviousRoom.getExits().get(j).getDirection().contains("EAST"))
						{
							UpdatedLocation = UpdatedLocation.east(NextRoom.getRoomStructure().getxSize());
						}else if(PreviousRoom.getExits().get(j).getDirection().contains("WEST"))
						{
							UpdatedLocation = UpdatedLocation.west(NextRoom.getRoomStructure().getxSize());
						}else if(PreviousRoom.getExits().get(j).getDirection().contains("NORTH"))
						{
							UpdatedLocation = UpdatedLocation.north(NextRoom.getRoomStructure().getzSize());
						}else if(PreviousRoom.getExits().get(j).getDirection().contains("WEST"))
						{
							UpdatedLocation = UpdatedLocation.south(NextRoom.getRoomStructure().getzSize());
						}		
					}
				}
			
			}else
			{
				if(!NextRoom.isLoaded())
				{
					NextRoom.loadRoom();
				}
				
				NextRoom.buildRoom(startingLocation, world, Direction);
				System.out.println("Working" +startingLocation);
				
			}
			
			PreviousRoom = NextRoom;
			NextRoom = this.selectRandomRoom();

		}

		//Add boss room here! 

	}


}
