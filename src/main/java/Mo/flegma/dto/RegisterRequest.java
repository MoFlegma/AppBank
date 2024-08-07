package Mo.flegma.dto;

import Mo.flegma.entities.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {
    @NotBlank
    @Size(min = 3, max=30)
    private String name;

    @NotBlank
    @Email
    @Size(min = 6, max=60)
    private String email;

    @NotBlank
    @Size(min = 8, max = 30)
    private String password;


}
