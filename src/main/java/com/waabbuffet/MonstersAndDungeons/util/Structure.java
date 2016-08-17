package com.waabbuffet.MonstersAndDungeons.util;

import java.io.File;

import com.waabbuffet.MonstersAndDungeons.client.ClientProxy;
import com.waabbuffet.MonstersAndDungeons.util.dungeon.DungeonNBTTag;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Structure {









	public static void StructureReaderFromWorld(World world, BlockPos point1, BlockPos point2){

		StructureData data = new StructureData();

		if(point1 != null && point2 != null){
			int minX = point1.getX() > point2.getX() ? point2.getX() : point1.getX();
			int maxX = point1.getX() > point2.getX() ? point1.getX() : point2.getX();
			int minY = point1.getY() > point2.getY() ? point2.getY() : point1.getY();
			int maxY = point1.getY() > point2.getY() ? point1.getY() : point2.getY();
			int minZ = point1.getZ() > point2.getZ() ? point2.getZ() : point1.getZ();
			int maxZ = point1.getZ() > point2.getZ() ? point1.getZ() : point2.getZ();

			int placePosX = 0, placePosY = 0, placePosZ = 0;


			int xSize = maxX - minX + 1;
			int ySize = maxY - minY + 1;
			int zSize = maxZ - minZ + 1;


			data.blocks = new IBlockState[xSize][ySize][zSize];


			for(int x = 0; x < data.blocks.length; x++) {
				for(int y = 0; y <data.blocks[0].length; y++) {
					for(int z = 0; z <data.blocks[0][0].length; z++) {


						if(point1.getX() > point2.getX()){
							placePosX = point1.getX() - x;
						}else if(point1.getX() < point2.getX()){
							placePosX = point1.getX() + x;
						}


						placePosY = point1.getY() + y;


						if(point1.getZ() > point2.getZ()){
							placePosZ = point1.getZ() - z;
						}else if(point1.getZ() < point2.getZ()){
							placePosZ = point1.getZ() + z;
						}

						data.blocks[x][y][z] =  world.getBlockState(new BlockPos(placePosX, placePosY, placePosZ));

					}
				}
			}

			NBTTagCompound cmp = new NBTTagCompound();


			for(int x = 0; x < data.blocks.length; x++) {
				for(int y = 0; y < data.blocks[0].length; y++) {
					for(int z = 0; z < data.blocks[0][0].length; z++) {


						if(!data.blocks[x][y][z].equals(Blocks.AIR.getDefaultState())){

							cmp.setInteger(x + "," + y + "," + z, Block.getStateId(data.blocks[x][y][z]));


						}


					}
				}

			}
			cmp.setInteger("MaxXValue", data.blocks.length);
			cmp.setInteger("MaxYValue", data.blocks[0].length);
			cmp.setInteger("MaxZValue", data.blocks[0][0].length);


			File file = DungeonNBTTag.createOrGetNBTFile(new File(ClientProxy.dataDirectory, "RecentlyCreated"));
			DungeonNBTTag.injectNBTToFile(cmp, file);



		}else {
			return;
		}

	}











}
