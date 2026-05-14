package com.mouse.mousesmagics.item.staffs.overgrown_sickle;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class OvergrownSickleRenderer extends GeoItemRenderer<OvergrownSickle> {
    public OvergrownSickleRenderer() {
        super(new OvergrownSickleModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}

