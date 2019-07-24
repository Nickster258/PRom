package org.stonecipher.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table (name = "rommanager_program")
public class Program {

    @Column (name = "program_id")
    private UUID id;

    @Column (name = "program_romid")
    private UUID romId;

    @Column (name = "program_title")
    private String title;

    @OneToMany
    private List<Cell> cells = new ArrayList<Cell>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getRomId() {
        return romId;
    }

    public void setRomId(UUID romId) {
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
