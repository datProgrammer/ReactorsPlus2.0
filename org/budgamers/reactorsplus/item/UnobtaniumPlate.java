package org.budgamers.reactorsplus.item;

import org.budgamers.reactorsplus.ReactorsPlus;

import net.minecraft.item.Item;

public class UnobtaniumPlate extends Item {

	public UnobtaniumPlate() {
		super();
		
		this.setUnlocalizedName("unobtaniumPlate");
		this.setTextureName(ReactorsPlus.MODID + ":unobtanium_plate");
		this.setCreativeTab(ReactorsPlus.reactorsPlus);
	}
}
