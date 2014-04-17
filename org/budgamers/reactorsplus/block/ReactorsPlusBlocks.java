package org.budgamers.reactorsplus.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import org.budgamers.reactorsplus.machine.AtomicCompressorMachine;
import org.budgamers.reactorsplus.machine.BlockCreativeEnergyCell;
import org.budgamers.reactorsplus.machine.EnricherMachine;
import org.budgamers.reactorsplus.machine.IsotopeReactorMachine;
import org.budgamers.reactorsplus.machine.PlatingMachine;
import org.budgamers.reactorsplus.machine.StabilizerMachine;

import cpw.mods.fml.common.registry.GameRegistry;

public class ReactorsPlusBlocks {

	public static Block unobtaniumOre;
	public static Block platinumOre;
	
	public static Block enricher;
	public static Block stabilizer;
	public static Block atomicCompressor;
	public static Block isotopeReactor;
	public static Block platingMachine;
	public static Block creativeCell;
	
	public ReactorsPlusBlocks() {
		unobtaniumOre = new UnobtaniumOre(Material.rock);
		platinumOre = new PlatinumOre(Material.rock);
		
		enricher = new EnricherMachine(Material.iron);
		stabilizer = new StabilizerMachine(Material.iron);
		atomicCompressor = new AtomicCompressorMachine(Material.iron);
		isotopeReactor = new IsotopeReactorMachine(Material.iron);
		platingMachine = new PlatingMachine(Material.iron);
		
		creativeCell = new BlockCreativeEnergyCell(Material.iron);
		
		GameRegistry.registerBlock(unobtaniumOre, "unobtaniumOre");
		GameRegistry.registerBlock(platinumOre, "platinumOre");
		GameRegistry.registerBlock(enricher, "enricher");
		GameRegistry.registerBlock(stabilizer, "stabilizer");
		GameRegistry.registerBlock(atomicCompressor, "atomicCompressor");
		GameRegistry.registerBlock(isotopeReactor, "isotopeReactor");
		GameRegistry.registerBlock(platingMachine, "platingMachine");
		GameRegistry.registerBlock(creativeCell, "creativeCell");
	}
}
