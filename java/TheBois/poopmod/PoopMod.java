package TheBois.poopmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import TheBois.poopmod.lists.ItemList;
import TheBois.poopmod.lists.ToolMaterialList;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
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
					
					//Wooden pick materials
					ItemList.regular_wooden_pick_bind = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("regular_wooden_pick_bind")),
					ItemList.regular_wooden_pick_left = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("regular_wooden_pick_left")),
					ItemList.regular_wooden_pick_right = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("regular_wooden_pick_right")),
					ItemList.regular_wooden_pick_rod = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("regular_wooden_pick_rod")),
					
					ItemList.strong_wooden_pick_bind = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("strong_wooden_pick_bind")),
					ItemList.strong_wooden_pick_left = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("strong_wooden_pick_left")),
					ItemList.strong_wooden_pick_right = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("strong_wooden_pick_right")),
					ItemList.strong_wooden_pick_rod = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("strong_wooden_pick_rod")),
					
					//Wood Tools
					ItemList.weak_wooden_axe = new AxeItem(ToolMaterialList.weakwood, 1.0f, -3.2f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("weak_wooden_axe")),
					ItemList.weak_wooden_hoe = new HoeItem(ToolMaterialList.weakwood, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("weak_wooden_hoe")),
					ItemList.weak_wooden_pickaxe = new PickaxeItem(ToolMaterialList.weakwood, -3, -2.8f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("weak_wooden_pickaxe")),
					ItemList.weak_wooden_shovel = new ShovelItem(ToolMaterialList.weakwood, -2.5f, -3f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("weak_wooden_shovel")),
					ItemList.weak_wooden_sword = new SwordItem(ToolMaterialList.weakwood, -1, -2.4f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("weak_wooden_sword"))
			);
			logger.info("Items Registered.");	
		}
		
		private static ResourceLocation location(String name)
		{
			return new ResourceLocation(modid, name);
		}
	}
}
