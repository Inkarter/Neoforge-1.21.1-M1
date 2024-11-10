package net.inkarter.mccourseid.datagen;

import net.inkarter.mccourseid.MCCourseMod;
import net.inkarter.mccourseid.item.ModItems;
import net.minecraft.client.model.ModelUtils;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider
{
    public ModItemModelProvider(PackOutput output,  ExistingFileHelper existingFileHelper)
    {
        super(output, MCCourseMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        basicItem(ModItems.BLACK_OPAL.get());
        basicItem(ModItems.RAW_BLACK_OPAL.get());
        basicItem(ModItems.CHAISAW.get());
        basicItem(ModItems.TOMATO.get());
        basicItem(ModItems.FROSTFIRE_ICE.get());


    }
}
