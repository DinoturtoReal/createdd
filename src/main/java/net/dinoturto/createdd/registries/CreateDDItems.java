package net.dinoturto.createdd.registries;

import net.dinoturto.createdd.CreateDD;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CreateDDItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CreateDD.MODID);

    public static final DeferredItem<Item> STARGAZE_SINGULARITY = ITEMS.register("stargaze_singularity",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TIN_INGOT = ITEMS.register("tin_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_TIN = ITEMS.register("raw_tin",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
