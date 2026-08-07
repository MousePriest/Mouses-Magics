package com.mouse.mousesmagics.entity.spells.dew_burst;

import com.mouse.mousesmagics.MousesMagics;
import com.mouse.mousesmagics.entity.spells.petal.PetalProjectile;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DewBurstModel extends GeoModel<DewBurstProjectile> {

    @Override
    public ResourceLocation getModelResource(DewBurstProjectile animatable) {
        return ResourceLocation.fromNamespaceAndPath(MousesMagics.MOD_ID, "geo/entities/spells/dew_burst.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DewBurstProjectile animatable) {
        return ResourceLocation.fromNamespaceAndPath(MousesMagics.MOD_ID, "textures/entity/dew_burst.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DewBurstProjectile animatable) {
        return ResourceLocation.fromNamespaceAndPath(MousesMagics.MOD_ID, "animations/entities/spells/blank.animation.json");
    }
}
