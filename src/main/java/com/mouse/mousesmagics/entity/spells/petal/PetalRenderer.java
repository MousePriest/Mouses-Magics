package com.mouse.mousesmagics.entity.spells.petal;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.mouse.mousesmagics.MousesMagics;
import com.mouse.mousesmagics.entity.spells.defenestration.DefenestrationModel;
import com.mouse.mousesmagics.entity.spells.defenestration.DefenestrationProjectile;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import javax.annotation.Nullable;

public class PetalRenderer extends GeoEntityRenderer<PetalProjectile> {
    private static final ResourceLocation TEXTURE = MousesMagics.namespacePath("textures/entity/petal_texture.png");

    public PetalRenderer(EntityRendererProvider.Context context) {
        super(context, new PetalModel());
        this.shadowRadius = 0f;
    }

    @Override
    public void preRender(PoseStack poseStack, PetalProjectile animatable, BakedGeoModel model,
                          @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer,
                          boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {

        Vec3 motion = animatable.getDeltaMovement();

        float xRot = (float) (-(Mth.atan2(motion.y, motion.horizontalDistance()) * (180F / Math.PI)));
        float yRot = -((float) (Mth.atan2(motion.z, motion.x) * (180F / (float) Math.PI)) + 90.0F) + 180.0F;

        poseStack.mulPose(Axis.YP.rotationDegrees(yRot));
        poseStack.mulPose(Axis.XP.rotationDegrees(xRot));

        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
    }

    @Override
    public ResourceLocation getTextureLocation(PetalProjectile entity) {
        return TEXTURE;
    }
}
