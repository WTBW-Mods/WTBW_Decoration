package com.wtbw.mods.decoration.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/*
  @author: Naxanria, Sunekaer
*/
public class WaterBlock extends Block
{
  public WaterBlock(Block.Properties properties)
  {
    super(properties);
  }
  
  public void harvestBlock(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable TileEntity te, ItemStack stack)
  {
    super.harvestBlock(world, player, pos, state, te, stack);
    if (EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, stack) == 0)
    {
      // does water evaporate
      if (world.func_230315_m_().func_236040_e_())
      {
        world.removeBlock(pos, false);
        return;
      }
      
      world.setBlockState(pos, Blocks.WATER.getDefaultState());
    }
  }
}