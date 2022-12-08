package com.Juski.vapemod.world.entity.projectile;

import com.Juski.vapemod.item.ModItems;
import com.Juski.vapemod.world.entity.ModEntityType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class VapeLiqRab extends AbstractArrow {
    private final Item referenceItem;
    public VapeLiqRab(EntityType<? extends AbstractArrow> type, Level level) {
        super(type, level);
        this.referenceItem = ModItems.VAPELIQ.get();
    }

    public VapeLiqRab(LivingEntity shooter, Level level, Item referenceItem) {
        super(ModEntityType.VAPELIQRAB.get(), shooter, level);
        this.referenceItem = referenceItem;
    }

    @Override
    public ItemStack getPickupItem() {
        return new ItemStack(this.referenceItem);
    }
}
