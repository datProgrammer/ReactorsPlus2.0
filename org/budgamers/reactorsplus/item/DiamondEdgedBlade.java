package org.budgamers.reactorsplus.item;

import org.budgamers.reactorsplus.ReactorsPlus;

import net.minecraft.item.ItemSword;

public class DiamondEdgedBlade extends ItemSword {

	public DiamondEdgedBlade(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);
		
		this.setUnlocalizedName("diamondEdge");
		this.setTextureName(ReactorsPlus.MODID + ":diamond_blade");
		this.setCreativeTab(ReactorsPlus.reactorsPlus);
	}

}
