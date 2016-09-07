package ftblag.summoningstructures;

import ftblag.summoningstructures.blocks.SSBlocks;
import ftblag.summoningstructures.crafting.SSCrafting;
import ftblag.summoningstructures.items.SSItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        register(e);
    }
    public void init(FMLInitializationEvent e) {
        SSCrafting.initCrafting();
        registerRender(e);
    }
    public void postInit(FMLPostInitializationEvent e) {
    	
    }
    
    public void register(FMLPreInitializationEvent preEvent) {
        SSBlocks.createBlocks();
        SSItems.createItems();
    }
    
	public void registerRender(FMLInitializationEvent event) {
        //do nothing
	}
	
	public void registerRenderers(summoningstructures ins) {
	}
}
