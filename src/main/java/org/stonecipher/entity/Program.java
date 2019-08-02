package org.stonecipher.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "rommanager_program")
public class Program {

    @Id
    @Column (name = "program_id")
    private long id;

    @Column (name = "program_romid")
    private long romId;

    @Column (name = "program_title")
    private String title;

    @OneToMany
    private List<Cell> cells = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRomId() {
        return romId;
    }

    public void setRomId(long romId) {
        this.romId = romId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

}
