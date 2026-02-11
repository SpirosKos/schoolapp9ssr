package gr.aueb.cf.schoolapp.service;

import gr.aueb.cf.schoolapp.core.exceptions.EntinyNotFoundException;
import gr.aueb.cf.schoolapp.core.exceptions.EntityAlreadyExistsException;
import gr.aueb.cf.schoolapp.core.exceptions.EntityInvalidArgumentException;
import gr.aueb.cf.schoolapp.dto.TeacherEditDTO;
import gr.aueb.cf.schoolapp.dto.TeacherInsertDTO;
import gr.aueb.cf.schoolapp.dto.TeacherReadOnlyDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ITeacherService {
    TeacherReadOnlyDTO saveTeacher(TeacherInsertDTO teacherInsertDTO)
            throws EntityAlreadyExistsException, EntityInvalidArgumentException;

    public boolean isTeacherExists(String uuid);

    Page<TeacherReadOnlyDTO> getPaginatedTeachers(Pageable pageable);
    Page<TeacherReadOnlyDTO> getPaginatedTeachersDeletedFalse(Pageable pageable);


    TeacherEditDTO getTeacherByUUID(UUID uuid) throws EntityNotFoundException;

    TeacherReadOnlyDTO updateTeacher(TeacherEditDTO teacherEditDTO)
            throws EntityNotFoundException, EntityAlreadyExistsException, EntityInvalidArgumentException;

    TeacherReadOnlyDTO deleteTeacherByUUID(UUID uuid) throws EntinyNotFoundException;
}