package net.wilale1.wermmod.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryEntry<PlacedFeature> URANIUM_ORE_PLACED = PlacedFeatures.register("uranium_ore_placed",
            // count = veins / chunk
            ModConfiguredFeatures.URANIUM_ORE, modifiersWithCount(9,
                    // offset 1 - offset 2 = Y levels spawned between
                    HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(15))));

    public static final RegistryEntry<PlacedFeature> END_URANIUM_ORE_PLACED = PlacedFeatures.register("end_uranium_ore_placed",
            ModConfiguredFeatures.END_URANIUM_ORE, modifiersWithCount(10,
                    HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));



    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }
    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }
    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }
}