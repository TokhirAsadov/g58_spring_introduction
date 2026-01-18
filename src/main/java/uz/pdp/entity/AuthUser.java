package uz.pdp.entity;

import lombok.*;

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
    private String role;
}
