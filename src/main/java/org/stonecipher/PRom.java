package org.stonecipher;

import org.bukkit.plugin.java.JavaPlugin;
import org.stonecipher.command.RomCommand;
import org.stonecipher.editor.RomBuilder;
import org.stonecipher.event.PlaceEvent;

import java.util.ArrayList;
import java.util.List;

public class PRom extends JavaPlugin {

    public static List<RomBuilder> builders = new ArrayList<RomBuilder>();

    @Override
    public void onEnable() {

        getCommand("rom").setExecutor(new RomCommand());

        getServer().getPluginManager().registerEvents(new PlaceEvent(), this);

    }

}
