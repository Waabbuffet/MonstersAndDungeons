package com.waabbuffet.MonstersAndDungeons.tileentity;




import net.minecraftforge.fml.common.registry.GameRegistry;

import com.waabbuffet.MonstersAndDungeons.tileentity.miscellaneous.TileEntityMonsterStatue;



public class MaDTileEntityHandler {


	public static void register()
	{
		
		GameRegistry.registerTileEntity(TileEntityMonsterStatue.class, "TileEntityMonsterStatue");
	}

}
