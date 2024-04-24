package com.byzh.item.custom;

import com.byzh.block.ModBlocks;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FireEther extends Item {
    public FireEther(Settings settings) {
        super(settings);
    }

    @Override //右键方块的时候
    public ActionResult useOnBlock(ItemUsageContext context) { //context携带了该操作的信息
        World world = context.getWorld();
        if (!world.isClient){
            PlayerEntity player = context.getPlayer();  //获取玩家对象
            ItemStack stack = context.getStack();   //获取物品对象
            BlockState blockState = world.getBlockState(context.getBlockPos()); //获取方块状态对象

            lightFire(blockState, context, player);
            stack.damage(1, player, playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));
        }
        return ActionResult.SUCCESS;
    }

    @Override //工具信息
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.try-mod.byzh_fire.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }

    private void lightFire(BlockState blockState, ItemUsageContext context, PlayerEntity player) {
        boolean playerNotOnFire = !player.isOnFire();
        if (context.getWorld().getRandom().nextFloat() > 0.5f){
            lightEntityOnFire(player, 200);//实体着火
        } else if (playerNotOnFire && blockIsRight(blockState)){
            gainFAandDB(player, context.getWorld(), context.getBlockPos());//抗火保护
        } else {
            lightGround(context);//点燃地面
        }
    }

    private void lightGround(ItemUsageContext context) {//来自打火石
        PlayerEntity player = context.getPlayer();
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();//点击方块的位置
        BlockPos blockPos1 = blockPos.offset(context.getSide());//向点击的面的方向向量偏移一格的方块的位置
        if (AbstractFireBlock.canPlaceAt(world, blockPos1, context.getHorizontalPlayerFacing())){
            world.playSound(player,
                    blockPos1,
                    SoundEvents.ITEM_FLINTANDSTEEL_USE,//打火石音效
                    SoundCategory.BLOCKS,//声音类别
                    1.0f,
                    world.getRandom().nextFloat() * 0.4f + 0.8f);
            BlockState blockState2 = AbstractFireBlock.getState(world, blockPos1);
            world.setBlockState(blockPos1, blockState2, Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);//
            world.emitGameEvent((Entity)player, GameEvent.BLOCK_PLACE, blockPos);//
            /*
            * Block.NOTIFY_ALL：这是一个常量标志，表示在更改方块状态后，应通知所有对此事件感兴趣的监听器。这包括但不限于：
            * 更新附近方块的碰撞箱、渲染数据等。触发与方块变化相关的游戏逻辑，如红石电路更新、生物行为调整、玩家成就解锁等。
            * 向客户端同步此变化，确保多人游戏中的其他玩家能看到相同的场景。*/
            /*
            * Block.REDRAW_ON_MAIN_THREAD：这是一个常量标志，指示在主线程上重新绘制（或更新渲染）与此次方块状态变化相关的区块（chunk）。
            * 在多线程环境中，通常游戏世界的物理模拟、逻辑处理等在工作线程中进行，而图形渲染在主线程进行。使用此标志确保：
            * 重绘操作与用户交互、界面更新等其他主线程任务同步执行，避免画面撕裂、延迟等问题。
            * 保证在主线程上按照正确的顺序更新相关方块及周围环境的视觉表现，如光照计算、流体流动动画等。*/
        }
    }

    private void gainFAandDB(PlayerEntity player, World world, BlockPos blockPos) {
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 200));
        world.breakBlock(blockPos, false);
    }

    private void lightEntityOnFire(PlayerEntity player, int i) {
        player.setFireTicks(i);
    }

    private boolean blockIsRight(BlockState blockState) {
        return blockState.isOf(ModBlocks.ICE_ETHER_BLOCK);
    }


}
