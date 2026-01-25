package uz.pdp.controller;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.dao.UploadDao;
import uz.pdp.entity.BookCreateDto;
import uz.pdp.entity.Upload;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Controller
public class FileUploadAndDownloadController {

    private final Path rootPath = Path.of("D:/pdp/G58/Spring/spring/spring_introduction/uploads");
    private final UploadDao dao;

    public FileUploadAndDownloadController(UploadDao dao) {
        this.dao = dao;
    }

    @GetMapping("/upload")
    public String uploadPage() {
        return "upload";
    }

    @PostMapping("/upload")
    public String uploading(
            @ModelAttribute BookCreateDto dto
    ) throws IOException {
        System.out.println("Dto: " + dto);
        for (MultipartFile file : dto.getFiles()) {
            String originalFilename = file.getOriginalFilename();
            System.out.println("Original filename: " + originalFilename);
            String generatedName = UUID.randomUUID() + "." + StringUtils.getFilenameExtension(originalFilename);
            System.out.println("Generated filename: " + generatedName);
            Path path = rootPath.resolve(generatedName);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            dao.save(Upload.builder()
                    .originalFileName(originalFilename)
                    .generatedFileName(generatedName)
                    .mimeType(file.getContentType())
                    .size(file.getSize())
                    .build());
        }
        return "redirect:/upload";
    }

    @GetMapping("/download/{generatedFileName:.+}")
    public ResponseEntity<Resource> downloadFile(
            @PathVariable(name = "generatedFileName") String generatedFileName
    ) throws IOException {
        Upload upload = dao.findByGeneratedFileName(generatedFileName);
        Path path = rootPath.resolve(upload.getGeneratedFileName());
        Resource resource = new org.springframework.core.io.UrlResource(path.toUri());
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=\"" + upload.getOriginalFileName() + "\"")
                .header("Content-Type", upload.getMimeType())
                .body(resource);
    }



    /*@GetMapping("/test")
    @ResponseBody
    public String testPage(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "age") Integer age
    ) {
        return "Name: " + name + ", Age: " + age;
    }

    @GetMapping("/books/{id}")
    @ResponseBody
    public String getBookById(
            @PathVariable(name = "id") Integer id
    ) {
        return "Book id: " + id;
    }*/

}
