package com.mouse.mousesmagics.item.armour.blossom_bandit;

import com.mouse.mousesmagics.MousesMagics;
import com.mouse.mousesmagics.entity.armour.BlossomBanditArmourModel;
import com.mouse.mousesmagics.registries.MMAttributeRegistries;
import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import io.redspace.ironsspellbooks.item.armor.IArmorCapeProvider;
import io.redspace.ironsspellbooks.item.armor.ImbuableChestplateArmorItem;
import io.redspace.ironsspellbooks.registries.ArmorMaterialRegistry;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class BlossomBanditArmourItem extends ImbuableChestplateArmorItem implements IArmorCapeProvider {
    public BlossomBanditArmourItem(Type slot, Properties settings) {
        super(ArmorMaterialRegistry.SCHOOL, slot, settings, schoolAttributes(MMAttributeRegistries.DEW_MAGIC_POWER));
    }

    @Override
    public ResourceLocation getCapeResourceLocation() {
        return ResourceLocation.fromNamespaceAndPath(MousesMagics.MOD_ID, "textures/armour/blossom_bandit_cape.png");
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new GenericCustomArmorRenderer<>(new BlossomBanditArmourModel());
    }
}
