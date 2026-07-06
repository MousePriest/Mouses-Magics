package com.mouse.mousesmagics.item.staffs.crystal_wrench;

import com.mouse.mousesmagics.MousesMagics;
import mod.azure.azurelib.common.animation.controller.AzAnimationController;
import mod.azure.azurelib.common.animation.controller.AzAnimationControllerContainer;
import mod.azure.azurelib.common.animation.impl.AzItemAnimator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class Crystal_WrenchAnimator extends AzItemAnimator {
    private static final ResourceLocation ANIMATIONS = ResourceLocation.fromNamespaceAndPath(
            MousesMagics.MOD_ID,
            "animations/item/staves/crystal_wrench.animation.json"
    );

    @Override
    public void registerControllers(AzAnimationControllerContainer<ItemStack> animationControllerContainer) {
        animationControllerContainer.add(
                AzAnimationController.builder(this, "base_controller")
                        .build()
        );
    }

    @Override
    public @NotNull ResourceLocation getAnimationLocation(ItemStack animatable) {
        return ANIMATIONS;
    }
}

