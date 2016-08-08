package com.waabbuffet.MonstersAndDungeons.world.dungeons;

import java.io.File;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

import com.waabbuffet.MonstersAndDungeons.util.DungeonNBTTag;
import com.waabbuffet.MonstersAndDungeons.util.DungeonRoom;
import com.waabbuffet.MonstersAndDungeons.util.Reference;

public class DungeonAutomatons  implements IDungeonBuilder{

	//Example set 
	DungeonRoom EntranceRoom = new DungeonRoom(new ResourceLocation(Reference.MODID + ":NYI"));
	DungeonRoom Room = new DungeonRoom(new ResourceLocation(Reference.MODID + ":NYI"));
	DungeonRoom Room2 = new DungeonRoom(new ResourceLocation(Reference.MODID + ":NYI"));
	DungeonRoom Room3 = new DungeonRoom(new ResourceLocation(Reference.MODID + ":NYI"));
	DungeonRoom Room4 = new DungeonRoom(new ResourceLocation(Reference.MODID + ":NYI"));
	DungeonRoom Room5 = new DungeonRoom(new ResourceLocation(Reference.MODID + ":NYI"));
	
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

	@Override
	public void constructDungeon() {
		//Dungeon Logic will go here!
		for(int i = 0; i < this.getDungeonSize(); i ++)
		{
			
		}
		
		//Add boss room here! 
		
	}
	

}
