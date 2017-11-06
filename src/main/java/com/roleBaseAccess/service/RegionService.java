package com.roleBaseAccess.service;

import java.util.List;

import com.roleBaseAccess.model.Region;
/**
 * Interface Service Region
 * @author Kevin ABRIAL & Alexis BARTHELEMY
 *
 */
public interface RegionService {
    List<Region> findRegionId(long regionId);
    
    Iterable<Region> findAllRegion();
    
    Region findRegion(long regionId);
    
    void saveRegion(Region Region);
}
