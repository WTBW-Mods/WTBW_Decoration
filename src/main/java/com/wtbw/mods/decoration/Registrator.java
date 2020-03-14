package com.wtbw.mods.decoration;

import com.wtbw.mods.decoration.block.LavaBlock;
import com.wtbw.mods.decoration.block.ModBlocks;
import com.wtbw.mods.decoration.block.WaterBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.*;

/*
  @author: Sunekaer
*/
public class Registrator extends com.wtbw.mods.lib.Registrator {
    public Registrator(ItemGroup group, String modid)
    {
        super(group, modid);
    }

    @Override
    protected void registerAllBlocks() {
        //POLISHED BRICK
        register(new Block(getBlockProperties(Material.ROCK,1.5F, 6.0F)), "polished_andesite_brick");
        register(new Block(getBlockProperties(Material.ROCK,1.5F, 6.0F)), "polished_diorite_brick");
        register(new Block(getBlockProperties(Material.ROCK,1.5F, 6.0F)), "polished_granite_brick");

        register(new Block(getBlockProperties(Material.ROCK,1.5F, 6.0F)), "basalt_block");
        register(new Block(getBlockProperties(Material.ROCK,1.5F, 6.0F)), "smooth_basalt_block");
        register(new Block(getBlockProperties(Material.ROCK,1.5F, 6.0F)), "smooth_basalt_brick");
        register(new Block(getBlockProperties(Material.ROCK,1.5F, 6.0F)), "smooth_basalt_small_brick");
        register(new Block(getBlockProperties(Material.ROCK,1.5F, 6.0F)), "chiseled_smooth_basalt_block");

        register(new Block(getBlockProperties(Material.ROCK,1.5F, 6.0F)), "limestone_block");
        register(new Block(getBlockProperties(Material.ROCK,1.5F, 6.0F)), "smooth_limestone_block");
        register(new Block(getBlockProperties(Material.ROCK,1.5F, 6.0F)), "smooth_limestone_brick");
        register(new Block(getBlockProperties(Material.ROCK,1.5F, 6.0F)), "smooth_limestone_small_brick");
        register(new Block(getBlockProperties(Material.ROCK,1.5F, 6.0F)), "chiseled_smooth_limestone_block");

        register(new Block(getBlockProperties(Material.ROCK,1.5F, 6.0F)), "marble_block");
        register(new Block(getBlockProperties(Material.ROCK,1.5F, 6.0F)), "smooth_marble_block");
        register(new Block(getBlockProperties(Material.ROCK,1.5F, 6.0F)), "smooth_marble_brick");
        register(new Block(getBlockProperties(Material.ROCK,1.5F, 6.0F)), "smooth_marble_small_brick");
        register(new Block(getBlockProperties(Material.ROCK,1.5F, 6.0F)), "chiseled_smooth_marble_block");

        // COLORED REDSTONE LAMPS
        register(new RedstoneLampBlock(getBlockProperties(Material.REDSTONE_LIGHT, 0.3F).lightValue(15).sound(SoundType.GLASS)), "blue_redstone_lamp");
        register(new RedstoneLampBlock(getBlockProperties(Material.REDSTONE_LIGHT, 0.3F).lightValue(15).sound(SoundType.GLASS)), "brown_redstone_lamp");
        register(new RedstoneLampBlock(getBlockProperties(Material.REDSTONE_LIGHT, 0.3F).lightValue(15).sound(SoundType.GLASS)), "cyan_redstone_lamp");
        register(new RedstoneLampBlock(getBlockProperties(Material.REDSTONE_LIGHT, 0.3F).lightValue(15).sound(SoundType.GLASS)), "gray_redstone_lamp");
        register(new RedstoneLampBlock(getBlockProperties(Material.REDSTONE_LIGHT, 0.3F).lightValue(15).sound(SoundType.GLASS)), "green_redstone_lamp");
        register(new RedstoneLampBlock(getBlockProperties(Material.REDSTONE_LIGHT, 0.3F).lightValue(15).sound(SoundType.GLASS)), "lime_redstone_lamp");
        register(new RedstoneLampBlock(getBlockProperties(Material.REDSTONE_LIGHT, 0.3F).lightValue(15).sound(SoundType.GLASS)), "light_blue_redstone_lamp");
        register(new RedstoneLampBlock(getBlockProperties(Material.REDSTONE_LIGHT, 0.3F).lightValue(15).sound(SoundType.GLASS)), "light_gray_redstone_lamp");
        register(new RedstoneLampBlock(getBlockProperties(Material.REDSTONE_LIGHT, 0.3F).lightValue(15).sound(SoundType.GLASS)), "magenta_redstone_lamp");
        register(new RedstoneLampBlock(getBlockProperties(Material.REDSTONE_LIGHT, 0.3F).lightValue(15).sound(SoundType.GLASS)), "orange_redstone_lamp");
        register(new RedstoneLampBlock(getBlockProperties(Material.REDSTONE_LIGHT, 0.3F).lightValue(15).sound(SoundType.GLASS)), "pink_redstone_lamp");
        register(new RedstoneLampBlock(getBlockProperties(Material.REDSTONE_LIGHT, 0.3F).lightValue(15).sound(SoundType.GLASS)), "purple_redstone_lamp");
        register(new RedstoneLampBlock(getBlockProperties(Material.REDSTONE_LIGHT, 0.3F).lightValue(15).sound(SoundType.GLASS)), "red_redstone_lamp");
        register(new RedstoneLampBlock(getBlockProperties(Material.REDSTONE_LIGHT, 0.3F).lightValue(15).sound(SoundType.GLASS)), "white_redstone_lamp");
        register(new RedstoneLampBlock(getBlockProperties(Material.REDSTONE_LIGHT, 0.3F).lightValue(15).sound(SoundType.GLASS)), "yellow_redstone_lamp");

        // LAVA BLOCK
        register(new LavaBlock(getBlockProperties(Material.GLASS,0.3F).sound(SoundType.GLASS).lightValue(15)), "lava_glass");
        register(new Block(getBlockProperties(Material.ROCK,1.5F, 6.0F).lightValue(15)), "lava_stone_brick");
        register(new SlabBlock(getBlockProperties(Material.ROCK,1.5F, 6.0F).lightValue(15)), "lava_stone_brick_slab");
        register(new StairsBlock(ModBlocks.LAVA_STONE_BRICK::getDefaultState, getBlockProperties(Material.ROCK,1.5F, 6.0F).lightValue(15)),"lava_stone_brick_stairs");
        register(new WallBlock(getBlockProperties(Material.ROCK,1.5F, 6.0F).lightValue(15)), "lava_stone_brick_wall");
        register(new Block(getBlockProperties(Material.ROCK,1.5F, 6.0F).lightValue(15)), "lava_chiseled_stone_brick");

        // WATER BLOCK
        register(new WaterBlock(getBlockProperties(Material.GLASS,0.3F).sound(SoundType.GLASS)), "water_glass");
        register(new Block(getBlockProperties(Material.ROCK,1.5F, 6.0F)), "water_stone_brick");
        register(new SlabBlock(getBlockProperties(Material.ROCK,1.5F, 6.0F)), "water_stone_brick_slab");
        register(new StairsBlock(ModBlocks.WATER_STONE_BRICK::getDefaultState, getBlockProperties(Material.ROCK,1.5F, 6.0F)),"water_stone_brick_stairs");
        register(new WallBlock(getBlockProperties(Material.ROCK,1.5F, 6.0F)), "water_stone_brick_wall");
        register(new Block(getBlockProperties(Material.ROCK,1.5F, 6.0F)), "water_chiseled_stone_brick");
    }

    @Override
    protected void registerAllItems() {

    }

    @Override
    protected void registerAllTiles() {

    }

    @Override
    protected void registerAllContainers() {

    }
}
