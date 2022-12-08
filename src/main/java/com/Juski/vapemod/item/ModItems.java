package com.Juski.vapemod.item;

import com.Juski.vapemod.item.custom.VapeAegisHero;
import com.Juski.vapemod.vapemod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, vapemod.MOD_ID);
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
    public static final RegistryObject<Item> VAPEAEGIS = ITEMS.register("vapeaegis",
            () -> new VapeAegisHero(new Item.Properties().tab(CreativeModeTab.TAB_BREWING).durability(500)));
    public static final RegistryObject<Item> VAPELIQ = ITEMS.register("vapeliq",
            () -> new VapeLiq(new Item.Properties().tab(CreativeModeTab.TAB_BREWING), 1.5F));

}
