package org.budgamers.reactorsplus;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import org.budgamers.reactorsplus.gui.GuiAtomicCompressor;
import org.budgamers.reactorsplus.gui.GuiEnricher;
import org.budgamers.reactorsplus.gui.GuiIsotopeReactor;
import org.budgamers.reactorsplus.gui.GuiPlatingMachine;
import org.budgamers.reactorsplus.gui.GuiStabilizer;
import org.budgamers.reactorsplus.tileentity.TileEntityAtomicCompressor;
import org.budgamers.reactorsplus.tileentity.TileEntityEnricher;
import org.budgamers.reactorsplus.tileentity.TileEntityIsotopeReactor;
import org.budgamers.reactorsplus.tileentity.TileEntityPlatingMachine;
import org.budgamers.reactorsplus.tileentity.TileEntityStabilizer;

public class ClientProxy extends CommonProxy {

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		
		if(tileEntity != null) {
			switch(ID) {
			case 0:
				return new GuiEnricher(player.inventory, (TileEntityEnricher) tileEntity);
			case 1:
				return new GuiStabilizer(player.inventory, (TileEntityStabilizer) tileEntity);
			case 2:
				return new GuiAtomicCompressor(player.inventory, (TileEntityAtomicCompressor) tileEntity);
			case 3:
				return new GuiIsotopeReactor(player.inventory, (TileEntityIsotopeReactor) tileEntity);
			case 4:
				return new GuiPlatingMachine(player.inventory, (TileEntityPlatingMachine) tileEntity);
			default:
				return null;
			}
		}
		
		return null;
	}
}
