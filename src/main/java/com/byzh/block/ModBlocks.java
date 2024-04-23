package com.byzh.block;

import com.byzh.TryMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
//    public static final Block ICE_ETHER_BLOCK_ORE = registerBlocks(
//            "ice_ether_block_ore",
//            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE), UniformIntProvider.create(2, 5)));
    public static final Block ICE_ETHER_BLOCK = registerBlocks(
            "ice_ether_block",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
    //==注册方法=====================================================================
    //方块物品(就不用跑到ModItems去注册了)
    private static Item registerBlockItems(String name, Block block){
        return Registry.register(
                Registries.ITEM,
                new Identifier(TryMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));//区别于item注册的一点。这里是BlockItem类
    }
    //方块
    public static Block registerBlocks(String name,Block block){
        registerBlockItems(name, block);//注册 方块 的时候也注册 方块物品
        return Registry.register(
                Registries.BLOCK,
                new Identifier(TryMod.MOD_ID, name),
                block);
    }
    public static void registerModBlocks(){};
}
