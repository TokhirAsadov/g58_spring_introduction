package uz.pdp.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AuthUser {
    private Integer id;
    private String username;
    private String password;
    private List<AuthRole> roles;
}
