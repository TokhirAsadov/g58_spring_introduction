package uz.pdp.entity;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookCreateDto {
    private String title;
    private String description;
    private MultipartFile[] files;
}
