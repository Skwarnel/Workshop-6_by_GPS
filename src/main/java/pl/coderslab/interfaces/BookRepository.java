package pl.coderslab.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.beans.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

}

