package net.robbyunderdog.robbysmaterialmod.entity.client;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.robbyunderdog.robbysmaterialmod.RobbysMaterialMod;
import net.robbyunderdog.robbysmaterialmod.entity.TriceratopsVariant;
import net.robbyunderdog.robbysmaterialmod.entity.custom.TriceratopsEntity;

import java.util.Map;

public class TriceratopsRenderer extends MobRenderer<TriceratopsEntity, TriceratopsModel<TriceratopsEntity>> {
    private static final Map<TriceratopsVariant, ResourceLocation> LOCATION_BY_VARIANT = Util.make(Maps.newEnumMap(TriceratopsVariant.class), map -> {
        map.put(TriceratopsVariant.GRAY, ResourceLocation.fromNamespaceAndPath(RobbysMaterialMod.MOD_ID, "textures/entity/triceratops/triceratops_gray.png"));
        map.put(TriceratopsVariant.GREEN, ResourceLocation.fromNamespaceAndPath(RobbysMaterialMod.MOD_ID, "textures/entity/triceratops/triceratops_green.png"));
    });


    public TriceratopsRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new TriceratopsModel<>(pContext.bakeLayer(TriceratopsModel.LAYER_LOCATION)), 0.85f);
    }

    @Override
    public ResourceLocation getTextureLocation(TriceratopsEntity pEntity) {
        return LOCATION_BY_VARIANT.get(pEntity.getVariant());
    }

    @Override
    public void render(TriceratopsEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {

        if(pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            pPoseStack.scale(1f, 1f, 1f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
