package ftblag.summoningstructures.render;

import ftblag.summoningstructures.summoningstructures;
import ftblag.summoningstructures.blocks.SSBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public final class BlockRenderRegister {
	
	public static String modid = summoningstructures.MODID;

	public static void registerBlockRenderer() {
	    reg(SSBlocks.spawnerBlock);
	    reg(SSBlocks.blazeSpawnerBlock);
	    reg(SSBlocks.creeperSpawnerBlock);
	    reg(SSBlocks.endermanSpawnerBlock);
	    reg(SSBlocks.zombieSpawnerBlock);
	    reg(SSBlocks.skeletonSpawnerBlock);
	    reg(SSBlocks.pigzombieSpawnerBlock);
	    reg1(SSBlocks.Bars);
	    reg(SSBlocks.baseBlock);
	}

	public static void reg(Block block) {
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    .register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(modid + ":" + block.getUnlocalizedName().substring(5), "inventory"));
	}

	public static void reg1(Block block) {
	    Item item = new Item().getItemFromBlock(block);
			RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
			renderItem.getItemModelMesher().register(item, 0,
					new ModelResourceLocation(block.getRegistryName().toString(), "inventory"));
	}
}
