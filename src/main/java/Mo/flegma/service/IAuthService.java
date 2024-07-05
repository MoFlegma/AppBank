package Mo.flegma.service;

import Mo.flegma.dto.AuthResponse;
import Mo.flegma.dto.LoginRequest;
import Mo.flegma.dto.RegisterRequest;

public interface IAuthService {
    public AuthResponse register (RegisterRequest registerRequest);

    public AuthResponse login(LoginRequest loginRequest);


}
