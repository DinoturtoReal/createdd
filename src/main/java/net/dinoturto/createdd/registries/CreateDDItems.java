package net.dinoturto.createdd.registries;

import net.dinoturto.createdd.CreateDD;
import net.dinoturto.createdd.item.ChromaticCompound;
import net.dinoturto.createdd.item.DrinkGeneric;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CreateDDItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CreateDD.MODID);

    public static final DeferredItem<Item> STARGAZE_SINGULARITY = ITEMS.register("stargaze_singularity",
            () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.EPIC).stacksTo(16)));
    public static final DeferredItem<Item> TIN_INGOT = ITEMS.register("tin_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_TIN = ITEMS.register("raw_tin",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TIN_NUGGET = ITEMS.register("tin_nugget",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BLAZE_BRASS = ITEMS.register("blaze_brass",
            () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final DeferredItem<Item> CHROMATIC_COMPOUND = ITEMS.register("chromatic_compound",
            () -> new ChromaticCompound(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final DeferredItem<Item> VANILLA_MILKSHAKE = ITEMS.register("vanilla_milkshake",
            () -> new DrinkGeneric(new Item.Properties().food(CreateDDFoodProperties.VANILLA_MILKSHAKE)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
