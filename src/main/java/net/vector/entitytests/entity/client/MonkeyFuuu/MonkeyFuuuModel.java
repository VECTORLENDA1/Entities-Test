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
    private final ModelPart leftarm1;
    private final ModelPart leftarm2;
    private final ModelPart rightarm;
    private final ModelPart rightarm1;
    private final ModelPart rightarm2;
    private final ModelPart leftleg;
    private final ModelPart leftleg1;
    private final ModelPart leftleg2;
    private final ModelPart leftleg3;
    private final ModelPart rightleg;
    private final ModelPart rightleg1;
    private final ModelPart rightleg2;
    private final ModelPart rightleg3;
    private final ModelPart tail;
    private final ModelPart tail1;
    private final ModelPart tail2;
    private final ModelPart tail3;
    private final ModelPart tail4;
    private final ModelPart tail5;
    private final ModelPart tail6;

    public MonkeyFuuuModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = this.body.getChild("head");
        this.bodychest = this.body.getChild("bodychest");
        this.leftarm = this.body.getChild("leftarm");
        this.leftarm1 = this.leftarm.getChild("leftarm1");
        this.leftarm2 = this.leftarm.getChild("leftarm2");
        this.rightarm = this.body.getChild("rightarm");
        this.rightarm1 = this.rightarm.getChild("rightarm1");
        this.rightarm2 = this.rightarm.getChild("rightarm2");
        this.leftleg = this.body.getChild("leftleg");
        this.leftleg1 = this.leftleg.getChild("leftleg1");
        this.leftleg2 = this.leftleg.getChild("leftleg2");
        this.leftleg3 = this.leftleg.getChild("leftleg3");
        this.rightleg = this.body.getChild("rightleg");
        this.rightleg1 = this.rightleg.getChild("rightleg1");
        this.rightleg2 = this.rightleg.getChild("rightleg2");
        this.rightleg3 = this.rightleg.getChild("rightleg3");
        this.tail = this.body.getChild("tail");
        this.tail1 = this.tail.getChild("tail1");
        this.tail2 = this.tail.getChild("tail2");
        this.tail3 = this.tail.getChild("tail3");
        this.tail4 = this.tail.getChild("tail4");
        this.tail5 = this.tail.getChild("tail5");
        this.tail6 = this.tail.getChild("tail6");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 25).addBox(-5.0F, -6.0F, -4.0F, 10.0F, 9.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(62, 26).addBox(-2.0F, -1.0F, -4.5F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, -6.0F, 0.1745F, 0.0F, 0.0F));

        PartDefinition bodychest = body.addOrReplaceChild("bodychest", CubeListBuilder.create(), PartPose.offset(0.0F, -17.5F, 5.0F));

        PartDefinition Body_r1 = bodychest.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -9.0F, -3.0F, 14.0F, 18.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.7058F, -3.5F, 1.309F, 0.0F, 0.0F));

        PartDefinition leftarm = body.addOrReplaceChild("leftarm", CubeListBuilder.create(), PartPose.offset(6.5F, -18.0F, -3.0F));

        PartDefinition leftarm1 = leftarm.addOrReplaceChild("leftarm1", CubeListBuilder.create().texOffs(0, 56).addBox(0.5F, -1.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition leftarm2 = leftarm.addOrReplaceChild("leftarm2", CubeListBuilder.create().texOffs(47, 45).addBox(7.0F, -8.0F, 1.0F, 3.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.5F, 15.0F, -3.0F));

        PartDefinition rightarm = body.addOrReplaceChild("rightarm", CubeListBuilder.create(), PartPose.offset(-6.5F, -18.0F, -3.0F));

        PartDefinition rightarm1 = rightarm.addOrReplaceChild("rightarm1", CubeListBuilder.create().texOffs(17, 43).addBox(-3.5F, -1.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition rightarm2 = rightarm.addOrReplaceChild("rightarm2", CubeListBuilder.create().texOffs(32, 45).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 7.0F, 0.0F));

        PartDefinition leftleg = body.addOrReplaceChild("leftleg", CubeListBuilder.create(), PartPose.offset(3.5F, -13.0F, 7.0F));

        PartDefinition leftleg1 = leftleg.addOrReplaceChild("leftleg1", CubeListBuilder.create(), PartPose.offset(0.0F, 5.0F, -10.5F));

        PartDefinition LLeg1_r1 = leftleg1.addOrReplaceChild("LLeg1_r1", CubeListBuilder.create().texOffs(41, 0).addBox(1.0F, -4.5F, -1.5F, 5.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -2.5168F, 9.0494F, 2.5744F, 0.0F, 0.0F));

        PartDefinition leftleg2 = leftleg.addOrReplaceChild("leftleg2", CubeListBuilder.create().texOffs(15, 56).addBox(2.0F, -9.0F, 3.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 13.0F, -7.0F));

        PartDefinition leftleg3 = leftleg.addOrReplaceChild("leftleg3", CubeListBuilder.create().texOffs(37, 25).addBox(1.0F, -2.0F, 0.0F, 5.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 13.0F, -7.0F));

        PartDefinition rightleg = body.addOrReplaceChild("rightleg", CubeListBuilder.create(), PartPose.offset(-3.5F, -13.0F, 7.0F));

        PartDefinition rightleg1 = rightleg.addOrReplaceChild("rightleg1", CubeListBuilder.create(), PartPose.offset(0.0F, 5.0F, -10.5F));

        PartDefinition RLeg1_r1 = rightleg1.addOrReplaceChild("RLeg1_r1", CubeListBuilder.create().texOffs(0, 43).addBox(-6.0F, -4.5F, -1.5F, 5.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -2.5168F, 9.0494F, 2.5744F, 0.0F, 0.0F));

        PartDefinition rightleg2 = rightleg.addOrReplaceChild("rightleg2", CubeListBuilder.create().texOffs(58, 0).addBox(-3.0F, -9.0F, 3.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 13.0F, -7.0F));

        PartDefinition rightleg3 = rightleg.addOrReplaceChild("rightleg3", CubeListBuilder.create().texOffs(37, 35).addBox(-4.0F, -2.0F, 0.0F, 5.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 13.0F, -7.0F));

        PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -27.1352F, 3.8177F, 1.0908F, 0.0F, 0.0F));

        PartDefinition tail1 = tail.addOrReplaceChild("tail1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Tail1_r1 = tail1.addOrReplaceChild("Tail1_r1", CubeListBuilder.create().texOffs(44, 62).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.1352F, -5.0177F, 0.5236F, 0.0F, 0.0F));

        PartDefinition tail2 = tail.addOrReplaceChild("tail2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Tail2_r1 = tail2.addOrReplaceChild("Tail2_r1", CubeListBuilder.create().texOffs(59, 62).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.9522F, -2.4686F, 1.0472F, 0.0F, 0.0F));

        PartDefinition tail3 = tail.addOrReplaceChild("tail3", CubeListBuilder.create(), PartPose.offset(0.0F, 4.1823F, -1.4525F));

        PartDefinition Tail3_r1 = tail3.addOrReplaceChild("Tail3_r1", CubeListBuilder.create().texOffs(41, 13).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5128F, 0.3042F, 1.4399F, 0.0F, 0.0F));

        PartDefinition tail4 = tail.addOrReplaceChild("tail4", CubeListBuilder.create(), PartPose.offset(-0.2953F, -1.3747F, -0.3631F));

        PartDefinition Tail4_r1 = tail4.addOrReplaceChild("Tail4_r1", CubeListBuilder.create().texOffs(62, 19).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2953F, -1.551F, 0.3087F, 1.1781F, 0.0F, 0.0F));

        PartDefinition tail5 = tail.addOrReplaceChild("tail5", CubeListBuilder.create(), PartPose.offset(0.0F, -4.6596F, 0.5088F));

        PartDefinition Tail5_r1 = tail5.addOrReplaceChild("Tail5_r1", CubeListBuilder.create().texOffs(62, 33).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.6087F, 1.2381F, 0.3927F, 0.0F, 0.0F));

        PartDefinition tail6 = tail.addOrReplaceChild("tail6", CubeListBuilder.create(), PartPose.offset(0.0F, -6.2396F, 3.4101F));

        PartDefinition Tail6_r1 = tail6.addOrReplaceChild("Tail6_r1", CubeListBuilder.create().texOffs(62, 40).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.3918F, 1.5119F, -0.2182F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }


    @Override
    public void setupAnim(MonkeyFuuuEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animate(entity.idleAnimationState, MonkeyFuuuAnimations.monkeyfuuu_idle, ageInTicks, 1f);
        this.animateWalk(MonkeyFuuuAnimations.monkeyfuuu_walk, limbSwing, limbSwingAmount, 2f, 2.5f);
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
