package com.orang3i.Instances;

import com.orang3i.Generators.MainGenerator;
import net.lumen.LumenServer;
import net.minestom.server.MinecraftServer;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.GameMode;
import net.minestom.server.entity.Player;
import net.minestom.server.event.GlobalEventHandler;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;
import net.minestom.server.instance.Chunk;
import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.instance.InstanceManager;
import net.minestom.server.instance.LightingChunk;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;


public class InitializeInstances {

    public static InstanceManager instanceManager = MinecraftServer.getInstanceManager();
    public static InstanceContainer instanceContainer = instanceManager.createInstanceContainer();
    public static GlobalEventHandler globalEventHandler = MinecraftServer.getGlobalEventHandler();


    public static void initialize() {
        instanceContainer.setGenerator(new MainGenerator());
        instanceContainer.setChunkSupplier(LightingChunk::new);

        var chunks = new ArrayList<CompletableFuture<Chunk>>();
        forChunksInRange(0, 0, 32, (x, z) -> chunks.add(instanceContainer.loadChunk(x, z)));

        CompletableFuture.runAsync(() -> {
            CompletableFuture.allOf(chunks.toArray(CompletableFuture[]::new)).join();
            LightingChunk.relight(instanceContainer, instanceContainer.getChunks());
        });

        globalEventHandler.addListener(AsyncPlayerConfigurationEvent.class, event -> {
            final Player player = event.getPlayer();
            event.setSpawningInstance(instanceContainer);
            player.setRespawnPoint(new Pos(0, 200, 0));
            player.setGameMode(GameMode.CREATIVE);
        });
    }

    public static void forChunksInRange(int centerX, int centerZ, int radius, BiConsumer<Integer, Integer> action) {
        for (int x = centerX - radius; x <= centerX + radius; x++) {
            for (int z = centerZ - radius; z <= centerZ + radius; z++) {
                action.accept(x, z);
            }
        }
    }
}
