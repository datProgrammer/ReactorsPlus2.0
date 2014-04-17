package org.budgamers.reactorsplus.block;

import org.budgamers.reactorsplus.ReactorsPlus;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class PlatinumOre extends Block {

	protected PlatinumOre(Material p_i45394_1_) {
		super(p_i45394_1_);
		
		this.setBlockName("platinumOre");
		this.setBlockTextureName(ReactorsPlus.MODID + ":platinum_ore");
		this.setResistance(30.0F);
		this.setHardness(3.0F);
		this.setCreativeTab(ReactorsPlus.reactorsPlus);
		this.setHarvestLevel("pickaxe", 2);
	}

}
