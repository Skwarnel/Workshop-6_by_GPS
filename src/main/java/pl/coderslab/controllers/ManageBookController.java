package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.beans.Book;
import pl.coderslab.mocks.BookService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/books")
public class ManageBookController {

    private final BookService bookService;

    public ManageBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public String showPosts(Model model) {
        List<Book> books = bookService.getBooksList();
        model.addAttribute("books", bookService.getBooksList());
        return "all";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveBook(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/add";
        }
        bookService.add(book);
        return "redirect:/admin/books/all";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable long id, Model model) {
        model.addAttribute("book", bookService.get(id));
        return "/editBook";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editBook(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/edit";
        }
        bookService.add(book);
        return "redirect:/admin/books/all";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable long id) {
        bookService.delete(id);
        return "redirect:/admin/books/all";
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String showBook(@PathVariable long id, Model model) {
        model.addAttribute("book", bookService.get(id).orElseThrow(EntityNotFoundException::new));
        return "showBook";
    }
}

