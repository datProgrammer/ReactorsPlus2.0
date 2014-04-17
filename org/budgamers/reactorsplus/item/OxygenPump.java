package org.budgamers.reactorsplus.item;

import net.minecraft.item.ItemStack;

import org.budgamers.reactorsplus.ReactorsPlus;

public class OxygenPump extends AirPump {

	public OxygenPump() {
		super();
		
		this.setUnlocalizedName("airPump.oxygen");
		this.setTextureName(ReactorsPlus.MODID + ":air_pump");
		this.setCreativeTab(ReactorsPlus.reactorsPlus);
	}
	
	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack stack) {
		return false;
	}
}
