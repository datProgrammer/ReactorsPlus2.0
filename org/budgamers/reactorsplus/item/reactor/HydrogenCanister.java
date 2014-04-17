package org.budgamers.reactorsplus.item.reactor;

import ic2.api.reactor.IReactor;
import ic2.api.reactor.IReactorComponent;

import org.budgamers.reactorsplus.ReactorsPlus;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class HydrogenCanister extends Item implements IReactorComponent {

	public ItemStack thisItem;
	public int damage;
	
	public HydrogenCanister() {
		super();
		
		this.thisItem = new ItemStack(this);
		this.setUnlocalizedName("hydrogenCanister");
		this.setTextureName(ReactorsPlus.MODID + ":hydrogen_canister");
		this.setCreativeTab(ReactorsPlus.reactorsPlus);
		this.setMaxDamage(500);
	}

	@Override
	public void processChamber(IReactor reactor, ItemStack yourStack, int x, int y, boolean heatrun) {
		reactor.addHeat(-100);
		damage++;
		this.setDamage(thisItem, damage);
	}

	@Override
	public boolean acceptUraniumPulse(IReactor reactor, ItemStack yourStack, ItemStack pulsingStack, int youX, int youY, int pulseX, int pulseY, boolean heatrun) {
		return false;
	}

	@Override
	public boolean canStoreHeat(IReactor reactor, ItemStack yourStack, int x, int y) {
		return false;
	}

	@Override
	public int getMaxHeat(IReactor reactor, ItemStack yourStack, int x, int y) {
		return 0;
	}

	@Override
	public int getCurrentHeat(IReactor reactor, ItemStack yourStack, int x, int y) {
		return 0;
	}

	@Override
	public int alterHeat(IReactor reactor, ItemStack yourStack, int x, int y, int heat) {
		return 0;
	}

	@Override
	public float influenceExplosion(IReactor reactor, ItemStack yourStack) {
		return 0;
	}
}
