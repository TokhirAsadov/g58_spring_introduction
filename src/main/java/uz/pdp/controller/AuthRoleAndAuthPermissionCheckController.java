package uz.pdp.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.security.RolesAllowed;

@Controller
@ResponseBody
public class AuthRoleAndAuthPermissionCheckController {

    @GetMapping("/has_admin_role")
    @PreAuthorize("hasRole('ADMIN')")
//    @Secured("ADMIN")
//    @RolesAllowed({"ADMIN","USER"})
    public String has_admin_role() {
        return "has_admin_role";
    }

    @GetMapping("/has_user_role")
    @PreAuthorize("hasRole('USER')")
    public String has_user_role() {
        return "has_user_role";
    }

    @GetMapping("/has_manager_role")
    @PreAuthorize("hasRole('MANAGER')")
    public String has_manager_role() {
        return "has_manager_role";
    }

    @GetMapping("/has_admin_user_role")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public String has_admin_user_role() {
        return "has_admin_user_role";
    }

    @GetMapping("/has_delete_manager_permission")
    @PreAuthorize("hasAuthority('DELETE_MANAGER')")
    public String has_delete_manager_permission() {
        return "has_delete_manager_permission";
    }

    @GetMapping("/has_delete_manager_create_user_permission")
    @PreAuthorize("hasAnyAuthority('DELETE_MANAGER','CREATE_USER')")
    public String has_delete_manager_create_user_permission() {
        return "has_delete_manager_create_user_permission";
    }
}
