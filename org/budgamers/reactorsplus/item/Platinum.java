package org.budgamers.reactorsplus.item;

import org.budgamers.reactorsplus.ReactorsPlus;

import net.minecraft.item.Item;

public class Platinum extends Item {

	public Platinum() {
		super();
		
		this.setUnlocalizedName("platinum");
		this.setTextureName(ReactorsPlus.MODID + ":platinum");
		this.setCreativeTab(ReactorsPlus.reactorsPlus);
	}
}
