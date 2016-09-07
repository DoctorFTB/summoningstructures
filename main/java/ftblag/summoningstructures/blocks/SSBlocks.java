package ftblag.summoningstructures.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class SSBlocks {
	
	public static Block spawnerBlock;
	public static Block zombieSpawnerBlock;
	public static Block pigzombieSpawnerBlock;
	public static Block endermanSpawnerBlock;
	public static Block creeperSpawnerBlock;
	public static Block blazeSpawnerBlock;
	public static Block skeletonSpawnerBlock;
	public static Block Bars = new Bars();
	public static Block baseBlock;
	public static Block metaBlock;
		
    public static void createBlocks() {
        GameRegistry.registerBlock(spawnerBlock = new spawner("spawner"), "spawner");
        GameRegistry.registerBlock(zombieSpawnerBlock = new spawners("zombieSpawner"), "zombieSpawner");
        GameRegistry.registerBlock(pigzombieSpawnerBlock = new spawners("pigzombieSpawner"), "pigzombieSpawner");
        GameRegistry.registerBlock(endermanSpawnerBlock = new spawners("endermanSpawner"), "endermanSpawner");
        GameRegistry.registerBlock(creeperSpawnerBlock = new spawners("creeperSpawner"), "creeperSpawner");
        GameRegistry.registerBlock(blazeSpawnerBlock = new spawners("blazeSpawner"), "blazeSpawner");
        GameRegistry.registerBlock(skeletonSpawnerBlock = new spawners("skeletonSpawner"), "skeletonSpawner");
        GameRegistry.registerBlock(baseBlock = new spawners("base"), "base");
			ItemBlock iBlock = new ItemBlock(Bars);
		GameRegistry.register(Bars);
		GameRegistry.register(iBlock, Bars.getRegistryName());
    }
}