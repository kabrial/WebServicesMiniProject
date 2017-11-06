package com.roleBaseAccess.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roleBaseAccess.model.Country;
import com.roleBaseAccess.service.CountryService;


import com.roleBaseAccess.repository.CountryRepository;

/**
 * Class ServiceImpl Country
 * @author Kevin ABRIAL & Alexis BARTHELEMY
 *
 */
@Service
public class CountryServiceImpl implements CountryService { 
    // Repository
    @Autowired
    final CountryRepository countryRepository;
    // Constructor
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    /**
     * findCountryName
     */
    @Override
    public List<Country> findCountryName(String countryName) {
        return countryRepository.findByCountryName(countryName);
    }

    /**
     * find All Countries
     */
    @Override
    public Iterable<Country> findAllCountries() {
        return countryRepository.findAll();
    }

    /**
     * find One Country
     */
    @Override
    public Country findCountry(String id) {
        return countryRepository.findOne(id);
    }

    /**
     * Save country
     */
    @Override
    public void saveCountry(Country country) {
        countryRepository.save(country);
    }

}