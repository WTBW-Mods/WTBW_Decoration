package com.wtbw.mods.decoration.world.gen;

import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.function.Supplier;

public class OreBlockProvider
{
  Supplier<Block> block;
  OreFeatureConfig.FillerBlockType fillerBlockType;
  
  public OreBlockProvider(Supplier<Block> block, OreFeatureConfig.FillerBlockType fillerBlockType)
  {
    this.block = block;
    this.fillerBlockType = fillerBlockType;
  }
  
  public Block getBlock()
  {
    return block.get();
  }
  
  public OreFeatureConfig.FillerBlockType getFillerBlockType()
  {
    return fillerBlockType;
  }
}
