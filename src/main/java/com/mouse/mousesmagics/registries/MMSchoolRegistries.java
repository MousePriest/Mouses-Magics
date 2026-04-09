package com.mouse.mousesmagics.registries;

import com.mouse.mousesmagics.MousesMagics;
import com.mouse.mousesmagics.utils.MMTags;
import io.redspace.ironsspellbooks.api.spells.SchoolType;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static io.redspace.ironsspellbooks.api.registry.SchoolRegistry.SCHOOL_REGISTRY_KEY;

public class MMSchoolRegistries {
    private static final DeferredRegister<SchoolType> MOUSES_SCHOOLS = DeferredRegister.create(SCHOOL_REGISTRY_KEY, MousesMagics.MOD_ID);

    public static void register(IEventBus eventBus)
    {
        MOUSES_SCHOOLS.register(eventBus);
    }

    private static Supplier<SchoolType> registerSchool(SchoolType type)
    {
        return MOUSES_SCHOOLS.register(type.getId().getPath(), () -> type);
    }

    //Dew
    public static final ResourceLocation DEW_RESOURCE = ResourceLocation.fromNamespaceAndPath(MousesMagics.MOD_ID, "dew");

    public static final Supplier<SchoolType> DEW = registerSchool(new SchoolType
            (
                    DEW_RESOURCE,
                    MMTags.DEW_FOCUS,
                    Component.translatable("school.mousesmagics.dew").withStyle(Style.EMPTY.withColor(0x36156c)),
                    MMAttributeRegistries.DEW_MAGIC_POWER,
                    MMAttributeRegistries.DEW_MAGIC_RESIST,
                    SoundRegistry.ENDER_CAST,
                    MMDamageTypes.DEW_MAGIC
            ));
}
