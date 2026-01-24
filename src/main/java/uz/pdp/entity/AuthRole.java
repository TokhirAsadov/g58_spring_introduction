package uz.pdp.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AuthRole {
    private Integer id;
    private String name;
    private String code;
    private List<AuthPermission> permissions;
}
