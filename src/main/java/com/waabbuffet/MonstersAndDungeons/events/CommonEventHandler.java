package com.waabbuffet.MonstersAndDungeons.events;

import com.waabbuffet.MonstersAndDungeons.entity.automatons.EntityAutomatonsRook;
import com.waabbuffet.MonstersAndDungeons.items.MaDItemsHandler;
import com.waabbuffet.MonstersAndDungeons.items.armor.ArmorStat;
import com.waabbuffet.MonstersAndDungeons.items.armor.ItemQuartzArmor;
import com.waabbuffet.MonstersAndDungeons.stats.StatDamageSources;
import com.waabbuffet.MonstersAndDungeons.stats.Stats;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CommonEventHandler {
	@SubscribeEvent
	public void onEntityAttack(LivingAttackEvent event){
		
		if(event.getSource() != StatDamageSources.bonusDamage){
			if(event.getSource().getSourceOfDamage() instanceof EntityPlayer){
				
				EntityPlayer attacker = (EntityPlayer)event.getSource().getSourceOfDamage();
				float bonusDamage = 0;
				if(attacker.getHeldItemMainhand() != null && attacker.getHeldItemMainhand().getItem() == MaDItemsHandler.quartzWarhammer){
					double str = 0;
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
					System.out.println(str);
					bonusDamage += (str > 0)?(1+(str/4d)):0;
					System.out.println(bonusDamage);
				}
				
				if(bonusDamage > 0){
					event.getEntityLiving().attackEntityFrom(StatDamageSources.bonusDamage, bonusDamage);
				}
				
				if(event.getEntityLiving() instanceof EntityAutomatonsRook)
				{
					if(event.getSource().getSourceOfDamage().getLookVec().dotProduct(event.getEntity().getLookVec()) < 0.5)
					{
						if(event.isCancelable())
						{
							event.setCanceled(true);
						}
					}
				}		
			}
		}
	}
	
}
