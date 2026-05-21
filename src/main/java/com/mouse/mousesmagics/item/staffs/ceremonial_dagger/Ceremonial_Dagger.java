package com.mouse.mousesmagics.item.staffs.ceremonial_dagger;

import com.mouse.mousesmagics.item.staffs.MMStaffTiers;
import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.item.weapons.StaffItem;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.acetheeldritchking.aces_spell_utils.utils.ASRarities;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Ceremonial_Dagger extends StaffItem {

    public Ceremonial_Dagger() {
        super(
                ItemPropertiesHelper
                        .equipment(1)
                        .fireResistant()
                        .rarity(ASRarities.FORBIDDEN_RARITY_PROXY.getValue())
                        .attributes(ExtendedSwordItem
                                .createAttributes(MMStaffTiers.CEREMONIAL_DAGGER)
                        )
        );
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack,
                                @NotNull TooltipContext context,
                                @NotNull List<Component> lines,
                                @NotNull TooltipFlag flag) {
        super.appendHoverText(stack, context, lines, flag);
    }
}

