package org.budgamers.reactorsplus.item;

import net.minecraft.item.ItemStack;

import org.budgamers.reactorsplus.ReactorsPlus;

public class HeliumPump extends AirPump {

	public HeliumPump() {
		super();
		
		this.setUnlocalizedName("airPump.helium");
		this.setTextureName(ReactorsPlus.MODID + ":air_pump");
		this.setCreativeTab(ReactorsPlus.reactorsPlus);
	}
	
	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack stack) {
		return false;
	}
}
