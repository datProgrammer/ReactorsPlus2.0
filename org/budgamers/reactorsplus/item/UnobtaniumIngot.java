package org.budgamers.reactorsplus.item;

import org.budgamers.reactorsplus.ReactorsPlus;

import net.minecraft.item.Item;

public class UnobtaniumIngot extends Item {

	public UnobtaniumIngot() {
		super();
		
		this.setUnlocalizedName("unobtaniumIngot");
		this.setTextureName(ReactorsPlus.MODID + ":unobtanium_ingot");
		this.setCreativeTab(ReactorsPlus.reactorsPlus);
	}
}
