/*
package pl.coderslab.dao;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.beans.Book;
import pl.coderslab.interfaces.BookRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    EntityManager em;

    public void update(Book entity) {
        em.merge(entity);
    }

    public void delete(Book entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    public List<Book> findAll() {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b", Book.class);
        List<Book> results = query.getResultList();
        //TAK NIE WOLNO
        //N+1 -> N obiektów == N zapytań do bazy danych + 1 do pobrania samych obiektów
        // results.stream().map(Book::getAuthors).forEach(Hibernate::initialize);
        //zamiast: piszemy drugą metodę poniżej
        return query.getResultList();
    }

    public List<Book> findAllWithAuthors() {
        //bez DISTINCT w liście wyników mielibyśmy zmultiplikowane książki, które mają więcej niż jednego autora

        return em.createQuery("SELECT DISTINCT b from Book b LEFT JOIN FETCH b.author", Book.class)
                .getResultList();
    }

    public List<Book> findAllByType(String type) {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.type = :type", Book.class);
        query.setParameter("type", type);
        return query.getResultList();
    }

    public List<Book> findAllWithPublisher() {
        return em.createQuery("SELECT b FROM Book b JOIN FETCH b.publisher", Book.class)
                .getResultList();
    }
}
*/
