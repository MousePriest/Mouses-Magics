package com.mouse.mousesmagics.item;

import com.mouse.mousesmagics.MousesMagics;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MousesMagics.MOD_ID);

    public static final DeferredItem<Item> FOCUS = ITEMS.register("focus",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BOTTLE_OF_CURSES = ITEMS.register("bottle_of_curses",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
