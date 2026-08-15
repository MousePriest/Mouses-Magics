package com.mouse.mousesmagics.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.mouse.mousesmagics.entity.spells.floral_spear.FloralSpearRenderer;
import com.mouse.mousesmagics.registries.SpellRegistries;
import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMob;
import io.redspace.ironsspellbooks.player.ClientMagicData;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class MMChargeSpellLayer {
    public static class Vanilla<T extends LivingEntity, M extends HumanoidModel<T>> extends RenderLayer<T, M> {

        public Vanilla(RenderLayerParent<T, M> pRenderer) {
            super(pRenderer);
        }

        @Override
        public void render(PoseStack poseStack, MultiBufferSource bufferSource, int pPackedLight, T entity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
            var syncedSpellData = ClientMagicData.getSyncedSpellData(entity);
            if (!syncedSpellData.isCasting()) {
                return;
            }
            var spellId = syncedSpellData.getCastingSpellId();
            poseStack.pushPose();
            this.getParentModel().translateToHand(HumanoidArm.RIGHT, poseStack);
            handleRender(poseStack, bufferSource, pPackedLight, entity, spellId, false);
            poseStack.popPose();
        }
    }

    private static <T extends LivingEntity> void handleRender(PoseStack poseStack, MultiBufferSource bufferSource, int pPackedLight, T entity, String spellId, boolean offhand) {
        if (spellId.equals(SpellRegistries.FLORAL_SPEAR.get().getSpellId())) {
            poseStack.translate((double) ((float) (offhand ? -1 : 1) / 32.0F) - .125, .5, 0);
            poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
            FloralSpearRenderer.renderModel(poseStack, bufferSource, entity.tickCount);
        }
    }

    public static class Geo extends GeoRenderLayer<AbstractSpellCastingMob> {
        public Geo(GeoEntityRenderer<AbstractSpellCastingMob> entityRenderer) {
            super(entityRenderer);
        }

        @Override
        public void renderForBone(PoseStack poseStack, AbstractSpellCastingMob animatable, GeoBone bone, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
            super.renderForBone(poseStack, animatable, bone, renderType, bufferSource, buffer, partialTick, packedLight, packedOverlay);
            if (bone.getName().equals("right_arm")) {
                poseStack.pushPose();
                var syncedSpellData = ClientMagicData.getSyncedSpellData(animatable);
                var spellId = syncedSpellData.getCastingSpellId();
                var scaleinv = 1 / animatable.getScale();
                poseStack.translate(0, 0.5, 0);
                poseStack.scale(scaleinv, scaleinv, scaleinv);
                if (!spellId.equals("mousesmagics:floral_spear")) {
                    poseStack.mulPose(Axis.XP.rotationDegrees(180.0F));
                }
//                                poseStack.translate(bone.getPivotX() / 16.0F, bone.getPivotY() / 16.0F, bone.getPivotZ() / 16.0F);
                handleRender(poseStack, bufferSource, packedLight, animatable, spellId, false);
                poseStack.popPose();
            }
        }
    }
}
