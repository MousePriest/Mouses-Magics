package com.mouse.mousesmagics.entity.spells.dew_burst;

import com.mouse.mousesmagics.registries.MMEffectRegisteries;
import com.mouse.mousesmagics.registries.MMEntityRegistries;
import com.mouse.mousesmagics.registries.SpellRegistries;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.entity.spells.AbstractMagicProjectile;
import io.redspace.ironsspellbooks.entity.spells.magma_ball.FireField;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

public class DewBurstProjectile extends AbstractMagicProjectile implements GeoEntity {
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);
    HashMap<UUID, Integer> victims;

    public DewBurstProjectile(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.victims = new HashMap<>();
        this.setNoGravity(true);
    }

    public DewBurstProjectile(Level level, LivingEntity shooter) {
        this(MMEntityRegistries.DEW_BURST_PROJECTILE.get(), level);
        setOwner(shooter);
    }

    @Override
    public void trailParticles() {
        for (int i = 0; i < 1; i++) {
            double speed = .05;
            double dx = Utils.random.nextDouble() * 2 * speed - speed;
            double dy = Utils.random.nextDouble() * 2 * speed - speed;
            double dz = Utils.random.nextDouble() * 2 * speed - speed;
            level().addParticle(Utils.random.nextDouble() < .1 ? ParticleHelper.SNOW_DUST : ParticleTypes.CHERRY_LEAVES, this.getX() + dx, this.getY() + dy, this.getZ() + dz, dx, dy, dz);
        }
    }


    public void impactParticles(double x, double y, double z) {
        MagicManager.spawnParticles(level(), ParticleTypes.CHERRY_LEAVES, x, y, z, 20, .2, .2, .2, .9, true);
    }

    public float getSpeed() {
        return 20F;
    }


    protected void onHit(@NotNull HitResult hitresult) {
        super.onHit(hitresult);
        createFlowerField(Utils.moveToRelativeGroundLevel(level(), hitresult.getLocation(), 2, 6));
        float explosionRadius = getExplosionRadius();
        var entities = level().getEntities(this, this.getBoundingBox().inflate(explosionRadius));
        for (Entity entity : entities) {
            double distance = entity.distanceToSqr(hitresult.getLocation());
            if (distance < explosionRadius * explosionRadius && canHitEntity(entity)) {
                if (Utils.hasLineOfSight(level(), hitresult.getLocation(), entity.position().add(0, entity.getEyeHeight() * .5f, 0), true)) {
                    double p = (1 - Math.pow(Math.sqrt(distance) / (explosionRadius), 3));
                    float damage = (float) (this.damage * p);
                    DamageSources.applyDamage(entity, damage, SpellRegistries.DEW_BURST.get().getDamageSource(this, getOwner()));
                }
            }
        }
        this.discardHelper(hitresult);
    }

    public void createFlowerField(Vec3 location) {
        if (!level().isClientSide) {
            FlowerField flower = new FlowerField(level());
            flower.setOwner(getOwner());
            flower.setDuration(200);
            flower.setDamage(aoeDamage);
            flower.setRadius(getExplosionRadius());
            flower.setCircular();
            flower.moveTo(location);
            level().addFreshEntity(flower);
        }
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
    public Optional<Holder<SoundEvent>> getImpactSound() {
        return Optional.of(SoundRegistry.BLOOD_STEP);
    }

    //Animation
    private final AnimationController<DewBurstProjectile> animationController = new AnimationController<>(this, "controller", 0, this::predicate);

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(animationController);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return geoCache;
    }

    private PlayState predicate(AnimationState<DewBurstProjectile> event) {
        // Sounds pretty cool!
        event.getController().setAnimation(RawAnimation.begin().then("animation.blank", Animation.LoopType.LOOP));

        return PlayState.CONTINUE;
    }
}
