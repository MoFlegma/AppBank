package Mo.flegma.dto;


import Mo.flegma.deserializer.UserDtoDeserializer;
import Mo.flegma.entities.Role;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonDeserialize(using = UserDtoDeserializer.class)
public class UserDto {

    private UUID id;

    private String name;

    private String email;

    private Role role;

    //private AccountDto account;
}
