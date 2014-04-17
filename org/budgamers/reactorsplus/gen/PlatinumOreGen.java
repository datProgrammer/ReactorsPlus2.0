package org.budgamers.reactorsplus.gen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import org.budgamers.reactorsplus.ReactorsPlus;
import org.budgamers.reactorsplus.block.ReactorsPlusBlocks;

import cpw.mods.fml.common.IWorldGenerator;

public class PlatinumOreGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId) {
		case 0: generateSurface(random, chunkX, chunkZ, world); break;
		}
	}
	
	private void generateSurface(Random random, int chunkX, int chunkZ, World world) {
		for(int i = 0; i < ReactorsPlus.instance.platinumChance; i++) {
			int xPos = (chunkX * 16) + random.nextInt(16);
			int yPos = random.nextInt(ReactorsPlus.instance.platinumLayer);
			int zPos = (chunkZ * 16) + random.nextInt(16);
			
			world.setBlock(xPos, yPos, zPos, ReactorsPlusBlocks.platinumOre);
		}
	}
}
