package uz.pdp.dto;


public record UserCreator(
        Integer id,
        String lastName,
        String firstName,
        Integer age
) {
}
