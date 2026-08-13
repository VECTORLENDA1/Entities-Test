package net.vector.fixe.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.vector.fixe.entity.ModEntities;
import net.vector.fixe.entity.client.Fixe.FixeModel;
import net.vector.fixe.entity.client.MonkeyFuuu.MonkeyFuuuModel;
import net.vector.fixe.entity.custom.FixeEntity;
import net.vector.fixe.entity.custom.MonkeyFuuuEntity;
import net.vector.fixe.fixe;

@EventBusSubscriber(modid = fixe.MODID, bus = EventBusSubscriber.Bus.MOD)
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
