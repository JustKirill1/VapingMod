package com.Juski.vapemod.item.custom;

import java.util.function.Predicate;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import static java.lang.Math.*;

public class VapeAegisHero extends ProjectileWeaponItem implements Vanishable {

    public static final int MAX_DRAW_DURATION = 20;
    public static final int DEFAULT_RANGE = 15;

    public VapeAegisHero(Item.Properties properties) {
        super(properties);
    }



    public void releaseUsing(ItemStack stack, Level level, LivingEntity entity, int i) {

        if (entity instanceof Player player) {
            outputSuccess(player);
            i = this.getUseDuration(stack) - i;
            spawnFoundParticles(player, stack, i);
            player.getCooldowns().addCooldown(this, 60);
        }
    }
    public static float getPowerForTime(int i) {
        float f = (float)i / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    public int getUseDuration(ItemStack itemStack) {
        return 72000;
    }

    public UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.BOW;
    }

//    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
//        ItemStack itemstack = player.getItemInHand(hand);
//        boolean flag = !player.getProjectile(itemstack).isEmpty();
//
//        InteractionResultHolder<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, level, player, hand, flag);
//        if (ret != null) return ret;
//
//        if (!player.getAbilities().instabuild && !flag) {
//            return InteractionResultHolder.fail(itemstack);
//        } else {
//            player.startUsingItem(hand);
//            return InteractionResultHolder.consume(itemstack);
//        }
//    }

    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ARROW_ONLY;
    }

//    public AbstractArrow customArrow(AbstractArrow arrow) {
//        return arrow;
//    }

    public int getDefaultProjectileRange() {
        return 15;
    }
    private void outputSuccess(Player player) {
        player.sendSystemMessage(Component.literal("Отпустили кнопку"));
    }
    private void spawnFoundParticles(Player player, ItemStack stack, int b) {
        double x = player.getX();
        double y = player.getY() + 1.5;
        double z = player.getZ();
        double xs = sin(player.getLookAngle().x);
        double ys = sin(player.getLookAngle().y);
        double zs = sin(player.getLookAngle().z);

        double f = getPowerForTime(b);
        double scale = Math.pow(10, 1);
        double ff = Math.ceil(f * scale);
        double fff = ff / scale;
        double r = Math.random()*10000;
        if(r == 100) {
            player.getLevel().addParticle(ParticleTypes.EXPLOSION, x+2, y, z, xs/2, ys/2, zs/2);
            player.getLevel().addParticle(ParticleTypes.EXPLOSION, x+2, y+1, z, xs/2, ys/2, zs/2);
            player.getLevel().addParticle(ParticleTypes.EXPLOSION, x, y, z+1, xs/2, ys/2, zs/2);
            player.getLevel().addParticle(ParticleTypes.EXPLOSION, x+3, y+1, z+1, xs/2, ys/2, zs/2);

            player.setHealth(0);
        }
        for(int i = 0; i < 360; i++) {
            if(i % fff * 5 == 0) {

                player.getLevel().addParticle(ParticleTypes.POOF, x, y, z, xs/2, ys/2, zs/2);
            }
        }
    }



}

