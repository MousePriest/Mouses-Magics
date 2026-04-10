package com.mouse.mousesmagics.registries;


import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MMEntityRegistries {
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, IronsSpellbooks.MODID);

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }


}