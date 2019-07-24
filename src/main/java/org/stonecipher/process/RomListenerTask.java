package org.stonecipher.process;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class RomListenerTask {

    private Plugin plugin;

    public RomListenerTask(Plugin plugin) {
        this.plugin = plugin;
    }

    public void startListener() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage("running");
            }
        }, 0L, 1L);
    }

    public void stopListener() {
        Bukkit.getScheduler().cancelTasks(plugin);
    }

}
