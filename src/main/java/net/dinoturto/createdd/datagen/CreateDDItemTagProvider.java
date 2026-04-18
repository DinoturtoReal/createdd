package net.dinoturto.createdd.datagen;

import net.dinoturto.createdd.CreateDD;
import net.dinoturto.createdd.registries.CreateDDItems;
import net.dinoturto.createdd.registries.CreateDDTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class CreateDDItemTagProvider extends ItemTagsProvider {
    public CreateDDItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                   CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, CreateDD.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(CreateDDTags.Items.INFABLOCKS)
                .add(CreateDDItems.STARGAZE_SINGULARITY.get());
    }
}
