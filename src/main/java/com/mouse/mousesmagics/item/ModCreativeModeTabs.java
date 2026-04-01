package com.mouse.mousesmagics.item;

import com.mouse.mousesmagics.MousesMagics;
import com.mouse.mousesmagics.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MousesMagics.MOD_ID);

    public static final Supplier<CreativeModeTab> MOUSES_MAGICS_TAB = CREATIVE_MODE_TAB.register("mouses_magics_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BOTTLE_OF_CURSES.get()))
                    .title(Component.translatable("creativetab.mousesmagics.mouses_magics"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.BOTTLE_OF_CURSES);
                        output.accept(ModItems.FOCUS);
                        output.accept(ModBlocks.BLOSSOM_CHALK);
                        output.accept(ModItems.ICE_LOLLY);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
