package org.stonecipher.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.stonecipher.command.usercommand.*;

public class RomCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        // Default to version if args are not specified
        if (strings.length == 0) {
            new VersionCommand("version", "prom.version").execute(commandSender, command, s, strings);
        }

        // Then do user-ambiguous commands
        switch (command.getName()) {
            case "info":
                return new InfoCommand("info", "prom.create").execute(commandSender, command, s, strings);
            case "version":
                return new VersionCommand("version", "prom.version").execute(commandSender, command, s, strings);
        }

        // Check if player is user to do the other commands
        if (!isUser(commandSender)) {
            return true;
        }

        switch (command.getLabel()) {
            case "cancel":
                return new CancelCommand("cancel", "prom.create").execute(commandSender, command, s, strings);
            case "confirm":
                return new ConfirmCommand("confirm", "prom.create").execute(commandSender, command, s, strings);
            case "create":
                return new CreateCommand("create", "prom.create").execute(commandSender, command, s, strings);
            case "edit":
                return new EditCommand("edit", "prom.edit").execute(commandSender, command, s, strings);
            case "exit":
                return new ExitCommand("exit", "prom.create").execute(commandSender, command, s, strings);
            case "program":
                return new ProgramCommand("program", "prom.program").execute(commandSender, command, s, strings);
            case "undo":
                return new UndoCommand("undo", "prom.create").execute(commandSender, command, s, strings);
        }

        // Since no valid command should ever reach this point
        return new VersionCommand("version", "prom.version").execute(commandSender, command, s, strings);

    }

    private boolean isUser(CommandSender commandSender) {
        if (commandSender instanceof Player) {
            commandSender.sendMessage(ChatColor.RED + "This command can only be ran ingame.");
            return true;
        }
        return false;
    }
}
