package net.dinoturto.createdd.datagen;

import net.dinoturto.createdd.CreateDD;
import net.dinoturto.createdd.registries.CreateDDBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class CreateDDBlockTagProvider extends BlockTagsProvider {
    public CreateDDBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CreateDD.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(CreateDDBlocks.TIN_BLOCK.get())
                .add(CreateDDBlocks.TIN_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(CreateDDBlocks.TIN_ORE.get());
    }
}
