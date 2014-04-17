package org.budgamers.reactorsplus.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import org.budgamers.reactorsplus.ReactorsPlus;

public class UnobtaniumOre extends Block {

	public UnobtaniumOre(Material p_i45394_1_) {
		super(p_i45394_1_);
		
		this.setBlockName("unobtaniumOre");
		this.setBlockTextureName(ReactorsPlus.MODID + ":unobtanium_ore");
		this.setResistance(1000.0F);
		this.setHardness(25.0F);
		this.setCreativeTab(ReactorsPlus.reactorsPlus);
		this.setHarvestLevel("pickaxe", 3);
	}
}
