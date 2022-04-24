package com.example.labemt2.service.implementation;

import com.example.labemt2.model.Country;
import com.example.labemt2.repository.CountryRepo;
import com.example.labemt2.service.CountryServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService implements CountryServiceInterface {

    private final CountryRepo countryRepo;

    public CountryService(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    @Override
    public List<Country> listAll() {
        return this.countryRepo.findAll();
    }

    @Override
    public Optional<Country> create(String name, String continent) {
        Country country = new Country(name,continent);
        return Optional.of(this.countryRepo.save(country));
    }

    @Override
    public Country delete(Long id) {
        Country country = this.countryRepo.findById(id).orElseThrow(RuntimeException::new);
        this.countryRepo.delete(country);
        return country;
    }

    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepo.findById(id);
    }

    @Override
    public Optional<Country> update(Long id, String name, String continent) {
        Country country = this.countryRepo.findById(id).orElseThrow(RuntimeException::new);
        country.setName(name);
        country.setContinent(continent);
        return Optional.of(country);
    }
}
