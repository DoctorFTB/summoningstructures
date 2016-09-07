package ftblag.summoningstructures.blocks;

import java.util.List;

import ftblag.summoningstructures.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class spawner extends Block {
	
	public spawner(String unlocalizedName) {
        super(Material.ROCK);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(ClientProxy.tab);
        this.setHardness(5F);
        this.setResistance(10F);
        this.setHarvestLevel("pickaxe", 0);
    }
    
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
    	{
    		list.add("More information in Manual.");
    	}
    }
    
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float x, float y, float z){
		if(checkOne(world, pos, x, y, z, SSBlocks.skeletonSpawnerBlock)) {
    		if (!world.isRemote) {
				EntitySkeleton skeleton = new EntitySkeleton(world);
				skeleton.setPosition(pos.getX()+0.5,pos.up(1).getY(),pos.getZ()+0.5);
				world.spawnEntityInWorld(skeleton);
			}
    	}
		if(checkOne(world, pos, x, y, z, SSBlocks.zombieSpawnerBlock)) {
    		if (!world.isRemote) {
    			EntityZombie Zombie = new EntityZombie(world);
    			Zombie.setPosition(pos.getX()+0.5,pos.up(1).getY(),pos.getZ()+0.5);
    			world.spawnEntityInWorld(Zombie);
			}
    	}
		if(checkOne(world, pos, x, y, z, SSBlocks.pigzombieSpawnerBlock)) {
    		if (!world.isRemote) {
    			EntityPigZombie PigZombie = new EntityPigZombie(world);
    			PigZombie.setPosition(pos.getX()+0.5,pos.up(1).getY(),pos.getZ()+0.5);
    			world.spawnEntityInWorld(PigZombie);
			}
    	}
		if(checkOne(world, pos, x, y, z, SSBlocks.endermanSpawnerBlock)) {
    		if (!world.isRemote) {
    			EntityEnderman Enderman = new EntityEnderman(world);
    			Enderman.setPosition(pos.getX()+0.5,pos.up(1).getY(),pos.getZ()+0.5);
    			world.spawnEntityInWorld(Enderman);
			}
    	}
		if(checkOne(world, pos, x, y, z, SSBlocks.creeperSpawnerBlock)) {
    		if (!world.isRemote) {
    			EntityCreeper Creeper = new EntityCreeper(world);
    			Creeper.setPosition(pos.getX()+0.5,pos.up(1).getY(),pos.getZ()+0.5);
    			world.spawnEntityInWorld(Creeper);
			}
    	}
		if(checkOne(world, pos, x, y, z, SSBlocks.blazeSpawnerBlock)) {
    		if (!world.isRemote) {
    			EntityBlaze Blaze = new EntityBlaze(world);
    			Blaze.setPosition(pos.getX()+0.5,pos.up(1).getY(),pos.getZ()+0.5);
    			world.spawnEntityInWorld(Blaze);
			}
    	}
    	return true;
    }
    
	private boolean checkOne(World world, BlockPos pos, float x, float y, float z, Block name) {
		if(world.getBlockState(pos.add(x+1,y,z+1)).getBlock() == SSBlocks.baseBlock){
			if(world.getBlockState(pos.add(x+1,y+1,z+1)).getBlock() == name){
				if(world.getBlockState(pos.add(x+1,y+2,z+1)).getBlock() == name){
					if(world.getBlockState(pos.add(x+1,y,z-1)).getBlock() == SSBlocks.baseBlock){
						if(world.getBlockState(pos.add(x+1,y+1,z-1)).getBlock() == name){
							if(world.getBlockState(pos.add(x+1,y+2,z-1)).getBlock() == name){
								if(world.getBlockState(pos.add(x-1,y,z+1)).getBlock() == SSBlocks.baseBlock){
									if(world.getBlockState(pos.add(x-1,y+1,z+1)).getBlock() == name){
										if(world.getBlockState(pos.add(x-1,y+2,z+1)).getBlock() == name){
											if(world.getBlockState(pos.add(x-1,y,z-1)).getBlock() == SSBlocks.baseBlock){
												if(world.getBlockState(pos.add(x-1,y+1,z-1)).getBlock() == name){
													if(world.getBlockState(pos.add(x-1,y+2,z-1)).getBlock() == name){
														if(world.getBlockState(pos.add(x+1,y,z)).getBlock() == SSBlocks.baseBlock){
															if(world.getBlockState(pos.add(x,y,z+1)).getBlock() == SSBlocks.baseBlock){
																if(world.getBlockState(pos.add(x-1,y,z)).getBlock() == SSBlocks.baseBlock){
																	if(world.getBlockState(pos.add(x,y,z-1)).getBlock() == SSBlocks.baseBlock){
																		if(world.getBlockState(pos.add(x+1,y+1,z)).getBlock() == SSBlocks.Bars){
																			if(world.getBlockState(pos.add(x+1,y+1,z)).getBlock() == SSBlocks.Bars){
																				if(world.getBlockState(pos.add(x,y+1,z+1)).getBlock() == SSBlocks.Bars){
																					if(world.getBlockState(pos.add(x,y+1,z+1)).getBlock() == SSBlocks.Bars){
																						if(world.getBlockState(pos.add(x-1,y+1,z)).getBlock() == SSBlocks.Bars){
																							if(world.getBlockState(pos.add(x-1,y+1,z)).getBlock() == SSBlocks.Bars){
																								if(world.getBlockState(pos.add(x,y+1,z-1)).getBlock() == SSBlocks.Bars){
																									if(world.getBlockState(pos.add(x,y+1,z-1)).getBlock() == SSBlocks.Bars){
																										if(world.getBlockState(pos.add(x,y+1,z)).getBlock() == Blocks.AIR){
																											if(world.getBlockState(pos.add(x,y+2,z)).getBlock() == Blocks.AIR){
																												return true;
																											}
																										}
																									}
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
}