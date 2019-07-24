package org.stonecipher.command.usercommand;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.stonecipher.command.RomSubCommand;

public class ProgramCommand extends RomSubCommand {

    public ProgramCommand(String name, String permission) {
        super(name, permission);
    }

    @Override
    public boolean execute(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        return true;
    }

}
