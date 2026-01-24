package uz.pdp.config.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.dao.AuthPermissionDao;
import uz.pdp.dao.AuthRoleDao;
import uz.pdp.dao.AuthUserDao;
import uz.pdp.entity.AuthRole;
import uz.pdp.entity.AuthUser;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final AuthUserDao authUserDao;
    private final AuthRoleDao authRoleDao;
    private final AuthPermissionDao authPermissionDao;

    public CustomUserDetailsService(AuthUserDao authUserDao, AuthRoleDao authRoleDao, AuthPermissionDao authPermissionDao) {
        this.authUserDao = authUserDao;
        this.authRoleDao = authRoleDao;
        this.authPermissionDao = authPermissionDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser authUser = authUserDao.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with username " + username + " not found"));

        var roles = authRoleDao.findAuthRolesByUserId(authUser.getId());
        for (AuthRole role : roles) {
            var permissions = authPermissionDao.findAuthPermissionsByRoleId(role.getId());
            role.setPermissions(permissions);
        }
        authUser.setRoles(roles);

        return new CustomUserDetails(authUser);
    }

}
