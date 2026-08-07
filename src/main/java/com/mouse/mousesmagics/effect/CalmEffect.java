package com.mouse.mousesmagics.effect;

import io.redspace.ironsspellbooks.effect.ISyncedMobEffect;
import io.redspace.ironsspellbooks.effect.MagicMobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class CalmEffect extends MagicMobEffect implements ISyncedMobEffect {
    public static final float MANA_MAGNITUDE = .75f;
    public static final float DEW_POWER_PER_LEVEL = .05f;
    public static final float SR_PER_LEVEL = .05f;

    public CalmEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }
}
