package monstersanddungeons.client;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

import monstersanddungeons.blocks.MaDBlocksHandler;
import monstersanddungeons.client.models.items.ModelQuartzArmor;
import monstersanddungeons.entity.MaDEntityHandler;
import monstersanddungeons.events.KeyBindEvent;
import monstersanddungeons.items.MaDItemsHandler;
import monstersanddungeons.proxy.CommonProxy;
import monstersanddungeons.util.Reference;
import monstersanddungeons.util.ResourceLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;



public class ClientProxy extends CommonProxy {

	
	public static File dataDirectory;
	public static BlockPos BlockPos1;
	public static BlockPos BlockPos2;
	
	public static List<IResourcePack> rPacks;
	

	
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		
		dataDirectory = new File(event.getModConfigurationDirectory(), Reference.NAME);
		
		
		try
		{
			Field field = Minecraft.class.getDeclaredField("defaultResourcePacks");
			field.setAccessible(true);
			
			rPacks =  (List<IResourcePack>) field.get(Minecraft.getMinecraft());
			rPacks.add(new ResourceLoader(new File(dataDirectory.getAbsolutePath() + "/madresources.zip")));
			Minecraft.getMinecraft().refreshResources();
			
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		
		

	}

	public void init(FMLInitializationEvent event) {
		super.init(event);
	
		MinecraftForge.EVENT_BUS.register(new KeyBindEvent());
		
	
		this.RegisterRenders();
	}

	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
		
		
	}
	
	@Override
	public void RegisterRenders() {
		
		MaDBlocksHandler.registerRenders();
		MaDItemsHandler.registerRenders();
		MaDEntityHandler.registerRenders();
	}
		
	@Override
	public ModelBiped getArmorModel(int id) {
		return new ModelQuartzArmor(id);
	}
}
