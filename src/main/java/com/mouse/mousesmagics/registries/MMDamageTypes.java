package com.mouse.mousesmagics.registries;

import com.mouse.mousesmagics.MousesMagics;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;

public class MMDamageTypes {
    public static ResourceKey<DamageType> register(String name)
    {
        return ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(MousesMagics.MOD_ID, name).toString()));
    }

    // Magic
    public static final ResourceKey<DamageType> DEW_MAGIC = register("dew_magic");
    public static final ResourceKey<DamageType> HEX_MAGIC = register("hex_magic");

    public static void bootstrap(BootstrapContext<DamageType> context)
    {
        context.register(DEW_MAGIC, new DamageType(DEW_MAGIC.location().getPath(), DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER, 0F));
    }
}
