package com.mouse.mousesmagics.spells.dew;

import com.mouse.mousesmagics.MousesMagics;
import com.mouse.mousesmagics.entity.spells.blossomingcuts.BlossomingCutsProjectile;
import com.mouse.mousesmagics.registries.MMSchoolRegistries;
import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.Utils;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

import java.util.List;

public class BlossomingCutsSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(MousesMagics.MOD_ID, "blossoming_cuts");

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(Component.translatable("ui.irons_spellbooks.damage", Utils.stringTruncation(getSpellPower(spellLevel, caster), 2)));
    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.EPIC)
            .setSchoolResource(MMSchoolRegistries.DEW_RESOURCE)
            .setMaxLevel(1)
            .setCooldownSeconds(1)
            .build();

    public BlossomingCutsSpell() {
        this.manaCostPerLevel = 0;
        this.baseSpellPower = 7;
        this.spellPowerPerLevel = 0;
        this.castTime = 1;
        this.baseManaCost = 10;
    }

    @Override
    public CastType getCastType() {
        return CastType.INSTANT;
    }

    @Override
    public DefaultConfig getDefaultConfig() {
        return defaultConfig;
    }

    @Override
    public ResourceLocation getSpellResource() {
        return spellId;
    }

    @Override
    public void onCast(Level world, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        BlossomingCutsProjectile blossomingCutsProjectile = new BlossomingCutsProjectile(world, entity);
        blossomingCutsProjectile.setPos(entity.position().add(0, entity.getEyeHeight() - blossomingCutsProjectile.getBoundingBox().getYsize() * .5f, 0));
        blossomingCutsProjectile.shoot(entity.getLookAngle());
        blossomingCutsProjectile.setDamage(getDamage(spellLevel, entity));
        world.addFreshEntity(blossomingCutsProjectile);
        super.onCast(world, spellLevel, entity, castSource, playerMagicData);
    }

    private float getDamage(int spellLevel, LivingEntity entity) {
        return getSpellPower(spellLevel, entity) * .5f;
    }

}

