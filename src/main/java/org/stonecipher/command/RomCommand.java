package org.stonecipher.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.stonecipher.command.usercommand.CreateCommand;
import org.stonecipher.command.usercommand.EditCommand;
import org.stonecipher.command.usercommand.InfoCommand;
import org.stonecipher.command.usercommand.ProgramCommand;
import org.stonecipher.command.usercommand.VersionCommand;

public class RomCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        // Default to version if args are not specified
        if (strings.length == 0) {
            new VersionCommand("version", "prom.version").execute(commandSender, command, s, strings);
        }

        // Then do user-ambiguous commands
        switch (command.getName()) {
            case "version":
                return new VersionCommand("version", "prom.version").execute(commandSender, command, s, strings);
            case "info":
                return new InfoCommand("info", "prom.create").execute(commandSender, command, s, strings);
        }

        // Check if player is user to do the other commands
        if (!isUser(commandSender)) {
            return true;
        }

        switch (command.getLabel()) {
            case "create":
                return new CreateCommand("create", "prom.create").execute(commandSender, command, s, strings);
            case "edit":
                return new EditCommand("edit", "prom.edit").execute(commandSender, command, s, strings);
            case "program":
                return new ProgramCommand("program", "prom.program").execute(commandSender, command, s, strings);
        }

        // Since no valid command should ever reach this point
        commandSender.sendMessage(ChatColor.RED + "Unrecognized subcommand!");

        return true;

    }

    private boolean isUser(CommandSender commandSender) {
        if (commandSender instanceof Player) {
            commandSender.sendMessage(ChatColor.RED + "This command can only be ran ingame.");
            return true;
        }
        return false;
    }
}
