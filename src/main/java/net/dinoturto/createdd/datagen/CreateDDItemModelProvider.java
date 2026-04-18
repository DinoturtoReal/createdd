package net.dinoturto.createdd.datagen;

import net.dinoturto.createdd.CreateDD;
import net.dinoturto.createdd.registries.CreateDDItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class CreateDDItemModelProvider extends ItemModelProvider {
    public CreateDDItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CreateDD.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(CreateDDItems.TIN_INGOT.get());
        basicItem(CreateDDItems.RAW_TIN.get());
        basicItem(CreateDDItems.VANILLA_MILKSHAKE.get());
        basicItem(CreateDDItems.BLAZE_BRASS.get());
        basicItem(CreateDDItems.CHROMATIC_COMPOUND.get());
        basicItem(CreateDDItems.COAL_PIECE.get());
        basicItem(CreateDDItems.STARGAZE_SINGULARITY.get());
        basicItem(CreateDDItems.TIN_NUGGET.get());
    }
}
