package Mo.flegma.service.implementation;

import Mo.flegma.dto.UserDto;
import Mo.flegma.entities.User;
import Mo.flegma.repository.UserRepository;
import Mo.flegma.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDto create(UserDto e) {
        return null;
    }

    @Override
    public List<UserDto> listing() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto read(UUID pk) {
        return null;
    }

    @Override
    public UserDto update(UUID pk, UserDto e) {
        return null;
    }

    @Override
    public void delete(UUID pk) {

    }
}
