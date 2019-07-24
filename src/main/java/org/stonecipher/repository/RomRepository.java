package org.stonecipher.repository;

import org.stonecipher.entity.Rom;

public interface RomRepository {

    Rom getRomById(long id);

    void saveRom(Rom rom);

    void deleteRom(Rom rom);

}
