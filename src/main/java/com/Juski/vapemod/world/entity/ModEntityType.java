package com.Juski.vapemod.world.entity;

import com.Juski.vapemod.item.VapeLiq;
import com.Juski.vapemod.vapemod;
import com.Juski.vapemod.world.entity.projectile.VapeLiqRab;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityType {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, vapemod.MOD_ID);

    public static final RegistryObject<EntityType<VapeLiqRab>> VAPELIQRAB = ENTITIES.register("vapeliqrab",
            () -> EntityType.Builder.
                    <VapeLiqRab>of(VapeLiqRab::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).clientTrackingRange(4)
                    .updateInterval(20).build(new ResourceLocation(vapemod.MOD_ID,"vapeliqrab")
                            .toString()));
    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}
