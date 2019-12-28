package com.wtbw.decoration;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
  @author: Sunekaer
*/
@Mod(WTBWDecoration.MODID)
public class WTBWDecoration
{
    public static final String MODID = "wtbw_decoration";

    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public WTBWDecoration() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        //eventBus.addListener();

        IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

        DistExecutor.runWhenOn(Dist.CLIENT, () -> () ->
        {
            LOGGER.log(Level.INFO, "Client side loaded");
        });

        DistExecutor.runWhenOn(Dist.DEDICATED_SERVER, () -> () ->
        {
            LOGGER.log(Level.INFO, "Server side loaded");
        });
    }
}
