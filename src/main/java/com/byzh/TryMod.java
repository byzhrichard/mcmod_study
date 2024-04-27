package com.byzh;

import com.byzh.block.ModBlocks;
import com.byzh.item.ModItemGroup;
import com.byzh.item.ModItems;
import net.fabricmc.api.ModInitializer;
//import net.fabricmc.loader.api.FabricLoader;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TryMod implements ModInitializer {
	public static final String MOD_ID = "try-mod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
//	FabricLoader loader = FabricLoader.getInstance();
//
//	// 获取游戏配置目录
//	java.nio.file.Path configDir = loader.getGameDirectory().resolve("config");
	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		//物品注册
		ModItems.registerModItems();
		//物品栏注册
		ModItemGroup.registerModItemGroup();
		//方块注册
		ModBlocks.registerModBlocks();
		//燃料注册
		FuelRegistry.INSTANCE.add(ModItems.BYZH_COAL, 2000);
	}
}