package net.inkarter.mccourseid.item;

import net.inkarter.mccourseid.MCCourseMod;
import net.inkarter.mccourseid.item.custom.*;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MCCourseMod.MOD_ID);



    public static final DeferredItem<Item> SMALL_EGG = ITEMS.registerSimpleItem("small_egg");
    public static final DeferredItem<Item> MEDIUM_EGG = ITEMS.registerSimpleItem("medium_egg");
    public static final DeferredItem<Item> LARGE_EGG = ITEMS.registerSimpleItem("large_egg");


    public static final DeferredItem<Item> BLACK_OPAL = ITEMS.registerSimpleItem("black_opal");
    public static final DeferredItem<Item> RAW_BLACK_OPAL =
            ITEMS.registerItem("raw_black_opal", Item::new, new Item.Properties());

    public static final DeferredItem<Item> CHAISAW =
            ITEMS.registerItem("chainsaw", ChainsawItem::new, new Item.Properties().durability(32));
    //another way how to do tooltips inh Tomato
    public static final DeferredItem<Item> TOMATO =
            ITEMS.registerItem("tomato", properties -> new Item(properties) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag)
                {
                    tooltipComponents.add(Component.translatable("tooltip.mccourseid.tomato.1"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            }, new Item.Properties().food(ModFoodProperties.TOMATO));

    public static final DeferredItem<Item> FROSTFIRE_ICE =
            ITEMS.registerItem("frostfire_ice", properties -> new FuelItem(properties, 800), new Item.Properties().food(ModFoodProperties.TOMATO));



    public static final DeferredItem<Item> BLACK_OPAL_SWORD = ITEMS.register("black_opal_sword",
            () -> new ModEffectSwordItem(ModToolsTiers.BLACK_OPAL,
                    new Item.Properties().attributes(SwordItem.createAttributes(ModToolsTiers.BLACK_OPAL, 3, -2.4f)), MobEffects.LEVITATION, MobEffects.MOVEMENT_SPEED));

    public static final DeferredItem<Item> BLACK_OPAL_PICKAXE = ITEMS.register("black_opal_pickaxe",
            () -> new PickaxeItem(ModToolsTiers.BLACK_OPAL,
                    new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolsTiers.BLACK_OPAL, 1, -2.8f)) ));
    public static final DeferredItem<Item> BLACK_OPAL_SHOVEL = ITEMS.register("black_opal_shovel",
            () -> new ShovelItem(ModToolsTiers.BLACK_OPAL,
                    new Item.Properties().attributes(ShovelItem.createAttributes(ModToolsTiers.BLACK_OPAL, 1.5f, -3.0f)) ));
    public static final DeferredItem<Item> BLACK_OPAL_AXE = ITEMS.register("black_opal_axe",
            () -> new AxeItem(ModToolsTiers.BLACK_OPAL,
                    new Item.Properties().attributes(AxeItem.createAttributes(ModToolsTiers.BLACK_OPAL, 6, -3.2f)) ));
    public static final DeferredItem<Item> BLACK_OPAL_HOE = ITEMS.register("black_opal_hoe",
            () -> new HoeItem(ModToolsTiers.BLACK_OPAL,
                    new Item.Properties().attributes(HoeItem.createAttributes(ModToolsTiers.BLACK_OPAL, 0, -3.0f)) ));
    public static final DeferredItem<Item> BLACK_OPAL_PAXEL = ITEMS.register("black_opal_paxel",
            () -> new PaxelItem(ModToolsTiers.BLACK_OPAL,
                    new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolsTiers.BLACK_OPAL, 1, -2.8f)) ));
    public static final DeferredItem<Item> BLACK_OPAL_HAMMER = ITEMS.register("black_opal_hammer",
            () -> new HammerItem(ModToolsTiers.BLACK_OPAL,
                    new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolsTiers.BLACK_OPAL, 8, -3.3f)) ));



    public static final DeferredItem<Item> BLACK_OPAL_HELMET = ITEMS.register("black_opal_helmet", () ->
            new ModArmorItem(ModArmorMaterials.BLACK_OPAL, ArmorItem.Type.HELMET,
                    new Item.Properties(). durability(ArmorItem.Type.HELMET.getDurability(16))));
    public static final DeferredItem<Item> BLACK_OPAL_CHESTPLATE = ITEMS.register("black_opal_chestplate", () ->
            new ArmorItem(ModArmorMaterials.BLACK_OPAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties(). durability(ArmorItem.Type.CHESTPLATE.getDurability(16))));
    public static final DeferredItem<Item> BLACK_OPAL_LEGGINGS = ITEMS.register("black_opal_leggings", () ->
            new ArmorItem(ModArmorMaterials.BLACK_OPAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties(). durability(ArmorItem.Type.LEGGINGS.getDurability(16))));
    public static final DeferredItem<Item> BLACK_OPAL_BOOTS = ITEMS.register("black_opal_boots", () ->
            new ArmorItem(ModArmorMaterials.BLACK_OPAL, ArmorItem.Type.BOOTS,
                    new Item.Properties(). durability(ArmorItem.Type.BOOTS.getDurability(16))));

public static DeferredItem<Item> BLACK_OPAL_HORSE_ARMOR = ITEMS.register("black_opal_horse_armor",
        () -> new AnimalArmorItem(ModArmorMaterials.BLACK_OPAL, AnimalArmorItem.BodyType.EQUESTRIAN, false, new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));
    public static final DeferredItem<Item> DATA_TABLET = ITEMS.register("data_tablet",
            () -> new DataTabletItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> INKARTER_BOW = ITEMS.register("inkarter_bow",
            () -> new BowItem(new Item.Properties().durability(328)));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }




}
