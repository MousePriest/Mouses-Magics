package com.mouse.mousesmagics.spells.dew;

import com.mouse.mousesmagics.MousesMagics;
import com.mouse.mousesmagics.registries.MMSchoolRegistries;
import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.AnimationHolder;
import io.redspace.ironsspellbooks.api.util.CameraShakeData;
import io.redspace.ironsspellbooks.api.util.CameraShakeManager;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.particle.BlastwaveParticleOptions;
import io.redspace.ironsspellbooks.particle.ZapParticleOption;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;

import java.util.List;
import java.util.Optional;

public class BloomingBurstSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(MousesMagics.MOD_ID, "blooming_burst");

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(
                Component.translatable("ui.irons_spellbooks.damage", Utils.stringTruncation(getDamage(spellLevel, caster), 2)),
                Component.translatable("ui.irons_spellbooks.radius", Utils.stringTruncation(getRadius(spellLevel, caster), 2))
        );
    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.COMMON)
            .setSchoolResource(MMSchoolRegistries.DEW_RESOURCE)
            .setMaxLevel(8)
            .setCooldownSeconds(15)
            .build();

    public BloomingBurstSpell() {
        this.manaCostPerLevel = 5;
        this.baseSpellPower = 8;
        this.spellPowerPerLevel = 1;
        this.castTime = 2;
        this.baseManaCost = 70;
    }

    @Override
    public CastType getCastType() {
        return CastType.LONG;
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
    public Optional<SoundEvent> getCastFinishSound() {
        return Optional.of(SoundRegistry.ROOT_EMERGE.get());
    }

    @Override
    public void onCast(Level level, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        float radius = getRadius(spellLevel, entity);
        Vector3f edge = new Vector3f(.7f, 1f, 1f);
        Vector3f center = new Vector3f(1, 1f, 1f);

        MagicManager.spawnParticles(level, new BlastwaveParticleOptions(edge, radius * 1.02f), entity.getX(), entity.getY() + .15f, entity.getZ(), 1, 0, 0, 0, 0, true);
        MagicManager.spawnParticles(level, new BlastwaveParticleOptions(edge, radius * 0.98f), entity.getX(), entity.getY() + .15f, entity.getZ(), 1, 0, 0, 0, 0, true);
        MagicManager.spawnParticles(level, new BlastwaveParticleOptions(center, radius), entity.getX(), entity.getY() + .165f, entity.getZ(), 1, 0, 0, 0, 0, true);
        MagicManager.spawnParticles(level, new BlastwaveParticleOptions(center, radius), entity.getX(), entity.getY() + .135f, entity.getZ(), 1, 0, 0, 0, 0, true);
        MagicManager.spawnParticles(level, ParticleHelper.WISP, entity.getX(), entity.getY() + 1, entity.getZ(), 200, .25, .25, .25, 0.7f + radius * .1f, false);
        MagicManager.spawnParticles(level, ParticleHelper.CLEANSE_PARTICLE, entity.getX(), entity.getY() + 1, entity.getZ(), 200, .25, .25, .25, 0.7f + radius * .1f, false);
        CameraShakeManager.addCameraShake(new CameraShakeData(level, 30, entity.position(), radius * 2));

        super.onCast(level, spellLevel, entity, castSource, playerMagicData);
    }

    private boolean canHit(Entity owner, Entity target) {
        return target != owner && target.isAlive() && target.isPickable() && !target.isSpectator();
    }

    public float getRadius(int spellLevel, LivingEntity caster) {
        return 4 + spellLevel;
    }

    public float getDamage(int spellLevel, LivingEntity caster) {
        return 4 + (getSpellPower(spellLevel, caster) * .75f);
    }

    @Override
    public void playSound(Optional<SoundEvent> sound, Entity entity) {
        sound.ifPresent((soundEvent -> entity.playSound(soundEvent, 3.0f, .9f + Utils.random.nextFloat() * .2f)));
    }

    @Override
    public AnimationHolder getCastFinishAnimation() {
        return SpellAnimations.ONE_HANDED_VERTICAL_UPSWING_ANIMATION;
    }
}

