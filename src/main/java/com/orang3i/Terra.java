package com.orang3i;

import com.orang3i.Instances.InitializeInstances;
import com.orang3i.Player.PlayerHandler;
import net.lumen.plugin.Plugin;

import java.util.logging.Logger;

public class Terra extends Plugin {

    private static final Logger LOGGER = Logger.getLogger("Tera");

    @Override
    public void onEnable() {

        InitializeInstances.getInstance().initialize();
        PlayerHandler.handlePlayer();
        LOGGER.info("Tera is enabled!!!!");
        //plugin enabled!!!
    }

    @Override
    public void onDisable() {
        LOGGER.info("Tera is disabled");
    }


}