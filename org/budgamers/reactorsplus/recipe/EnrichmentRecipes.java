package org.budgamers.reactorsplus.recipe;

import java.util.HashMap;
import java.util.Map;

import org.budgamers.reactorsplus.item.ReactorsPlusItems;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EnrichmentRecipes {

	private Map<Object, ItemStack> list = new HashMap<Object, ItemStack>();
	
	protected EnrichmentRecipes() {
		addEnrichment(ReactorsPlusItems.unobtanium, new ItemStack(ReactorsPlusItems.enrichedUnstableUnobtanium, 1));
	}
	
	protected void addEnrichment(Item item, ItemStack stack) {
		list.put(item, stack);
	}
	
	protected void addEnrichment(Block block, ItemStack stack) {
		list.put(block, stack);
	}
	
	public ItemStack getEnrichmentResult(Item item) {
		return list.get(item);
	}
	
	public ItemStack getEnrichmentResult(Block block) {
		return list.get(block);
	}
	
	public Map<Object, ItemStack> getEnrichmentList() {
		return list;
	}
}