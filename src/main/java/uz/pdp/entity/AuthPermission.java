package uz.pdp.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AuthPermission {
    private Integer id;
    private String name;
    private String code;
}
