package com.waabbuffet.MonstersAndDungeons.world.dungeons;

import java.io.File;
import java.util.Random;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.waabbuffet.MonstersAndDungeons.util.Reference;
import com.waabbuffet.MonstersAndDungeons.util.dungeon.Dungeon;
import com.waabbuffet.MonstersAndDungeons.util.dungeon.DungeonExit;
import com.waabbuffet.MonstersAndDungeons.util.dungeon.DungeonNBTTag;
import com.waabbuffet.MonstersAndDungeons.util.dungeon.DungeonRoom;
import com.waabbuffet.MonstersAndDungeons.util.dungeon.ExitData;

public class DungeonAutomatons  extends Dungeon{


	public DungeonAutomatons(int dungeonSize)
	{
		super(dungeonSize);	
	}

	@Override
	public DungeonRoom selectRandomRoom()
	{
		Random rand = new Random();

		switch(rand.nextInt(20))
		{
		case 1:
		case 6:
			return new DungeonRoom("assets/monsteranddungeons/generation/dungeonAutomatons/DungeonAutomatonsRoom1");//corner
		case 7:
		case 11:
			return new DungeonRoom("assets/monsteranddungeons/generation/dungeonAutomatons/DungeonAutomatonsRoom2"); //straight
		case 12:
			return new DungeonRoom("assets/monsteranddungeons/generation/dungeonAutomatons/DungeonAutomatonsRoom3");
		case 13:
			return new DungeonRoom("assets/monsteranddungeons/generation/dungeonAutomatons/DungeonAutomatonsRoom5"); // straight
		case 14:
			return new DungeonRoom("assets/monsteranddungeons/generation/dungeonAutomatons/DungeonAutomatonsRoom6"); // corner
		case 15:
			return new DungeonRoom("assets/monsteranddungeons/generation/dungeonAutomatons/DungeonAutomatonsRoom7");
		case 16:
			return new DungeonRoom("assets/monsteranddungeons/generation/dungeonAutomatons/DungeonAutomatonsRoom11");
		case 17:
			return new DungeonRoom("assets/monsteranddungeons/generation/dungeonAutomatons/DungeonAutomatonsRoom11");
		case 18:
			return new DungeonRoom("assets/monsteranddungeons/generation/dungeonAutomatons/DungeonAutomatonsRoom12");
		default:
			return new DungeonRoom("assets/monsteranddungeons/generation/dungeonAutomatons/DungeonAutomatonsRoom7");
		}	
	}

	@Override
	public DungeonRoom selectRandomExit()
	{
		Random rand = new Random();

		switch(rand.nextInt(15))
		{
		case 1:
			return new DungeonRoom("assets/monsteranddungeons/generation/dungeonAutomatons/DungeonAutomatonsRoom4"); // ore
		case 2:
			return new DungeonRoom("assets/monsteranddungeons/generation/dungeonAutomatons/DungeonAutomatonsRoom8");
		case 3:
			return new DungeonRoom("assets/monsteranddungeons/generation/dungeonAutomatons/DungeonAutomatonsRoom9");
		case 4:
			return new DungeonRoom("assets/monsteranddungeons/generation/dungeonAutomatons/DungeonAutomatonsRoom13");
		case 5:
			return new DungeonRoom("assets/monsteranddungeons/generation/dungeonAutomatons/DungeonAutomatonsRoom13"); // ore
		default:
			return new DungeonRoom("assets/monsteranddungeons/generation/dungeonAutomatons/DungeonAutomatonsRoom8");
		}
	}


	@Override
	public void ConstructDungeon(World world, BlockPos startingLocation, int DungeonSize) {
		createBranch(world, startingLocation, DungeonSize, null, "RANDOM");

		//for(ExitData exit : getTotalExits())
		for(int i = 0; i < getTotalExits().size(); i ++)
		{
<<<<<<< HEAD
			Random rand = new Random();
			ExitData exit = getTotalExits().get(i);
=======
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
>>>>>>> 8b6081fe644657aac12a7ecef2a0266a4ca3032b

			if(rand.nextInt(10) == 0)
			{
				createBranch(exit, world, 3);
			}else
			{
				closeBranch(exit, world);
			}
		}
	}
<<<<<<< HEAD
=======




>>>>>>> 8b6081fe644657aac12a7ecef2a0266a4ca3032b
}