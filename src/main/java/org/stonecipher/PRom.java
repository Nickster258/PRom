package org.stonecipher;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
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

    public static RomBuilder getBuilder(Player player) {
        return PRom.builders.stream()
                .filter(romBuilder -> romBuilder.getPlayer().equals(player))
                .findFirst().get();
    }

    public static void sendMessage(CommandSender sender, String message) {
        sender.sendMessage("§8[§7PRom§8] §r" + message);
    }

}
