package com.roleBaseAccess.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roleBaseAccess.model.Location;
import com.roleBaseAccess.repository.LocationRepository;
import com.roleBaseAccess.service.LocationService;

/**
 * Class ServiceImpl Lcoation
 * @author Kevin ABRIAL & Alexis BARTHELEMY
 *
 */
@Service
public class LocationServiceImpl implements LocationService {
    // Repository
    @Autowired
    final LocationRepository locationRepository;
    // Constructor
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    /**
     * find Location Id
     */
    @Override
    public List<Location> findLocationId(long LocationId) {
        return locationRepository.findByLocationId(LocationId);
    }
    /**
     * find all location
     */
    @Override
    public Iterable<Location> findAllLocation() {
        return locationRepository.findAll();
    }

    /**
     * find one Location
     */
    @Override
    public Location findLocation(long LocationId) {
        return locationRepository.findOne(LocationId);
    }

    /**
     * Save a Location
     */
    @Override
    public void saveLocation(Location location) {
        locationRepository.save(location);
    }
}


