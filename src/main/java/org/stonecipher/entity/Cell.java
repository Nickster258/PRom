package org.stonecipher.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table (name = "rommanager_cell")
public class Cell {

    @Column (name = "cell_romid", updatable = false)
    private UUID romId;

    @Column (name = "cell_programid")
    private UUID programId;

    @Column (name = "cell_column")
    private int column;

    @Column (name = "cell_row")
    private int row;

    @Column (name = "cell_value")
    private boolean value;

    public UUID getRomId() {
        return romId;
    }

    public void setRomId(UUID romId) {
        this.romId = romId;
    }

    public UUID getProgramId() {
        return programId;
    }

    public void setProgramId(UUID programId) {
        this.programId = programId;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

}
