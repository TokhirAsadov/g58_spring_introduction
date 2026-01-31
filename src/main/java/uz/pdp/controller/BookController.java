package uz.pdp.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.dto.Book;
import uz.pdp.exceptions.BookNotFoundException;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Controller
@RequestMapping("/books")
public class BookController {
    private final MessageSource messageSource;
    private final List<Book> books = List.of(
            new Book(1, "1984", "George Orwell"),
            new Book(2, "To Kill a Mockingbird", "Harper Lee"),
            new Book(3, "The Great Gatsby", "F. Scott Fitzgerald")
    );

    public BookController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("")
    public String allBooks(Model model) {
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/{bookId}")
    public String getBookById(@PathVariable(name = "bookId") Integer bookId, Model model,
                              @CookieValue(name = "language", required = false) String langCookie,
                              @RequestParam(name = "lang", required = false) String language
                              ) {

//        throw new ArrayIndexOutOfBoundsException("Custom exception for testing global handler");
        String lang = Objects.requireNonNullElse(language, langCookie != null ? langCookie : "uz");
        String errorMessage = messageSource.getMessage("book.not.found.error", new Object[]{bookId}, Locale.forLanguageTag(lang));
        Book book = books.stream()
                .filter(b -> b.getId().equals(bookId))
                .findFirst()
                .orElseThrow(
                   () -> new BookNotFoundException(errorMessage)
                );
        model.addAttribute("book", book);
        return "book-detail";
    }

   /* @ExceptionHandler({BookNotFoundException.class})
    public ModelAndView error_404(HttpServletRequest request, BookNotFoundException ex) {
        ModelAndView modelAndView = new ModelAndView("error/404");
        modelAndView.addObject("message", ex.getMessage());
        modelAndView.addObject("url", request.getRequestURL());
        return modelAndView;
    }*/
}
