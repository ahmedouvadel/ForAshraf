package vadel.com.projectrdvmedical.Security.Service.IServiceAuth;

import vadel.com.projectrdvmedical.Security.Entity.Role;
import vadel.com.projectrdvmedical.Security.Entity.User;

public interface IServiceAuth {

    User createAppUser(User appUser);
    Role createAppRole(Role appRole);
    void addRoleToUser(String username, String role);
    User LoadUserByUserName(String username);
}
