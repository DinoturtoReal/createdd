package net.dinoturto.createdd.datagen;

import net.dinoturto.createdd.registries.CreateDDBlocks;
import net.dinoturto.createdd.registries.CreateDDItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class CreateDDBlockLootTableProvider extends BlockLootSubProvider {
    protected CreateDDBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(CreateDDBlocks.TIN_BLOCK.get());

        add(CreateDDBlocks.TIN_ORE.get(),
                block -> createOreDrop(CreateDDBlocks.TIN_ORE.get(), CreateDDItems.RAW_TIN.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return CreateDDBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
