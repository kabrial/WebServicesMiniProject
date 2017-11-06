package com.roleBaseAccess.service;

import java.util.List;

import com.roleBaseAccess.model.Job;
/**
 * Interface Service Job
 * @author Kevin ABRIAL & Alexis BARTHELEMY
 *
 */
public interface JobService {
    List<Job> findJobId(String JobId);
    
    Iterable<Job> findAllJobs();
    
    Job findJob(String jobId);
    
    void saveJob(Job job);
}
