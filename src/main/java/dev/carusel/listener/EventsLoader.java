package dev.carusel.listener;

import dev.carusel.Carusel;
import dev.carusel.listener.PlayerInteractListener;

import dev.carusel.listener.PlayerVenicleExitListener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

public class EventsLoader {
    private PluginManager pluginmanager;
    private final Carusel instance = Carusel.getInstance();

    public void init() {
        pluginmanager = Bukkit.getServer().getPluginManager();

        register(new PlayerInteractListener());
//        register(new PlayerVenicleExitListener());
    }

    private void register(Listener listener) {
        pluginmanager.registerEvents(listener, instance);
    }
}
