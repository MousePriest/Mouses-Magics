package com.mouse.mousesmagics.setup;

import com.mouse.mousesmagics.MousesMagics;
import com.mouse.mousesmagics.entity.spells.BloomBombRenderer;
import com.mouse.mousesmagics.registries.MMEntityRegistries;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = MousesMagics.MOD_ID, value = Dist.CLIENT)
public class MMClientSetup {

    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {

        event.registerLayerDefinition(BloomBombRenderer.MODEL_LAYER_LOCATION, BloomBombRenderer::createBodyLayer);
    }

    @SubscribeEvent
    public static void rendererRegister(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(MMEntityRegistries.BLOOM_BOMB.get(), BloomBombRenderer::new);
    }
}