package authserver.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class UserEntity {
    private String id;
    private String name;
    private String emailId;
    private String password;
    private Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
}
