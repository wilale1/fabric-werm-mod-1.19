package net.wilale1.wermmod.villager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import net.wilale1.wermmod.WermMod;
import net.wilale1.wermmod.block.ModBlocks;
import net.wilale1.wermmod.item.ModItems;

public class ModVillagers {
    public static final PointOfInterestType URANIUM_POI = registerPOI("uranium_poi", ModBlocks.URANIUM_BLOCK);
    public static final VillagerProfession SAFETY_INSPECTOR = registerProfession("safetyinspector",
            RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(WermMod.MOD_ID, "uranium_poi")));

    public static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registry.VILLAGER_PROFESSION, new Identifier(WermMod.MOD_ID, name),
                VillagerProfessionBuilder.create().id(new Identifier(WermMod.MOD_ID, name)).workstation(type)
                        .workSound(SoundEvents.ENTITY_VILLAGER_WORK_ARMORER).build());
    }

    public static PointOfInterestType registerPOI(String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(WermMod.MOD_ID, name), 1, 1, ImmutableSet.copyOf(block.getStateManager().getStates()));
    }
    public static void registerVillagers() {
        WermMod.LOGGER.debug("Registering Villagers for " + WermMod.MOD_ID);
    }

    public static void  registerTrades() {
        TradeOfferHelper.registerVillagerOffers(SAFETY_INSPECTOR, 1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 3),
                            new ItemStack(ModItems.TOMACCO_SEEDS, 5), 6, 2, 0.02f
                    )));
                });
    }
}
