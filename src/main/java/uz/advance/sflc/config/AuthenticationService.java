package uz.advance.sflc.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.advance.sflc.dto.JwtAuthenticationResponse;
import uz.advance.sflc.dto.SignInRequest;
import uz.advance.sflc.user.UserService;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    public JwtAuthenticationResponse signIn(SignInRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));
        var user = userService.userDetailsService().loadUserByUsername(request.getUsername());
        var accessToken = jwtService.generateToken(user);
        return  new JwtAuthenticationResponse(accessToken);
    }
}
