package net.wilale1.wermmod.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.wilale1.wermmod.WermMod;

public class ModItemgroup {
    public static final ItemGroup WERM_ITEMS = FabricItemGroupBuilder.build(new Identifier(WermMod.MOD_ID, "wermitems"), () -> new ItemStack(ModItems.URANIUM));
}
