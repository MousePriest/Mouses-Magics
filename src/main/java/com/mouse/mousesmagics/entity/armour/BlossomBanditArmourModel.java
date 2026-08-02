package com.mouse.mousesmagics.entity.armour;

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
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "geo/pyromancer_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BlossomBanditArmourItem object) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "textures/models/armor/pyromancer.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BlossomBanditArmourItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
