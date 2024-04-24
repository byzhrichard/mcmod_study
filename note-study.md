# 继承Item类
### 主体代码
//构造函数
public Prospector(Settings settings) {
    super(settings);
}
//右键方块的时候
@Override 
public ActionResult useOnBlock(ItemUsageContext context) {
    ......
}
### 包含的类
1. ItemUsageContext 物品使用信息(context)
- getBlockPos()
- getPlayer()
- getStack()
- getWorld()

2. World 世界
- getBlockState(BlockPos对象)
- breakBlock(BlockPos对象,drop: false)

3. ItemStack
- damage(扣除的耐久值, PlayerEntity对象, playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()))
4. BlockPos 方块位置
- getX() / getY() / getZ()
- down(整数)   

5. BlockState 方块状态
- isOf(Block对象)

6. PlayerEntity 玩家实体
- sendMessage(Text.literal("文本信息"))
- isOnFire()
- addStatusEffect(StatusEffectInstance对象)
- setFireTicks(整数)

### 获取原版对象
Blocks.IRON_ORE
Items.BOOK
