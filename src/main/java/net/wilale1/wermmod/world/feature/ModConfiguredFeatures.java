package net.wilale1.wermmod.world.feature;

import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.wilale1.wermmod.WermMod;
import net.wilale1.wermmod.block.ModBlocks;

import java.rmi.registry.Registry;
import java.util.List;

public class ModConfiguredFeatures {
    public static final List<OreFeatureConfig.Target> OVERWORLD_URANIUM_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.URANIUM_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_URANIUM_ORE.getDefaultState()));

    public static final List<OreFeatureConfig.Target> END_URANIUM_ORES = List.of(
            OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.ENDSTONE_URANIUM_ORE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> URANIUM_ORE =
            // size = ore vein size
            ConfiguredFeatures.register("uranium_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_URANIUM_ORES, 9));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> END_URANIUM_ORE =
            ConfiguredFeatures.register("end_uranium_ore", Feature.ORE, new OreFeatureConfig(END_URANIUM_ORES, 12));

    public static void  registerConfiguredFeatures() {
        WermMod.LOGGER.debug("Registering the ModConfiguredFeatures for" + WermMod.MOD_ID);
    }
}
