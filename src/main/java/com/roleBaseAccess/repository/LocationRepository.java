package com.roleBaseAccess.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.roleBaseAccess.model.Location;
/**
 * Repository Location
 * @author Kevin ABRIAL & Alexis BARTHELEMY
 *
 */
@Repository
public interface LocationRepository extends PagingAndSortingRepository<Location, Long> {

    List<Location> findByLocationId(long locationId);

}