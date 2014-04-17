package org.budgamers.reactorsplus.recipe;

import ic2.api.item.IC2Items;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

import org.budgamers.reactorsplus.block.ReactorsPlusBlocks;
import org.budgamers.reactorsplus.item.ReactorsPlusItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class ReactorsPlusRecipes {

	public ReactorsPlusRecipes() {
		GameRegistry.addRecipe(new ItemStack(ReactorsPlusItems.diamondEdgedBlade), new Object[] { "DI ", " DI", "  S", 'D', Items.diamond, 'S', Items.stick, 'I', Items.iron_ingot });
		GameRegistry.addRecipe(new ItemStack(ReactorsPlusItems.emptyCanister), new Object[] { "IGI", "IGI", "IGI", 'I', Items.iron_ingot, 'G', Blocks.glass });
		GameRegistry.addRecipe(new ItemStack(ReactorsPlusItems.airPump), new Object[] { " C ", " P ", "RGR", 'C', ReactorsPlusItems.emptyCanister, 'P', Blocks.piston, 'R', Items.redstone, 'G', Items.gold_ingot });
		
		GameRegistry.addRecipe(new ItemStack(ReactorsPlusBlocks.atomicCompressor), new Object[]{"OIO", "DED", "OIO", 'E', ReactorsPlusItems.extremeCircuit, 'O', Blocks.obsidian, 'I', Items.iron_ingot, 'D', Items.diamond});
		GameRegistry.addRecipe(new ItemStack(ReactorsPlusBlocks.enricher), new Object[]{"QIQ", "DED", "QIQ", 'E', ReactorsPlusItems.extremeCircuit, 'Q', Items.quartz, 'I', Items.iron_ingot, 'D', Items.diamond}); 
		GameRegistry.addRecipe(new ItemStack(ReactorsPlusBlocks.isotopeReactor), new Object[]{"PIP", "DED", "PIP", 'E', ReactorsPlusItems.extremeCircuit, 'P', ReactorsPlusItems.airPump, 'I', Items.iron_ingot, 'D', Items.diamond});
		GameRegistry.addRecipe(new ItemStack(ReactorsPlusBlocks.platingMachine), new Object[]{"BIB", "DED", "BIB", 'B', ReactorsPlusItems.diamondEdgedBlade, 'I', Items.iron_ingot, 'D', Items.diamond, 'E', ReactorsPlusItems.extremeCircuit});
		GameRegistry.addRecipe(new ItemStack(ReactorsPlusBlocks.stabilizer), new Object[]{"PIP", "DED", "PIP", 'E', ReactorsPlusItems.extremeCircuit, 'I', Items.iron_ingot});
		 
		GameRegistry.addShapelessRecipe(new ItemStack(ReactorsPlusItems.hydrogenPump), new Object[] {new ItemStack(ReactorsPlusItems.airPump), new ItemStack(Items.water_bucket) });
		GameRegistry.addShapelessRecipe(new ItemStack(ReactorsPlusItems.heliumPump), new Object[] {new ItemStack(ReactorsPlusItems.unobtanium), new ItemStack(ReactorsPlusItems.airPump) });
		GameRegistry.addShapelessRecipe(new ItemStack(ReactorsPlusItems.nitrogenPump), new Object[] {new ItemStack(ReactorsPlusItems.airPump), new ItemStack(ReactorsPlusItems.highDensityMesh) });
		GameRegistry.addShapelessRecipe(new ItemStack(ReactorsPlusItems.oxygenPump), new Object[] { new ItemStack(ReactorsPlusItems.airPump), IC2Items.getItem("chargedReBattery") });
		GameRegistry.addRecipe( new ItemStack(ReactorsPlusItems.extremeCircuit), new Object[] { "DPD", "MAM", "DPD", 'A', IC2Items.getItem("advancedCircuit"), 'D', Items.diamond, 'P', IC2Items.getItem("glassFiberCableItem") });

		GameRegistry.addRecipe(new ItemStack(ReactorsPlusItems.unobtaniumHeatVent), new Object[] { "PBP", "EAE", "PBP", 'P', ReactorsPlusItems.unobtaniumPlate, 'B', Blocks.iron_bars, 'E', ReactorsPlusItems.extremeCircuit, 'A', IC2Items.getItem("reactorVentDiamond").getItem() });
		GameRegistry.addRecipe(new ItemStack(ReactorsPlusItems.unobtaniumHeatEvapourator), new Object[] { "PWP", "UVU", "PLP", 'P', ReactorsPlusItems.unobtaniumPlate, 'W', Items.water_bucket, 'U', ReactorsPlusItems.enrichedUnobtanium, 'V', ReactorsPlusItems.unobtaniumHeatVent, 'L', Items.lava_bucket });
		
		GameRegistry.addShapelessRecipe(new ItemStack(ReactorsPlusItems.hydrogenCanister), new Object[]{ReactorsPlusItems.emptyCanister, ReactorsPlusItems.hydrogenPump});
		GameRegistry.addShapelessRecipe(new ItemStack(ReactorsPlusItems.heliumCanister), new Object[]{ReactorsPlusItems.emptyCanister, ReactorsPlusItems.heliumPump});
		GameRegistry.addShapelessRecipe(new ItemStack(ReactorsPlusItems.nitrogenCanister), new Object[]{ReactorsPlusItems.emptyCanister, ReactorsPlusItems.nitrogenPump});
		GameRegistry.addShapelessRecipe(new ItemStack(ReactorsPlusItems.oxygenCanister), new Object[]{ReactorsPlusItems.emptyCanister, ReactorsPlusItems.oxygenPump});
		
		Recipes.extractor.addRecipe(new RecipeInputItemStack(IC2Items.getItem("carbonMesh")), null, new ItemStack(ReactorsPlusItems.highDensityMesh));
		
		FurnaceRecipes.smelting().func_151393_a(ReactorsPlusBlocks.platinumOre, new ItemStack(ReactorsPlusItems.platinum), 10.0F);
	}
}
