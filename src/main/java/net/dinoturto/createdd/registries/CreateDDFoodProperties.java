package net.dinoturto.createdd.registries;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

public class CreateDDFoodProperties {
    public static final FoodProperties VANILLA_MILKSHAKE = new FoodProperties.Builder().nutrition(2).saturationModifier(1.75F)
            .usingConvertsTo(Items.GLASS_BOTTLE)
            .effect(new MobEffectInstance(MobEffects.SATURATION, 600, 1, false, false, false), 1).build();
}
