package ftblag.summoningstructures.gui;

import java.util.Random;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@SuppressWarnings("unchecked")
public class guiManualTwo {
	
    private GuiButton buttonDone;
	
	public static Object instance;

	public static int GUIID = 2;

	public guiManualTwo() {
	}

	public void load(FMLInitializationEvent event) {
	}

	public void registerRenderers() {
	}

	public void generateNether(World world, Random random, int chunkX, int chunkZ) {
	}

	public void generateSurface(World world, Random random, int chunkX, int chunkZ) {
	}

	public int addFuel(ItemStack fuel) {
		return 0;
	}

	public void serverLoad(FMLServerStartingEvent event) {
	}

	public void preInit(FMLPreInitializationEvent event) {
	}

	public static IInventory inherited;

	public static class GuiContainerMod extends Container {

		World world = null;
		EntityPlayer entity = null;
		int i, j, k;

		public GuiContainerMod(World world, int i, int j, int k, EntityPlayer player) {

			this.world = world;
			this.entity = player;
			this.i = i;
			this.j = j;
			this.k = k;

		}

		@Override
		public boolean canInteractWith(EntityPlayer player) {
			return true;
		}

		protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
			int i;
			int j;

			for (i = 0; i < 3; ++i) {
				for (j = 0; j < 9; ++j) {
					this.addSlotToContainer(new Slot(inventoryPlayer, j + (i + 1) * 9, 8 + j * 18, 84 + i * 18));
				}
			}

			for (i = 0; i < 9; ++i) {
				this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
			}
		}

		@Override
		public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
			ItemStack itemstack = null;
			Slot slot = (Slot) this.inventorySlots.get(index);

			if (slot != null && slot.getHasStack()) {
				ItemStack itemstack1 = slot.getStack();
				itemstack = itemstack1.copy();

				if (index < 9) {
					if (!this.mergeItemStack(itemstack1, 9, (45 - 9), true)) {// fixes
																				// shiftclick
																				// error
						return null;
					}
				} else if (!this.mergeItemStack(itemstack1, 0, 9, false)) {
					return null;
				}

				if (itemstack1.stackSize == 0) {
					slot.putStack((ItemStack) null);
				} else {
					slot.onSlotChanged();
				}

				if (itemstack1.stackSize == itemstack.stackSize) {
					return null;
				}

				slot.onPickupFromSlot(playerIn, itemstack1);
			}

			return itemstack;
		}

		public void onContainerClosed(EntityPlayer playerIn) {
			super.onContainerClosed(playerIn);

		}
	}

	public static class GuiWindow extends GuiContainer {

		int i = 0;
		int j = 0;
		int k = 0;
		EntityPlayer entity = null;

		public GuiWindow(World world, int i, int j, int k, EntityPlayer entity) {
			super(new GuiContainerMod(world, i, j, k, entity));
			this.i = i;
			this.j = j;
			this.k = k;
			this.entity = entity;
			this.xSize = 176;
			this.ySize = 166;
		}

		private static final ResourceLocation texture = new ResourceLocation("summoningstructures","textures/gui/GuiB.png");

		protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
			int posX = (this.width) / 2;
			int posY = (this.height) / 2;
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

			this.mc.renderEngine.bindTexture(texture);
			int k = (this.width - this.xSize) / 2;
			int l = (this.height - this.ySize) / 2;
			this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

			zLevel = 100.0F;

			this.mc.renderEngine.bindTexture(new ResourceLocation("summoningstructures","textures/gui/1Two.png"));
			this.drawTexturedModalRect((this.guiLeft + 69), (this.guiTop + 58), 0, 0, 256, 256);

		}

		protected void mouseClicked(int par1, int par2, int par3) throws java.io.IOException {
			super.mouseClicked(par1, par2, par3);

		}

		public void updateScreen() {
			super.updateScreen();
			int posX = (this.width) / 2;
			int posY = (this.height) / 2;

		}

		@Override
		protected void keyTyped(char par1, int par2) throws java.io.IOException {

			super.keyTyped(par1, par2);

		}

		protected void drawGuiContainerForegroundLayer(int par1, int par2) {
			int posX = (this.width) / 2;
			int posY = (this.height) / 2;
			//"abcdefghijklmnopqrstuvwxyzabcd"
			this.fontRendererObj.drawString("For create spawning structure", (2), (3), 0x000000);
			this.fontRendererObj.drawString("Need continue structure with", (2), (12), 0x000000);
			this.fontRendererObj.drawString("Add x16 block", (2), (21), 0x000000);
			this.fontRendererObj.drawString("x8 Decalithium Bars and", (2), (30), 0x000000);
			this.fontRendererObj.drawString("x8 Mob Spawners and click to", (2), (39), 0x000000);
			this.fontRendererObj.drawString("Down Spawner Core for spawning.", (2), (48), 0x000000);
		}

		public void onGuiClosed() {
			super.onGuiClosed();
			Keyboard.enableRepeatEvents(false);
		}

		public void initGui() {
			super.initGui();
			this.guiLeft = (this.width - 176) / 2;
			this.guiTop = (this.height - 166) / 2;
			Keyboard.enableRepeatEvents(true);
			this.buttonList.clear();
			int posX = (this.width) / 2;
			int posY = (this.height) / 2;
			this.buttonList.add(new GuiButton(0, this.guiLeft + 0, this.guiTop + 146, 46, 20, "Back"));
			this.buttonList.add(new GuiButton(1, this.guiLeft + 163, this.guiTop + 3, 11, 11, "X"));
		}

		protected void actionPerformed(GuiButton button) {
			MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
			World world = server.worldServers[0];

			if (button.id == 0) {
				if (true) {
					if (entity instanceof EntityPlayer)
						((EntityPlayer) entity).openGui(instance, guiManual.GUIID, world, i, j, k);
				}
			}
			
			if (button.id == 1) {
				if (true) {
					if (entity instanceof EntityPlayer)
				         mc.displayGuiScreen((GuiScreen)null);
				}
			}
		}

		public boolean doesGuiPauseGame() {
			return false;
		}

	}

}