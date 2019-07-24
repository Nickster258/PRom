package org.stonecipher.repository;

import org.stonecipher.entity.Program;

import java.util.UUID;

public interface ProgramRepository {

    Program getProgramById(UUID id);

    void saveProgram(Program program);

}
