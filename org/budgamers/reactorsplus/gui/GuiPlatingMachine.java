package org.budgamers.reactorsplus.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.budgamers.reactorsplus.container.ContainerPlatingMachine;
import org.budgamers.reactorsplus.tileentity.TileEntityPlatingMachine;
import org.lwjgl.opengl.GL11;

public class GuiPlatingMachine extends GuiContainer {

	private TileEntityPlatingMachine plating;
	
	public GuiPlatingMachine(InventoryPlayer inventory, TileEntityPlatingMachine tileEntity) {
		super(new ContainerPlatingMachine(inventory, tileEntity));
		this.plating = tileEntity;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		this.fontRendererObj.drawString(I18n.format(this.plating.getInventoryName(), new Object[0]), this.xSize / 2, 6, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1, 1, 1, 1);
		
		this.mc.renderEngine.bindTexture(new ResourceLocation("reactorsplus", "textures/gui/plating.png"));
		
		int i = (width - xSize) / 2;
		int j = (height - ySize) / 2;
		
		drawTexturedModalRect(i, j, 0, 0, xSize, ySize);
		
		if(plating.isBurning()) {
			int burn = plating.getBurnTimeRemainingScaled(14);
			
			drawTexturedModalRect(i + 73, j + 59, 176, 16, burn, 10);
		}
		
		int update = plating.getCookProgressScaled(16);
		
		drawTexturedModalRect(i + 89, j + 55, 191, 15, -update, -update);
	}

}
