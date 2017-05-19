package monstersanddungeons.items.spawnEggs;

import java.util.Iterator;
import java.util.List;

import monstersanddungeons.entity.MaDEntityList;
import monstersanddungeons.util.Reference;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemSpawnWhitePawn extends Item implements IItemColor
{

	String key =  "WhitePawns";
	protected int colorBase = 0x000000;
	protected int colorSpots = 0xFFFFFF;

	public ItemSpawnWhitePawn(String name) {

		this.setCreativeTab(CreativeTabs.MISC);
		setUnlocalizedName(name);
		setRegistryName(name);

		this.setHasSubtypes(true);

		GameRegistry.register(this);
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		String s = "Spawn ";
		String entityName = MaDEntityList.getStringFromID(stack.getItemDamage());
		if (entityName != null) {
			s = s + entityName;
		}
		return s;
}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {

		if(!worldIn.isRemote)
		{
			this.spawnCreature(worldIn, itemStackIn.getItemDamage(), playerIn.posX, playerIn.posY, playerIn.posZ);
		}

		return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
	}

	public Entity spawnCreature(World world, int entityID, double x, double y, double z) {
		
		Entity entity = null;
		Class<? extends Entity> oclass = MaDEntityList.getClassFromID(entityID);
		
		if (MaDEntityList.entityEggs.containsKey(oclass)) {
			entity = MaDEntityList.createEntity(oclass, world);
			
			if (entity instanceof EntityLiving) {
				EntityLiving entityliving = (EntityLiving) entity;
				entityliving.rotationYawHead = entityliving.rotationYaw;
				entityliving.renderYawOffset = entityliving.rotationYaw;
				entityliving.setPosition(x, y, z);
				world.spawnEntityInWorld(entity);
				entityliving.playLivingSound();
			}
		}
		
		return entity;
	}

	@Override
	public void getSubItems(Item item, CreativeTabs tab, List<ItemStack> itemList) {

		Iterator<Class<? extends Entity>> iterator = MaDEntityList.entityEggs.keySet().iterator();
		
		while (iterator.hasNext()) {
			
			Class<? extends Entity> oclass = iterator.next();
			List<Integer> colors = MaDEntityList.entityEggs.get(oclass);
			
			if (colors != null && colors.size() == 2) {
				
				itemList.add(new ItemStack(item, 1, MaDEntityList.getEntityId(oclass)));
			}
		}
	}

	@Override
	public int getColorFromItemstack(ItemStack stack, int tintIndex) {
		List<Integer> colors = MaDEntityList.entityEggs.get(MaDEntityList.getClassFromID(stack.getItemDamage()));
		return colors != null && colors.size() > 1 ? colors.get((tintIndex == 0 ? 0 : 1)) : 16777215;
	}
	
}
