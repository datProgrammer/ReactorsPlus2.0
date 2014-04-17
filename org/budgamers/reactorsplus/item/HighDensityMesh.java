package org.budgamers.reactorsplus.item;

import org.budgamers.reactorsplus.ReactorsPlus;

import net.minecraft.item.Item;

public class HighDensityMesh extends Item {

	public HighDensityMesh() {
		super();
		
		this.setUnlocalizedName("highDensityMesh");
		this.setTextureName(ReactorsPlus.MODID + ":highdensity_mesh");
		this.setCreativeTab(ReactorsPlus.reactorsPlus);
	}
}
