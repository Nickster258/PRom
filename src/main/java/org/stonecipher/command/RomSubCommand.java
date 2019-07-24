package org.stonecipher.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public abstract class RomSubCommand {

    private final String name;
    private final String permission;

    public RomSubCommand(String name, String permission) {
        this.name = name;
        this.permission = permission;
    }

    public String getName() {
        return name;
    }

    public String getPermission() {
        return permission;
    }

    public abstract boolean execute(CommandSender sender, Command cmd, String commandLabel, String[] args);

}
