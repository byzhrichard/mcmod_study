# gradle.properties放着配置信息
mod_version=1.0.0
maven_group=com.byzh
archives_base_name=try-mod

# src/main/resources/fabric.mod.json放着更详细的配置信息
license协议
icon模组图片

# 启动
gradle-Tasks-fabric-runClient

# Item
1. 代码
```java
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
}
```
2. 语言文件
src/main/resources/assets/try-mod/lang/en_us.json
src/main/resources/assets/try-mod/lang/zh_cn.json
3. 模型|物品状态文件
用Minecraft原版物品的渲染方法
src/main/resources/assets/try-mod/models/item/ice_ether.json
4. 材质文件
src/main/resources/assets/try-mod/textures/item/ice_ether.png

# Block
Block注册分为 方块(Block) and 方块物品(BlockItem)
方块状态文件：
src/main/resources/assets/try-mod/blockstates/ice_ether_block.json
方块模型文件：
src/main/resources/assets/try-mod/models/block/ice_ether_block.json
方块材质文件:
> 对copyOf中的Blocks.STONE的STONE进行ctrl+b
> ![img.png](pic/img.png)