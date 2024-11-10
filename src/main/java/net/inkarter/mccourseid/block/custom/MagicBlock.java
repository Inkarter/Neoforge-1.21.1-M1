package net.inkarter.mccourseid.block.custom;

import net.inkarter.mccourseid.item.ModItems;
import net.inkarter.mccourseid.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;

public class MagicBlock extends Block
{
    public MagicBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos,
                                               Player pPlayer, BlockHitResult pHitResult)
    {
        pLevel.playSound(pPlayer, pPos, SoundEvents.WARDEN_STEP, SoundSource.BLOCKS, 1f, 1f);
        return InteractionResult.SUCCESS;

    }


    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity)
    {

        if(pEntity instanceof ItemEntity itemEntity)
        {
            if(isValidItem(itemEntity.getItem()))
            {
                itemEntity.setItem(new ItemStack(Items.DIAMOND, itemEntity.getItem().getCount()));
            }
        }



        super.stepOn(pLevel, pPos, pState, pEntity);
    }

    private boolean isValidItem(ItemStack item)
    {
        return item.is(ModTags.Items.TRANSFORMABLE_ITEM);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag)
    {
        tooltipComponents.add(Component.translatable("tooltip.mccourseid.magic_block.tooltip.1"));

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
