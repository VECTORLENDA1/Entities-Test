package net.vector.entitytests.entity.client.MonkeyFuuu;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.vector.entitytests.entity.custom.MonkeyFuuuEntity;
import net.vector.entitytests.entitytests;

public class MonkeyFuuuRenderer extends MobRenderer<MonkeyFuuuEntity, MonkeyFuuuModel<MonkeyFuuuEntity>> {
    public MonkeyFuuuRenderer(EntityRendererProvider.Context context) {
        super(context, new MonkeyFuuuModel<>(context.bakeLayer(MonkeyFuuuModel.LAYER_LOCATION)), 0.55f); //Shadow underneath the entity
    }

    @Override
    public ResourceLocation getTextureLocation(MonkeyFuuuEntity Entity) {
        return ResourceLocation.fromNamespaceAndPath(entitytests.MODID,"textures/entity/monkeyfuuu/monkeyfuuu.png");
    }

    @Override
    public void render(MonkeyFuuuEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();

        if(entity.isBaby()) {
            poseStack.scale(0.4F,0.4F,0.4F); //How big or small the entities are
        }else {
            poseStack.scale(0.8F,0.8F,0.8F); //How big or small the entities are
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
        poseStack.popPose();
    }
}
