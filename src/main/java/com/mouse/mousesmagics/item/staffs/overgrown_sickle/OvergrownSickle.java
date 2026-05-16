package com.mouse.mousesmagics.item.staffs.overgrown_sickle;

import com.mouse.mousesmagics.item.staffs.MMStaffTiers;
import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.item.weapons.StaffItem;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.acetheeldritchking.aces_spell_utils.utils.ASRarities;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;
import java.util.function.Consumer;

public class OvergrownSickle extends StaffItem {

    public OvergrownSickle() {
        super(
                ItemPropertiesHelper
                        .equipment(1)
                        .fireResistant()
                        .rarity(ASRarities.COSMIC_RARITY_PROXY.getValue())
                        .attributes(ExtendedSwordItem
                                .createAttributes(MMStaffTiers.OVERGROWN_SICKLE)
                        )
        );
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        boolean result = super.hurtEnemy(stack, target, attacker);

        if (!attacker.level().isClientSide) {
            boolean isCrit = false;

            if (attacker instanceof Player player) {
                isCrit =
                        player.fallDistance > 0.0F &&
                                !player.onGround() &&
                                !player.isInWater() &&
                                !player.hasEffect(net.minecraft.world.effect.MobEffects.BLINDNESS) &&
                                !player.isPassenger() &&
                                !player.isSprinting() &&
                                player.getMainHandItem() == stack;
            }

            if (isCrit) {
                attacker.level().playSound(
                        null,
                        target.getX(),
                        target.getY(),
                        target.getZ(),
                        SoundRegistry.SOULCALLER_TOLL_SUCCESS,
                        SoundSource.PLAYERS,
                        0.5f,
                        1.0f
                );
            }
        }

        return result;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack,
                                @NotNull TooltipContext context,
                                @NotNull List<Component> lines,
                                @NotNull TooltipFlag flag) {
        super.appendHoverText(stack, context, lines, flag);

        // Custom item description section
        lines.add(Component.translatable("item.mousesmagics.overgrownsickle.description")
                .withStyle(Style.EMPTY.withColor(15881518).withItalic(true)));
    }
}

