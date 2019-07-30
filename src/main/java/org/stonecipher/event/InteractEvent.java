package org.stonecipher.event;

import org.bukkit.block.Block;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.stonecipher.PRom;
import org.stonecipher.editor.RomBuilder;
import org.stonecipher.entity.Input;
import org.stonecipher.entity.Output;

public class InteractEvent implements Listener {

    public void onBreak(PlayerInteractEvent playerInteractEvent) {
        RomBuilder builder = PRom.builders.stream()
                .filter(romBuilder -> romBuilder.getPlayer().equals(playerInteractEvent.getPlayer()))
                .findFirst().get();

        // Check if the builder exists, the action was a left click, and the previous action was confirmed
        if ((builder == null) || (playerInteractEvent.getAction().equals(Action.LEFT_CLICK_BLOCK)) || (!builder.getConfirmedState())) {
            return;
        }

        Block clickedBlock = playerInteractEvent.getClickedBlock();
        Block selectedBlock = clickedBlock.getRelative(playerInteractEvent.getBlockFace());

        if (builder.getConfirmedState()) {
            if (builder.isBuildingInputs()) {
                builder.getRom().addInput(new Input(selectedBlock.getLocation(), builder.getInputCount()));
                builder.incrementInputCount();
            } else {
                builder.getRom().addOutput(new Output(selectedBlock.getLocation(), builder.getOutputCount()));
                builder.incrementOutputCount();
            }
        } else {
            if (builder.isBuildingInputs()) {
                builder.getRom().addInput(new Input(selectedBlock.getLocation(), builder.getInputCount()-1));
                builder.incrementInputCount();
            } else {
                builder.getRom().addOutput(new Output(selectedBlock.getLocation(), builder.getOutputCount()-1));
                builder.incrementOutputCount();
            }
        }

        if (builder.getInputCount() == builder.getRom().getAddressable()) {
            builder.setBuildingInputs(false);
        }

        builder.setConfirmedState(false);

    }

}
