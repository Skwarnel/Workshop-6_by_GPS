package pl.coderslab.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.beans.Book;
import pl.coderslab.mocks.BookService;

import java.util.List;
//Workshop 05 finished
@RestController
@RequestMapping("/books")
public class BookController {

    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    @ResponseBody
    public List<Book> getList() {
        return bookService.getBooksList();
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        bookService.add(book);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return this.bookService.get(id).orElseThrow(() -> {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        });
    }

    @DeleteMapping("/{id}")
    public void removeBook(@PathVariable Long id) {
        bookService.delete(id);
    }

    @PutMapping("")
    @ResponseBody
    public void updateBook(@RequestBody Book book) {
        bookService.update(book);
    }
//    @RequestMapping("/helloBook")
//    public Book helloBook() {
//        Book book = new Book(1L, "9788324631766", "Thinking in Java",
//                "Bruce Eckel", "Helion", "programming");
//        mockBookService.addBook(book);
//        return book;
//    }
//
//    @RequestMapping("/books")
//    public String showBooks() {
//        return mockBookService.showAllBooks();
//    }
//
//    @RequestMapping("/addNewBook")
//    public String addNewBook(HttpServletRequest req) {
//
//        long id = Long.parseLong(req.getParameter("id"));
//        String isbn = req.getParameter("isbn");
//        String title = req.getParameter("title");
//        String author = req.getParameter("author");
//        String publisher = req.getParameter("publisher");
//        String type = req.getParameter("type");
//        List<Book> list = mockBookService.getBooksList();
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).getId() == id) {
//                list.get(i).setIsbn(isbn);
//                list.get(i).setTitle(title);
//                list.get(i).setAuthor(author);
//                list.get(i).setPublisher(publisher);
//                list.get(i).setType(type);
//                return "book edited";
//            }
//        }
//        Book book = new Book(id,isbn, title, author, publisher, type);
//        list.add(book);
//        return "bookAdded";
//    }
//
//    @RequestMapping("/book/{id}")
//    public String getBookById(@PathVariable long id) {
//        if (Objects.isNull(mockBookService.getBookById(id))) {
//            return "no such a book in database";
//        } else {
//            return mockBookService.getBookById(id).toString();
//        }
//    }
//
//    @RequestMapping("/removeBook")
//    public String removeBookById(@RequestParam long id) {
//        mockBookService.removeBook(id);
//        return "book removed";
//    }
}