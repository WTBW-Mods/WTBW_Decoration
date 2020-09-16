//package com.wtbw.mods.decoration.world.gen;
//
//import com.wtbw.mods.core.WTBWCore;
//import com.wtbw.mods.core.config.CoreCommonConfig;
//import com.wtbw.mods.core.world.gen.OreBlockProvider;
//import net.minecraft.world.biome.Biome;
//import net.minecraft.world.gen.GenerationStage;
//import net.minecraft.world.gen.feature.ConfiguredFeature;
//import net.minecraft.world.gen.feature.Feature;
//import net.minecraft.world.gen.feature.OreFeatureConfig;
//import net.minecraftforge.event.world.BiomeLoadingEvent;
//
///*
//  @author: Naxanria
//*/
//public class WorldGenHandler
//{
//  private static ConfiguredFeature<?, ?> marbleFeature;
//  private static ConfiguredFeature<?, ?> basaltFeature;
//  private static ConfiguredFeature<?, ?> limestoneFeature;
//
//
//  public static void setupWorldGen(final BiomeLoadingEvent event)
//  {
//    if (marbleFeature == null)
//    {
//      marbleFeature = getOreFeature(CoreCommonConfig.COPPER, Feature.ORE);
//    }
//
//    if (basaltFeature == null)
//    {
//      basaltFeature = getOreFeature(CoreCommonConfig.COBALT, Feature.ORE);
//    }
//
//    if (limestoneFeature == null)
//    {
//      limestoneFeature = getOreFeature(CoreCommonConfig.COBALT, Feature.ORE);
//    }
//
//    if (isOverworld(event.getCategory()))
//    {
//      event.getGeneration().func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, marbleFeature);
//      event.getGeneration().func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, basaltFeature);
//      event.getGeneration().func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, limestoneFeature);
//    }
//  }
//
//  public static boolean isOverworld(Biome.Category category)
//  {
//    return category != Biome.Category.NETHER && category != Biome.Category.THEEND;
//  }
//
//  public static boolean isTheEnd(Biome.Category category)
//  {
//    return category == Biome.Category.THEEND;
//  }
//
//  public static boolean isNether(Biome.Category category)
//  {
//    return category == Biome.Category.NETHER;
//  }
//
//  private static ConfiguredFeature<?, ?> getOreFeature(CoreCommonConfig.OreConfig config, Feature<OreFeatureConfig> feature)
//  {
//    OreBlockProvider provider = config.getProvider();
//
//    if (config.isOreEnabled())
//    {
//      WTBWCore.LOGGER.info("Creating ore config {} max: {} bottom: {} top: {}", provider.getBlock().getRegistryName().toString(), config.getMaxHeight(), config.getBottomOffset(), config.getTopOffset());
//
//      return feature.withConfiguration(new OreFeatureConfig(provider.getFillerBlockType(), provider.getBlock().getDefaultState(), config.maxVeinSize()))
//        .func_242733_d(config.getMaxHeight()).func_242728_a().func_242731_b(config.getPerChunk());
//    }
//
//    return null;
//  }
//}
