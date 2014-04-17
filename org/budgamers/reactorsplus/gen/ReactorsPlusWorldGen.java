package org.budgamers.reactorsplus.gen;

import cpw.mods.fml.common.registry.GameRegistry;

public class ReactorsPlusWorldGen {

	public ReactorsPlusWorldGen() {
		GameRegistry.registerWorldGenerator(new UnobtaniumOreGen(), 10);
		GameRegistry.registerWorldGenerator(new PlatinumOreGen(), 10);
	}
}
