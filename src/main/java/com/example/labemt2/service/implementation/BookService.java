package com.example.labemt2.service.implementation;

import com.example.labemt2.model.Author;
import com.example.labemt2.model.Book;
import com.example.labemt2.model.Category;
import com.example.labemt2.repository.BookRepo;
import com.example.labemt2.service.BookServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements BookServiceInterface {

    private final BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public List<Book> listAll() {
        return this.bookRepo.findAll();
    }

    @Override
    public Optional<Book> create(String name, Category category, List<Author> author, Integer availableCopies) {
        return Optional.of(this.bookRepo.save(new Book(name,category,author,availableCopies)));
    }

    @Override
    public Book delete(Long id) {
        Book book = this.bookRepo.findById(id).orElseThrow(RuntimeException::new);
        this.bookRepo.delete(book);
        return book;
    }

    @Override
        public Optional<Book> findById(Long id) {
        return this.bookRepo.findById(id);
    }

    @Override
    public Optional<Book> update(Long id, String name, Category category, List<Author> author, Integer availableCopies) {
        Book book = this.bookRepo.findById(id).orElseThrow(RuntimeException::new);
        book.setName(name);
        book.setAuthor(author);
        book.setCategory(category);
        book.setAvailableCopies(availableCopies);
        return Optional.of(book);
    }

    @Override
    public Book markAsTaken(Long id) {
        Book book=this.bookRepo.findById(id).orElseThrow(RuntimeException::new);
        book.setAvailableCopies(book.getAvailableCopies()-1);
        return this.bookRepo.save(book);
    }
}
