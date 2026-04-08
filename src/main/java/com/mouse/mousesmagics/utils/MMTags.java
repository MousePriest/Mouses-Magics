package com.mouse.mousesmagics.utils;

import com.mouse.mousesmagics.MousesMagics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class MMTags {
    //Dew school focus
    public static final TagKey<Item> DEW_FOCUS = ItemTags.create(
            ResourceLocation.parse(MousesMagics.namespacePath("dew_focus")).toString());
}
