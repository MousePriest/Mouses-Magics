package com.mouse.mousesmagics.registries;

import com.mouse.mousesmagics.MousesMagics;
import com.mouse.mousesmagics.effect.CalmEffect;
import com.mouse.mousesmagics.effect.FlowerFoodEffect;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MMEffectRegisteries {
    public static final DeferredRegister<MobEffect> MOB_EFFECT_DEFERRED_REGISTER = DeferredRegister.create(Registries.MOB_EFFECT, MousesMagics.MOD_ID);

    public static void register(IEventBus eventBus) {
        MOB_EFFECT_DEFERRED_REGISTER.register(eventBus);
    }

    public static final DeferredHolder<MobEffect, MobEffect> CALM = MOB_EFFECT_DEFERRED_REGISTER.register("calm", () -> new CalmEffect(MobEffectCategory.BENEFICIAL, 0xffffff)
            .addAttributeModifier(AttributeRegistry.MANA_REGEN, MousesMagics.namespacePath("mobeffect_calm"), AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, level -> -CalmEffect.MANA_MAGNITUDE)
            .addAttributeModifier(MMAttributeRegistries.DEW_MAGIC_POWER, MousesMagics.namespacePath("mobeffect_calm"), CalmEffect.DEW_POWER_PER_LEVEL, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
            .addAttributeModifier(AttributeRegistry.SPELL_RESIST, MousesMagics.namespacePath("mobeffect_calm"), CalmEffect.SR_PER_LEVEL, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
            .addAttributeModifier(Attributes.SAFE_FALL_DISTANCE, MousesMagics.namespacePath("mobeffect_calm"), 1000, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
            .addAttributeModifier(Attributes.BURNING_TIME, MousesMagics.namespacePath("mobeffect_calm"), AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, level -> -1000)
            .addAttributeModifier(Attributes.KNOCKBACK_RESISTANCE, MousesMagics.namespacePath("mobeffect_calm"), 10, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
            .addAttributeModifier(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE, MousesMagics.namespacePath("mobeffect_calm"), 10, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
            .addAttributeModifier(Attributes.OXYGEN_BONUS, MousesMagics.namespacePath("mobeffect_calm"), 10, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static final DeferredHolder<MobEffect, MobEffect> FLOWER_FOOD = MOB_EFFECT_DEFERRED_REGISTER.register("flower_food", () -> new FlowerFoodEffect(MobEffectCategory.BENEFICIAL, 0xffffff));

}
