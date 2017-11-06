package com.roleBaseAccess.service;

import java.util.List;

import com.roleBaseAccess.model.Country;

/**
 * Interface Service Country
 * @author Kevin ABRIAL & Alexis BARTHELEMY
 *
 */
public interface CountryService {
    public List<Country> findCountryName(String countryName);
    public Iterable<Country> findAllCountries();
    public Country findCountry(String id);
    public void saveCountry(Country country);
}
