package com.example.labemt2.service;

import com.example.labemt2.model.Author;
import com.example.labemt2.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryServiceInterface {

    List<Country> listAll();

    Optional<Country> create(String name, String continent);

    Country delete(Long id);

    Optional<Country> findById(Long id);

    Optional<Country> update(Long id,String name, String continent);
}
