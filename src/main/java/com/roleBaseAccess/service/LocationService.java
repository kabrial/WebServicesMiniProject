package com.roleBaseAccess.service;

import java.util.List;

import com.roleBaseAccess.model.Location;
/**
 * Interface Service Location
 * @author Kevin ABRIAL & Alexis BARTHELEMY
 *
 */
public interface LocationService {
    List<Location> findLocationId(long LocationId);
    
    Iterable<Location> findAllLocation();
    
    Location findLocation(long LocationId);
    
    void saveLocation(Location location);
}
