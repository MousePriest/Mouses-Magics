package com.mouse.mousesmagics.utils.animations;

import mod.azure.azurelib.common.animation.dispatch.command.AzCommand;
import mod.azure.azurelib.common.animation.play_behavior.AzPlayBehaviors;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

public class MMDispatcher {
    private static final AzCommand IDLE = AzCommand.create(
            "base_controller",
            "idle",
            AzPlayBehaviors.LOOP
    );

    public void idle(Entity entity, ItemStack itemStack) {
        IDLE.sendForItem(entity, itemStack);
    }
}
