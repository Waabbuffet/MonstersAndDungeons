package com.waabbuffet.MonstersAndDungeons.sound;

import com.waabbuffet.MonstersAndDungeons.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class MaDSoundsHandler {
	public static SoundEvent automatonHurt;
	
	public static void init() {
		automatonHurt = new SoundEvent(new ResourceLocation(Reference.MODID, "automaton_hurt"));
	}

}
