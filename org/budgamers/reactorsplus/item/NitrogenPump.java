package org.budgamers.reactorsplus.item;

import net.minecraft.item.ItemStack;

import org.budgamers.reactorsplus.ReactorsPlus;

public class NitrogenPump extends AirPump {

	public NitrogenPump() {
		super();
		
		this.setUnlocalizedName("airPump.nitrogen");
		this.setTextureName(ReactorsPlus.MODID + ":air_pump");
		this.setCreativeTab(ReactorsPlus.reactorsPlus);
	}
	
	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack stack) {
		return false;
	}
}
