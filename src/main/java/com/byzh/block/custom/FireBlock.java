package com.byzh.block.custom;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.world.BlockView;

public class FireBlock extends Block {
    public FireBlock(Settings settings) {
        super(settings);
    }
    @Override //当实体走在上面的时候
    public void onEntityLand(BlockView world, Entity entity) {
        entity.setFireTicks(200);
        super.onEntityLand(world, entity);
    }
}
