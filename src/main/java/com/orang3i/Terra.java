package com.orang3i;

import com.lumenmc.plugin.Plugin;
import com.orang3i.Instances.InitializeInstances;
import com.orang3i.Player.PlayerHandler;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Terra extends Plugin {

    private static final Logger LOGGER = LoggerFactory.getLogger(Terra.class);

    @Override
    public void onEnable() {

        InitializeInstances.getInstance().initialize();
        PlayerHandler.handlePlayer();
        LOGGER.info("Terra is enabled!!!!");
        //plugin enabled!!!
    }

    @Override
    public void onDisable() {
        LOGGER.info("Terra is disabled");
    }


}