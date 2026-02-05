package gr.aueb.cf.schoolapp.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record TeacherInsertDTO(

        @NotNull(message = "Firstname cannot be empty")
        @Size (min = 2, message = "Firstname must contain at least 2 characters")
        String firstname,

        @NotNull(message = "Lastname cannot be empty")
        @Size (min = 2, message = "Lastname must contain at least 2 characters")
        String lastname,

        @Pattern(regexp = "\\d{9,}", message = "VAT cannot be less than 9 digits")
        String vat,

        @NotNull(message = "Region cannot be empty")
        Long regionId
) {

    public static TeacherInsertDTO empty() {
        return new TeacherInsertDTO("","","",0L);
    }
}
