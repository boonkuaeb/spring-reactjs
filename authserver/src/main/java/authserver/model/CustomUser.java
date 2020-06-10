package authserver.model;


import lombok.Data;
import org.springframework.security.core.userdetails.User;

@Data
public class CustomUser extends User {
    private String id;
    private String name;

    public CustomUser(UserEntity userEntity) {
        super(userEntity.getEmailId(), userEntity.getPassword(), userEntity.getGrantedAuthoritiesList());
        this.id = userEntity.getId();
        this.name = userEntity.getName();
    }
}
