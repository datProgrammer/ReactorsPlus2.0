package org.budgamers.reactorsplus.item;

import org.budgamers.reactorsplus.ReactorsPlus;

import net.minecraft.item.Item;

public class EmptyCanister extends Item {

	public EmptyCanister() {
		super();
		
		this.setUnlocalizedName("emptyCanister");
		this.setTextureName(ReactorsPlus.MODID + ":empty_canister");
		this.setCreativeTab(ReactorsPlus.reactorsPlus);
	}
}
