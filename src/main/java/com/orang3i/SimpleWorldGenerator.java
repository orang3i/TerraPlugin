package com.orang3i;

import com.orang3i.Instances.InitializeInstances;
import com.orang3i.Instances.InstanceCreator;
import net.lumen.plugin.Plugin;
import net.minestom.server.instance.InstanceContainer;

import java.util.logging.Logger;

public class SimpleWorldGenerator extends Plugin {

    private static final Logger LOGGER = Logger.getLogger("SimpleWorldGenerator");

    @Override
    public void onEnable() {

        InstanceCreator.create();
        InitializeInstances.initialize();
        LOGGER.info("SimpleWorldGenerator is enabled :)");
        //test
    }

    @Override
    public void onDisable() {
        LOGGER.info("SimpleWorldGenerator is disabled");
    }
}