package org.budgamers.reactorsplus.item;

import org.budgamers.reactorsplus.ReactorsPlus;

import net.minecraft.item.Item;

public class Francium extends Item {

	public Francium() {
		super();
		
		this.setUnlocalizedName("francium");
		this.setTextureName(ReactorsPlus.MODID + ":francium");
		this.setCreativeTab(ReactorsPlus.reactorsPlus);
	}
}
