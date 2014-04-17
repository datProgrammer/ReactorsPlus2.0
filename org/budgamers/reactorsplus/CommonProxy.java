package org.budgamers.reactorsplus;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import org.budgamers.reactorsplus.container.ContainerAtomicCompressor;
import org.budgamers.reactorsplus.container.ContainerEnricher;
import org.budgamers.reactorsplus.container.ContainerIsotopeReactor;
import org.budgamers.reactorsplus.container.ContainerPlatingMachine;
import org.budgamers.reactorsplus.container.ContainerStabilizer;
import org.budgamers.reactorsplus.tileentity.TileEntityAtomicCompressor;
import org.budgamers.reactorsplus.tileentity.TileEntityEnricher;
import org.budgamers.reactorsplus.tileentity.TileEntityIsotopeReactor;
import org.budgamers.reactorsplus.tileentity.TileEntityPlatingMachine;
import org.budgamers.reactorsplus.tileentity.TileEntityStabilizer;

import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler {

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		
		if(tileEntity != null) {
			switch(ID) {
			case 0:
				return new ContainerEnricher(player.inventory, (TileEntityEnricher) tileEntity);
			case 1:
				return new ContainerStabilizer(player.inventory, (TileEntityStabilizer) tileEntity);
			case 2:
				return new ContainerAtomicCompressor(player.inventory, (TileEntityAtomicCompressor) tileEntity);
			case 3:
				return new ContainerIsotopeReactor(player.inventory, (TileEntityIsotopeReactor) tileEntity);
			case 4:
				return new ContainerPlatingMachine(player.inventory, (TileEntityPlatingMachine) tileEntity);
			default:
				return null;
			}
		}
		
		return null;
	}

}
