package org.budgamers.reactorsplus.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import org.budgamers.reactorsplus.ReactorsPlus;

public class AirPump extends Item {
	
	public AirPump() {
		super();
		
		this.setUnlocalizedName("airPump");
		this.setTextureName(ReactorsPlus.MODID + ":air_pump");
		this.setCreativeTab(ReactorsPlus.reactorsPlus);
		this.setContainerItem(this);
	}
	
	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack stack) {
		return false;
	}
}
