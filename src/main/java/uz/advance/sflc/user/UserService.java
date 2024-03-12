package uz.advance.sflc.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


public interface UserService {
    User save(User user);

    User create(User user);

    User getUserByUsername(String username);

    UserDetailsService userDetailsService();

    User getCurrentUser();

    User update(String username, User user);
}
