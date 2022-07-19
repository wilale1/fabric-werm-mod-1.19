package net.wilale1.wermmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.wilale1.wermmod.WermMod;

public class ModItems {

    public static final Item RAW_PLATINUM = registerItem("raw_platinum",
            new Item(new FabricItemSettings().group(ModItemgroup.WERM_ITEMS)));

    public static final Item PLATINUM = registerItem("platinum",
            new Item(new FabricItemSettings().group(ModItemgroup.WERM_ITEMS)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(WermMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        WermMod.LOGGER.debug("Registering Mod Items for " + WermMod.MOD_ID);
    }
}
