package org.stonecipher.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "rommanager_rom")
public class Rom {

    @Column (name = "rom_id", updatable = false, nullable = false)
    private UUID id;

    @Column (name = "rom_owner")
    private UUID owner;

    @Column (name = "rom_width")
    private int width;

    @Column (name = "rom_length")
    private int length;

    @OneToMany
    private List<Input> inputs = new ArrayList<Input>();

    @OneToMany
    private List<Output> outputs = new ArrayList<Output>();

    public Output getOutputAt(int sequence) {
        for (Output output : outputs) {
            if (output.getSequence() == sequence) {
                return output;
            }
        }
        return null;
    }

    public Input getInputAt(int sequence) {
        for (Input input : inputs) {
            if (input.getSequence() == sequence) {
                return input;
            }
        }
        return null;
    }

    public void addInput(Input input) {
        inputs.add(input);
    }

    public void addOutput(Output output) {
        outputs.add(output);
    }

    public void removeInput(Input toRemove) {
        int index = 0;
        for (Input input : inputs) {
            if (input.equals(toRemove)) {
                index = inputs.indexOf(input);
            }
        }
        inputs.remove(index);
    }

    public void removeOutput(Output toRemove) {
        int index = 0;
        for (Output output : outputs) {
            if (output.equals(toRemove)) {
                index = outputs.indexOf(output);
            }
        }
        outputs.remove(index);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getOwner() {
        return owner;
    }

    public void setOwner(UUID owner) {
        this.owner = owner;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int lines) {
        this.length = length;
    }

}
