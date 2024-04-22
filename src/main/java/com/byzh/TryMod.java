package com.byzh;

import com.byzh.block.ModBlocks;
import com.byzh.item.ModItemGroup;
import com.byzh.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TryMod implements ModInitializer {
	public static final String MOD_ID = "try-mod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		//物品注册
		ModItems.registerModItems();
		//物品栏注册
		ModItemGroup.registerModItemGroup();
		//方块注册
		ModBlocks.registerModBlocks();
	}
}