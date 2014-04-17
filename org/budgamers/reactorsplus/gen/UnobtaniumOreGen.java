package org.budgamers.reactorsplus.gen;

import java.util.Random;

import org.budgamers.reactorsplus.ReactorsPlus;
import org.budgamers.reactorsplus.block.ReactorsPlusBlocks;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class UnobtaniumOreGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId) {
		case 0: generateSurface(random, chunkX, chunkZ, world); break;
		}
	}
	
	private void generateSurface(Random random, int chunkX, int chunkZ, World world) {
		for(int i = 0; i < ReactorsPlus.instance.unobtaniumChance; i++) {
			int xPos = (chunkX * 16) + random.nextInt(16);
			int yPos = random.nextInt(ReactorsPlus.instance.unobtaniumLayer);
			int zPos = (chunkZ * 16) + random.nextInt(16);
			
			world.setBlock(xPos, yPos, zPos, ReactorsPlusBlocks.unobtaniumOre);
		}
	}
}