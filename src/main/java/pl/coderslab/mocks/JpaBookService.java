package pl.coderslab.mocks;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.beans.Book;
import pl.coderslab.interfaces.BookRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class JpaBookService implements BookService {

    private final BookRepository bookRepository;
    @PersistenceContext
    EntityManager em;

    public JpaBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooksList() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> get(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void add(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void update(Book book) {
        bookRepository.save(book);
    }
}
