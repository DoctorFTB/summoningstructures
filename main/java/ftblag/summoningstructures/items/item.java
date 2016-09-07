package ftblag.summoningstructures.items;

import ftblag.summoningstructures.ClientProxy;
import net.minecraft.item.Item;

public class item extends Item {
	public item(String unlocalizedName) {
	    super();

	    this.setUnlocalizedName(unlocalizedName);
	    this.setCreativeTab(ClientProxy.tab);
	}
}
