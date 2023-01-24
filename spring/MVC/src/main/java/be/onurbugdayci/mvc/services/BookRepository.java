package be.onurbugdayci.mvc.services;

import be.onurbugdayci.mvc.domain.Book;

import java.util.List;

public interface BookRepository {
    public List<Book> getBooks();
    public Book getBook(String title);
}
