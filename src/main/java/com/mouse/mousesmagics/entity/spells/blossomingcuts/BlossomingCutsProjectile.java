package com.mouse.mousesmagics.entity.spells.blossomingcuts;

import com.mouse.mousesmagics.registries.MMEntityRegistries;
import com.mouse.mousesmagics.registries.SpellRegistries;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.entity.spells.AbstractMagicProjectile;
import io.redspace.ironsspellbooks.registries.MobEffectRegistry;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.*;

public class BlossomingCutsProjectile extends AbstractMagicProjectile implements GeoEntity {
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);
    HashMap<UUID, Integer> victims;

    public BlossomingCutsProjectile(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.victims = new HashMap<>();
        this.setNoGravity(true);
    }

    public BlossomingCutsProjectile(Level level, LivingEntity shooter) {
        this(MMEntityRegistries.BLOSSOMING_CUTS_PROJECTILE.get(), level);
        setOwner(shooter);
    }

    public void trailParticles() {
    }

    public void impactParticles(double x, double y, double z) {
        MagicManager.spawnParticles(level(), ParticleHelper.CLEANSE_PARTICLE, x, y, z, 5, .1, .1, .1, .25, true);
    }

    public float getSpeed() {
        return 1F;
    }


    protected void onHitEntity(EntityHitResult entityHitResult) {
        if(getOwner() != null && getOwner() instanceof LivingEntity owner){
            owner.addEffect(new MobEffectInstance(MobEffectRegistry.CHARGED, 200));}
        super.onHitEntity(entityHitResult);
        DamageSources.applyDamage(entityHitResult.getEntity(), damage, SpellRegistries.BLOSSOMING_CUTS.get().getDamageSource(this, getOwner()));
        pierceOrDiscard();
    }

    protected void onHitBlock(@NotNull BlockHitResult blockHitResult) {
        super.onHitBlock(blockHitResult);
        this.discard();
    }

    @Override
    public Optional<Holder<SoundEvent>> getImpactSound() {
        return Optional.of(SoundRegistry.ECHOING_STRIKE);
    }

    //Animation
    private final AnimationController<BlossomingCutsProjectile> animationController = new AnimationController<>(this, "controller", 0, this::predicate);

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(animationController);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return geoCache;
    }

    private PlayState predicate(AnimationState<BlossomingCutsProjectile> event) {
        // Sounds pretty cool!
        event.getController().setAnimation(RawAnimation.begin().then("animation.blossoming_cuts_idle", Animation.LoopType.LOOP));

        return PlayState.CONTINUE;
    }
}

