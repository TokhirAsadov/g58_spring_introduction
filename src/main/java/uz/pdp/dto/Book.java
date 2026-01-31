package uz.pdp.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Book {
    private Integer id;
    private String title;
    private String author;
}
