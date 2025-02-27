package com.orang3i.Instances;

import net.lumen.LumenServer;
import net.minestom.server.event.GlobalEventHandler;
import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.instance.InstanceManager;

public class InstanceCreator {
    public static InstanceManager instanceManager;
    public static InstanceContainer instanceContainer;
    public static GlobalEventHandler globalEventHandler;

    public static void create() {
        instanceManager = LumenServer.getServer().getInstanceManager();
        instanceContainer = instanceManager.createInstanceContainer();
        globalEventHandler = LumenServer.getGlobalEventHandler();
    }

}
