package com.byzh.item;

import com.byzh.TryMod;
import com.byzh.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class ModItemGroup {
    //Text.translatable()会去json中翻译
    //icons下写的是: new Supplier<ItemStack>()的get方法的匿名内部类 //返回一个ItemStack
    //entries下写的是: new ItemGroup.EntryCollector()的accept方法的匿名内部类 //无返回
    public static final ItemGroup Try_Group = Registry.register(
            Registries.ITEM_GROUP,
            new Identifier(TryMod.MOD_ID, "try_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.try_group"))
                    .icon(()->new ItemStack(ModItems.ICE_ETHER))
                    .entries( (displayContext, entries) -> {
                        entries.add(ModItems.ICE_ETHER);
                        entries.add(ModBlocks.ICE_ETHER_BLOCK);
                        entries.add(Items.BOOK);
                        entries.add(Blocks.GRASS_BLOCK);
                    })
                    .build()
    );
    public static void registerModItemGroup(){

    }
}
