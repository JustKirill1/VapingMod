package com.Juski.vapemod.client;
import com.Juski.vapemod.world.entity.ModEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.Juski.vapemod.vapemod;
import com.Juski.vapemod.client.renderer.entity.VapeLiqRenderer;

import javax.swing.text.html.parser.Entity;

@Mod.EventBusSubscriber(modid = vapemod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)

public class ClientModEventSubscriber {
    @SubscribeEvent
    public static void onClientSetup(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(ModEntityType.VAPELIQRAB.get(), VapeLiqRenderer::new);
    }
}
