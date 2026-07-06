package com.mouse.mousesmagics.item.staffs.crystal_wrench;

import com.mouse.mousesmagics.item.staffs.MMStaffTiers;
import com.mouse.mousesmagics.utils.animations.MMDispatcher;
import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.item.weapons.StaffItem;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.acetheeldritchking.aces_spell_utils.utils.ASRarities;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Crystal_Wrench extends StaffItem {
    public final MMDispatcher dispatcher;

    public Crystal_Wrench() {
        super(ItemPropertiesHelper
                        .equipment(1)
                        .fireResistant()
                        .rarity(ASRarities.GLACIAL_RARITY_PROXY.getValue())
                        .attributes(ExtendedSwordItem
                                .createAttributes(MMStaffTiers.CRYSTAL_WRENCH)
                        )
        );
        this.dispatcher = new MMDispatcher();
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (!level.isClientSide && entity instanceof Player player )
        {
            dispatcher.idle(player, stack);
        }
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack,
                                @NotNull TooltipContext context,
                                @NotNull List<Component> lines,
                                @NotNull TooltipFlag flag) {
        super.appendHoverText(stack, context, lines, flag);

        lines.add(Component.translatable("item.mousesmagics.crystal_wrench.description")
                .withStyle(Style.EMPTY.withColor(15881518).withItalic(true)));
    }
}

