package com.byzh.item.custom;

import com.byzh.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockStateRaycastContext;
import net.minecraft.world.World;
import net.fabricmc.loader.api.FabricLoader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Random;

public class Prospector extends Item {
    //构造函数
    public Prospector(Settings settings) {
        super(settings);
    }


    @Override //右键方块的时候
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        if (!world.isClient()){ //客户端与服务端的判断
            BlockPos blockPos = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;
            for (int i = -64; i <= blockPos.getY() + 64; i++) {
                BlockState state = context.getWorld().getBlockState(blockPos.down(i));
                if (isRightBlock(state)){
                    outputMessage(blockPos.down(i), player, state.getBlock());
                    foundBlock= true;
                    break;
                }
            }
            if (!foundBlock){
                player.sendMessage(Text.literal("No Ore Found!"));
            }
            //test
            FabricLoader loader = FabricLoader.getInstance();
            java.nio.file.Path configDir = loader.getGameDir();
            String path = configDir.toString()+"\\config\\byzh";
            File newDirectory = new File(path);
            newDirectory.mkdir();
            int FileCnt = newDirectory.list().length;
            try {
                mytry(path, FileCnt);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            player.sendMessage(Text.literal(path),false);
        }
        //减去耐久值
        context.getStack().damage(1, context.getPlayer(),
                playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));


        return ActionResult.SUCCESS;
    }

    private void outputMessage(BlockPos down, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("Found"+block.asItem().getName().getString() + "at" +
                "(" + down.getX() + "," + down.getY() + "," + down.getZ() + ")!"),false);
    }

    private boolean isRightBlock(BlockState state){
//        return state.isOf(Blocks.IRON_ORE) || state.isOf(Blocks.DIAMOND_ORE);
        return state.isIn(ModTags.Blocks.PROSPECTOR_LIST);
    }

    private void mytry(String path,int FileCnt) throws IOException {

        int width = 800; // 画布宽度
        int height = 600; // 画布高度
        int[][] pixels = new int[width][height]; // 初始化画布

        Random random = new Random();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int red = random.nextInt(256); // 生成0-255的随机数作为红色分量
                int green = random.nextInt(256); // 生成0-255的随机数作为绿色分量
                int blue = random.nextInt(256); // 生成0-255的随机数作为蓝色分量

                int pixel = (red << 16) | (green << 8) | blue; // 合并RGB值
                pixels[x][y] = pixel; // 将像素值存入画布中
            }
        }

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, pixels[x][y]); // 设置像素颜色
            }
        }

        File output = new File(path+"\\output"+ FileCnt +".png");
        ImageIO.write(image, "png", output); // 保存为PNG格式的图片
    }
}
