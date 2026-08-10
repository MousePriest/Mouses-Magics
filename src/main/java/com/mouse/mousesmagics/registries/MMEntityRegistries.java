package com.mouse.mousesmagics.registries;

import com.mouse.mousesmagics.MousesMagics;
import com.mouse.mousesmagics.entity.spells.defenestration.DefenestrationProjectile;
import com.mouse.mousesmagics.entity.spells.dew_burst.DewBurstProjectile;
import com.mouse.mousesmagics.entity.spells.dew_burst.FlowerField;
import com.mouse.mousesmagics.entity.spells.petal.PetalProjectile;
import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.entity.spells.magma_ball.FireField;
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

    public static final DeferredHolder<EntityType<?>, EntityType<DefenestrationProjectile>> DEFENESTRATION_PROJECTILE =
            ENTITIES.register("defenestration", () -> EntityType.Builder.<DefenestrationProjectile>of(DefenestrationProjectile::new, MobCategory.MISC)
                    .sized(.5f, .5f)
                    .clientTrackingRange(64)
                    .build(ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "defenestration").toString()));

    public static final DeferredHolder<EntityType<?>, EntityType<PetalProjectile>> PETAL_PROJECTILE =
            ENTITIES.register("petal", () -> EntityType.Builder.<PetalProjectile>of(PetalProjectile::new, MobCategory.MISC)
                    .sized(.5f, .5f)
                    .clientTrackingRange(64)
                    .build(ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "petal").toString()));

    public static final DeferredHolder<EntityType<?>, EntityType<DewBurstProjectile>> DEW_BURST_PROJECTILE =
            ENTITIES.register("dew_burst", () -> EntityType.Builder.<DewBurstProjectile>of(DewBurstProjectile::new, MobCategory.MISC)
                    .sized(.5f, .5f)
                    .clientTrackingRange(64)
                    .build(ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "dew_burst").toString()));

    public static final DeferredHolder<EntityType<?>, EntityType<FlowerField>> FLOWER_FIELD =
            ENTITIES.register("flower_field", () -> EntityType.Builder.<FlowerField>of(FlowerField::new, MobCategory.MISC)
                    .sized(4f, 1.2f)
                    .clientTrackingRange(64)
                    .build(ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "flower_field").toString()));


}