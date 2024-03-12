package uz.advance.sflc.userinfo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.advance.sflc.user.UserService;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {
    private final UserProfileRepository userProfileRepository;
    private final UserService userService;
    @Override
    public void save(UserProfile userProfile, String username) {
        var user = userService.getUserByUsername(username);
        user.setUserProfile(userProfile);
        userService.save(user);
    }

    @Override
    public void update(UserProfile userProfile, String username) {
        var user = userService.getUserByUsername(username);
        var updUserProfile = user.getUserProfile();
        updUserProfile.setPhoto(userProfile.getPhoto());
        updUserProfile.setBirthDay(userProfile.getBirthDay());
        updUserProfile.setPassportID(userProfile.getPassportID());
        updUserProfile.setAddress(userProfile.getAddress());
        updUserProfile.setPhoto(userProfile.getPhoto());
        user.setUserProfile(updUserProfile);
        userService.update(username, user);
    }
}
