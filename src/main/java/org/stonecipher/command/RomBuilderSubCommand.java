package org.stonecipher.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.stonecipher.PRom;
import org.stonecipher.editor.RomBuilder;

public abstract class RomBuilderSubCommand extends RomSubCommand {
    public RomBuilderSubCommand(String name, String permission) {
        super(name, permission);
    }

    @Override
    public boolean execute(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be ran from ingame.");
            return false;
        }
        RomBuilder builder = PRom.getBuilder((Player) sender);

        if (builder == null) {
            PRom.sendMessage(sender, ChatColor.RED + "You have to be actively building a ROM to run this command!");
        }

        return execute((Player) sender, cmd, commandLabel, args);
    }

    public abstract boolean execute(Player player, Command cmd, String commandLabel, String[] args);
}
