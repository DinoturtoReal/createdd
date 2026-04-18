package net.dinoturto.createdd.item;

import net.createmod.catnip.math.VecHelper;
import net.dinoturto.createdd.CreateDD;
import net.dinoturto.createdd.registries.CreateDDItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
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
import net.minecraft.world.phys.Vec3;

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

        spawnCaptureEffects(world, entity.position());
        if (world.isClientSide()) {
            return InteractionResult.FAIL;
        }

        giveBlazeBrass(player, heldItem, hand);
        entity.discard();
        return InteractionResult.FAIL;
    }

    protected void giveBlazeBrass(Player player, ItemStack heldItem, InteractionHand hand) {
        ItemStack filled = ItemUtils.createFilledResult(heldItem, player, CreateDDItems.BLAZE_BRASS.get().getDefaultInstance(), false);
        player.setItemInHand(hand, filled);
    }

    private void spawnCaptureEffects(Level world, Vec3 vec) {
        if (world.isClientSide) {
            for (int i = 0; i < 40; i++) {
                Vec3 motion = VecHelper.offsetRandomly(Vec3.ZERO, world.random, .125f);
                world.addParticle(ParticleTypes.FLAME, vec.x, vec.y, vec.z, motion.x, motion.y, motion.z);
                world.addParticle(ParticleTypes.SMOKE, vec.x, vec.y, vec.z, motion.x, motion.y, motion.z);
                world.addParticle(ParticleTypes.LAVA, vec.x, vec.y, vec.z, motion.x, motion.y, motion.z);
                Vec3 circle = motion.multiply(1, 0, 1)
                        .normalize()
                        .scale(.5f);
                world.addParticle(ParticleTypes.SMOKE, circle.x, vec.y, circle.z, 0, -0.125, 0);
            }
            return;
        }

        BlockPos soundPos = BlockPos.containing(vec);
        world.playSound(null, soundPos, SoundEvents.BLAZE_HURT, SoundSource.PLAYERS, .25f, .5f);
        world.playSound(null, soundPos, SoundEvents.BLAZE_DEATH, SoundSource.PLAYERS, .5f, .75f);
        world.playSound(null, soundPos, SoundEvents.FIRE_EXTINGUISH, SoundSource.PLAYERS, .5f, .75f);
    }
}
