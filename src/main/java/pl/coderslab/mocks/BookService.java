package pl.coderslab.mocks;

import pl.coderslab.beans.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getBooksList();

    void add(Book book);

    Optional<Book> get(Long id);

    void delete(Long id);

    void update(Book book);
}