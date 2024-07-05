package Mo.flegma.controller;

import Mo.flegma.dto.UserDto;
import Mo.flegma.service.IUserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
@Tag(name = "UsersRoutes")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> listing(){
        return userService.listing();
    }



}
