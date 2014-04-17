package org.budgamers.reactorsplus.recipe;

import java.util.HashMap;
import java.util.Map;

import org.budgamers.reactorsplus.item.ReactorsPlusItems;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PlatingRecipes {

	private Map<Object, ItemStack> list = new HashMap<Object, ItemStack>();
	
	protected PlatingRecipes() {
		addPlating(ReactorsPlusItems.unobtaniumIngot, new ItemStack(ReactorsPlusItems.unobtaniumPlate, 1));
	}
	
	protected void addPlating(Item item, ItemStack stack) {
		list.put(item, stack);
	}
	
	protected void addPlating(Block block, ItemStack stack) {
		list.put(block, stack);
	}
	
	public ItemStack getPlatingResult(Item item) {
		return list.get(item);
	}
	
	public ItemStack getPlatingResult(Block block) {
		return list.get(block);
	}
	
	public Map<Object, ItemStack> getPlatingList() {
		return list;
	}
}