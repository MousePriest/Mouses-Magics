package com.mouse.mousesmagics.entity.armour;

import com.mouse.mousesmagics.MousesMagics;
import com.mouse.mousesmagics.item.armour.blossom_bandit.BlossomBanditArmourItem;
import io.redspace.ironsspellbooks.IronsSpellbooks;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BlossomBanditArmourModel extends GeoModel<BlossomBanditArmourItem> {

    public BlossomBanditArmourModel() {
        super();

    }

    @Override
    public ResourceLocation getModelResource(BlossomBanditArmourItem object) {
        return ResourceLocation.fromNamespaceAndPath(MousesMagics.MOD_ID, "geo/blossom_bandit.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BlossomBanditArmourItem object) {
        return ResourceLocation.fromNamespaceAndPath(MousesMagics.MOD_ID, "textures/armour/blossom_bandit.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BlossomBanditArmourItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
