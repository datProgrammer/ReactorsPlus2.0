package org.budgamers.reactorsplus.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import org.budgamers.reactorsplus.recipe.MachineRecipes;

public class TileEntityAtomicCompressor extends TileEntity implements IInventory {
	
	private boolean isActive;
	
	public ItemStack[] items;
	public int itemBurnTime;
	public int burnTime;
	public int cookTime;
	
	public int frontDirection = 3;
	
	public TileEntityAtomicCompressor() {
		items = new ItemStack[3];
		
		itemBurnTime = 0;
		burnTime = 0;
		cookTime = 0;
	}
	
	@Override
	public int getSizeInventory() {
		return items.length;
	}
	
	@Override
	public ItemStack getStackInSlot(int slot) {
		return items[slot];
	}
	
	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		if(items[slot] != null) {
			if(items[slot].stackSize <= amount) {
				ItemStack stack = items[slot];
				items[slot] = null;
				return stack;
			}
			
			ItemStack stack = items[slot].splitStack(amount);
			
			if(items[slot].stackSize == 0) {
				items[slot] = null;
			}
			
			return stack;
		} else {
			return null;
		}
	}

	@Override
	public void closeInventory() {}

	@Override
	public String getInventoryName() {
		return "container.atomicCompressor";
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		if(items[slot] != null) {
			ItemStack stack = items[slot];
			
			items[slot] = null;
			
			return stack;
		} else {
			return null;
		}
	}

	@Override
	public boolean hasCustomInventoryName() {
		return true;
	}

	@Override
	public boolean isItemValidForSlot(int var1, ItemStack var2) {
		return false;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer var1) {
		if(worldObj.getTileEntity(xCoord, yCoord, zCoord) != this) {
			return false;
		}
		
		return var1.getDistanceSq((double) xCoord + 0.5D, (double) yCoord + 0.5D, (double) zCoord + 0.5D) <= 64D;
	}

	@Override
	public void openInventory() {}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		items[slot] = stack;
		
		if(stack != null && stack.stackSize > getInventoryStackLimit()) {
			stack.stackSize = getInventoryStackLimit();
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		
		NBTTagList tagList = tag.getTagList("Items", 0);
		
		items = new ItemStack[getSizeInventory()];
		
		for(int i = 0; i < tagList.tagCount(); i++) {
			NBTTagCompound compound = (NBTTagCompound) tagList.getCompoundTagAt(i);
			
			byte b = compound.getByte("Slot");
			
			if(b >= 0 && b < items.length) {
				items[b] = ItemStack.loadItemStackFromNBT(compound);
			}
		}
		
		burnTime = tag.getShort("BurnTime");
		cookTime = tag.getShort("CookTime");
		itemBurnTime = getItemBurnTime(items[1]);
		frontDirection = tag.getShort("Front");
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		
		tag.setShort("BurnTime", (short) burnTime);
		tag.setShort("CookTime", (short) cookTime);
		tag.setShort("Front", (short) frontDirection);
		
		NBTTagList tagList = new NBTTagList();
		
		for(int i = 0; i < items.length; i++) {
			if(items[i] != null) {
				NBTTagCompound compound = new NBTTagCompound();
				
				compound.setByte("Slot", (byte) i);
				
				items[i].writeToNBT(compound);
				
				tagList.appendTag(compound);
			}
		}
		
		tag.setTag("Items", tagList);
	}
	
	public int getCookProgressScaled(int progress) {
		return (cookTime * progress) / 200;
	}
	
	public int getBurnTimeRemainingScaled(int progress) {
		if(burnTime == 0) {
			itemBurnTime = 200;
		}
		
		return (burnTime * progress) / itemBurnTime;
	}
	
	public boolean isBurning() {
		return burnTime > 0;
	}
	
	@Override
	public void updateEntity() {
		boolean unfinishedFuel = this.burnTime > 0;
		boolean flag = false;
		
		if(unfinishedFuel) {
			--this.burnTime;
		}
		
		if(!this.worldObj.isRemote) {
			if(this.burnTime == 0 && this.canEnrich()) {
				this.itemBurnTime = this.burnTime = getItemBurnTime(this.items[1]);
				
				if(this.burnTime > 0) {
					flag = true;
					
					if(this.items[1] != null) {
						--this.items[1].stackSize;
						
						if(this.items[1].stackSize == 0) {
							Item item = this.items[1].getItem().getContainerItem();
							
							this.items[1] = item == null ? null : new ItemStack(item);
						}
					}
				}
			}
			
			if(this.isEnriching() && this.canEnrich()) {
				++this.cookTime;
				
				if(this.cookTime == 200) {
					this.cookTime = 0;
					this.enrichItem();
					
					flag = true;
				}
			} else {
				this.cookTime = 0;
			}
			
			if(unfinishedFuel != this.burnTime > 0) {
				flag = true;
				this.validate();
			}
		}
		
		boolean check = isActive;
		
		isActive = isEnriching();
		
		if(isActive != check) {
			this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
		}
		
		if(flag) {
			this.markDirty();
		}
	}
	
	public boolean canEnrich() {
		if(items[0] == null) {
			return false;
		}
		
		ItemStack stack = MachineRecipes.compressor().getCompressResult(items[0].getItem());
		
		if(stack == null) {
			return false;
		}
		
		if(items[2] == null) {
			return true;
		}
		
		if(!items[2].isItemEqual(stack)) {
			return false;
		}
		
		if(items[2].stackSize < getInventoryStackLimit() && items[2].stackSize < items[2].getMaxStackSize()) {
			return true;
		}
		
		return items[2].stackSize < stack.getMaxStackSize();
	}
	
	public boolean isEnriching() {
		return this.burnTime > 0;
	}
	
	public void enrichItem() {
		if(this.canEnrich()) {
			ItemStack stack = MachineRecipes.compressor().getCompressResult(this.items[0].getItem());
			
			if(this.items[2] == null) {
				this.items[2] = stack.copy();
			} else if(this.items[2] == stack) {
				++this.items[2].stackSize;
			}
			
			--this.items[0].stackSize;
			
			if(this.items[0].stackSize == 0) {
				Item item = this.items[0].getItem().getContainerItem();
				this.items[0] = item == null ? null : new ItemStack(item);
			}
		}
	}
	
	public static boolean isItemFuel(ItemStack stack) {
		return getItemBurnTime(stack) > 0;
	}
	
	public static int getItemBurnTime(ItemStack stack) {
		if(stack == null) {
			return 0;
		}
		
		Item item = stack.getItem();
		
		if(item == Item.getItemFromBlock(Blocks.obsidian)) {
			return 3840;
		} else {
			return 0;
		}
	}
}