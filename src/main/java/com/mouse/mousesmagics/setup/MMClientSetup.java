package com.mouse.mousesmagics.setup;

import com.mouse.mousesmagics.MousesMagics;
import com.mouse.mousesmagics.entity.spells.blossomingcuts.BlossomingCutsRenderer;
import com.mouse.mousesmagics.registries.MMEntityRegistries;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = MousesMagics.MOD_ID, value = Dist.CLIENT)
public class MMClientSetup {

    @SubscribeEvent
    public static void rendererRegister(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(MMEntityRegistries.BLOSSOMING_CUTS_PROJECTILE.get(), BlossomingCutsRenderer::new);
    }
}