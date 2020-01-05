package TheBois.poopmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import TheBois.poopmod.lists.ItemList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("poopmod")
public class PoopMod
{
	public static PoopMod instance;
	public static final String modid = "poopmod";
	private static final Logger logger = LogManager.getLogger(modid);
	
	public PoopMod()
	{
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	 
	private void setup(final FMLCommonSetupEvent event)
	{
		logger.info("poop1");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event)
	{
		logger.info("poop2");
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event)
		{
			event.getRegistry().registerAll
			(
					ItemList.poop_item = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("poop_item")),
					//Wooden picks
					ItemList.regular_wooden_pick_bind = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("regular_wooden_pick_bind")),
					ItemList.regular_wooden_pick_left = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("regular_wooden_pick_left")),
					ItemList.regular_wooden_pick_right = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("regular_wooden_pick_right")),
					ItemList.regular_wooden_pick_rod = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("regular_wooden_pick_rod")),
					
					ItemList.strong_wooden_pick_bind = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("strong_wooden_pick_bind")),
					ItemList.strong_wooden_pick_left = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("strong_wooden_pick_left")),
					ItemList.strong_wooden_pick_right = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("strong_wooden_pick_right")),
					ItemList.strong_wooden_pick_rod = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("strong_wooden_pick_rod"))
			);
			logger.info("Items Registered.");	
		}
		
		private static ResourceLocation location(String name)
		{
			return new ResourceLocation(modid, name);
		}
	}
}
