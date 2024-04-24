package com.byzh.util;

import com.byzh.TryMod;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    //静态内部类
    public static class Blocks{
        public static final TagKey<Block> PROSPECTOR_LIST = createTag("prospector_list");
        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(TryMod.MOD_ID, name));
        }
    }
    public static class Items{

    }
}
