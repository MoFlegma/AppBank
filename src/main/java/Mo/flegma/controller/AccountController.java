package Mo.flegma.controller;

import Mo.flegma.dto.AccountDto;
import Mo.flegma.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/account/")
@RequiredArgsConstructor
public class AccountController {

    private final IAccountService iAccountService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<AccountDto> getAllAccounts(){
        return iAccountService.listing();
    }

    @PostMapping("create")
    @PreAuthorize("hasAuthority({'ADMIN', 'CLIENT'})")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountDto createAccount(@RequestBody AccountDto accountDto) {
        return iAccountService.create(accountDto);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountDto read(@PathVariable("id")UUID id){
        return iAccountService.read(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AccountDto update(@PathVariable("id") UUID id, @RequestBody AccountDto accountDto){
        return iAccountService.update(id, accountDto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") UUID id){
        iAccountService.delete(id);
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String HelloAdmin(){
        return "Bonjour admin";
    }

}
