package net.dinoturto.createdd.registries;

import net.dinoturto.createdd.CreateDD;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CreateDDCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateDD.MODID);

    public static final Supplier<CreativeModeTab> CREATE_DD_TAB = CREATIVE_MODE_TAB.register("createdd_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(CreateDDItems.STARGAZE_SINGULARITY.get()))
                    .title(Component.translatable("creativetab.createdd.createdd"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(CreateDDItems.STARGAZE_SINGULARITY);
                        output.accept(CreateDDItems.TIN_INGOT);
                        output.accept(CreateDDItems.RAW_TIN);
                        output.accept(CreateDDItems.TIN_NUGGET);
                        output.accept(CreateDDBlocks.TIN_ORE);
                        output.accept(CreateDDBlocks.TIN_BLOCK);
                        output.accept(CreateDDItems.BLAZE_BRASS);
                        output.accept(CreateDDItems.CHROMATIC_COMPOUND);
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
