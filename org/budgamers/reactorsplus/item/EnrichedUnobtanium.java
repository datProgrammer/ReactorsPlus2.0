package org.budgamers.reactorsplus.item;

import org.budgamers.reactorsplus.ReactorsPlus;

import net.minecraft.item.Item;

public class EnrichedUnobtanium extends Item {

	public EnrichedUnobtanium() {
		super();
		
		this.setUnlocalizedName("enrichedUnobtanium");
		this.setTextureName(ReactorsPlus.MODID + ":unobtanium_enriched");
		this.setCreativeTab(ReactorsPlus.reactorsPlus);
	}
}
