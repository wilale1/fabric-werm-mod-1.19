package net.wilale1.wermmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.wilale1.wermmod.WermMod;
import net.wilale1.wermmod.block.ModBlocks;

public class ModItems {

    // Adds Uranium and Raw Uranium as items

    public static final Item RAW_URANIUM = registerItem("raw_uranium",
            new Item(new FabricItemSettings().group(ModItemgroup.WERM_ITEMS)));

    public static final Item URANIUM = registerItem("uranium",
            new Item(new FabricItemSettings().group(ModItemgroup.WERM_ITEMS)));

    public static final Item TOMACCO_SEEDS = registerItem("tomacco_seeds",
            new AliasedBlockItem(ModBlocks.TOMACCO_CROP, new FabricItemSettings().group(ModItemgroup.WERM_ITEMS)));

    public static final Item TOMACCO = registerItem("tomacco",
            new Item(new FabricItemSettings().group(ModItemgroup.WERM_ITEMS).food(new FoodComponent.Builder().hunger(4).saturationModifier(4).build())));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(WermMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        WermMod.LOGGER.debug("Registering Mod Items for " + WermMod.MOD_ID);
    }
}
