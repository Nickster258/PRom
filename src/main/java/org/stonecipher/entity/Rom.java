package org.stonecipher.entity;

import java.util.UUID;

public class Rom {

    private String name;
    private int bitWidth;
    private int lines;
    private UUID owner;
    private boolean[][] rom;

    public Rom(String name, int bitWidth, int lines, UUID owner) {
        this.name = name;
        this.bitWidth = bitWidth;
        this.lines = lines;
        this.owner = owner;
        this.rom = new boolean[bitWidth][lines];
    }

    public void setValueAt(int bit, int line, boolean value) {
        rom[bit][line] = value;
    }

    public boolean getValueAt(int bit, int line) {
        return rom[bit][line];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBitWidth() {
        return bitWidth;
    }

    public void setBitWidth(int bitWidth) {
        this.bitWidth = bitWidth;
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public UUID getOwner() {
        return owner;
    }

    public void setOwner(UUID owner) {
        this.owner = owner;
    }

    public boolean[][] getRom() {
        return rom;
    }

    public void setRom(boolean[][] rom) {
        this.rom = rom;
    }
}
