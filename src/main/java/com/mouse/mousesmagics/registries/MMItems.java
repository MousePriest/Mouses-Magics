package com.mouse.mousesmagics.registries;

import com.mouse.mousesmagics.MousesMagics;
import com.mouse.mousesmagics.item.spellbooks.GardeningGuide;
import com.mouse.mousesmagics.item.staffs.MMStaffTiers;
import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.compat.Curios;
import io.redspace.ironsspellbooks.item.SpellBook;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.item.weapons.StaffItem;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MMItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MousesMagics.MOD_ID);

    //Dew focus
    public static final DeferredItem<Item> FOCUS = ITEMS.register("focus",
            () -> new Item(new Item.Properties()));
    //Dew staffs
    public static final DeferredHolder<Item, Item> OVERGROWN_SICKLE = ITEMS.register("overgrown_sickle", () ->
            new StaffItem(ItemPropertiesHelper.equipment(1).attributes(ExtendedSwordItem.createAttributes(MMStaffTiers.OVERGROWN_SICKLE))));
    //Dew books
    public static final DeferredHolder<Item, Item> GARDENING_GUIDE = ITEMS.register
            ("gardening_guide", GardeningGuide::new);

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
