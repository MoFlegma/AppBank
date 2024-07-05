package Mo.flegma.service.implementation;

import Mo.flegma.dto.AccountDto;
import Mo.flegma.entities.Account;
import Mo.flegma.entities.AccountCeilingConfig;
import Mo.flegma.entities.User;
import Mo.flegma.exception.ClassNotFoundException;
import Mo.flegma.repository.AccountRepository;
import Mo.flegma.repository.UserRepository;
import Mo.flegma.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private final ModelMapper modelMapper;
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    @Override
    public AccountDto create(AccountDto accountDto) {
        Account account = modelMapper.map(accountDto, Account.class);
        account.setCeiling(AccountCeilingConfig.getCeiling(account.getType()));
        // Trouver l'utilisateur par ID et l'associer au compte
        User owner = userRepository.findById(accountDto.getOwner().getId())
                    .orElseThrow(()-> new ClassNotFoundException(accountDto.getOwner().getId(), User.class.getName()));
        account.setOwner(owner);
        owner.setAccount(account);
        account.setActive(true);
        Account savedAccount = accountRepository.save(account);
        return modelMapper.map(savedAccount, AccountDto.class);
    }

    @Override
    public List<AccountDto> listing() {
        List<Account> accountList = accountRepository.findAll();
        return accountList.stream().map((account) -> modelMapper.map(account, AccountDto.class)).collect(Collectors.toList());
    }

    @Override
    public AccountDto read(UUID id) {
        Optional<Account>optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isPresent()){
            Account account = optionalAccount.get();
            return modelMapper.map(account, AccountDto.class);
        }
        else throw new ClassNotFoundException(id, Account.class.getName());
    }

    @Override
    public AccountDto update(UUID id, AccountDto accountDto) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isPresent()){
            Account account = optionalAccount.get();
            account.setType(accountDto.getType());

            Account updateAccount = accountRepository.save(account);
            return modelMapper.map(account, AccountDto.class);
        }else throw new ClassNotFoundException(id, Account.class.getName());
    }

    @Override
    public void delete(UUID id) {
        Optional<Account> optionalPerson = accountRepository.findById(id);
        if(optionalPerson.isPresent()){
            accountRepository.deleteById(id);
        }else throw new ClassNotFoundException(id, Account.class.getName());
    }

    @Override
    public AccountDto deposit(UUID accountNumber, double amount) {
        Optional<Account> optionalAccount = accountRepository.findById(accountNumber);
        if (optionalAccount.isEmpty()) {
            throw new RuntimeException("Account does not exist");
        }
        Account account = optionalAccount.get();
        if (account.getSold() + amount > account.getCeiling()) {
            throw new IllegalArgumentException("Deposit amount exceeds account plafond");
        }
        account.setSold(account.getSold() + amount);
        Account updatedAccount = accountRepository.save(account);
        return modelMapper.map(updatedAccount, AccountDto.class);
    }
}
