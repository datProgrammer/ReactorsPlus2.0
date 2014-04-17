package org.budgamers.reactorsplus.item;

import org.budgamers.reactorsplus.ReactorsPlus;

import net.minecraft.item.Item;

public class EnrichedUnstableUnobtanium extends Item {

	public EnrichedUnstableUnobtanium() {
		super();
		
		this.setUnlocalizedName("enrichedUnstableUnobtanium");
		this.setTextureName(ReactorsPlus.MODID + ":unobtanium_unstable");
		this.setCreativeTab(ReactorsPlus.reactorsPlus);
	}
}
