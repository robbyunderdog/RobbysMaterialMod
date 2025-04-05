package net.robbyunderdog.robbysmaterialmod.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

public class ChiselItem extends Item {
    private static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS,
                    Blocks.CRACKED_STONE_BRICKS, Blocks.CHISELED_STONE_BRICKS,
                    Blocks.CHISELED_STONE_BRICKS, Blocks.STONE,

                    Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS,
                    Blocks.DEEPSLATE_BRICKS, Blocks.CRACKED_DEEPSLATE_BRICKS,
                    Blocks.CRACKED_DEEPSLATE_BRICKS, Blocks.DEEPSLATE_TILES,
                    Blocks.DEEPSLATE_TILES, Blocks.DEEPSLATE,

                    Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                    Blocks.END_STONE_BRICKS, Blocks.END_STONE
            );

    public ChiselItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();

        if(CHISEL_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide) {
                level.setBlockAndUpdate(pContext.getClickedPos(), CHISEL_MAP.get(clickedBlock).defaultBlockState());

                pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()), item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, pContext.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }
}
