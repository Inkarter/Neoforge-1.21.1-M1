package net.inkarter.mccourseid.item.custom;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class ModEffectSwordItem extends SwordItem
{

    private final Holder<MobEffect> mobEffect;
    private final Holder<MobEffect> playerEffect;

    public ModEffectSwordItem(Tier tier, Properties properties, Holder<MobEffect> mobEffect, Holder<MobEffect> playerEffect)
    {
        super(tier, properties);
        this.mobEffect = mobEffect;
        this.playerEffect = playerEffect;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity)
    {
        if(entity instanceof LivingEntity livingEntity)
        {
            livingEntity.addEffect(new MobEffectInstance(mobEffect, 20, 10 ), player);
            player.addEffect(new MobEffectInstance(playerEffect, 50, 1), player);
        }



        return super.onLeftClickEntity(stack, player, entity);
    }
}
