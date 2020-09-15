package com.wtbw.mods.decoration.config;

import com.wtbw.mods.decoration.block.ModBlocks;
import com.wtbw.mods.decoration.world.gen.OreBlockProvider;
import com.wtbw.mods.decoration.WTBWDecoration;
import com.wtbw.mods.lib.config.BaseConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

/*
  @author: Naxanria
*/
public class DecorationCommonConfig extends BaseConfig
{
  private static DecorationCommonConfig instance;

  public static DecorationCommonConfig getConfig()
  {
    return instance;
  }

  public static StoneConfig MARBLE;
  public static StoneConfig BASALT;
  public static StoneConfig LIMESTONE;

  public static void init()
  {
    final Pair<DecorationCommonConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(DecorationCommonConfig::new);
    instance = specPair.getLeft();

    ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, specPair.getRight());
  }

  public DecorationCommonConfig(ForgeConfigSpec.Builder builder)
  {
    super(WTBWDecoration.MODID, builder);
    instance = this;
    
    push("stoneGen");
    MARBLE = new StoneConfig("marble", StoneConfig.marble_provider, 20, 6, 20, 80);
    BASALT = new StoneConfig("basalt", StoneConfig.basalt_provider, 20, 6, 15, 50);
    LIMESTONE = new StoneConfig("limestone", StoneConfig.limestone_provider, 20, 6, 20, 80);
    pop();
  }
  
  public static class StoneConfig
  {
    static final OreBlockProvider marble_provider = new OreBlockProvider(() -> ModBlocks.MARBLE_BLOCK, OreFeatureConfig.FillerBlockType.field_241882_a);
    static final OreBlockProvider basalt_provider = new OreBlockProvider(() -> ModBlocks.BASALT_BLOCK, OreFeatureConfig.FillerBlockType.field_241882_a);
    static final OreBlockProvider limestone_provider = new OreBlockProvider(() -> ModBlocks.LIMESTONE_BLOCK, OreFeatureConfig.FillerBlockType.field_241882_a);

    private final OreBlockProvider provider;
    
    private final String name;
    private ForgeConfigSpec.BooleanValue enabled;
    private ForgeConfigSpec.IntValue maxVein;
    private ForgeConfigSpec.IntValue perChunk;
    private ForgeConfigSpec.IntValue start;
    private ForgeConfigSpec.IntValue end;
    
    public StoneConfig(String name, OreBlockProvider provider, int maxVein, int perChunk, int start, int end)
    {
      this.name = name;
      
      this.provider = provider;
      ForgeConfigSpec.Builder builder = instance.builder;
      instance.push(name);
      
      this.maxVein = builder
        .comment("Max size of vein", "Default: " + maxVein)
        .translation(key("max_vein"))
        .defineInRange("maxVein", maxVein, 1, 256);

      this.perChunk = builder
        .comment("Veins per chunk", "Default: " + perChunk)
        .translation(key("per_chunk"))
        .defineInRange("perChunk", perChunk, 1, 256);
  
      this.start = builder
        .comment("Start height of veins", "Default: " + start)
        .translation(key("start"))
        .defineInRange("start", start, 0, 256);
  
      this.end = builder
        .comment("End height of veins", "Default: " + end)
        .translation(key("end"))
        .defineInRange("end", end, 0, 256);
      
      this.enabled = builder
        .comment("Is this stonegen option enabled")
        .comment("Is this stonegen option enabled")
        .translation(key("enabled"))
        .define("enabled", true);
      
      instance.pop();
    }
    
    private String key(String key)
    {
      return instance.key("stonegen." + name + "." + key);
    }
    
    public boolean isStoneEnabled()
    {
      return enabled.get();
    }
    
    public int maxVeinSize()
    {
      return maxVein.get();
    }
    
    public int getPerChunk()
    {
      return perChunk.get();
    }
    
    public int getBottomOffset()
    {
      return start.get();
    }
    
    public int getTopOffset()
    {
      return start.get();
    }
    
    public int getMaxHeight()
    {
      return end.get() + 1;
    }
    
    public OreBlockProvider getProvider()
    {
      return provider;
    }
  }
}
