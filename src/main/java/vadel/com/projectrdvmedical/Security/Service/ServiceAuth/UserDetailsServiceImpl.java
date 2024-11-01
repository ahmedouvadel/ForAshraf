package vadel.com.projectrdvmedical.Security.Service.ServiceAuth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vadel.com.projectrdvmedical.Security.Entity.Role;
import vadel.com.projectrdvmedical.Security.Entity.User;
import vadel.com.projectrdvmedical.Security.Service.IServiceAuth.IServiceAuth;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final IServiceAuth iServiceAuth;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User appUser = iServiceAuth.LoadUserByUserName(username);
        if(appUser == null) throw new UsernameNotFoundException("User with " + username + "does not exist");
        String[] roles = appUser.getRoleList().stream().map(Role::getRoleName).toArray(String[]::new);
        return org.springframework.security.core.userdetails.User
                .withUsername(appUser.getUsername())
                .password(appUser.getPassword())
                .roles(roles)
                .build();
    }
}
