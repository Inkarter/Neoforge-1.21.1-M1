package net.inkarter.mccourseid.item;

import net.inkarter.mccourseid.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolsTiers
{
    public static final Tier BLACK_OPAL = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_BLACK_OPAL_TOOL,
            600, 4f, 1.5f, 20,
            () -> Ingredient.of(ModItems.BLACK_OPAL.get()));
}