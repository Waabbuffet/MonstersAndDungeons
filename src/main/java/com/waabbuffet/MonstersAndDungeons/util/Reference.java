package com.waabbuffet.MonstersAndDungeons.util;

public class Reference 
{
	public static final String MODID = "monsteranddungeons";
	public static final String MOD_ID_GenBlocks = "monsteranddungeons";

	public static final String NAME = "Monster and Dungeons";
	public static final String VERSION = "0.1";
	public static final String MC_VERSION = "1.10.2";

	public static final String COMMON_PROXY = "com.waabbuffet.MonstersAndDungeons.proxy.CommonProxy";
	public static final String CLIENT_PROXY = "com.waabbuffet.MonstersAndDungeons.client.ClientProxy";


	public static final String genBlock_Stairs_Blockstate = 
			"{ " + 
					"\"variants\": { "  +
					" \"facing=east,half=bottom,shape=straight\":  { \"model\": \"oak_stairs\" }," +
					" \"facing=west,half=bottom,shape=straight\":  { \"model\": \"oak_stairs\", \"y\": 180, \"uvlock\": true }," +
					"\"facing=south,half=bottom,shape=straight\": { \"model\": \"oak_stairs\", \"y\": 90, \"uvlock\": true }," +
					"\"facing=north,half=bottom,shape=straight\": { \"model\": \"oak_stairs\", \"y\": 270, \"uvlock\": true }," + 
					"\"facing=east,half=bottom,shape=outer_right\":  { \"model\": \"oak_outer_stairs\" }," +
					"\"facing=west,half=bottom,shape=outer_right\":  { \"model\": \"oak_outer_stairs\", \"y\": 180, \"uvlock\": true }," +
					"\"facing=south,half=bottom,shape=outer_right\": { \"model\": \"oak_outer_stairs\", \"y\": 90, \"uvlock\": true }," +
					"\"facing=north,half=bottom,shape=outer_right\": { \"model\": \"oak_outer_stairs\", \"y\": 270, \"uvlock\": true }, " +
					"\"facing=east,half=bottom,shape=outer_left\":  { \"model\": \"oak_outer_stairs\", \"y\": 270, \"uvlock\": true }, " +
					"\"facing=west,half=bottom,shape=outer_left\":  { \"model\": \"oak_outer_stairs\", \"y\": 90, \"uvlock\": true }, " +
					"\"facing=south,half=bottom,shape=outer_left\": { \"model\": \"oak_outer_stairs\" }, " +
					"\"facing=north,half=bottom,shape=outer_left\": { \"model\": \"oak_outer_stairs\", \"y\": 180, \"uvlock\": true }," +
					"\"facing=east,half=bottom,shape=inner_right\":  { \"model\": \"oak_inner_stairs\" }," +
					"\"facing=west,half=bottom,shape=inner_right\":  { \"model\": \"oak_inner_stairs\", \"y\": 180, \"uvlock\": true }," +
					"\"facing=south,half=bottom,shape=inner_right\": { \"model\": \"oak_inner_stairs\", \"y\": 90, \"uvlock\": true }," +
					"\"facing=north,half=bottom,shape=inner_right\": { \"model\": \"oak_inner_stairs\", \"y\": 270, \"uvlock\": true }," +
					"\"facing=east,half=bottom,shape=inner_left\":  { \"model\": \"oak_inner_stairs\", \"y\": 270, \"uvlock\": true }," +
					"\"facing=west,half=bottom,shape=inner_left\":  { \"model\": \"oak_inner_stairs\", \"y\": 90, \"uvlock\": true }," +
					"\"facing=south,half=bottom,shape=inner_left\": { \"model\": \"oak_inner_stairs\" }," +
					"\"facing=north,half=bottom,shape=inner_left\": { \"model\": \"oak_inner_stairs\", \"y\": 180, \"uvlock\": true }," +
					"\"facing=east,half=top,shape=straight\":  { \"model\": \"oak_stairs\", \"x\": 180, \"uvlock\": true }," +
					"\"facing=west,half=top,shape=straight\":  { \"model\": \"oak_stairs\", \"x\": 180, \"y\": 180, \"uvlock\": true }," +
					"\"facing=south,half=top,shape=straight\": { \"model\": \"oak_stairs\", \"x\": 180, \"y\": 90, \"uvlock\": true }," +
					"\"facing=north,half=top,shape=straight\": { \"model\": \"oak_stairs\", \"x\": 180, \"y\": 270, \"uvlock\": true }," +
					"\"facing=east,half=top,shape=outer_right\":  { \"model\": \"oak_outer_stairs\", \"x\": 180, \"y\": 90, \"uvlock\": true }," +
					"\"facing=west,half=top,shape=outer_right\":  { \"model\": \"oak_outer_stairs\", \"x\": 180, \"y\": 270, \"uvlock\": true }," +
					"\"facing=south,half=top,shape=outer_right\": { \"model\": \"oak_outer_stairs\", \"x\": 180, \"y\": 180, \"uvlock\": true }, " +
					"\"facing=north,half=top,shape=outer_right\": { \"model\": \"oak_outer_stairs\", \"x\": 180, \"uvlock\": true }," +
					"\"facing=east,half=top,shape=outer_left\":  { \"model\": \"oak_outer_stairs\", \"x\": 180, \"uvlock\": true }," +
					"\"facing=west,half=top,shape=outer_left\":  { \"model\": \"oak_outer_stairs\", \"x\": 180, \"y\": 180, \"uvlock\": true }," +
					"\"facing=south,half=top,shape=outer_left\": { \"model\": \"oak_outer_stairs\", \"x\": 180, \"y\": 90, \"uvlock\": true }," +
					"\"facing=north,half=top,shape=outer_left\": { \"model\": \"oak_outer_stairs\", \"x\": 180, \"y\": 270, \"uvlock\": true }," +
					"\"facing=east,half=top,shape=inner_right\":  { \"model\": \"oak_inner_stairs\", \"x\": 180, \"y\": 90, \"uvlock\": true }," +
					"\"facing=west,half=top,shape=inner_right\":  { \"model\": \"oak_inner_stairs\", \"x\": 180, \"y\": 270, \"uvlock\": true }," +
					"\"facing=south,half=top,shape=inner_right\": { \"model\": \"oak_inner_stairs\", \"x\": 180, \"y\": 180, \"uvlock\": true }," +
					"\"facing=north,half=top,shape=inner_right\": { \"model\": \"oak_inner_stairs\", \"x\": 180, \"uvlock\": true }," +
					"\"facing=east,half=top,shape=inner_left\":  { \"model\": \"oak_inner_stairs\", \"x\": 180, \"uvlock\": true }, " +
					"\"facing=west,half=top,shape=inner_left\":  { \"model\": \"oak_inner_stairs\", \"x\": 180, \"y\": 180, \"uvlock\": true }," +
					"\"facing=south,half=top,shape=inner_left\": { \"model\": \"oak_inner_stairs\", \"x\": 180, \"y\": 90, \"uvlock\": true }, " +
					"\"facing=north,half=top,shape=inner_left\": { \"model\": \"oak_inner_stairs\", \"x\": 180, \"y\": 270, \"uvlock\": true }" +
					"}" + "}" ;

	public static final String genBlocks_Stairs_model_outer = 
			"{ " +
					"\"parent\": \"block/outer_stairs\"," +
					"\"textures\": { " +
					"\"bottom\": \"blocks/planks_oak\"," +
					"\"top\": \"blocks/planks_oak\", " +
					"\"side\": \"blocks/planks_oak\" " +
					"} " +
					"} ";

	public static final String genBlocks_Stairs_model_inner = 
			"{ " +
					"\"parent\": \"block/inner_stairs\"," +
					"\"textures\": { " +
					"\"bottom\": \"blocks/planks_oak\"," +
					"\"top\": \"blocks/planks_oak\", " +
					"\"side\": \"blocks/planks_oak\" " +
					"} " +
					"} ";

	public static final String genBlocks_Stairs_model_reg = 
			"{ " +
					"\"parent\": \"block/stairs\"," +
					"\"textures\": { " +
					"\"bottom\": \"blocks/planks_oak\"," +
					"\"top\": \"blocks/planks_oak\", " +
					"\"side\": \"blocks/planks_oak\" " +
					"} " +
					"} ";

}
