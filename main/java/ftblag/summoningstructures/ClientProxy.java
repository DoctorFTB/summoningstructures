package ftblag.summoningstructures;

import ftblag.summoningstructures.blocks.SSBlocks;
import ftblag.summoningstructures.render.BlockRenderRegister;
import ftblag.summoningstructures.render.ItemRenderRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }
    
	@Override
	public void register(FMLPreInitializationEvent preEvent){
		super.register(preEvent);
	}
    
	@Override
	public void registerRender(FMLInitializationEvent event) {
		ItemRenderRegister.registerItemRenderer();
		BlockRenderRegister.registerBlockRenderer();
	}
	
	@Override
	public void registerRenderers(summoningstructures ins) {
		ins.ssmod_0.registerRenderers();
		ins.ssmod_1.registerRenderers();
		ins.ssmod_2.registerRenderers();

	}
	
    public static final CreativeTabs tab = new CreativeTabs("SummoningStructures") {
    	@Override public Item getTabIconItem() {
            return Item.getItemFromBlock(SSBlocks.spawnerBlock);
        }
    };
}
