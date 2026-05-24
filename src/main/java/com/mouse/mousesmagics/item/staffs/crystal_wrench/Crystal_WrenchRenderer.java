package com.mouse.mousesmagics.item.staffs.crystal_wrench;

import com.mouse.mousesmagics.MousesMagics;
import mod.azure.azurelib.common.render.item.AzItemRenderer;
import mod.azure.azurelib.common.render.item.AzItemRendererConfig;
import net.minecraft.resources.ResourceLocation;

public class Crystal_WrenchRenderer extends AzItemRenderer {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(MousesMagics.MOD_ID, "geo/crystal_wrench.geo.json");
    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(MousesMagics.MOD_ID, "textures/item/crystal_wrench.png");

    public Crystal_WrenchRenderer() {
        super(
                AzItemRendererConfig.builder(GEO, TEX)
                        .build()
        );
    }
}

