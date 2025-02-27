package com.orang3i;

import com.orang3i.Instances.InitializeInstances;
import net.lumen.plugin.Plugin;

import java.util.logging.Logger;

public class SimpleWorldGenerator extends Plugin {

    private static final Logger LOGGER = Logger.getLogger("SimpleWorldGenerator");

    @Override
    public void onEnable() {

        InitializeInstances.initialize();
        LOGGER.info("SimpleWorldGenerator is enabled!!!!");
        //plugin enabled!!!
    }

    @Override
    public void onDisable() {
        LOGGER.info("SimpleWorldGenerator is disabled");
    }
}