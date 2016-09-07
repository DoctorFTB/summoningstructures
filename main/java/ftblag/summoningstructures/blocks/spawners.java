package ftblag.summoningstructures.blocks;

import ftblag.summoningstructures.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class spawners extends Block {
	
    public spawners(String unlocalizedName) {
        super(Material.ROCK);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(ClientProxy.tab);
        this.setHardness(5F);
        this.setResistance(10F);
        this.setHarvestLevel("pickaxe", 0);
    }
}
