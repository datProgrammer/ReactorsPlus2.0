package org.budgamers.reactorsplus.tileentity;

import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileUnloadEvent;
import ic2.api.energy.tile.IEnergySource;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityCreativeEnergyCell extends TileEntity implements IEnergySource {

	public double energy = 0.0D;
	
	public static final double maxPerTick = 1024.0D;
	
	private boolean initialized;
	
	@Override
	public boolean emitsEnergyTo(TileEntity receiver, ForgeDirection direction) {
		return true;
	}

	@Override
	public double getOfferedEnergy() {
		energy = Double.POSITIVE_INFINITY;
		return Math.min(energy, maxPerTick);
	}

	@Override
	public void drawEnergy(double amount) {
		energy = Double.POSITIVE_INFINITY;
	}
	
	@Override
	public void updateEntity() {
		if(!initialized && worldObj != null) {
			if(!worldObj.isRemote) {
				EnergyTileLoadEvent loadEvent = new EnergyTileLoadEvent(this);
				
				MinecraftForge.EVENT_BUS.post(loadEvent);
			}
			
			initialized = true;
		}
		
		energy = Double.POSITIVE_INFINITY;
	}
	
	@Override
	public void invalidate() {
		EnergyTileUnloadEvent unloadEvent = new EnergyTileUnloadEvent(this);
		MinecraftForge.EVENT_BUS.post(unloadEvent);
	}
}
