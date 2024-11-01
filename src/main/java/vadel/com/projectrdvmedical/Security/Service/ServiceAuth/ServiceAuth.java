package vadel.com.projectrdvmedical.Security.Service.ServiceAuth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vadel.com.projectrdvmedical.Security.Entity.Role;
import vadel.com.projectrdvmedical.Security.Entity.User;
import vadel.com.projectrdvmedical.Security.Repository.RoleRepository;
import vadel.com.projectrdvmedical.Security.Repository.UserRepository;
import vadel.com.projectrdvmedical.Security.Service.IServiceAuth.IServiceAuth;

@Service
@RequiredArgsConstructor
public class ServiceAuth implements IServiceAuth {
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    @Override
    public User createAppUser(User appUser) {
        if (userRepository.findByUsername(appUser.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return userRepository.save(appUser);
    }
    @Override
    public Role createAppRole(Role appRole) {
        if(roleRepository.findByRoleName(appRole.getRoleName()).isPresent()) {
            throw new IllegalArgumentException("The role already exists");
        }
        return roleRepository.save(appRole);
    }
    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Role role = roleRepository.findByRoleName(roleName)
                .orElseThrow(() -> new IllegalArgumentException("Role not found"));
        user.getRoleList().add(role);
        userRepository.save(user);
    }

    @Override
    public User LoadUserByUserName(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User with username " + username + " not found") );
    }
}
