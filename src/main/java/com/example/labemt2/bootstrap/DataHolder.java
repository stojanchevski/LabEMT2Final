package com.example.labemt2.bootstrap;


import com.example.labemt2.model.Author;
import com.example.labemt2.model.Book;
import com.example.labemt2.model.Country;
import com.example.labemt2.service.implementation.AuthorService;
import com.example.labemt2.service.implementation.BookService;
import com.example.labemt2.service.implementation.CountryService;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

import static com.example.labemt2.model.Category.NOVEL;

@Component
public class DataHolder {
    //    private List<Country> countries=new ArrayList<>();
    private final AuthorService authorService;
    private final BookService bookService;
    private final CountryService countryService;

    public DataHolder(AuthorService authorService, BookService bookService, CountryService countryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.countryService = countryService;
    }

    List<Country> countryList = new ArrayList<>();
    List<Book> bookList = new ArrayList<>();
    List<Author> authorList = new ArrayList<>();

    @PostConstruct
    void initData(){

        this.countryService.create("Serbia", "Europe");
        this.countryService.create("Sweden", "Europe");
        this.countryService.create("Canada", "North America");
        countryList = this.countryService.listAll();
        this.authorService.create("Nikola", "Stojancevski", countryList.get(0));
        this.authorService.create("Bjorn", "Sigurdson", countryList.get(1));
        authorList = this.authorService.listAll();
        this.bookService.create("Zlostorstvo i kazna", NOVEL, authorList, 10);
        this.bookService.create("Marley and Me", NOVEL, authorList, 10);
    }
}
