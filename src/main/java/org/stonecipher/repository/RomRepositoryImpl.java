package org.stonecipher.repository;

import org.stonecipher.entity.Rom;

import javax.persistence.EntityManager;
import java.util.UUID;

public class RomRepositoryImpl implements RomRepository {

    private EntityManager entityManager;

    @Override
    public Rom getRomById(long id) {
        return entityManager.find(Rom.class, id);
    }

    @Override
    public void saveRom(Rom rom) {
        if (rom.getId() < 0) {
            entityManager.persist(rom);
        } else {
            entityManager.merge(rom);
        }
    }

    @Override
    public void deleteRom(Rom rom) {
        if (entityManager.contains(rom)) {
            entityManager.refresh(rom);
        } else {
            entityManager.merge(rom);
        }
    }
}
