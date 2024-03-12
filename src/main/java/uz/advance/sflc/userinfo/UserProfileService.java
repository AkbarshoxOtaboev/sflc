package uz.advance.sflc.userinfo;

public interface UserProfileService {
    void save(UserProfile userProfile, String username);

    void update(UserProfile userProfile, String username);
}
