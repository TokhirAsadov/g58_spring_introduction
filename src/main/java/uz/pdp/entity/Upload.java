package uz.pdp.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Upload {
    private Integer id;
    private String originalFileName;
    private String generatedFileName;
    private String mimeType;
    private Long size;
}
