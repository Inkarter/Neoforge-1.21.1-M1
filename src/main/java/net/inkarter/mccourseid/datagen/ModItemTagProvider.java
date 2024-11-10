package net.inkarter.mccourseid.datagen;

import net.inkarter.mccourseid.MCCourseMod;
import net.inkarter.mccourseid.item.ModItems;
import net.inkarter.mccourseid.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider
{
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags,  @Nullable ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, blockTags, MCCourseMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider)
    {
    tag(ModTags.Items.TRANSFORMABLE_ITEM)
            .add(ModItems.BLACK_OPAL.get())
            .add(Items.COAL)
            .add(Items.DANDELION)
            .add(Items.COMPASS);

    }
}
