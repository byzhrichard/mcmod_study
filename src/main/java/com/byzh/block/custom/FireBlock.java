package com.byzh.block.custom;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FireBlock extends Block {
    public FireBlock(Settings settings) {
        super(settings);
    }
    @Override //当实体走在上面的时候
    public void onEntityLand(BlockView world, Entity entity) {
        entity.setFireTicks(200);
        super.onEntityLand(world, entity);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.literal("Don't walk on this block!"));
        super.appendTooltip(stack, world, tooltip, options);
    }
}
