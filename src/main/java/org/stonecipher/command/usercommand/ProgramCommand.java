package org.stonecipher.command.usercommand;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.stonecipher.command.RomBuilderSubCommand;

public class ProgramCommand extends RomBuilderSubCommand {

    public ProgramCommand(String name, String permission) {
        super(name, permission);
    }

    @Override
    public boolean execute(Player player, Command cmd, String commandLabel, String[] args) {
        return true;
    }

}
