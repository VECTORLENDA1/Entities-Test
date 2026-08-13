package net.vector.entitytests.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.vector.entitytests.entity.ModEntities;
import net.vector.entitytests.entity.client.Fixe.FixeModel;
import net.vector.entitytests.entity.client.MonkeyFuuu.MonkeyFuuuModel;
import net.vector.entitytests.entity.custom.FixeEntity;
import net.vector.entitytests.entity.custom.MonkeyFuuuEntity;
import net.vector.entitytests.entitytests;

@EventBusSubscriber(modid = entitytests.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(FixeModel.LAYER_LOCATION, FixeModel::createBodyLayer);
        event.registerLayerDefinition(MonkeyFuuuModel.LAYER_LOCATION, MonkeyFuuuModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.FIXE.get(), FixeEntity.createAttributes().build());
        event.put(ModEntities.MONKEYFUUU.get(), MonkeyFuuuEntity.createAttributes().build());
    }
}
