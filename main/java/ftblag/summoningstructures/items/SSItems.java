package ftblag.summoningstructures.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class SSItems {
	
	public static Item spawnerDustItem;
	public static Item spawnerIngotItem;
	
    public static void createItems() {
    	GameRegistry.registerItem(spawnerDustItem = new item("spawnerDust"), "spawnerDust");
    	GameRegistry.registerItem(spawnerIngotItem = new item("spawnerIngot"), "spawnerIngot");
    }
}
