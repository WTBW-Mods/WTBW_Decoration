package com.wtbw.mods.decoration.world.gen;

import com.wtbw.mods.decoration.WTBWDecoration;
import com.wtbw.mods.decoration.config.DecorationCommonConfig;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

/*
  @author: Naxanria
*/
public class WorldGenHandler
{
  private static ConfiguredFeature<?, ?> marbleFeature;
  private static ConfiguredFeature<?, ?> basaltFeature;
  private static ConfiguredFeature<?, ?> limestoneFeature;

  
  public static void setupWorldGen()
  {
    marbleFeature = getOreFeature(DecorationCommonConfig.MARBLE, Feature.ORE);
    basaltFeature = getOreFeature(DecorationCommonConfig.BASALT, Feature.ORE);
    limestoneFeature = getOreFeature(DecorationCommonConfig.LIMESTONE, Feature.ORE);

  
    ForgeRegistries.BIOMES.forEach(biome ->
    {
      if (DecorationCommonConfig.MARBLE.isStoneEnabled())
      {
        if (isBiomeValid(biome, false))
        {
          addFeature(biome, marbleFeature);
        }
      }
      if (DecorationCommonConfig.BASALT.isStoneEnabled())
      {
        if (isBiomeValid(biome, false))
        {
          addFeature(biome, basaltFeature);
        }
      }
      if (DecorationCommonConfig.LIMESTONE.isStoneEnabled())
      {
        if (isBiomeValid(biome, false))
        {
          addFeature(biome, limestoneFeature);
        }
      }
    });
  }
  
  
  private static boolean isBiomeValid(Biome biome, boolean nether)
  {
    if (nether)
    {
      return biome.getCategory() == Biome.Category.NETHER;
    }
    
    return biome.getCategory() != Biome.Category.THEEND && biome.getCategory() != Biome.Category.NETHER;
  }
  
  private static ConfiguredFeature<?, ?> getOreFeature(DecorationCommonConfig.StoneConfig config, Feature<OreFeatureConfig> feature)
  {
    OreBlockProvider provider = config.getProvider();
    
    if (config.isStoneEnabled())
    {
      WTBWDecoration.LOGGER.info("Creating stone config {} max: {} bottom: {} top: {}", provider.getBlock().getRegistryName().toString(), config.getMaxHeight(), config.getBottomOffset(), config.getTopOffset());
      return feature.func_225566_b_(new OreFeatureConfig(provider.getFillerBlockType(), provider.getBlock().getDefaultState(), config.maxVeinSize()))
        .func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(
          new CountRangeConfig(config.getPerChunk(), config.getBottomOffset(), config.getTopOffset(), config.getMaxHeight())
        ));
    }
    
    return null;
  }
  
  private static void addFeature(Biome biome, ConfiguredFeature<?, ?> feature)
  {
    if (feature != null)
    {
      biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, feature);
    }
  }
}
