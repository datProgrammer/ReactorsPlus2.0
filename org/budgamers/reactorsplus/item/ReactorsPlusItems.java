package org.budgamers.reactorsplus.item;

import org.budgamers.reactorsplus.item.reactor.HeliumCanister;
import org.budgamers.reactorsplus.item.reactor.HydrogenCanister;
import org.budgamers.reactorsplus.item.reactor.NitrogenCanister;
import org.budgamers.reactorsplus.item.reactor.OxygenCanister;
import org.budgamers.reactorsplus.item.reactor.UnobtaniumHeatEvapourator;
import org.budgamers.reactorsplus.item.reactor.UnobtaniumHeatVent;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import cpw.mods.fml.common.registry.GameRegistry;

public class ReactorsPlusItems {

	public static Item unobtanium;
	public static Item francium;
	public static Item platinum;
	
	public static Item emptyCanister;
	public static Item oxygenCanister;
	public static Item hydrogenCanister;
	public static Item heliumCanister;
	public static Item nitrogenCanister;
	public static Item diamondEdgedBlade;
	public static Item airPump;
	public static Item heliumPump;
	public static Item hydrogenPump;
	public static Item nitrogenPump;
	public static Item oxygenPump;
	public static Item extremeCircuit;
	public static Item highDensityMesh;
	
	public static Item enrichedUnstableUnobtanium;
	public static Item enrichedUnobtanium;
	public static Item unobtaniumIngot;
	public static Item unobtaniumPlate;
	public static Item unobtaniumHeatVent;
	public static Item unobtaniumHeatEvapourator;
	
	public ReactorsPlusItems() {
		unobtanium = new Unobtanium();
		francium = new Francium();
		platinum = new Platinum();
		
		emptyCanister = new EmptyCanister();
		oxygenCanister = new OxygenCanister();
		hydrogenCanister = new HydrogenCanister();
		heliumCanister = new HeliumCanister();
		nitrogenCanister = new NitrogenCanister();
		
		diamondEdgedBlade = new DiamondEdgedBlade(ToolMaterial.EMERALD);
		airPump = new AirPump();
		heliumPump = new HeliumPump();
		hydrogenPump = new HydrogenPump();
		nitrogenPump = new NitrogenPump();
		oxygenPump = new OxygenPump();
		extremeCircuit = new ExtremeCircuit();
		highDensityMesh = new HighDensityMesh();
		
		enrichedUnstableUnobtanium = new EnrichedUnstableUnobtanium();
		enrichedUnobtanium = new EnrichedUnobtanium();
		unobtaniumIngot = new UnobtaniumIngot();
		unobtaniumPlate = new UnobtaniumPlate();
		unobtaniumHeatVent = new UnobtaniumHeatVent();
		unobtaniumHeatEvapourator = new UnobtaniumHeatEvapourator();
		
		GameRegistry.registerItem(unobtanium, "unobtanium");
		GameRegistry.registerItem(francium, "francium");
		GameRegistry.registerItem(platinum, "platinum");
		GameRegistry.registerItem(enrichedUnstableUnobtanium, "enrichedUnstableUnobtanium");
		GameRegistry.registerItem(enrichedUnobtanium, "enrichedUnobtanium");
		GameRegistry.registerItem(unobtaniumIngot, "unobtaniumIngot");
		GameRegistry.registerItem(unobtaniumPlate, "unobtaniumPlate");
		GameRegistry.registerItem(unobtaniumHeatVent, "unobtaniumHeatVent");
		GameRegistry.registerItem(unobtaniumHeatEvapourator, "unobtaniumHeatEvapourator");
		GameRegistry.registerItem(emptyCanister, "emptyCanister");
		GameRegistry.registerItem(oxygenCanister, "oxygenCanister");
		GameRegistry.registerItem(hydrogenCanister, "hydrogenCanister");
		GameRegistry.registerItem(heliumCanister, "heliumCanister");
		GameRegistry.registerItem(nitrogenCanister, "nitrogenCanister");
		GameRegistry.registerItem(diamondEdgedBlade, "diamondEdge");
		GameRegistry.registerItem(airPump, "Air Pump");
		GameRegistry.registerItem(heliumPump, "airPump.helium");
		GameRegistry.registerItem(hydrogenPump, "airPump.hydrogen");
		GameRegistry.registerItem(nitrogenPump, "airPump.nitrogen");
		GameRegistry.registerItem(oxygenPump, "airPump.oxygen");
		GameRegistry.registerItem(extremeCircuit, "extremeCircuit");
		GameRegistry.registerItem(highDensityMesh, "highDensityMesh");
	}
}
