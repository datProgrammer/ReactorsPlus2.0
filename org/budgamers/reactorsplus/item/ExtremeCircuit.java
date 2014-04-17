package org.budgamers.reactorsplus.item;

import org.budgamers.reactorsplus.ReactorsPlus;

import net.minecraft.item.Item;

public class ExtremeCircuit extends Item {

	public ExtremeCircuit() {
		super();
		
		this.setUnlocalizedName("extremeCircuit");
		this.setTextureName(ReactorsPlus.MODID + ":extreme_circuit");
		this.setCreativeTab(ReactorsPlus.reactorsPlus);
	}
}
