package net.dinoturto.createdd.item;

import net.dinoturto.createdd.CreateDD;
import net.dinoturto.createdd.registries.CreateDDItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.animal.Cow;

import java.util.Map;

public class ChromaticCompound extends Item {
    public ChromaticCompound(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack heldItem, Player player, LivingEntity entity, InteractionHand hand) {
        if (!(entity instanceof Blaze)) {
            return InteractionResult.PASS;
        }

        Level world = player.level();

        giveBlazeBrass(player, heldItem, hand);
        entity.discard();
        return InteractionResult.sidedSuccess(world.isClientSide);
    }

    protected void giveBlazeBrass(Player player, ItemStack heldItem, InteractionHand hand) {
        ItemStack filled = ItemUtils.createFilledResult(heldItem, player, new ItemStack(CreateDDItems.BLAZE_BRASS.get()));
        player.setItemInHand(hand, filled);
        /*ItemStack filled = new ItemStack(CreateDDItems.BLAZE_BRASS.get());
        if (!player.isCreative()) {
            heldItem.shrink(1);
        }
        if (heldItem.isEmpty()) {
            int itemIndex = player.getInventory().items.indexOf(heldItem);
            player.getInventory().removeItem(heldItem);
            player.getInventory().add(itemIndex, filled);
            System.out.println("gave blaze brass no stack");
            return;
        }
        player.getInventory().add(filled);
        System.out.println("gave blaze brass stack");
         */
    }
}
