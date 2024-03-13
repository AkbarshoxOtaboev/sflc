package uz.advance.sflc.userinfo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.advance.sflc.utils.TableName;
import uz.advance.sflc.user.User;

import java.util.Date;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = TableName.USERPROFILE)
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phone;
    private Date birthDay;
    private String passportID;
    private String address;
    private String photo;

    @JsonIgnore
    @OneToOne(mappedBy = "userProfile")
    private User user;

}
