package Mo.flegma.service;

import Mo.flegma.dto.AccountDto;

import java.util.UUID;

public interface IAccountService extends ICrud<AccountDto, UUID>{
    public AccountDto deposit(UUID accountDto, double amount);
}
