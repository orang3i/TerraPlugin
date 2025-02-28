package com.orang3i.Player;

import com.orang3i.Instances.InitializeInstances;
import com.orang3i.Terra;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.GameMode;
import net.minestom.server.entity.Player;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;


public class PlayerHandler {

    public static void handlePlayer(){


            InitializeInstances.getInstance().getGlobalEventHandler().addListener(AsyncPlayerConfigurationEvent.class, event -> {
            final Player player = event.getPlayer();
            event.setSpawningInstance(InitializeInstances.getInstance().getInstanceContainer());
            player.setRespawnPoint(new Pos(0, 200, 0));
            player.setGameMode(GameMode.CREATIVE);
        });
    }
}
