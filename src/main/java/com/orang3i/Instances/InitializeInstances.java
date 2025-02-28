package com.orang3i.Instances;


import com.dfsek.terra.minestom.world.TerraMinestomWorldBuilder;
import net.minestom.server.MinecraftServer;
import net.minestom.server.event.GlobalEventHandler;
import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.instance.InstanceManager;
import net.minestom.server.instance.LightingChunk;



public class InitializeInstances {

    private static InitializeInstances instance;

    public  InstanceManager instanceManager;
    public  static InstanceContainer instanceContainer;
    public  GlobalEventHandler globalEventHandler;



    public InitializeInstances() {
        instanceManager = MinecraftServer.getInstanceManager();
        instanceContainer = instanceManager.createInstanceContainer();
        globalEventHandler = MinecraftServer.getGlobalEventHandler();
    }

    public static InitializeInstances getInstance() {
        if (instance == null) {
            instance = new InitializeInstances();
        }
        return instance;
    }

    public  void initialize() {
        TerraMinestomWorldBuilder.from(instanceContainer)
                .defaultPack()
                .attach();

        instanceContainer.setChunkSupplier(LightingChunk::new);
    }

    public InstanceContainer getInstanceContainer() {
        return instanceContainer;
    }

    public GlobalEventHandler getGlobalEventHandler() {
        return globalEventHandler;
    }

}
