package com.waabbuffet.MonstersAndDungeons.util;

import java.io.File;

import com.waabbuffet.MonstersAndDungeons.world.dungeons.IDungeonRoom;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

public class DungeonRoom implements IDungeonRoom {

	StructureData roomStructure;
	ResourceLocation filename;
	
	DungeonExit entrance, exit;
	
	public DungeonRoom(ResourceLocation FileName) {
		// TODO Auto-generated constructor stub
		this.filename = FileName;
		
	}
	

	public boolean isLoaded()
	{
		return (this.roomStructure.blocks.length != 0 && this.roomStructure.blocks[0].length != 0 && this.roomStructure.blocks[0][0].length != 0);
	}
	
	
	public StructureData getRoomStructure() {
		return roomStructure;
	}
	
	public ResourceLocation getFilename() {
		return filename;
	}
	
	public DungeonExit getEntrance() {
		return entrance;
	}
	
	public DungeonExit getExit() {
		return exit;
	}
	
	
	@Override
	public void buildRoom(BlockPos startPos) {
		// TODO Auto-generated method stub
		
		if(this.isLoaded())
		{
			
		}
	}

	
	@Override
	public boolean loadRoom() {
		// TODO Auto-generated method stub
		File dungeonRoom = new File(this.getFilename().getResourcePath());
		
		if(dungeonRoom != null)
		{
			NBTTagCompound cmp = DungeonNBTTag.getTagCompoundInFile(dungeonRoom);
			
			this.roomStructure.xSize = cmp.getInteger("MaxXValue");
			this.roomStructure.ySize = cmp.getInteger("MaxYValue");
			this.roomStructure.zSize = cmp.getInteger("MaxZValue");
			
			this.roomStructure.blocks = new IBlockState[this.roomStructure.xSize][this.roomStructure.ySize][this.roomStructure.zSize];
			
			for(int x = 0; x < this.roomStructure.blocks.length; x ++)
			{
				for(int y = 0; y < this.roomStructure.blocks[0].length; x ++)
				{
					for(int z = 0; z < this.roomStructure.blocks[0][0].length; z ++)
					{
						int ID = cmp.getInteger(x + "," + y + "," + z);
						
						this.roomStructure.blocks[x][y][z] = Block.getStateById(ID);
						
						
					}
				}
			}
			
			this.entrance = new DungeonExit(new BlockPos(cmp.getInteger("EntranceBlockX"), cmp.getInteger("EntranceBlockY") , cmp.getInteger("EntranceBlockZ")), cmp.getString("EntranceDirection"));
			this.exit = new DungeonExit(new BlockPos(cmp.getInteger("ExitBlockX"), cmp.getInteger("ExitBlockY") , cmp.getInteger("ExitBlockZ")), cmp.getString("ExitDirection"));
			
				
		}
	
		return false;
	}


	@Override
	public BlockPos alignWithRoom(DungeonRoom entrance) {
		// TODO Auto-generated method stub
		BlockPos StartingPos = null;
		
		
		
		return StartingPos;
	}


	@Override
	public void unloadRoom() {
		this.roomStructure = null;
		this.entrance = null;
		this.exit = null;
	}
	
	
}
