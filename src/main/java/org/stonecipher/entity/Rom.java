package org.stonecipher.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "rommanager_rom")
public class Rom {

    @Id
    @Column (name = "rom_id", updatable = false, nullable = false)
    private long id;

    @Column (name = "rom_world")
    private UUID world;

    @Column (name = "rom_owner")
    private UUID owner;

    @Column (name = "rom_name")
    private String name;

    @Column (name = "rom_addressable")
    private int addressable;

    @Column (name = "rom_width")
    private int width;

    @Column (name = "rom_length")
    private int length;

    @OneToMany
    private List<Input> inputs = new ArrayList<>();

    @OneToMany
    private List<Output> outputs = new ArrayList<>();

    public Output getOutputAt(int sequence) {
        return outputs.stream()
                .filter(output -> output.getSequence() == sequence).findFirst().get();
    }

    public Input getInputAt(int sequence) {
        return inputs.stream()
                .filter(input -> input.getSequence() == sequence).findFirst().get();
    }

    public void addInput(Input input) {
        inputs.add(input);
    }

    public void addOutput(Output output) {
        outputs.add(output);
    }

    public void removeInput(Input input) {
        inputs.remove(input);
    }

    public void removeOutput(Output output) {
        outputs.remove(output);
    }

    public void removeInputAt(int index) {
        inputs.remove(index);
    }

    public void removeOutputAt(int index) {
        outputs.remove(index);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UUID getWorld() {
        return world;
    }

    public void setWorld(UUID world) {
        this.world = world;
    }

    public UUID getOwner() {
        return owner;
    }

    public void setOwner(UUID owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAddressable() {
        return addressable;
    }

    public void setAddressable(int addressable) {
        this.addressable = addressable;
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
