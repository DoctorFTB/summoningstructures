package ftblag.summoningstructures.items;

import java.util.Random;

import ftblag.summoningstructures.ClientProxy;
import ftblag.summoningstructures.gui.guiManual;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@SuppressWarnings("unchecked")
public class manual {

	public manual() {
	}

	public static Item manualI;
	public static Object instance;

	public void load(FMLInitializationEvent event) {
		if (event.getSide() == Side.CLIENT)
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
					.register(manualI, 0, new ModelResourceLocation("SummoningStructures:manual", "inventory"));
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

	public void registerRenderers() {
	}

	static {
		manualI = (new Itemmanual());

	}

	static class Itemmanual extends Item {

		public Itemmanual() {
			maxStackSize = 1;
			setUnlocalizedName("manual");
			GameRegistry.registerItem(this, "manual");
			setCreativeTab(ClientProxy.tab);
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getMaxItemUseDuration(ItemStack par1ItemStack) {
			return 0;
		}

		@Override
		public float getStrVsBlock(ItemStack par1ItemStack, IBlockState par2Block) {
			return 1.0F;
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(ItemStack itemstack, World world, EntityPlayer entity, EnumHand hand) {
			float var4 = 1.0F;
			int i = (int) (entity.prevPosX + (entity.posX - entity.prevPosX) * (double) var4);
			int j = (int) (entity.prevPosY + (entity.posY - entity.prevPosY) * (double) var4 + 1.62D);
			int k = (int) (entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double) var4);

			if (true) {
				if (entity instanceof EntityPlayer)
					((EntityPlayer) entity).openGui(instance, guiManual.GUIID, world, i, j, k);
			}

			return new ActionResult(EnumActionResult.PASS, itemstack);
		}

	}
}