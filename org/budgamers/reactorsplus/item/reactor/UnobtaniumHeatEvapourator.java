package org.budgamers.reactorsplus.item.reactor;

import org.budgamers.reactorsplus.ReactorsPlus;

import ic2.api.item.IC2Items;
import ic2.api.reactor.IReactor;
import ic2.api.reactor.IReactorComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class UnobtaniumHeatEvapourator extends Item implements IReactorComponent {

	public UnobtaniumHeatEvapourator() {
		super();
		
		this.setUnlocalizedName("unobtaniumHeatEvapourator");
		this.setTextureName(ReactorsPlus.MODID + ":unobtanium_evaporator");
		this.setCreativeTab(ReactorsPlus.reactorsPlus);
	}
	
	@Override
	public void processChamber(IReactor reactor, ItemStack yourStack, int x, int y, boolean heatrun) {
		if(reactor.getItemAt(x + 1, y) == IC2Items.getItem("reactorUraniumQuad")) {
			reactor.addHeat(-1000);
		} else if(reactor.getItemAt(x - 1, y) == IC2Items.getItem("reactorUraniumQuad")) {
			reactor.addHeat(-1000);
		} else if(reactor.getItemAt(x, y + 1) == IC2Items.getItem("reactorUraniumQuad")) {
			reactor.addHeat(-1000);
		} else if(reactor.getItemAt(x, y - 1) == IC2Items.getItem("reactorUraniumQuad")) {
			reactor.addHeat(-1000);
		}
		
		reactor.addHeat(-1000);
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
