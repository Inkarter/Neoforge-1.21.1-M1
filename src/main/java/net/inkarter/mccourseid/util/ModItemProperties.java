package net.inkarter.mccourseid.util;

import net.inkarter.mccourseid.MCCourseMod;
import net.inkarter.mccourseid.component.ModDataComponentTypes;
import net.inkarter.mccourseid.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class ModItemProperties
{
    public static void addCustomItemProperties()
    {
        ItemProperties.register(ModItems.DATA_TABLET.get(), ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "on"),
                (stack, level, entity, seed) -> stack.get(ModDataComponentTypes.FOUND_BLOCK) != null ? 1f : 0f);

        makeCustomBow(ModItems.INKARTER_BOW.get());
    }


    private static void makeCustomBow(Item item)
    {
        ItemProperties.register(item, ResourceLocation.withDefaultNamespace("pull"), (p_344163_, p_344164_, p_344165_, p_344166_) -> {
            if (p_344165_ == null)
            {
                return 0.0F;
            } else
            {
                return p_344165_.getUseItem() != p_344163_ ? 0.0F : (float) (p_344163_.getUseDuration(p_344165_) - p_344165_.getUseItemRemainingTicks()) / 20.0F;
            }
        });
        ItemProperties.register(
                item,
                ResourceLocation.withDefaultNamespace("pulling"),
                (p_174630_, p_174631_, p_174632_, p_174633_) -> p_174632_ != null && p_174632_.isUsingItem() && p_174632_.getUseItem() == p_174630_ ? 1.0F : 0.0F
        );

    }
}
