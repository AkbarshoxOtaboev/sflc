package uz.advance.sflc.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService{
    private final UserRepository repository;
    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public User create(User user) {
        if(repository.existsByUsername(user.getUsername())){
            throw  new RuntimeException("Пользователь с таким именем уже существует");
        }
        return save(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return repository.findUserByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Пользователь не найден"));
    }

    @Override
    public UserDetailsService userDetailsService() {
        return this::getUserByUsername;
    }

    @Override
    public User getCurrentUser() {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByUsername(username);
    }

    @Override
    public User update(String username, User user) {
        var updUser = getUserByUsername(username);
        updUser.setUsername(user.getUsername());
        updUser.setPassword(user.getPassword());
        updUser.setFullName(user.getFullName());
        return repository.saveAndFlush(updUser);
    }
}
