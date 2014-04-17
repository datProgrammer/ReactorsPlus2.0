package org.budgamers.reactorsplus.machine;

import org.budgamers.reactorsplus.ReactorsPlus;
import org.budgamers.reactorsplus.tileentity.TileEntityCreativeEnergyCell;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCreativeEnergyCell extends BlockContainer {

	public BlockCreativeEnergyCell(Material p_i45386_1_) {
		super(p_i45386_1_);
		
		this.setBlockName("creativeEnergy");
		this.setBlockTextureName(ReactorsPlus.MODID + ":creative_energy");
		this.setCreativeTab(ReactorsPlus.reactorsPlus);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return null;
	}
	
	@Override
	public TileEntity createTileEntity(World world, int meta) {
		return new TileEntityCreativeEnergyCell();
	}
}
