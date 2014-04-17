package org.budgamers.reactorsplus.machine;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import org.budgamers.reactorsplus.ReactorsPlus;
import org.budgamers.reactorsplus.tileentity.TileEntityPlatingMachine;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PlatingMachine extends BlockContainer {

	public static IIcon topIcon;
	public static IIcon sideIcon;
	public static IIcon frontIcon;
	
	public TileEntityPlatingMachine tileEntity;
	
	public int front = 3;
	
	public PlatingMachine(Material p_i45386_1_) {
		super(p_i45386_1_);
		
		this.setBlockName("platingMachine");
		this.setBlockTextureName(ReactorsPlus.MODID + ":enricher_side");
		this.setCreativeTab(ReactorsPlus.reactorsPlus);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon) {
		topIcon = icon.registerIcon(ReactorsPlus.MODID + ":enricher_top");
		sideIcon = icon.registerIcon(ReactorsPlus.MODID + ":enricher_side");
		frontIcon = icon.registerIcon(ReactorsPlus.MODID + ":plating_front");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		if(tileEntity != null) {
			if(side == this.tileEntity.frontDirection)
				return frontIcon;
			if(side == 1)
				return topIcon;
			else
				return sideIcon;
		} else {
			if(side == front)
				return frontIcon;
			if(side == 1)
				return topIcon;
			else
				return sideIcon;
		}
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return null;
	}
	
	@Override
	public TileEntity createTileEntity(World world, int meta) {
		return new TileEntityPlatingMachine();
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		
		this.tileEntity = (TileEntityPlatingMachine) world.getTileEntity(x, y, z);
		
		world.markBlockForUpdate(x, y, z);
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
		int dir = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		
		this.tileEntity = (TileEntityPlatingMachine) world.getTileEntity(x, y, z);
		
		switch(dir) {
		case 0:
			this.tileEntity.frontDirection = 2; break;
		case 1:
			this.tileEntity.frontDirection = 5; break;
		case 2:
			this.tileEntity.frontDirection = 3; break;
		case 3:
			this.tileEntity.frontDirection = 4; break;
		}
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float a, float b, float c) {
		player.openGui(ReactorsPlus.instance, 4, world, x, y, z);
		
		return true;
	}
}
