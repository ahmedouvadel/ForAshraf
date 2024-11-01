package vadel.com.projectrdvmedical.Security.Controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vadel.com.projectrdvmedical.Security.Entity.Role;
import vadel.com.projectrdvmedical.Security.Entity.User;
import vadel.com.projectrdvmedical.Security.Service.IServiceAuth.IServiceAuth;

@RestController
@RequestMapping(path = "/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final IServiceAuth iServiceAuth;

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User appUser) {
        User createdUser = iServiceAuth.createAppUser(appUser);
        return ResponseEntity.ok(createdUser);
    }

    // Action pour ajouter un nouveau rôle
    @PostMapping("/addRole")
    public ResponseEntity<Role> addRole(@RequestBody Role appRole) {
        Role createdRole = iServiceAuth.createAppRole(appRole);
        return ResponseEntity.ok(createdRole);
    }

    // Action pour ajouter un rôle existant à un utilisateur existant
    @PostMapping("/addRoleToUser")
    public ResponseEntity<String> assignRoleToUser(@RequestParam String username, @RequestParam String roleName) {
        iServiceAuth.addRoleToUser(username, roleName);
        return ResponseEntity.ok("Role " + roleName + " assigned to user " + username);
    }

}
