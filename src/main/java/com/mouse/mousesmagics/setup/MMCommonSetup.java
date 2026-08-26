package com.mouse.mousesmagics.setup;

import com.mouse.mousesmagics.MousesMagics;
import com.mouse.mousesmagics.entity.mobs.wizards.gardener.GardenerEntity;
import com.mouse.mousesmagics.registries.MMEntityRegistries;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = MousesMagics.MOD_ID)
public class MMCommonSetup {
    @SubscribeEvent
    public static void onAttributeCreate(EntityAttributeCreationEvent event) {
        event.put(MMEntityRegistries.GARDENER.get(), GardenerEntity.prepareAttributes().build());
    }
}
