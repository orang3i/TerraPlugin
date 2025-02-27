package com.orang3i.Instances;

import com.orang3i.Generators.MainGenerator;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.GameMode;
import net.minestom.server.entity.Player;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;
import net.minestom.server.instance.Chunk;
import net.minestom.server.instance.LightingChunk;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

import static com.orang3i.Instances.InstanceCreator.globalEventHandler;
import static com.orang3i.Instances.InstanceCreator.instanceContainer;

public class InitializeInstances {

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
