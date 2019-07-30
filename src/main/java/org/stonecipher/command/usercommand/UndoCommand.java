package org.stonecipher.command.usercommand;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.stonecipher.PRom;
import org.stonecipher.command.RomBuilderSubCommand;
import org.stonecipher.editor.RomBuilder;

public class UndoCommand extends RomBuilderSubCommand {

    public UndoCommand(String name, String permission) {
        super(name, permission);
    }

    @Override
    public boolean execute(Player player, Command cmd, String commandLabel, String[] args) {
        RomBuilder builder = PRom.getBuilder(player);

        boolean result = builder.undoLastEdit();
        if (result) {
            PRom.sendMessage(player, "Undo successful.");
        } else {
            PRom.sendMessage(player, "Nothing left to undo.");
        }
        return true;
    }
}
