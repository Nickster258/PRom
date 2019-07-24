package org.stonecipher.repository;

import org.stonecipher.entity.Program;

import javax.persistence.EntityManager;
import java.util.UUID;

public class ProgramRepositoryImpl implements ProgramRepository {

    private EntityManager entityManager;

    @Override
    public Program getProgramById(UUID id) {
        return entityManager.find(Program.class, id);
    }

    @Override
    public void saveProgram(Program program) {
        if (program.getId() == null) {
            entityManager.persist(program);
        } else {
            entityManager.merge(program);
        }
    }

}
