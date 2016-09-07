package ftblag.summoningstructures.blocks;

import ftblag.summoningstructures.ClientProxy;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Bars extends BlockPane{
	
	public Bars() {
        super(Material.ROCK, false);
        this.setUnlocalizedName("Bars");
        this.setRegistryName("Bars");
        this.setCreativeTab(ClientProxy.tab);
        this.setHardness(5F);
        this.setResistance(10F);
        this.setHarvestLevel("pickaxe", 0);
    }
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }
}