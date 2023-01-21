package pl.coderslab.mocks;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.coderslab.beans.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class MockBookService implements BookService {
    private List<Book> booksList = new ArrayList<>();
    private static Long nextId = 4L;

    public List<Book> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<Book> booksList) {
        this.booksList = booksList;
    }

    @Override
    public void add(Book book) {
        book.setId(nextId++);
        booksList.add(book);
    }

    @Override
    public Optional<Book> get(Long id) {
        return booksList.stream()
                .filter(item -> Objects.equals(item.getId(), id))
                .findFirst();
    }

    @Override
    public void delete(Long id) {
        if (get(id).isPresent()) {
            booksList.remove(this.get(id).get());
        }
    }

    @Override
    public void update(Book book) {
        if (this.get(book.getId()).isPresent()) {
            int indexOf = booksList.indexOf(this.get(book.getId()).get());
            booksList.set(indexOf, book);
        }
    }

    public MockBookService() {
        booksList.add(new Book(1l, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        booksList.add(new Book(2l, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        booksList.add(new Book(3l, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }
}
