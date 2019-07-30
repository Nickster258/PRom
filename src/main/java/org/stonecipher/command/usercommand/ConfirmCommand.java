package org.stonecipher.command.usercommand;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.stonecipher.PRom;
import org.stonecipher.command.RomBuilderSubCommand;
import org.stonecipher.editor.RomBuilder;

public class ConfirmCommand extends RomBuilderSubCommand {

    public ConfirmCommand(String name, String permission) {
        super(name, permission);
    }

    @Override
    public boolean execute(Player player, Command cmd, String commandLabel, String[] args) {
        RomBuilder builder = PRom.getBuilder(player);

        builder.setConfirmedState(true);
        return true;
    }

}
