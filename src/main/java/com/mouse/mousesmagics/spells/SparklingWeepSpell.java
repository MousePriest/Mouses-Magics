package com.mouse.mousesmagics.spells;

import com.mouse.mousesmagics.MousesMagics;
import com.mouse.mousesmagics.registries.MMSchoolRegistry;
import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.api.spells.CastType;
import io.redspace.ironsspellbooks.api.spells.SpellRarity;
import net.minecraft.resources.ResourceLocation;

//Cone spell
public class SparklingWeepSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(MousesMagics.MOD_ID, "sparkling_weep");

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.UNCOMMON)
            .setSchoolResource(MMSchoolRegistry.DEW_RESOURCE)
            .setMaxLevel(10)
            .setCooldownSeconds(20)
            .build();

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
