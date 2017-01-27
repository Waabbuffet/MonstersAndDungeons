package monstersanddungeons.util;


import net.minecraft.block.state.IBlockState;

public class StructureData {

	public int xSize, ySize, zSize;
	String BuildingDirection; 

	public 	IBlockState[][][] blocks;

	boolean isLoaded = false;

	public int getxSize() {
		return xSize;
	}

	public int getySize() {
		return ySize;
	}

	public int getzSize() {
		return zSize;
	}
	public void setLoaded(boolean isLoaded) {
		this.isLoaded = isLoaded;
	}

	public boolean getIsLoaded()
	{
		return this.isLoaded;
	}

	//load values from file, build structureData(take direction, world and other stuff)



	/* Hardest part is to place the room directly aligned with another room
	 * 
	 */


	// Dungeons will work like this... A dungeon = a list of rooms, a room = a structure data with labeled exits. 
	// - The dungeon builder will first pick a dungeon, then it will scan the file and 
	// fill the room structure data and exits.it will split the dungeon data into two lists (while first read) (list of blockstate/pos), 
	// first placement block and second placement block (things that require a block to live). Add functions like distance 
	// from block exit 1 to exit two and etc. 
	// Then it will build the first room using the two lists! Then it will select another room load the room with exits and entrance
	// check to see if that entrance is possible if not add rotation and then check
	// if it is build that room using the two lists again and keep going until dungeon size then add boss room. 


	// need function buildroomwithRotation(blockPos startingPoint, String Direction);
	// need function that will place the room correctly aligned with exit of last room.
}
