package com.roleBaseAccess.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.roleBaseAccess.model.Country;

/**
 * Repository Employee
 * @author Kevin ABRIAL & Alexis BARTHELEMY
 *
 */
@Repository
public interface CountryRepository extends PagingAndSortingRepository<Country, String> {

    List<Country> findByCountryName(String countryName);

}
