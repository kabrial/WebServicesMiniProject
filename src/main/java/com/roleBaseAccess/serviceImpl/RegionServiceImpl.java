package com.roleBaseAccess.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roleBaseAccess.model.Region;
import com.roleBaseAccess.repository.RegionRepository;
import com.roleBaseAccess.service.RegionService;
/**
 * Class ServiceImpl Region
 * @author Kevin ABRIAL & Alexis BARTHELEMY
 *
 */
@Service
public class RegionServiceImpl implements RegionService {
    // Repository
    @Autowired
    final RegionRepository regionRepository;
    
    // Constructor
    public RegionServiceImpl(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    /**
     * find Region Id
     */
    @Override
    public List<Region> findRegionId(long regionId) {
        return regionRepository.findByRegionId(regionId);
    }

    /**
     * find all region
     */
    @Override
    public Iterable<Region> findAllRegion() {
        return regionRepository.findAll();
    }

    /**
     * find One Region
     */
    @Override
    public Region findRegion(long regionId) {
        return regionRepository.findOne(regionId);
    }

    /** 
     * Save a region
     */
    @Override
    public void saveRegion(Region Region) {
        regionRepository.save(Region);
    }
}
