package ftblag.summoningstructures.crafting;

import ftblag.summoningstructures.blocks.SSBlocks;
import ftblag.summoningstructures.items.SSItems;
import ftblag.summoningstructures.items.manual;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SSCrafting {

	public static void initCrafting() {
		
		GameRegistry.addRecipe(new ItemStack(SSBlocks.Bars,6), 
						new Object[] {"III", "III",
								'I', SSItems.spawnerIngotItem});
		
		GameRegistry.addSmelting(SSItems.spawnerDustItem, new ItemStack(SSItems.spawnerIngotItem), 1.0F);
		
		GameRegistry.addRecipe(new ItemStack(SSItems.spawnerDustItem,2), 
				new Object[] {"GDR", "DND", "RDG",
				'N', Items.NETHER_STAR, 'D', Items.DRAGON_BREATH, 'G', Items.GUNPOWDER, 'R', Items.REDSTONE});
				
		GameRegistry.addRecipe(new ItemStack(SSItems.spawnerDustItem,2), 
				new Object[] {"RDG", "DND", "GDR",
				'N', Items.NETHER_STAR, 'D', Items.DRAGON_BREATH, 'G', Items.GUNPOWDER, 'R', Items.REDSTONE});
		
		GameRegistry.addRecipe(new ItemStack(SSBlocks.baseBlock,2), 
				new Object[] {"IBI", "BDB", "IBI",
				'B', SSBlocks.Bars, 'I', SSItems.spawnerIngotItem, 'D', Blocks.DIAMOND_BLOCK});
		
		GameRegistry.addRecipe(new ItemStack(SSBlocks.spawnerBlock), 
				new Object[] {"CBC", "BMB", "CBC",
				'M', Blocks.BEACON, 'B', SSBlocks.baseBlock, 'C', Blocks.SEA_LANTERN});
		
		GameRegistry.addRecipe(new ItemStack(SSBlocks.zombieSpawnerBlock,4), 
				new Object[] {"CBC", "BMB", "CBC",
				'M', Blocks.SEA_LANTERN, 'B', SSBlocks.baseBlock, 'C', Items.ROTTEN_FLESH});
		
		GameRegistry.addRecipe(new ItemStack(SSBlocks.pigzombieSpawnerBlock,4), 
				new Object[] {"CBC", "BMB", "CBC",
				'M', Blocks.SEA_LANTERN, 'B', SSBlocks.baseBlock, 'C', Items.GOLD_NUGGET});
		
		GameRegistry.addRecipe(new ItemStack(SSBlocks.endermanSpawnerBlock,4), 
				new Object[] {"CBC", "BMB", "CBC",
				'M', Blocks.SEA_LANTERN, 'B', SSBlocks.baseBlock, 'C', Items.ENDER_PEARL});
		
		GameRegistry.addRecipe(new ItemStack(SSBlocks.creeperSpawnerBlock,4), 
				new Object[] {"CBC", "BMB", "CBC",
				'M', Blocks.SEA_LANTERN, 'B', SSBlocks.baseBlock, 'C', Items.GUNPOWDER});
		
		GameRegistry.addRecipe(new ItemStack(SSBlocks.blazeSpawnerBlock,4), 
				new Object[] {"CBC", "BMB", "CBC",
				'M', Blocks.SEA_LANTERN, 'B', SSBlocks.baseBlock, 'C', Items.BLAZE_ROD});
		
		GameRegistry.addRecipe(new ItemStack(SSBlocks.skeletonSpawnerBlock,4), 
				new Object[] {"CBC", "BMB", "CBC",
				'M', Blocks.SEA_LANTERN, 'B', SSBlocks.baseBlock, 'C', Items.BONE});
		
		GameRegistry.addShapelessRecipe(new ItemStack(manual.manualI),
				new Object[] {Items.BOOK, SSItems.spawnerIngotItem});

	}
}
