package net.wilale1.wermmod;

import net.fabricmc.api.ModInitializer;
import net.wilale1.wermmod.block.ModBlocks;
import net.wilale1.wermmod.item.ModItems;
import net.wilale1.wermmod.painting.ModPaintings;
import net.wilale1.wermmod.villager.ModVillagers;
import net.wilale1.wermmod.world.gen.ModOreGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WermMod implements ModInitializer {
	public static final String MOD_ID = "wermmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModVillagers.registerVillagers();
		ModVillagers.registerTrades();

		ModPaintings.registerPaintings();
		ModOreGeneration.generateOres();
	}
}
