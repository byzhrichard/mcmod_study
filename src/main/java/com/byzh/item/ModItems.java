package com.byzh.item;

import com.byzh.TryMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    //注册物品
    public static final Item ICE_ETHER = registerItems("ice_ether",new Item(new FabricItemSettings()));

    //物品注册的方法
    private static Item registerItems(String name,Item item){
        return Registry.register(
                Registries.ITEM,
                new Identifier(TryMod.MOD_ID, name),
                item);
    }
    //添加到fabric的物品group中
    private static void addItemsToItemGroup(FabricItemGroupEntries fabricItemGroupEntries){
        fabricItemGroupEntries.add(ICE_ETHER);
    }
    //将 fabric物品栏 注册到 Minecraft物品栏
    public static void registerModItems(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToItemGroup);
    }
}
