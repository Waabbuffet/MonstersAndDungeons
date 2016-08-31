package com.waabbuffet.MonstersAndDungeons.client.events;

import com.waabbuffet.MonstersAndDungeons.items.MaDItemsHandler;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientEventHandler {

	
	/*
	@SubscribeEvent
	public void RenderPlayerEvent(RenderPlayerEvent.Post event)
	{
		EntityPlayer player = event.getEntityPlayer();
			
		if(player.getHeldItemOffhand() != null)
		{
		
			if(player.getHeldItemOffhand().getItem().equals(MaDItemsHandler.QuartzShield))
			{
				
				ItemStack shield = player.getHeldItemOffhand();
				
				Item itemarmor = shield.getItem();
				ModelBiped modelbiped =  itemarmor.getArmorModel(player, new ItemStack(itemarmor), EntityEquipmentSlot.CHEST, event.getRenderer().getMainModel());

				if(modelbiped != null)
				{
					GlStateManager.pushMatrix();
					event.getRenderer().bindTexture(new ResourceLocation(itemarmor.getArmorTexture(new ItemStack(itemarmor), player, EntityEquipmentSlot.CHEST, "Dylan")));
					modelbiped.render(player, 0, 0, 0, 0, 0, 0.0625f);
					GlStateManager.popMatrix();    
				}
				
			}
		}
	}
	*/
}
