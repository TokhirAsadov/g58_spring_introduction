package uz.pdp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Book {
    private Integer id;
    @NotBlank(message = "Title cannot be blank")
    private String title;
    @NotBlank(message = "Author cannot be blank")
    private String author;
}
