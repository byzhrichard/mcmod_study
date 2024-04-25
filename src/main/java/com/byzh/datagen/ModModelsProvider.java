package com.byzh.datagen;

import com.byzh.block.ModBlocks;
import com.byzh.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ICE_ETHER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FIRE_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BYZH_COAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.BYZH_FIRE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BYZH_FOOD, Models.GENERATED);
        itemModelGenerator.register(ModItems.BYZH_STAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.ICE_ETHER, Models.GENERATED);
    }
}
