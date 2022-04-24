package com.example.labemt2.service;

import com.example.labemt2.model.Author;
import com.example.labemt2.model.Book;
import com.example.labemt2.model.Category;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface BookServiceInterface{
    List<Book> listAll();

    Optional<Book> create(String name, Category category, List<Author> author, Integer availableCopies);

    Book delete(Long id);

    Optional<Book> findById(Long id);

    Optional<Book> update(Long id,String name, Category category, List<Author> author, Integer availableCopies);

    Book markAsTaken(Long id);
}
