package com.mouse.mousesmagics.item.staffs.ceremonial_dagger;

import com.mouse.mousesmagics.MousesMagics;
import mod.azure.azurelib.common.render.item.AzItemRenderer;
import mod.azure.azurelib.common.render.item.AzItemRendererConfig;
import mod.azure.azurelib.common.render.layer.AzAutoGlowingLayer;
import net.minecraft.resources.ResourceLocation;

public class Ceremonial_DaggerRenderer extends AzItemRenderer {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(MousesMagics.MOD_ID, "geo/ceremonial_dagger.geo.json");
    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(MousesMagics.MOD_ID, "textures/item/ceremonial_dagger.png");

    public Ceremonial_DaggerRenderer() {
        super(
                AzItemRendererConfig.builder(GEO, TEX)
                        .build()
        );
    }
}
