package net.vector.fixe.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;

import static net.vector.fixe.fixe.MODID;

public class ModCreativeModTabs {
    public static final net.neoforged.neoforge.registries.DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            net.neoforged.neoforge.registries.DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> FIXE = CREATIVE_MODE_TABS.register("fixe",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetab.fixe"))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .icon(() -> ModItems.FIXE_SPAWN_EGG.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {


                        //EGGS//
                        output.accept(ModItems.FIXE_SPAWN_EGG.get());
                        output.accept(ModItems.MONKEYFUUU_SPAWN_EGG.get());

                    })
                    .build());

    public static void register(net.neoforged.bus.api.IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
