package net.vector.entitytests.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.vector.entitytests.entity.custom.FixeEntity;
import net.vector.entitytests.entity.custom.MonkeyFuuuEntity;

import java.util.function.Supplier;

import static net.vector.entitytests.entitytests.MODID;


public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, MODID);

    public static final Supplier<EntityType<FixeEntity>> FIXE =
            ENTITY_TYPES.register("fixe", () -> EntityType.Builder.of(FixeEntity::new, MobCategory.WATER_AMBIENT)
                    .sized(1.0f, 0.4f).eyeHeight(0.26F).clientTrackingRange(4).build("fixe")); //How big or small is the HitBox of the entity

    public static final Supplier<EntityType<MonkeyFuuuEntity>> MONKEYFUUU =
            ENTITY_TYPES.register("monkeyfuuu", () -> EntityType.Builder.of(MonkeyFuuuEntity::new, MobCategory.AMBIENT)
                    .sized(1f, 1.35f).eyeHeight(1.2F).clientTrackingRange(4).build("monkeyfuuu")); //How big or small is the HitBox of the entity


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
