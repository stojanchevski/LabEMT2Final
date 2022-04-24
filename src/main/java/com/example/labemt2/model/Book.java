package com.example.labemt2.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Category category;

    @ManyToMany
    private List<Author> author;
    private Integer availableCopies;

    public Book(Long id, String name, Category category, List<Author> author, Integer availableCopies) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public Book() {
    }

    public Book(String name, Category category, List<Author> author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
