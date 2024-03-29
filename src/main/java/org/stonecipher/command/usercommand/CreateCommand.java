package org.stonecipher.command.usercommand;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.stonecipher.PRom;
import org.stonecipher.command.RomBuilderSubCommand;
import org.stonecipher.editor.RomBuilder;

public class CreateCommand extends RomBuilderSubCommand {

    public CreateCommand(String name, String permission) {
        super(name, permission);
    }

    @Override
    public boolean execute(Player player, Command cmd, String commandLabel, String[] args) {
        if (args.length < 3) {
            return false;
        }

        // TODO get rid of unsafe cast
        PRom.builders.add(new RomBuilder(player, args[0], Integer.valueOf(args[1]), Integer.valueOf(args[2])));
        return true;
    }

}
