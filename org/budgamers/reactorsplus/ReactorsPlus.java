package org.budgamers.reactorsplus;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.config.Configuration;

import org.budgamers.reactorsplus.block.ReactorsPlusBlocks;
import org.budgamers.reactorsplus.gen.ReactorsPlusWorldGen;
import org.budgamers.reactorsplus.item.ReactorsPlusItems;
import org.budgamers.reactorsplus.recipe.ReactorsPlusRecipes;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = ReactorsPlus.MODID, name = ReactorsPlus.NAME, version = ReactorsPlus.VERSION)
public class ReactorsPlus {
	
	@Instance(ReactorsPlus.MODID)
	public static ReactorsPlus instance;
	
	public static final String MODID = "ReactorsPlus";
	public static final String NAME = "Reactors+";
	public static final String VERSION = "2.42";
	
	@SidedProxy(clientSide = "org.budgamers.reactorsplus.ClientProxy", serverSide = "org.budgamers.reactorsplus.CommonProxy")
	public static ClientProxy proxy;
	
	public int unobtaniumChance;
	public int unobtaniumLayer;
	
	public int platinumChance;
	public int platinumLayer;
	
	public static CreativeTabs reactorsPlus = new CreativeTabsReactorsPlus("Reactors+");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		NetworkRegistry.INSTANCE.registerGuiHandler(this, ReactorsPlus.proxy);
		
		Configuration config = new Configuration(e.getSuggestedConfigurationFile());
		
		config.load();
		
		unobtaniumChance = config.get(Configuration.CATEGORY_GENERAL, "unobtanium_generation_chance", 1).getInt();
		unobtaniumLayer = config.get(Configuration.CATEGORY_GENERAL, "unobtanium_generation_layer", 16).getInt();
		
		platinumChance = config.get(Configuration.CATEGORY_GENERAL, "platinum_generation_chance", 4).getInt();
		platinumLayer = config.get(Configuration.CATEGORY_GENERAL, "platinum_generation_layer", 16).getInt();
		
		config.save();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		new ReactorsPlusBlocks();
		new ReactorsPlusItems();
		new ReactorsPlusRecipes();
		new ReactorsPlusWorldGen();
	}
}
