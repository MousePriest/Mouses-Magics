package com.mouse.mousesmagics.entity.mobs.wizards.gardener;

import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class GardenerRenderer extends AbstractSpellCastingMobRenderer {

    public GardenerRenderer(EntityRendererProvider.Context context) {
        super(context, new GardenerModel());
    }
}
