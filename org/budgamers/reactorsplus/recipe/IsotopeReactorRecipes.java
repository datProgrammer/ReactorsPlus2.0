package org.budgamers.reactorsplus.recipe;

import java.util.HashMap;
import java.util.Map;

import org.budgamers.reactorsplus.item.ReactorsPlusItems;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class IsotopeReactorRecipes {

	private Map<Object, ItemStack> list = new HashMap<Object, ItemStack>();
	
	protected IsotopeReactorRecipes() {
		addReaction(Items.gold_ingot, new ItemStack(ReactorsPlusItems.francium));
	}
	
	protected void addReaction(Item item, ItemStack stack) {
		list.put(item, stack);
	}
	
	protected void addReaction(Block block, ItemStack stack) {
		list.put(block, stack);
	}
	
	public ItemStack getReactionResult(Item item) {
		return list.get(item);
	}
	
	public ItemStack getReactionResult(Block block) {
		return list.get(block);
	}
	
	public Map<Object, ItemStack> getReactionResult() {
		return list;
	}
}