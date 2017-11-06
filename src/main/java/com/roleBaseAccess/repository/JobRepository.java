package com.roleBaseAccess.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.roleBaseAccess.model.Job;
/**
 * Repository Job
 * @author Kevin ABRIAL & Alexis BARTHELEMY
 *
 */
@Repository
public interface JobRepository extends PagingAndSortingRepository<Job, String> {

    List<Job> findByJobId(String jobId);

}

