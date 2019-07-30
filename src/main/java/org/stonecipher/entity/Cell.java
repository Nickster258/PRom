package org.stonecipher.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table (name = "rommanager_cell")
public class Cell {

    @Column (name = "cell_programid")
    private long programId;

    @Column (name = "cell_column")
    private int column;

    @Column (name = "cell_row")
    private int row;

    public long getProgramId() {
        return programId;
    }

    public void setProgramId(long programId) {
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

}
