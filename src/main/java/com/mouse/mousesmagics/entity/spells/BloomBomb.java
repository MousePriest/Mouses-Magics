package com.mouse.mousesmagics.entity.spells;

import com.mouse.mousesmagics.registries.MMEntityRegistries;
import com.mouse.mousesmagics.registries.MMParticleRegistries;
import com.mouse.mousesmagics.registries.SpellRegistries;
import com.mouse.mousesmagics.utils.MMParticleHelper;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.entity.spells.AbstractMagicProjectile;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.Optional;

public class BloomBomb extends AbstractMagicProjectile {
    public BloomBomb(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public BloomBomb(Level level, LivingEntity shooter) {
        this(MMEntityRegistries.BLOOM_BOMB.get(), level);
        setOwner(shooter);
    }

    @Override
    public void trailParticles() {
        Vec3 vec3 = getDeltaMovement();
        double d0 = this.getX() - vec3.x;
        double d1 = this.getY() - vec3.y;
        double d2 = this.getZ() - vec3.z;
        for (int i = 0; i < 4; i++) {
            Vec3 random = Utils.getRandomVec3(.2);
            level().addParticle(ParticleHelper.FIREFLY, vec3.x, vec3.y, vec3.z, 0, 0, 0);
        }
    }

    @Override
    public void impactParticles(double x, double y, double z) {
        MagicManager.spawnParticles(level(), MMParticleHelper.FLOWER, x, y, z, 30, 1.5, .1, 1.5, 1, false);
    }

    @Override
    public float getSpeed() {
        return .200f;
    }

    @Override
    protected void onHit(HitResult hitresult) {
        super.onHit(hitresult);
        float explosionRadius = getExplosionRadius();
        var entities = level().getEntities(this, this.getBoundingBox().inflate(explosionRadius));
        for (Entity entity : entities) {
            double distance = entity.distanceToSqr(hitresult.getLocation());
            if (distance < explosionRadius * explosionRadius && canHitEntity(entity)) {
                if (Utils.hasLineOfSight(level(), hitresult.getLocation(), entity.position().add(0, entity.getEyeHeight() * .5f, 0), true)) {
                    double p = (1 - Math.pow(Math.sqrt(distance) / (explosionRadius), 5));
                    float damage = (float) (this.damage * p);
                DamageSources.applyDamage(entity, damage, SpellRegistries.BLOOMING_BURST_SPELL.get().getDamageSource(this, getOwner()));
                }
            }
        }
        this.discardHelper(hitresult);
    }

    float aoeDamage;

    public void setAoeDamage(float damage) {
        this.aoeDamage = damage;
    }

    public float getAoeDamage() {
        return aoeDamage;
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putFloat("AoeDamage", aoeDamage);


    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.aoeDamage = tag.getFloat("AoeDamage");

    }

    @Override
    protected void doImpactSound(Holder<SoundEvent> sound) {
        level().playSound(null, getX(), getY(), getZ(), sound, SoundSource.NEUTRAL, 2, 1.2f + Utils.random.nextFloat() * .2f);
    }

    @Override
    public Optional<Holder<SoundEvent>> getImpactSound() {
        return Optional.of(SoundEvents.GENERIC_EXPLODE);
    }

}

