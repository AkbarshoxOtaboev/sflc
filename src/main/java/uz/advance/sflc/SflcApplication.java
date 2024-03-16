package uz.advance.sflc;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import uz.advance.sflc.auth.RegisterRequest;
import uz.advance.sflc.user.Role;
import uz.advance.sflc.user.User;
import uz.advance.sflc.user.UserService;

@SpringBootApplication
@RequiredArgsConstructor
public class SflcApplication {
    private final PasswordEncoder passwordEncoder;
    public static void main(String[] args) {
        SpringApplication.run(SflcApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(UserService userService){
        return args -> {
            var admin = User.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("12345678"))
                    .fullName("Admin Admin")
                    .role(Role.ADMIN)
                    .build();
            userService.create(admin);

            var user = User.builder()
                    .username("user")
                    .password(passwordEncoder.encode("12345678"))
                    .fullName("User user")
                    .role(Role.USER)
                    .build();
            userService.create(user);
        };
    }
}
