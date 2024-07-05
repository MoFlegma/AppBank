package Mo.flegma.service;

import Mo.flegma.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface IUserService extends ICrud<UserDto, UUID>{
}
