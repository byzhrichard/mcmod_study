package com.byzh.item;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;

public class ModFoodComponents {
    public static final FoodComponent CORN = new FoodComponent.Builder()
            .hunger(3).saturationModifier(0.3f) //饥饿值：hunger     饱和度：saturation
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200), 0.2f)
            .build();
}
