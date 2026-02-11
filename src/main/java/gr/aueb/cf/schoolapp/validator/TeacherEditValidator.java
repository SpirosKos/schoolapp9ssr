package gr.aueb.cf.schoolapp.validator;

import gr.aueb.cf.schoolapp.core.exceptions.EntinyNotFoundException;
import gr.aueb.cf.schoolapp.dto.TeacherEditDTO;
import gr.aueb.cf.schoolapp.service.ITeacherService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
@RequiredArgsConstructor
@Slf4j
public class TeacherEditValidator implements Validator {

    private final ITeacherService teacherService;

    @Override
    public boolean supports(Class<?> clazz) {
        return TeacherEditDTO.class == clazz;  // or class == clazz
    }

    @Override
    public void validate(Object target, Errors errors) {
        TeacherEditDTO teacherEditDTO = (TeacherEditDTO) target;

        try {
            TeacherEditDTO  savedTeacher = teacherService.getTeacherByUUID(teacherEditDTO.uuid());

            if (savedTeacher != null && !savedTeacher.vat().equals(teacherEditDTO.vat())) {
                if (teacherService.isTeacherExists(teacherEditDTO.vat())) {
                    log.warn("Save failed. Teacher with vat={} already exists", teacherEditDTO.vat());
                    errors.rejectValue("vat", "vat.teacher.exist");
                }
            }
        }catch (EntityNotFoundException e) {
            log.warn("Save failed.Teacher with uuid={} not found.", teacherEditDTO.uuid());
            errors.rejectValue("uuid", "uuid.teacher.notfound");
        }

    }
}
