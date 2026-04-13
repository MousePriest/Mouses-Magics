package com.mouse.mousesmagics.registries;


import com.mouse.mousesmagics.MousesMagics;
import com.mouse.mousesmagics.entity.spells.BloomBomb;
import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.entity.spells.magma_ball.FireBomb;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MMEntityRegistries {
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, IronsSpellbooks.MODID);

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }

    public static final DeferredHolder<EntityType<?>, EntityType<BloomBomb>> BLOOM_BOMB =
            ENTITIES.register("bloom_ball", () -> EntityType.Builder.<BloomBomb>of(BloomBomb::new, MobCategory.MISC)
                    .sized(0.75F, 0.75F)
                    .clientTrackingRange(64)
                    .build(ResourceLocation.fromNamespaceAndPath(MousesMagics.MOD_ID, "bloom_ball").toString()));
}