package net.dinoturto.createdd.datagen;

import net.dinoturto.createdd.CreateDD;
import net.dinoturto.createdd.registries.CreateDDBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class CreateDDBlockStateProvider extends BlockStateProvider {
    public CreateDDBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CreateDD.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(CreateDDBlocks.TIN_BLOCK);
        blockWithItem(CreateDDBlocks.TIN_ORE);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
