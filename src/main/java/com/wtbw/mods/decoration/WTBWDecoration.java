package com.wtbw.mods.decoration;

import com.wtbw.mods.decoration.block.ModBlocks;
import com.wtbw.mods.decoration.config.DecorationCommonConfig;
import com.wtbw.mods.decoration.world.gen.WorldGenHandler;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
  @author: Sunekaer
*/
@Mod(WTBWDecoration.MODID)
public class WTBWDecoration
{
    public static final String MODID = "wtbw_decoration";
    private Registrator registrator;
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static ItemGroup GROUP = new ItemGroup(MODID)
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModBlocks.LAVA_STONE_BRICK);
        }
    };


    public WTBWDecoration() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        registrator = new Registrator(GROUP, MODID);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.addListener(WorldGenHandler::setupWorldGen);

        DecorationCommonConfig.init();
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    
    }
}
