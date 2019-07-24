package org.stonecipher.editor;

import org.bukkit.entity.Player;
import org.stonecipher.entity.Rom;

public class RomBuilder {

    private Player player;
    private Rom rom;

    public RomBuilder(Player player) {
        this.player = player;
        this.rom = new Rom();
        rom.setOwner(player.getUniqueId());
    }

}
