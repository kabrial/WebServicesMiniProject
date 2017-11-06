package com.roleBaseAccess.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.roleBaseAccess.model.Region;
/**
 * Repository Region
 * @author Kevin ABRIAL & Alexis BARTHELEMY
 *
 */
@Repository
public interface RegionRepository extends PagingAndSortingRepository<Region, Long> {

    List<Region> findByRegionId(long regionId);

}
