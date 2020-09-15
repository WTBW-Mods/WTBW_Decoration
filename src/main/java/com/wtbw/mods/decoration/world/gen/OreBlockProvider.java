package com.wtbw.mods.decoration.world.gen;

import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;

import java.util.function.Supplier;

public class OreBlockProvider
{
  private final Supplier<Block> block;
  private final RuleTest fillerBlockType;
  
  public OreBlockProvider(Supplier<Block> block, RuleTest fillerBlockType)
  {
    this.block = block;
    this.fillerBlockType = fillerBlockType;
  }
  
  public Block getBlock()
  {
    return block.get();
  }
  
  public RuleTest getFillerBlockType()
  {
    return fillerBlockType;
  }
}
