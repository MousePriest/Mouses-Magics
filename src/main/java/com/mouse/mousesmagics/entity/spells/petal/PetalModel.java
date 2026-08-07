package com.mouse.mousesmagics.entity.spells.petal;

import com.mouse.mousesmagics.MousesMagics;
import com.mouse.mousesmagics.entity.spells.defenestration.DefenestrationProjectile;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PetalModel extends GeoModel<PetalProjectile> {

    @Override
    public ResourceLocation getModelResource(PetalProjectile animatable) {
        return ResourceLocation.fromNamespaceAndPath(MousesMagics.MOD_ID, "geo/entities/spells/petal_model.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PetalProjectile animatable) {
        return ResourceLocation.fromNamespaceAndPath(MousesMagics.MOD_ID, "textures/entity/petal_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PetalProjectile animatable) {
        return ResourceLocation.fromNamespaceAndPath(MousesMagics.MOD_ID, "animations/entities/spells/blank.animation.json");
    }
}
