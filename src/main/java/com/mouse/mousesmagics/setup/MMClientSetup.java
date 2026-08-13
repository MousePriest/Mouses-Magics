package com.mouse.mousesmagics.setup;

import com.mouse.mousesmagics.MousesMagics;
import com.mouse.mousesmagics.entity.spells.defenestration.DefenestrationRenderer;
import com.mouse.mousesmagics.entity.spells.dragon_burst.DragonBurstRenderer;
import com.mouse.mousesmagics.entity.spells.petal.PetalRenderer;
import com.mouse.mousesmagics.registries.MMEntityRegistries;
import net.minecraft.client.renderer.entity.NoopRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = MousesMagics.MOD_ID, value = Dist.CLIENT)
public class MMClientSetup {

    @SubscribeEvent
    public static void rendererRegister(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(MMEntityRegistries.DEFENESTRATION_PROJECTILE.get(), DefenestrationRenderer::new);
        event.registerEntityRenderer(MMEntityRegistries.PETAL_PROJECTILE.get(), PetalRenderer::new);
        event.registerEntityRenderer(MMEntityRegistries.DRAGON_BURST_PROJECTILE.get(), DragonBurstRenderer::new);
        event.registerEntityRenderer(MMEntityRegistries.DRAGON_FIELD.get(), NoopRenderer::new);
    }
}