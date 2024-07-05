package Mo.flegma.dto;

import Mo.flegma.entities.Account;
import Mo.flegma.entities.TransactionType;
import Mo.flegma.entities.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private TransactionType transactionType;

    @PositiveOrZero
    private double amount;

    private LocalDate dateTransaction;

    private AccountDto originAccount;

    private AccountDto destinationAccount;

    private UserDto userTransaction;
}
