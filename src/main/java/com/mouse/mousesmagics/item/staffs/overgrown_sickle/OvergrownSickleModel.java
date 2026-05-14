package com.mouse.mousesmagics.item.staffs.overgrown_sickle;

import com.mouse.mousesmagics.MousesMagics;
import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class OvergrownSickleModel extends DefaultedItemGeoModel<OvergrownSickle> {
    public OvergrownSickleModel() {
        super(ResourceLocation.fromNamespaceAndPath(MousesMagics.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(OvergrownSickle animatable) {
        return ResourceLocation.fromNamespaceAndPath(MousesMagics.MOD_ID, "geo/overgrownsickle.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(OvergrownSickle animatable) {
        return ResourceLocation.fromNamespaceAndPath(MousesMagics.MOD_ID, "textures/item/sickletexture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(OvergrownSickle animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
