package org.stonecipher.repository;

import org.stonecipher.entity.Rom;

import java.util.UUID;

public interface RomRepository {

    Rom getRomById(UUID id);

    void saveRom(Rom rom);

    void deleteRom(Rom rom);

}
