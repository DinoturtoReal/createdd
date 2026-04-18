package net.dinoturto.createdd.datagen;

import net.dinoturto.createdd.CreateDD;
import net.dinoturto.createdd.registries.CreateDDBlocks;
import net.dinoturto.createdd.registries.CreateDDItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.ibm.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class CreateDDRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public CreateDDRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> TIN_SMELTABLES = List.of(CreateDDItems.RAW_TIN, CreateDDBlocks.TIN_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CreateDDBlocks.TIN_BLOCK.get())
                .pattern("TTT")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', CreateDDItems.TIN_INGOT.get())
                .unlockedBy("has_tin", has(CreateDDItems.TIN_INGOT)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CreateDDItems.TIN_INGOT.get(), 9)
                .requires(CreateDDBlocks.TIN_BLOCK.get())
                .unlockedBy("has_tin_block", has(CreateDDBlocks.TIN_BLOCK)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CreateDDItems.TIN_INGOT.get())
                .pattern("TTT")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', CreateDDItems.TIN_NUGGET.get())
                .unlockedBy("has_tin", has(CreateDDItems.TIN_NUGGET))
                .save(recipeOutput, "createdd:tin_ingot_from_nugget");

        oreSmelting(recipeOutput, TIN_SMELTABLES, RecipeCategory.MISC, CreateDDItems.TIN_INGOT.get(), 0.7f, 200, "tin_ingot");
        oreBlasting(recipeOutput, TIN_SMELTABLES, RecipeCategory.MISC, CreateDDItems.TIN_INGOT.get(), 0.7f, 100, "tin_ingot");
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, CreateDD.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
