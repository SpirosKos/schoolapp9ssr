package gr.aueb.cf.schoolapp.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserInsertDTO(

        @NotNull(message = "Username cannot be empty.")
        @Size(min = 2, max = 20, message = "Username must be between 2-20 characters")
        String username,

        @NotNull(message = "Password cannot be empty")
        @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*+=])^.{8,}$")
        String password,


        @NotNull(message = "Role cannot be empty")
        Long roleId
) {

    public static UserInsertDTO empty(){
        return new UserInsertDTO("","", 0L);
    }
}
