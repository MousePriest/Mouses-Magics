package com.mouse.mousesmagics.item;

import com.mouse.mousesmagics.MousesMagics;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MousesMagics.MOD_ID);

    //Dew focus
    public static final DeferredItem<Item> FOCUS = ITEMS.register("focus",
            () -> new Item(new Item.Properties()));
    //Hex focus
    public static final DeferredItem<Item> BOTTLE_OF_CURSES = ITEMS.register("bottle_of_curses",
            () -> new Item(new Item.Properties()));
    //Ace reference
    public static final DeferredItem<Item> ICE_LOLLY = ITEMS.register("ice_lolly",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).food(Foods.CHORUS_FRUIT).component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
