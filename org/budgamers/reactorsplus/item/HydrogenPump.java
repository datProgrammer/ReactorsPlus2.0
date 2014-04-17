package org.budgamers.reactorsplus.item;

import net.minecraft.item.ItemStack;

import org.budgamers.reactorsplus.ReactorsPlus;

public class HydrogenPump extends AirPump {

	public HydrogenPump() {
		super();
		
		this.setUnlocalizedName("airPump.hydrogen");
		this.setTextureName(ReactorsPlus.MODID + ":air_pump");
		this.setCreativeTab(ReactorsPlus.reactorsPlus);
	}
	
	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack stack) {
		return false;
	}
}
