package org.budgamers.reactorsplus.container;

import java.util.Iterator;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import org.budgamers.reactorsplus.recipe.MachineRecipes;
import org.budgamers.reactorsplus.tileentity.TileEntityEnricher;
import org.budgamers.reactorsplus.tileentity.TileEntityStabilizer;

public class ContainerStabilizer extends Container {

	private TileEntityStabilizer stabilizer;
	private int lastCookTime;
	private int lastBurnTime;
	private int lastItemBurnTime;
	
	public ContainerStabilizer(InventoryPlayer inventory, TileEntityStabilizer stabilizer) {
		lastCookTime = 0;
		lastBurnTime = 0;
		lastItemBurnTime = 0;
		
		this.stabilizer = stabilizer;
		
		addSlotToContainer(new Slot(stabilizer, 0, 90, 56));
		addSlotToContainer(new Slot(stabilizer, 1, 54, 56));
		addSlotToContainer(new SlotMachine(inventory.player, stabilizer, 2, 51, 17));
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		
		for(int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		return this.stabilizer.isUseableByPlayer(var1);
	}
	
	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		
		Iterator<?> iter = this.crafters.iterator();
		
		while(iter.hasNext()) {
			ICrafting crafting = (ICrafting) iter.next();
			
			if(this.lastCookTime != this.stabilizer.cookTime) {
				crafting.sendProgressBarUpdate(this, 0, this.stabilizer.cookTime);
			}
			
			if(this.lastBurnTime != this.stabilizer.burnTime) {
				crafting.sendProgressBarUpdate(this, 1, this.stabilizer.burnTime);
			}
			
			if(this.lastItemBurnTime != this.stabilizer.itemBurnTime) {
				crafting.sendProgressBarUpdate(this, 2, this.stabilizer.itemBurnTime);
			}
		}
		
		this.lastBurnTime = this.stabilizer.burnTime;
		this.lastCookTime = this.stabilizer.cookTime;
		this.lastItemBurnTime = this.stabilizer.itemBurnTime;
	}
	
	@Override
	public void updateProgressBar(int x, int y) {
		if(x == 0) {
			this.stabilizer.cookTime = y;
		}
		
		if(x == 1) {
			this.stabilizer.burnTime = y;
		}
		
		if(x == 2) {
			this.stabilizer.itemBurnTime = y;
		}
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotNumber) {
		ItemStack stack = null;
		
		Slot slot = (Slot) inventorySlots.get(slotNumber);
		
		if(slot != null && slot.getHasStack()) {
			ItemStack stack1 = slot.getStack();
			
			stack = stack1.copy();
			
			if(slotNumber == 2) {
                if (!mergeItemStack(stack1, 3, 39, true)) {
                        return null;
                }

                slot.onSlotChange(stack1, stack);
			} else if(slotNumber == 1 || slotNumber == 0) {
				if(!mergeItemStack(stack1, 3, 39, false)) {
					return null;
				}
			} else if(MachineRecipes.enrichment().getEnrichmentResult(stack1.getItem()) != null) {
				if(!mergeItemStack(stack1, 0, 1, false)) {
					return null;
				}
			} else if(TileEntityEnricher.isItemFuel(stack1)) {
				if(!mergeItemStack(stack1, 1, 2, false)) {
					return null;
				}
			} else if(slotNumber >= 3 && slotNumber < 30) {
				if(!mergeItemStack(stack1, 30, 39, false)) {
					return null;
				}
			} else if(slotNumber >= 30 && slotNumber < 39 && !mergeItemStack(stack1, 3, 30, false)) {
				return null;
			}
			
			if(stack1.stackSize == 0) {
				slot.putStack(null);
			} else {
				slot.onSlotChanged();
			}
			
			if(stack1.stackSize == stack.stackSize) {
				return null;
			}
			
			slot.onPickupFromSlot(player, stack);
		}
		
		return stack;
	}
}
