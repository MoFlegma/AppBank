package Mo.flegma.dto;

import Mo.flegma.entities.Sexe;
import Mo.flegma.entities.Type;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID accountNumber;

    @NotBlank
    @PositiveOrZero
    private double sold;

    private Type type;

    @PositiveOrZero
    private double ceiling;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    private boolean isActive;

    private UserDto owner;

}
