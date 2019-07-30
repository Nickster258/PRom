package org.stonecipher.command.usercommand;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.stonecipher.command.RomBuilderSubCommand;

public class EditCommand extends RomBuilderSubCommand {

    public EditCommand(String name, String permission) {
        super(name, permission);
    }

    @Override
    public boolean execute(Player player, Command cmd, String commandLabel, String[] args) {
        return true;
    }

}
