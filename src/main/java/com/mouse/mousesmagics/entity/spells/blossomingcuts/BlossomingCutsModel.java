package com.mouse.mousesmagics.entity.spells.blossomingcuts;

import com.mouse.mousesmagics.MousesMagics;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BlossomingCutsModel extends GeoModel<BlossomingCutsProjectile> {

    @Override
    public ResourceLocation getModelResource(BlossomingCutsProjectile animatable) {
        return ResourceLocation.fromNamespaceAndPath(MousesMagics.MOD_ID, "geo/entities/spells/blossoming_cuts_projectile.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BlossomingCutsProjectile animatable) {
        return ResourceLocation.fromNamespaceAndPath(MousesMagics.MOD_ID, "textures/entity/blossoming_cuts.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BlossomingCutsProjectile animatable) {
        return ResourceLocation.fromNamespaceAndPath(MousesMagics.MOD_ID, "animations/entities/spells/blossoming_cuts_idle.animation.json");
    }
}
