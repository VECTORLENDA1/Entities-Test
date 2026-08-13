package net.vector.entitytests.entity.client.Fixe;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.vector.entitytests.entity.custom.FixeEntity;
import net.vector.entitytests.entitytests;

public class FixeModel<T extends FixeEntity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation( ResourceLocation.fromNamespaceAndPath(entitytests.MODID, "fixe"), "main");

    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart RightFin;
    private final ModelPart LeftFin;
    private final ModelPart BodyTail;
    private final ModelPart tail;

    public FixeModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = this.body.getChild("head");
        this.RightFin = this.body.getChild("RightFin");
        this.LeftFin = this.body.getChild("LeftFin");
        this.BodyTail = this.body.getChild("BodyTail");
        this.tail = this.body.getChild("tail");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-9.5714F, -2.5714F, -2.1429F, 12.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4286F, 20.5714F, 4.1429F, 0.0F, -1.5708F, 0.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(12, 10).addBox(-6.0F, -3.2F, -2.0F, 4.0F, 4.4F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(10, 20).addBox(-7.0F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.5714F, 1.4286F, 0.8571F));

        PartDefinition RightFin = body.addOrReplaceChild("RightFin", CubeListBuilder.create(), PartPose.offset(-3.5714F, -1.5714F, 1.8571F));

        PartDefinition FinR_r1 = RightFin.addOrReplaceChild("FinR_r1", CubeListBuilder.create().texOffs(12, 16).addBox(0.0F, -2.0F, 0.0F, 6.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 1.8F, 0.0F, 0.0F, -0.1745F, 0.0F));

        PartDefinition LeftFin = body.addOrReplaceChild("LeftFin", CubeListBuilder.create(), PartPose.offset(-3.5714F, -1.5714F, -2.1429F));

        PartDefinition FinL_r1 = LeftFin.addOrReplaceChild("FinL_r1", CubeListBuilder.create().texOffs(12, 16).addBox(0.0F, -2.0F, 0.0F, 6.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 1.8F, 0.0F, 0.0F, 0.1745F, 0.0F));

        PartDefinition BodyTail = body.addOrReplaceChild("BodyTail", CubeListBuilder.create().texOffs(0, 10).addBox(-1.0F, -2.0F, -1.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 20).addBox(1.0F, -1.0F, -0.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.4286F, 0.4286F, -0.1429F));

        PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(16, 20).addBox(5.0F, -0.7F, 0.0F, 2.0F, 1.4F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(2.4286F, 0.4286F, -0.1429F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(FixeEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.animate(entity.idleAnimationState, FixeAnimations.fixe_animation_tail, ageInTicks, 6.5f);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return body;
    }
}
