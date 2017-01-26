package com.waabbuffet.MonstersAndDungeons.tileentity;




import com.waabbuffet.MonstersAndDungeons.tileentity.miscellaneous.TileEntityMonsterStatue;

import net.minecraftforge.fml.common.registry.GameRegistry;



public class MaDTileEntityHandler {


	public static void register()
	{
		
		GameRegistry.registerTileEntity(TileEntityMonsterStatue.class, "TileEntityMonsterStatue");
	}

}
