package com.example.labemt2.model.dto;

import com.example.labemt2.model.Author;
import com.example.labemt2.model.Category;
import lombok.Data;

import java.util.List;

@Data
public class BookDto {
    private String name;
    private Category category;
    private List<Author> authorList;
    private Integer availableCopies;
    private Boolean markAsTaken;
}
