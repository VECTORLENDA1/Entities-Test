package net.vector.entitytests.entity.client.MonkeyFuuu;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.vector.entitytests.entity.custom.MonkeyFuuuEntity;
import net.vector.entitytests.entitytests;

public class MonkeyFuuuModel<T extends MonkeyFuuuEntity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation( ResourceLocation.fromNamespaceAndPath(entitytests.MODID, "monkeyfuuu"), "main");

    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart bodychest;
    private final ModelPart leftarm;
    private final ModelPart rightarm;
    private final ModelPart leftleg;
    private final ModelPart rightleg;
    private final ModelPart tail;

    public MonkeyFuuuModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = this.body.getChild("head");
        this.bodychest = this.body.getChild("bodychest");
        this.leftarm = this.body.getChild("leftarm");
        this.rightarm = this.body.getChild("rightarm");
        this.leftleg = this.body.getChild("leftleg");
        this.rightleg = this.body.getChild("rightleg");
        this.tail = this.body.getChild("tail");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 25).addBox(-5.0F, -9.0F, -4.0F, 10.0F, 9.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(62, 26).addBox(-2.0F, -4.0F, -4.5F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -18.0F, 4.0F));

        PartDefinition bodychest = body.addOrReplaceChild("bodychest", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -18.0F, 1.0F, 14.0F, 18.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition leftarm = body.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(0, 56).addBox(7.0F, -16.0F, 1.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(47, 45).addBox(7.0F, -8.0F, 1.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(28, 58).addBox(7.0F, 0.0F, 1.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

        PartDefinition rightarm = body.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(17, 43).addBox(-10.0F, -16.0F, 1.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(32, 45).addBox(-10.0F, -8.0F, 1.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(58, 11).addBox(-10.0F, 0.0F, 1.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

        PartDefinition leftleg = body.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(15, 56).addBox(2.0F, -9.0F, -5.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(37, 25).addBox(1.0F, -2.0F, -8.0F, 5.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition LLeg_r1 = leftleg.addOrReplaceChild("LLeg_r1", CubeListBuilder.create().texOffs(41, 0).addBox(-2.5F, -3.5F, -1.5F, 5.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -5.3101F, -1.0594F, 0.6545F, 0.0F, 0.0F));

        PartDefinition rightleg = body.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(58, 0).addBox(-3.0F, -9.0F, -5.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(37, 35).addBox(-4.0F, -2.0F, -8.0F, 5.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, 0.0F));

        PartDefinition RLeg_r1 = rightleg.addOrReplaceChild("RLeg_r1", CubeListBuilder.create().texOffs(0, 43).addBox(-2.5F, -3.5F, -1.5F, 5.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -5.3101F, -1.0594F, 0.6545F, 0.0F, 0.0F));

        PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Tail_r1 = tail.addOrReplaceChild("Tail_r1", CubeListBuilder.create().texOffs(62, 40).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.9831F, 17.4396F, -0.2182F, 0.0F, 0.0F));

        PartDefinition Tail_r2 = tail.addOrReplaceChild("Tail_r2", CubeListBuilder.create().texOffs(62, 33).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.4035F, 14.2646F, 0.3927F, 0.0F, 0.0F));

        PartDefinition Tail_r3 = tail.addOrReplaceChild("Tail_r3", CubeListBuilder.create().texOffs(62, 19).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.0609F, 12.4632F, 1.1781F, 0.0F, 0.0F));

        PartDefinition Tail_r4 = tail.addOrReplaceChild("Tail_r4", CubeListBuilder.create().texOffs(41, 13).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.4658F, 11.3694F, 1.4399F, 0.0F, 0.0F));

        PartDefinition Tail_r5 = tail.addOrReplaceChild("Tail_r5", CubeListBuilder.create().texOffs(56, 58).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.183F, 10.049F, 1.0472F, 0.0F, 0.0F));

        PartDefinition Tail_r6 = tail.addOrReplaceChild("Tail_r6", CubeListBuilder.create().texOffs(43, 58).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 7.5F, 0.5236F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }


    @Override
    public void setupAnim(MonkeyFuuuEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        //this.animate(entity.idleAnimationState, MonkeyFuuuAnimations.fixe_animation_tail, ageInTicks, 6.5f);
    }

    public void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -40f, 40f);
        headPitch = Mth.clamp(headPitch, -15f, 25);

        this.head.yRot = headYaw * ((float)Math.PI / 180f);
        this.head.xRot = headPitch *  ((float)Math.PI / 180f);
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
