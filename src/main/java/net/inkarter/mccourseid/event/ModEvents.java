package net.inkarter.mccourseid.event;


import net.inkarter.mccourseid.MCCourseMod;
import net.inkarter.mccourseid.item.ModItems;
import net.inkarter.mccourseid.item.custom.HammerItem;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.HashSet;
import java.util.Set;

@EventBusSubscriber(modid = MCCourseMod.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents
{
    @SubscribeEvent
    public static void livingDamage(LivingDamageEvent.Pre event)
    {
        if(event.getEntity() instanceof Sheep sheep)
        {
            if(event.getSource().getDirectEntity() instanceof Player player)
            {
                if(player.getMainHandItem().getItem() == ModItems.METAL_DETECTOR.get())
                {
                    player.sendSystemMessage(Component.literal(player.getName().getString() + "hit a freaking sheep with a Metal Detector!"));
                }
                if(player.getMainHandItem().getItem() == ModItems.TOMATO.get())
                {
                    player.sendSystemMessage(Component.literal(player.getName().getString() + "hit a freaking sheep with a tomato!!"));
                    sheep.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 50, 5));
                    player.getMainHandItem().shrink(1);
                }
                if(player.getMainHandItem().getItem() == Items.END_ROD)
                {
                    player.sendSystemMessage(Component.literal(player.getName().getString() + "hit a freaking sheep with a end rod? Why in the world you have it?!!"));
                    sheep.addEffect(new MobEffectInstance(MobEffects.POISON, 50, 50));
                    player.getMainHandItem().shrink(1);
                }

            }
        }
    }







    // Done with the help of https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java
    // Don't be a jerk License
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();
    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent event)
    {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if(mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayer serverPlayer)
        {
            BlockPos initialPosition = event.getPos();
            if(HARVESTED_BLOCKS.contains(initialPosition))
            {
                return;
            }
            for(BlockPos pos : HammerItem.getBlocksToBeDestroyed(1, initialPosition, serverPlayer))
                // 1 is range so it breaks 3x3 blocks, to break 5x5 blocks range = 2 and so on
            {
                if(pos == initialPosition || !hammer.isCorrectToolForDrops(mainHandItem,event.getLevel().getBlockState(pos))) {
                    continue;

                }
                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }


        }
    }

}
