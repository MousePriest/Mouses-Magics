package com.mouse.mousesmagics.spells;

import com.mouse.mousesmagics.MousesMagics;
import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.api.spells.CastType;
import net.minecraft.resources.ResourceLocation;

public class SparklingWeepSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(MousesMagics.MOD_ID, "sparkling_weep");

    @Override
    public ResourceLocation getSpellResource() {
        return null;
    }

    @Override
    public DefaultConfig getDefaultConfig() {
        return null;
    }

    @Override
    public CastType getCastType() {
        return null;
    }
}
