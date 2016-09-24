package ftblag.summoningstructures;

import java.util.Random;

import ftblag.summoningstructures.blocks.SSBlocks;
import ftblag.summoningstructures.config.SSConfigLoader;
import ftblag.summoningstructures.gui.emptyone;
import ftblag.summoningstructures.gui.guiManual;
import ftblag.summoningstructures.gui.guiManualTwo;
import ftblag.summoningstructures.items.manual;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@net.minecraftforge.fml.common.Mod(modid = summoningstructures.MODID, name = summoningstructures.MODNAME, version = summoningstructures.VERSION)

public class summoningstructures implements IFuelHandler, IWorldGenerator {
		
    public static final String MODID = "SummoningStructures";
    public static final String MODNAME = "Summoning Structures";
    public static final String VERSION = "1.0";

    @Instance
    public static summoningstructures instance = new summoningstructures();

    @SidedProxy
    	(clientSide="ftblag.summoningstructures.ClientProxy",
    	serverSide="ftblag.summoningstructures.ServerProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
		SSConfigLoader.loadConfigSettings(e.getSuggestedConfigurationFile());
        this.proxy.preInit(e);
		ssmod_0.instance = this.instance;
		ssmod_1.instance = this.instance;
		ssmod_2.instance = this.instance;
		ssmod_1.preInit(e);
		ssmod_2.preInit(e);
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        this.proxy.init(e);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        this.proxy.postInit(e);
    }
    
	public static class GuiHandler implements IGuiHandler {
		@Override
		public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
			if (id == guiManual.GUIID)
				return new guiManual.GuiContainerMod(world, x, y, z, player);
			if (id == guiManualTwo.GUIID)
				return new guiManualTwo.GuiContainerMod(world, x, y, z, player);
			return null;
		}

		@Override
		public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
			if (id == guiManual.GUIID)
				return new guiManual.GuiWindow(world, x, y, z, player);
			if (id == guiManualTwo.GUIID)
				return new guiManualTwo.GuiWindow(world, x, y, z, player);
			return null;
		}
	}
	
	manual ssmod_0 = new manual();
	guiManual ssmod_1 = new guiManual();
	guiManualTwo ssmod_2 = new guiManualTwo();
	
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

		chunkX = chunkX * 16;
		chunkZ = chunkZ * 16;
		if (world.provider.getDimension() == -1)
			ssmod_1.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			ssmod_1.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			ssmod_2.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			ssmod_2.generateSurface(world, random, chunkX, chunkZ);

	}

	@EventHandler
	public void load(FMLInitializationEvent event) {

		GameRegistry.registerFuelHandler(this);
		GameRegistry.registerWorldGenerator(this, 1);
		if (event.getSide() == Side.CLIENT) {
			OBJLoader.INSTANCE.addDomain("summoningstructures");
		}
		MinecraftForge.EVENT_BUS.register(new emptyone());
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		ssmod_1.load(event);
		ssmod_2.load(event);
		proxy.registerRenderers(this);

	}

	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		ssmod_1.serverLoad(event);
		ssmod_2.serverLoad(event);
	}
	
	@Override
	public int getBurnTime(ItemStack fuel) {
		if (ssmod_0.addFuel(fuel) != 0)
			return ssmod_0.addFuel(fuel);
		if (ssmod_1.addFuel(fuel) != 0)
			return ssmod_1.addFuel(fuel);
		if (ssmod_2.addFuel(fuel) != 0)
			return ssmod_2.addFuel(fuel);
		return 0;
	}
}