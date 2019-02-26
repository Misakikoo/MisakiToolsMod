package com.github.misakikoo.misakitools.common;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

public class ConfigLoader {
    private static Configuration config;
    private static Logger logger;


    public static int goldenEggBurnTime;


    public ConfigLoader(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        config = new Configuration(event.getSuggestedConfigurationFile());

        config.load();
        load();
    }

    public static void load() {
        logger.info("Started loading config.");
        String comment;


        comment = "How many seconds(*20ticks) can a goldenEgg burn in a furnace";
        goldenEggBurnTime = config.get(Configuration.CATEGORY_GENERAL, "goldenEggBurnTime", 12800, comment).getInt();


        config.save();
        logger().info("Finished loading config");
    }

    public static Logger logger() {
        return logger;
    }
}
