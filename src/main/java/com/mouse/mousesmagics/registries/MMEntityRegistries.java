package com.mouse.mousesmagics.registries;

import com.mouse.mousesmagics.MousesMagics;
import com.mouse.mousesmagics.entity.spells.blossomingcuts.BlossomingCutsProjectile;
import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.entity.spells.firebolt.FireboltProjectile;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MMEntityRegistries {
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, MousesMagics.MOD_ID);

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }

    public static final DeferredHolder<EntityType<?>, EntityType<BlossomingCutsProjectile>> BLOSSOMING_CUTS_PROJECTILE =
            ENTITIES.register("firebolt", () -> EntityType.Builder.<BlossomingCutsProjectile>of(BlossomingCutsProjectile::new, MobCategory.MISC)
                    .sized(.5f, .5f)
                    .clientTrackingRange(64)
                    .build(ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "firebolt").toString()));
}