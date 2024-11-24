package net.inkarter.mccourseid.item;

import net.inkarter.mccourseid.MCCourseMod;
import net.inkarter.mccourseid.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.apache.commons.io.output.AppendableOutputStream;

import java.util.function.Supplier;

public class ModCreativeModeTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MCCourseMod.MOD_ID);



    public static final Supplier<CreativeModeTab> BLACK_OPAL_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("black_opal_items_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.mccourseid.black_opal_items_tab"))
                    .icon(() -> new ItemStack(ModItems.BLACK_OPAL.get()))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.BLACK_OPAL);
                        pOutput.accept(ModItems.RAW_BLACK_OPAL);

                        pOutput.accept(ModItems.CHAISAW);
                        pOutput.accept(ModItems.TOMATO);
                        pOutput.accept(ModItems.FROSTFIRE_ICE);


                    })
                    .build());

    public static final Supplier<CreativeModeTab> BLACK_OPAL_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("black_opal_blocks_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.mccourseid.black_opal_blocks_tab"))
                    .icon(() -> new ItemStack(ModBlocks.BLACK_OPAL_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "black_opal_items_tab"))
                    //means withTabsBefore we show the tabs that are going to be before this tab
                    .displayItems((pParameters, pOutput) -> {
                    pOutput.accept(ModBlocks.BLACK_OPAL_BLOCK);
                    pOutput.accept(ModBlocks.RAW_BLACK_OPAL_BLOCK);

                    pOutput.accept(ModBlocks.BLACK_OPAL_ORE);

                    pOutput.accept(ModBlocks.BLACK_OPAL_DEEPSLATE_ORE);
                    pOutput.accept(ModBlocks.BLACK_OPAL_END_ORE);
                    pOutput.accept(ModBlocks.BLACK_OPAL_NETHER_ORE);

                    pOutput.accept(ModBlocks.MAGIC_BLOCK);

                    pOutput.accept(ModBlocks.BLACK_OPAL_SLAB);
                    pOutput.accept(ModBlocks.BLACK_OPAL_STAIRS);

                    pOutput.accept(ModBlocks.BLACK_OPAL_BUTTON);
                    pOutput.accept(ModBlocks.BLACK_OPAL_PRESSURE_PLATE);

                    pOutput.accept(ModBlocks.BLACK_OPAL_FENCE);
                    pOutput.accept(ModBlocks.BLACK_OPAL_FENCE_GATE);
                    pOutput.accept(ModBlocks.BLACK_OPAL_WALL);

                    pOutput.accept(ModBlocks.BLACK_OPAL_DOOR);
                    pOutput.accept(ModBlocks.BLACK_OPAL_TRAPDOOR);


                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
