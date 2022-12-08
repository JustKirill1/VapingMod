package com.Juski.vapemod.client.renderer.entity;

import com.Juski.vapemod.vapemod;
import com.Juski.vapemod.world.entity.projectile.VapeLiqRab;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class VapeLiqRenderer extends ArrowRenderer<VapeLiqRab> {
    public VapeLiqRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(VapeLiqRab pEntity) {
        Item referenceItem = pEntity.getPickupItem().getItem();

        return new ResourceLocation(vapemod.MOD_ID, "textures/entity/projectiles/vapeliq.png");
    }
}
