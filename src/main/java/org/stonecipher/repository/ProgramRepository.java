package org.stonecipher.repository;

import org.stonecipher.entity.Program;

public interface ProgramRepository {

    Program getProgramById(long id);

    void saveProgram(Program program);

}
