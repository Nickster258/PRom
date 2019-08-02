package org.stonecipher.repository;

import org.stonecipher.entity.Program;

import javax.persistence.EntityManager;

public class ProgramRepositoryImpl implements ProgramRepository {

    private EntityManager entityManager;

    @Override
    public Program getProgramById(long id) {
        return entityManager.find(Program.class, id);
    }

    @Override
    public void saveProgram(Program program) {
        if (program.getId() < 0) {
            entityManager.persist(program);
        } else {
            entityManager.merge(program);
        }
    }

}
