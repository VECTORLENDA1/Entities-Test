package net.vector.entitytests.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.vector.entitytests.entity.ModEntities;

import static net.vector.entitytests.entitytests.MODID;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);


    public static final DeferredItem<Item> FIXE_SPAWN_EGG = ITEMS.register("fixe_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.FIXE, 0x31afaf, 0xffac00,
                    new Item.Properties()));

    public static final DeferredItem<Item> MONKEYFUUU_SPAWN_EGG = ITEMS.register("monkeyfuuu_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.MONKEYFUUU, 0x31afaf, 0xffac00,
                    new Item.Properties()));

    public static void Register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
