package com.byzh.datagen;

import com.byzh.block.ModBlocks;
import com.byzh.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        //接收TagKey
        getOrCreateTagBuilder(ModTags.Blocks.PROSPECTOR_LIST)   //往自定义prospector_list里添加
                .add(ModBlocks.ICE_ETHER_BLOCK)
                .forceAddTag(BlockTags.COAL_ORES)
                .forceAddTag(BlockTags.IRON_ORES)
                .forceAddTag(BlockTags.GOLD_ORES)
                .forceAddTag(BlockTags.LAPIS_ORES)
                .forceAddTag(BlockTags.DIAMOND_ORES)
                .forceAddTag(BlockTags.REDSTONE_ORES)
                .forceAddTag(BlockTags.EMERALD_ORES)
                .forceAddTag(BlockTags.COPPER_ORES);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)   //用工具
                .add(ModBlocks.ICE_ETHER_BLOCK);
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)    //用铁镐
                .add(ModBlocks.ICE_ETHER_BLOCK);

    }
}
