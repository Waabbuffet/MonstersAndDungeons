package com.waabbuffet.MonstersAndDungeons.events;

import com.waabbuffet.MonstersAndDungeons.items.MaDItemsHandler;
import com.waabbuffet.MonstersAndDungeons.items.armor.ArmorStat;
import com.waabbuffet.MonstersAndDungeons.items.armor.ItemQuartzArmor;
import com.waabbuffet.MonstersAndDungeons.stats.Stats;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CommonEventHandler {
	@SubscribeEvent
	public static void onEntityAttack(LivingAttackEvent event){
		if(event.getSource().getSourceOfDamage() instanceof EntityPlayer){
			EntityPlayer attacker = (EntityPlayer)event.getSource().getSourceOfDamage();
			float bonusDamage = 0;
			if(attacker.getActiveItemStack().getItem() == MaDItemsHandler.quartzWarhammer){
				int str = 0;
				for(ItemStack armor : attacker.getArmorInventoryList()){
					if(armor.getItem() instanceof ItemQuartzArmor){
						ItemQuartzArmor quartzArmor = (ItemQuartzArmor)armor.getItem();
						for(ArmorStat stat : quartzArmor.getArmorStats()){
							if(stat.getStat() == Stats.strength){
								str += stat.getPower();
							}
						}
					}
				}
				bonusDamage += (str!=0)?(1+(str/4)):0;
			}
			
			if(bonusDamage > 0){
				event.getEntityLiving().attackEntityFrom(event.getSource(), bonusDamage);
			}
		}
	}
}
