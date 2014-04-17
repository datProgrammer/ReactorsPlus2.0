package org.budgamers.reactorsplus.recipe;

import java.util.HashMap;
import java.util.Map;

import org.budgamers.reactorsplus.item.ReactorsPlusItems;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class StabilizerRecipes {

	private Map<Object, ItemStack> list = new HashMap<Object, ItemStack>();
	
	protected StabilizerRecipes() {
		addStabilize(ReactorsPlusItems.enrichedUnstableUnobtanium, new ItemStack(ReactorsPlusItems.enrichedUnobtanium));
	}
	
	protected void addStabilize(Item item, ItemStack stack) {
		list.put(item, stack);
	}
	
	protected void addStabilize(Block block, ItemStack stack) {
		list.put(block, stack);
	}
	
	public ItemStack getStabilizeResult(Item item) {
		return list.get(item);
	}
	
	public ItemStack getStabilizeResult(Block block) {
		return list.get(block);
	}
	
	public Map<Object, ItemStack> getStabilizeList() {
		return list;
	}
}