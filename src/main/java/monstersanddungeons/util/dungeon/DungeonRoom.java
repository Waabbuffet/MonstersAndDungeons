package monstersanddungeons.util.dungeon;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import monstersanddungeons.entity.automatons.EntityWhitePawns;
import monstersanddungeons.util.StructureData;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.BlockRedstoneOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DungeonRoom implements IDungeonRoom {

	StructureData roomStructure = new StructureData();
	String filename;
	EnumDirection prevBuiltDirection;

	List<DungeonExit> exits = new ArrayList<DungeonExit>();
	Random rand = new Random();

	public DungeonRoom(String FileName) {
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

	public void setPrevBuiltDirection(EnumDirection prevBuiltDirection) {
		this.prevBuiltDirection = prevBuiltDirection;
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
	public void buildRoom(BlockPos startPos, World world, EnumDirection direction) {
		if(this.isLoaded())
		{
			if(direction == EnumDirection.EAST)
			{
				for(int x = 0; x < this.roomStructure.blocks.length; x ++)
				{
					for(int y = 0; y < this.roomStructure.blocks[0].length; y ++)
					{
						for(int z = 0; z < this.roomStructure.blocks[0][0].length; z ++)
						{
							BlockPos blockPos = new BlockPos(startPos.getX() + x, startPos.getY() + y, startPos.getZ() + z);
							if(this.roomStructure.blocks[x][y][z].getBlock() == Blocks.STONE){
								if(!(world.getBlockState(blockPos).getBlock() instanceof BlockOre) && !(world.getBlockState(blockPos).getBlock() instanceof BlockRedstoneOre)){
									world.setBlockState(blockPos, this.roomStructure.blocks[x][y][z]);
								}//if the dungeon block to place is stone, then do not replace the ore that has already been generated.
							}else if(y-1 == this.roomStructure.blocks[0].length && this.roomStructure.blocks[x][y][z].getBlock() == Blocks.AIR){
								//Don't force air at the top layer
							}
							else{
								world.setBlockState(blockPos, this.roomStructure.blocks[x][y][z]);
							}
							if(rand.nextInt(300) == 0 && canSpawnWhite(x, y, z) && (!world.getBlockState(new BlockPos(startPos.getX() + x, startPos.getY() + y,startPos.getZ() + z)).equals(Blocks.AIR)))
							{
								EntityWhitePawns pawn = new EntityWhitePawns(world);
								pawn.setPosition(startPos.getX() + x, startPos.getY() + y + 2,startPos.getZ() + z);
								world.spawnEntityInWorld(pawn);

							}
						}
					}
				}
			}else if(direction == EnumDirection.WEST)
			{
				for(int x = 0; x < this.roomStructure.blocks.length; x ++)
				{
					for(int y = 0; y < this.roomStructure.blocks[0].length; y ++)
					{
						for(int z = 0; z < this.roomStructure.blocks[0][0].length; z ++)
						{
							BlockPos blockPos = new BlockPos(startPos.getX() - x, startPos.getY() + y, startPos.getZ() - z);
							if(this.roomStructure.blocks[x][y][z].getBlock() == Blocks.STONE){
								if(!(world.getBlockState(blockPos).getBlock() instanceof BlockOre) && !(world.getBlockState(blockPos).getBlock() instanceof BlockRedstoneOre)){
									world.setBlockState(blockPos, this.roomStructure.blocks[x][y][z]);
								}//if the dungeon block to place is stone, then do not replace the ore that has already been generated.
							}else if(y-1 == this.roomStructure.blocks[0].length && this.roomStructure.blocks[x][y][z].getBlock() == Blocks.AIR){
								//Don't force air at the top layer
							}
							else{
								world.setBlockState(blockPos, this.roomStructure.blocks[x][y][z]);
							}
							if(rand.nextInt(300) == 0 && canSpawnWhite(x, y, z) && (!world.getBlockState(new BlockPos(startPos.getX() - x, startPos.getY() + y,startPos.getZ() - z)).equals(Blocks.AIR)))
							{

								EntityWhitePawns pawn = new EntityWhitePawns(world);
								pawn.setPosition(startPos.getX() - x, startPos.getY() + y + 2,startPos.getZ() - z);
								world.spawnEntityInWorld(pawn);

							}
						}	
					}
				}

			}else if(direction == EnumDirection.NORTH)
			{

				for(int x = 0; x < this.roomStructure.blocks.length; x ++)
				{
					for(int y = 0; y < this.roomStructure.blocks[0].length; y ++)
					{
						for(int z = 0; z < this.roomStructure.blocks[0][0].length; z ++)
						{
							BlockPos blockPos = new BlockPos(startPos.getX() + z, startPos.getY() + y, startPos.getZ() - x);
							if(this.roomStructure.blocks[x][y][z].getBlock() == Blocks.STONE){
								if(!(world.getBlockState(blockPos).getBlock() instanceof BlockOre) && !(world.getBlockState(blockPos).getBlock() instanceof BlockRedstoneOre)){
									world.setBlockState(blockPos, this.roomStructure.blocks[x][y][z]);
								}//if the dungeon block to place is stone, then do not replace the ore that has already been generated.
							}else if(y-1 == this.roomStructure.blocks[0].length && this.roomStructure.blocks[x][y][z].getBlock() == Blocks.AIR){
								//Don't force air at the top layer
							}
							else{
								world.setBlockState(blockPos, this.roomStructure.blocks[x][y][z]);
							}
							if(rand.nextInt(300) == 0 && canSpawnWhite(x, y, z) && (!world.getBlockState(new BlockPos(startPos.getX() + z, startPos.getY() + y,startPos.getZ() - x)).equals(Blocks.AIR)))
							{

								EntityWhitePawns pawn = new EntityWhitePawns(world);
								pawn.setPosition(startPos.getX() + z, startPos.getY() + y + 2,startPos.getZ() - x);
								world.spawnEntityInWorld(pawn);

							}
						}	
					}
				}
			}else if(direction == EnumDirection.SOUTH)
			{
				for(int x = 0; x < this.roomStructure.blocks.length; x ++)
				{
					for(int y = 0; y < this.roomStructure.blocks[0].length; y ++)
					{
						for(int z = 0; z < this.roomStructure.blocks[0][0].length; z ++)
						{
							BlockPos blockPos = new BlockPos(startPos.getX() - z, startPos.getY() + y, startPos.getZ() + x);
							if(this.roomStructure.blocks[x][y][z].getBlock() == Blocks.STONE){
								if(!(world.getBlockState(blockPos).getBlock() instanceof BlockOre) && !(world.getBlockState(blockPos).getBlock() instanceof BlockRedstoneOre)){
									world.setBlockState(blockPos, this.roomStructure.blocks[x][y][z]);
								}//if the dungeon block to place is stone, then do not replace the ore that has already been generated.
							}else if(y-1 == this.roomStructure.blocks[0].length && this.roomStructure.blocks[x][y][z].getBlock() == Blocks.AIR){
								//Don't force air at the top layer
							}
							else{
								world.setBlockState(blockPos, this.roomStructure.blocks[x][y][z]);
							}
						
							if(rand.nextInt(300) == 0 && canSpawnWhite(x, y, z) && (!world.getBlockState(new BlockPos(startPos.getX() - z, startPos.getY() + y,startPos.getZ() + x)).equals(Blocks.AIR)))
							{
								EntityWhitePawns pawn = new EntityWhitePawns(world);
								pawn.setPosition(startPos.getX() - z, startPos.getY() + y + 2,startPos.getZ() + x);
								world.spawnEntityInWorld(pawn);
							}
						}
					}
				}
			}	
		}
	}
	
	private boolean canSpawnWhite(int x, int y, int z)
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
		InputStream dungeonRoom = getClass().getClassLoader().getResourceAsStream(this.filename);
		int howManyExits;			
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


			howManyExits = cmp.getInteger("TotalExits");
			for(int i = 0; i < howManyExits; i ++)
			{
				int X =	cmp.getInteger("ExitNumberX" + i);
				int Y =	cmp.getInteger("ExitNumberY" + i);
				int Z =	cmp.getInteger("ExitNumberZ" + i);
				EnumDirection dir = EnumDirection.getDirectionFromID(cmp.getInteger("ExitDirection" + i));

				this.getExits().add(new DungeonExit(new BlockPos(X,Y,Z), dir));
				this.roomStructure.blocks[X][Y][Z] = Blocks.AIR.getDefaultState();
			}
		}		
		return false;
	}


	/*public static EnumDirection getDirectionBasedOnState(IBlockState state){
		return EnumDirection.getDirectionFromID(state.getBlock().getMetaFromState(state));
	}*/


	@Override
	public DungeonExit alignWithRoom(DungeonRoom nextRoom, DungeonRoom previousRoom, DungeonExit previousEntrance, BlockPos startingPosition) {

		BlockPos realPrevEntrance = null;
		EnumDirection PreviousBuiltDirection = previousRoom.getPrevBuiltDIRECTION();
		EnumDirection direction = null;
		DungeonExit exit = null;

		int j = 0;
		here:
			do{
				for(int i = 0; i < nextRoom.getExits().size(); i ++)// 0 = west, 1 = north, 2 = east, 3 = south
				{
					if(nextRoom.getExits().get(i).getDirectionWithRotation(j) == previousEntrance.getOppositeDirection())
					{
						direction = EnumDirection.getDirectionFromID(j);
						exit = nextRoom.getExits().get(i);

						for(int l = 0; l < nextRoom.getExits().size(); l ++)
						{
							nextRoom.getExits().get(l).setRotation(j);
						}

						break here;
					}
				}

				j++;
			}while(j < 4);



		if(PreviousBuiltDirection == EnumDirection.WEST) // gets the entrance actual position
		{
			realPrevEntrance = new BlockPos(startingPosition.getX() - previousEntrance.getPos().getX(), startingPosition.getY(), startingPosition.getZ() - previousEntrance.getPos().getZ());
		}else if(PreviousBuiltDirection == EnumDirection.EAST)
		{
			realPrevEntrance = new BlockPos(startingPosition.getX() + previousEntrance.getPos().getX(), startingPosition.getY(), startingPosition.getZ() + previousEntrance.getPos().getZ());
		}else if(PreviousBuiltDirection == EnumDirection.NORTH)
		{
			realPrevEntrance = new BlockPos(startingPosition.getX() + previousEntrance.getPos().getZ(), startingPosition.getY(), startingPosition.getZ() - previousEntrance.getPos().getX());
		}else if(PreviousBuiltDirection == EnumDirection.SOUTH)
		{
			realPrevEntrance = new BlockPos(startingPosition.getX() - previousEntrance.getPos().getZ(), startingPosition.getY(), startingPosition.getZ() + previousEntrance.getPos().getX());
		}

		if(previousEntrance.getDirection() == EnumDirection.EAST)
		{
			if(direction == EnumDirection.NORTH)
			{
				realPrevEntrance = new BlockPos(realPrevEntrance.getX(), realPrevEntrance.getY(), realPrevEntrance.getZ() + this.roomStructure.zSize);
			}else if(direction == EnumDirection.SOUTH)
			{
				realPrevEntrance = new BlockPos(realPrevEntrance.getX() + this.roomStructure.xSize, realPrevEntrance.getY(), realPrevEntrance.getZ());
			}else if(direction == EnumDirection.WEST)
			{
				realPrevEntrance = new BlockPos(realPrevEntrance.getX() + this.roomStructure.xSize, realPrevEntrance.getY(), realPrevEntrance.getZ() + this.roomStructure.zSize);
			}

		}else if(previousEntrance.getDirection() == EnumDirection.WEST)
		{
			if(direction == EnumDirection.EAST)
			{
				realPrevEntrance = new BlockPos(realPrevEntrance.getX() - this.roomStructure.xSize , realPrevEntrance.getY(), realPrevEntrance.getZ() - this.roomStructure.zSize);
			}else if(direction == EnumDirection.SOUTH)
			{
				realPrevEntrance = new BlockPos(realPrevEntrance.getX() - this.roomStructure.zSize, realPrevEntrance.getY(), realPrevEntrance.getZ());
			}else if(direction == EnumDirection.NORTH)
			{
				realPrevEntrance = new BlockPos(realPrevEntrance.getX(), realPrevEntrance.getY(), realPrevEntrance.getZ() - this.roomStructure.zSize);
			}

		}else if(previousEntrance.getDirection() == EnumDirection.NORTH)
		{
			//RealPrevEntrance = new BlockPos(RealPrevEntrance.getX() - this.roomStructure.xSize, RealPrevEntrance.getY(), RealPrevEntrance.getZ() - this.roomStructure.zSize);
			if(direction == EnumDirection.EAST)
			{
				realPrevEntrance = new BlockPos(realPrevEntrance.getX(), realPrevEntrance.getY(), realPrevEntrance.getZ() - this.roomStructure.zSize);
			}else if(direction == EnumDirection.SOUTH)
			{

				realPrevEntrance = new BlockPos(realPrevEntrance.getX() + this.roomStructure.zSize, realPrevEntrance.getY(), realPrevEntrance.getZ() - this.roomStructure.xSize);
			}else if(direction == EnumDirection.WEST)
			{
				realPrevEntrance = new BlockPos(realPrevEntrance.getX() + this.roomStructure.xSize, realPrevEntrance.getY(), realPrevEntrance.getZ());
			}

		}else if(previousEntrance.getDirection() == EnumDirection.SOUTH)
		{
			if(direction == EnumDirection.EAST)
			{
				realPrevEntrance = new BlockPos(realPrevEntrance.getX() - this.roomStructure.xSize, realPrevEntrance.getY(), realPrevEntrance.getZ());
			}else if(direction == EnumDirection.NORTH)
			{
				realPrevEntrance = new BlockPos(realPrevEntrance.getX() - this.roomStructure.zSize, realPrevEntrance.getY(), realPrevEntrance.getZ() + this.roomStructure.xSize);
			}else if(direction == EnumDirection.WEST)
			{
				realPrevEntrance = new BlockPos(realPrevEntrance.getX(), realPrevEntrance.getY(), realPrevEntrance.getZ() + this.roomStructure.zSize);
			}

		}
		if(exit != null)
		{
			if(previousEntrance.getDirection() == EnumDirection.WEST)
			{
				realPrevEntrance = realPrevEntrance.south(j % 2 == 0 ? exit.getPos().getZ() : exit.getPos().getX());
	
			}else if(previousEntrance.getDirection() == EnumDirection.NORTH)
			{
				realPrevEntrance =	realPrevEntrance.west(j % 2 == 0 ? exit.getPos().getX() : exit.getPos().getZ());
	
			}else if(previousEntrance.getDirection() == EnumDirection.EAST)
			{
				realPrevEntrance = realPrevEntrance.north(j % 2 == 0 ? exit.getPos().getZ() : exit.getPos().getX());
	
			}else if(previousEntrance.getDirection() == EnumDirection.SOUTH)
			{
				realPrevEntrance = realPrevEntrance.east(j % 2 == 0 ? exit.getPos().getX() : exit.getPos().getZ());
	
			}
		}
		
		return new DungeonExit(realPrevEntrance, direction);
	}
	
	//only method that uses this is close, but is just for testing purposes
	public DungeonExit TESTalignWithRoom(DungeonRoom Nextroom, DungeonRoom PreviousRoom, DungeonExit PreviousEntrance, BlockPos StartingPosition) {

		BlockPos realPrevEntrance = StartingPosition;
		EnumDirection PreviousBuiltDirection = PreviousRoom.getPrevBuiltDIRECTION();
		EnumDirection direction = null;
		DungeonExit exit = null;

		int j =0;
		here:
			while(j < 4){
				for(int i = 0; i < Nextroom.getExits().size(); i ++)// 0 = west, 1 = north, 2 = east, 3 = south
				{
					if(Nextroom.getExits().get(i).getDirectionWithRotation(j) == PreviousEntrance.getOppositeDirection())
					{
						direction = EnumDirection.getDirectionFromID(j);
						exit = Nextroom.getExits().get(i);

						for(int l = 0; l < Nextroom.getExits().size(); l ++)
						{
							Nextroom.getExits().get(l).setRotation(j);
						}

						break here;
					}
				}

				j++;
			}
		if(PreviousEntrance.getDirection() == EnumDirection.EAST)
		{
			if(direction == EnumDirection.NORTH)
			{
				realPrevEntrance = new BlockPos(realPrevEntrance.getX(), realPrevEntrance.getY(), realPrevEntrance.getZ() + this.roomStructure.zSize);
			}else if(direction == EnumDirection.SOUTH)
			{
				realPrevEntrance = new BlockPos(realPrevEntrance.getX() + this.roomStructure.xSize, realPrevEntrance.getY(), realPrevEntrance.getZ());
			}else if(direction == EnumDirection.WEST)
			{
				realPrevEntrance = new BlockPos(realPrevEntrance.getX() + this.roomStructure.xSize, realPrevEntrance.getY(), realPrevEntrance.getZ() + this.roomStructure.zSize);
			}

		}else if(PreviousEntrance.getDirection() == EnumDirection.WEST)
		{
			if(direction == EnumDirection.EAST)
			{
				realPrevEntrance = new BlockPos(realPrevEntrance.getX() - this.roomStructure.xSize , realPrevEntrance.getY(), realPrevEntrance.getZ() - this.roomStructure.zSize);
			}else if(direction == EnumDirection.SOUTH)
			{
				realPrevEntrance = new BlockPos(realPrevEntrance.getX() - this.roomStructure.zSize, realPrevEntrance.getY(), realPrevEntrance.getZ());
			}else if(direction == EnumDirection.NORTH)
			{
				realPrevEntrance = new BlockPos(realPrevEntrance.getX(), realPrevEntrance.getY(), realPrevEntrance.getZ() - this.roomStructure.zSize);
			}

		}else if(PreviousEntrance.getDirection() == EnumDirection.NORTH)
		{
			//RealPrevEntrance = new BlockPos(RealPrevEntrance.getX() - this.roomStructure.xSize, RealPrevEntrance.getY(), RealPrevEntrance.getZ() - this.roomStructure.zSize);
			if(direction == EnumDirection.EAST)
			{
				realPrevEntrance = new BlockPos(realPrevEntrance.getX(), realPrevEntrance.getY(), realPrevEntrance.getZ() - this.roomStructure.zSize);
			}else if(direction == EnumDirection.SOUTH)
			{

				realPrevEntrance = new BlockPos(realPrevEntrance.getX() + this.roomStructure.zSize, realPrevEntrance.getY(), realPrevEntrance.getZ() - this.roomStructure.xSize);
			}else if(direction == EnumDirection.WEST)
			{
				realPrevEntrance = new BlockPos(realPrevEntrance.getX() + this.roomStructure.xSize, realPrevEntrance.getY(), realPrevEntrance.getZ());
			}

		}else if(PreviousEntrance.getDirection() == EnumDirection.SOUTH)
		{
			if(direction == EnumDirection.EAST)
			{
				realPrevEntrance = new BlockPos(realPrevEntrance.getX() - this.roomStructure.xSize, realPrevEntrance.getY(), realPrevEntrance.getZ());
			}else if(direction == EnumDirection.NORTH)
			{
				realPrevEntrance = new BlockPos(realPrevEntrance.getX() - this.roomStructure.zSize, realPrevEntrance.getY(), realPrevEntrance.getZ() + this.roomStructure.xSize);
			}else if(direction == EnumDirection.WEST)
			{
				realPrevEntrance = new BlockPos(realPrevEntrance.getX(), realPrevEntrance.getY(), realPrevEntrance.getZ() + this.roomStructure.zSize);
			}

		}

		if(exit != null)
		{
			if(PreviousEntrance.getDirection() == EnumDirection.WEST)
			{
				realPrevEntrance = realPrevEntrance.south(j % 2 == 0 ? exit.getPos().getZ() : exit.getPos().getX());

			}else if(PreviousEntrance.getDirection() == EnumDirection.NORTH)
			{
				realPrevEntrance =	realPrevEntrance.west(j % 2 == 0 ? exit.getPos().getX() : exit.getPos().getZ());

			}else if(PreviousEntrance.getDirection() == EnumDirection.EAST)
			{
				realPrevEntrance = realPrevEntrance.north(j % 2 == 0 ? exit.getPos().getZ() : exit.getPos().getX());

			}else if(PreviousEntrance.getDirection() == EnumDirection.SOUTH)
			{
				realPrevEntrance = realPrevEntrance.east(j % 2 == 0 ? exit.getPos().getX() : exit.getPos().getZ());

			}
		}

		return new DungeonExit(realPrevEntrance, direction);
	}

	@Override
	public void unloadRoom() {
		this.roomStructure = null;
		this.exits.clear();
	}

	@Override
	public DungeonExit setCorrectPath() {
		Random Rand = new Random();
		int RandomNumber;


		if(this.getExits().size() > 0)
		{
			RandomNumber = Rand.nextInt(this.getExits().size());
			this.getExits().get(RandomNumber).setCorrectPath(true);
			return this.getExits().get(RandomNumber);
		}

		return null;
	}
	
	public DungeonExit setCorrectPath(EnumDirection enumDirection) {
		for(DungeonExit tree : exits){
			if(tree.getDirection() == enumDirection){
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

	public EnumDirection getPrevBuiltDIRECTION() {
		return prevBuiltDirection;
	}


}
