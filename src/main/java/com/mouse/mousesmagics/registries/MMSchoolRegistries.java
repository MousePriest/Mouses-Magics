package com.mouse.mousesmagics.registries;

import com.mouse.mousesmagics.MousesMagics;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.SchoolType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class MMSchoolRegistry extends SchoolRegistry {

    private static final DeferredRegister<SchoolType> MM_SCHOOLS = DeferredRegister.create(SCHOOL_REGISTRY_KEY, MousesMagics.MOD_ID);


    public static void register(IEventBus eventBus) {

        MM_SCHOOLS.register(eventBus);
    }


    private static Supplier<SchoolType> registerSchool(SchoolType type) {
        return MM_SCHOOLS.register(type.getId().getPath(), () -> type);
    }


    @Nullable
    public static SchoolType getSchoolFromFocus(ItemStack focusStack) {
        for (SchoolType school : REGISTRY) {
            if (school.isFocus(focusStack)) {
                return school;
            }
        }
        return null;
    }

    public static final ResourceLocation DEW_RESOURCE = ResourceLocation.fromNamespaceAndPath(MousesMagics.MOD_ID, "dew");

    public static final Supplier<SchoolType> DEW = registerSchool(new SchoolType(
            ASTRAL_RESOURCE,
            ASARTags.ASTRAL_FOCUS,
            Component.translatable("school.mousesmagics.dew").withColor(7231167),
            ASARAttributeRegistry.ASTRAL_SPELL_POWER,
            ASARAttributeRegistry.ASTRAL_MAGIC_RESIST,
            ASARSoundsRegistry.ASTRAL_CAST_IMPACT_LOW,
            ASARDamageTypes.ASTRAL_MAGIC
    ));
}