package com.mouse.mousesmagics.registries;

import com.mouse.mousesmagics.MousesMagics;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class MMParticleRegistries {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(Registries.PARTICLE_TYPE, MousesMagics.MOD_ID);

    public static void register(IEventBus eventBus) {PARTICLE_TYPES.register(eventBus);}

    /* Copying Iron guide

    To Create Particle:
    - textures + json
    - particle class
    - register it here
    - add it to particle helper
    - register it in client setup

     */

    public static final Supplier<SimpleParticleType> DEW_ONE_PARTICLE = PARTICLE_TYPES.register("dew_one", () -> new SimpleParticleType(false));
}
