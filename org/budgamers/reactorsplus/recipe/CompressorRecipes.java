package org.budgamers.reactorsplus.recipe;

import java.util.HashMap;
import java.util.Map;

import org.budgamers.reactorsplus.item.ReactorsPlusItems;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CompressorRecipes {

	private Map<Object, ItemStack> list = new HashMap<Object, ItemStack>();
	
	protected CompressorRecipes() {
		addCompress(ReactorsPlusItems.enrichedUnobtanium, new ItemStack(ReactorsPlusItems.unobtaniumIngot));
	}
	
	protected void addCompress(Item item, ItemStack stack) {
		list.put(item, stack);
	}
	
	protected void addCompress(Block block, ItemStack stack) {
		list.put(block, stack);
	}
	
	public ItemStack getCompressResult(Item item) {
		return list.get(item);
	}
	
	public ItemStack getCompressResult(Block block) {
		return list.get(block);
	}
	
	public Map<Object, ItemStack> getCompressList() {
		return list;
	}
}