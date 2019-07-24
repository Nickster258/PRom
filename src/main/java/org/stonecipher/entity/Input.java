package org.stonecipher.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table (name = "rommanager_input")
public class Input {

    @Column (name = "input_romid")
    private UUID id;

    @Column (name = "input_sequence")
    private int sequence;

    @Column (name = "input_x")
    private int x;

    @Column (name = "input_y")
    private int y;

    @Column (name = "input_z")
    private int z;

    public UUID getRomId() {
        return id;
    }

    public void setRomId(UUID id) {
        this.id = id;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

}
