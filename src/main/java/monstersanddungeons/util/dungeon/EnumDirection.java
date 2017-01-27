package monstersanddungeons.util.dungeon;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.EnumFaceDirection;

public enum EnumDirection {
	WEST(0),
	NORTH(1),
	EAST(2),
	SOUTH(3);
	
	int id;
	private EnumDirection(int i){
		this.id = i;
	}
	
	public static EnumDirection getDirectionFromID(int id){
		for(EnumDirection dir : values()){
			if(dir.getID() == id){
				return dir;
			}
		}
		return null;
	}
	
	public static EnumDirection getDirectionFromBlockState(IBlockState state){
		int i = state.getBlock().getMetaFromState(state);
		for(EnumDirection dir : values()){
			if(dir.getID()-1 == i){
				return dir;
			}else if(dir == WEST && i == 3){
				return dir;
			}
		}
		return null;
	}
	
	public int getID(){
		return this.id;
	}
}
