package com.mouse.mousesmagics.entity.spells.dew_burst;

import com.mouse.mousesmagics.registries.MMDamageTypes;
import com.mouse.mousesmagics.registries.MMEntityRegistries;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.entity.spells.AoeEntity;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;

import java.util.Optional;

public class FlowerField extends AoeEntity {

    private DamageSource damageSource;

    public FlowerField(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public FlowerField(Level level) {
        this(MMEntityRegistries.FLOWER_FIELD.get(), level);
    }

    @Override
    public void applyEffect(LivingEntity target) {
        if (damageSource == null) {
            damageSource = new DamageSource(DamageSources.getHolderFromResource(target, MMDamageTypes.DEW_MAGIC), this, getOwner());
        }
        if (!DamageSources.isFriendlyFireBetween(this.getOwner(), target)) {
            DamageSources.ignoreNextKnockback(target);
            if (target.hurt(damageSource, getDamage())) {
            }
        }
    }

    @Override
    public float getParticleCount() {
        return getRadius();
    }

    @Override
    public float getRadius() {
        return 3;
    }

    @Override
    protected float particleYOffset() {
        return .25f;
    }

    @Override
    protected float getParticleSpeedModifier() {
        return 1.4f;
    }

    @Override
    public Optional<ParticleOptions> getParticle() {
        return Optional.of(ParticleTypes.CHERRY_LEAVES);
    }
}
