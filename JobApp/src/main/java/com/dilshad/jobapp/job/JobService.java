package com.dilshad.jobapp.job;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface JobService {

    List<Job> findAllJobs();
    String createJob(Job job);
    Job findJobById(long id);
    boolean deleteJobById(long id);
    boolean updateJob(long id, Job job);
}
