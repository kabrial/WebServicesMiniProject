package com.roleBaseAccess.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roleBaseAccess.model.Job;
import com.roleBaseAccess.repository.JobRepository;
import com.roleBaseAccess.service.JobService;

/**
 * Class ServiceImpl Job
 * @author Kevin ABRIAL & Alexis BARTHELEMY
 *
 */
@Service
public class JobServiceImpl implements JobService {
    // Repository
    @Autowired
    final JobRepository jobRepository;
    
    // Constructor
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    /**
     * find job Id
     */
    @Override
    public List<Job> findJobId(String JobId) {
        return jobRepository.findByJobId(JobId);
    }

    /**
     * find All job
     */
    @Override
    public Iterable<Job> findAllJobs() {
        return jobRepository.findAll();
    }

    /**
     * Find One a Job
     */
    @Override
    public Job findJob(String jobId) {
        return jobRepository.findOne(jobId);
    }

    /**
     * Save a job
     */
    @Override
    public void saveJob(Job job) {
        jobRepository.save(job);
    }

}