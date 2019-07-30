package org.stonecipher.editor;

import org.bukkit.entity.Player;
import org.stonecipher.object.MinecraftRom;

public class RomBuilder {

    private Player player;
    private MinecraftRom rom;
    private int inputCount;
    private int outputCount;
    private boolean buildingInputs;
    private boolean confirmedState;

    public RomBuilder(Player player, String name, int addressable, int width) {
        this.player = player;
        this.rom = new MinecraftRom();
        this.buildingInputs = true;
        this.confirmedState = true;
        rom.setOwner(player.getUniqueId());
        rom.setWorld(player.getUniqueId());
        rom.setAddressable(addressable);
        rom.setName(name);
        rom.setWidth(width);
        // TODO get rid of unsafe cast
        rom.setLength((int) Math.pow(2, width));
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public MinecraftRom getRom() {
        return rom;
    }

    public void setRom(MinecraftRom rom) {
        this.rom = rom;
    }

    public int getInputCount() {
        return inputCount;
    }

    public void setInputCount(int inputCount) {
        this.inputCount = inputCount;
    }

    public int getOutputCount() {
        return outputCount;
    }

    public void setOutputCount(int outputCount) {
        this.outputCount = outputCount;
    }

    public boolean isBuildingInputs() {
        return buildingInputs;
    }

    public void setBuildingInputs(boolean buildingInputs) {
        this.buildingInputs = buildingInputs;
    }

    public boolean getConfirmedState() {
        return confirmedState;
    }

    public void setConfirmedState(boolean confirmedState) {
        this.confirmedState = confirmedState;
    }

    public boolean undoLastEdit() {
        if (buildingInputs) {
            if (inputCount == 0) {
                return false;
            }
            rom.removeInputAt(inputCount - 1);
        } else {
            if (outputCount == 0) {
                return false;
            }
            rom.removeOutputAt(outputCount - 1);
        }

        return true;
    }

    public void incrementInputCount() {
        this.inputCount++;
    }

    public void incrementOutputCount() {
        this.outputCount++;
    }
}
