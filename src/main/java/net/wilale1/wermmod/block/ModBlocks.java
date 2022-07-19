package net.wilale1.wermmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.wilale1.wermmod.WermMod;
import net.wilale1.wermmod.block.custom.TomaccoCropBlock;
import net.wilale1.wermmod.item.ModItemgroup;

public class ModBlocks {
    public static final Block URANIUM_BLOCK = registerBlock("uranium_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()), ModItemgroup.WERM_ITEMS);

    public static final Block URANIUM_ORE = registerBlock("uranium_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool().luminance(1), UniformIntProvider.create(3, 7)), ModItemgroup.WERM_ITEMS);

    public static final Block DEEPSLATE_URANIUM_ORE = registerBlock("deepslate_uranium_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool().luminance(1), UniformIntProvider.create(3, 7)), ModItemgroup.WERM_ITEMS);

    public static final Block TOMACCO_CROP = registerBlockWithoutItem("tomacco_crop",
            new TomaccoCropBlock(FabricBlockSettings.copy(Blocks.WHEAT)));



    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(WermMod.MOD_ID, name), block);

    }    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(WermMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {

        return Registry.register(Registry.ITEM, new Identifier(WermMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }

    public static void registerModBlocks() {
        WermMod.LOGGER.debug("Registering Mod Blocks For " + WermMod.MOD_ID);
    }
}
