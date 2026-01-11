package uz.pdp.user;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
}
