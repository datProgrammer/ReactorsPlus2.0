package org.budgamers.reactorsplus;

import org.budgamers.reactorsplus.block.ReactorsPlusBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabsReactorsPlus extends CreativeTabs {

	public CreativeTabsReactorsPlus(String lable) {
		super(lable);
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(ReactorsPlusBlocks.unobtaniumOre);
	}

}
