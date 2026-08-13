package net.vector.entitytests.entity.client.Fixe;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.vector.entitytests.entity.custom.FixeEntity;
import net.vector.entitytests.entitytests;

public class FixeRenderer extends MobRenderer<FixeEntity, FixeModel<FixeEntity>> {
    public FixeRenderer(EntityRendererProvider.Context context) {
        super(context, new FixeModel<>(context.bakeLayer(FixeModel.LAYER_LOCATION)), 0.25f); //Shadow underneath the entity
    }

    @Override
    public ResourceLocation getTextureLocation(FixeEntity Entity) {
        return ResourceLocation.fromNamespaceAndPath(entitytests.MODID,"textures/entity/fixe/fixe.png");
    }

    @Override
    public void render(FixeEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();

        if(entity.isBaby()) {
            poseStack.scale(0.5F,0.5F,0.5F);
        }else {
            poseStack.scale(1F,1F,1F);
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
        poseStack.popPose();
    }
}
