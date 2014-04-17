package org.budgamers.reactorsplus.item;

import org.budgamers.reactorsplus.ReactorsPlus;

import net.minecraft.item.Item;

public class Unobtanium extends Item {

	public Unobtanium() {
		super();
		
		this.setUnlocalizedName("unobtanium");
		this.setTextureName(ReactorsPlus.MODID + ":unobtanium");
		this.setCreativeTab(ReactorsPlus.reactorsPlus);
	}
}
