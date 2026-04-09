package com.mouse.mousesmagics;

import com.mouse.mousesmagics.block.ModBlocks;
import com.mouse.mousesmagics.item.ModCreativeModeTabs;
import com.mouse.mousesmagics.item.ModItems;
import com.mouse.mousesmagics.registries.MMAttributeRegistries;
import com.mouse.mousesmagics.registries.MMSchoolRegistries;
import com.mouse.mousesmagics.registries.SpellRegistries;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(MousesMagics.MOD_ID)
public class MousesMagics {
    public static final String MOD_ID = "mousesmagics";
    public static final Logger LOGGER = LogUtils.getLogger();

    public MousesMagics(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);

        MMAttributeRegistries.register(modEventBus);

        MMSchoolRegistries.register(modEventBus);

        ModBlocks.register(modEventBus);

        SpellRegistries.register(modEventBus);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    @EventBusSubscriber(modid = MousesMagics.MOD_ID, value = Dist.CLIENT)
    static class ClientModEvents {
        @SubscribeEvent
        static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
