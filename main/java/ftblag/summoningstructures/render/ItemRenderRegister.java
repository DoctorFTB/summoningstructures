package ftblag.summoningstructures.render;

import ftblag.summoningstructures.summoningstructures;
import ftblag.summoningstructures.items.SSItems;
import ftblag.summoningstructures.items.manual;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ItemRenderRegister {
	public static String modid = summoningstructures.MODID;

	public static void preInit() {
		
	}
	
	public static void registerItemRenderer() {
	    reg(SSItems.spawnerDustItem);
	    reg(SSItems.spawnerIngotItem);
	    reg(manual.manualI);
	}

	public static void reg(Item item) {
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    .register(item, 0, new ModelResourceLocation(modid + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
