package com.dilshad.jobapp.job.impl;

import com.dilshad.jobapp.job.Job;
import com.dilshad.jobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JobServiceImpl implements JobService {

    private List<Job> jobs=new ArrayList<>();
    private Map<Long,Job> jobMap=new HashMap<>();
    private long nextId = 1L;

    @Override
    public List<Job> findAllJobs() {
        return jobs;
    }

    @Override
    public String createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
        jobMap.put(job.getId(), job);
        return "job added.";
    }

    @Override
    public Job findJobById(long id) {
        Job job=null;
        for (Job job1:jobs) {
            if(job1.getId()==id){
                job=job1; break;
            }
        }
        return job;
    }

    @Override
    public boolean deleteJobById(long id) {
        ListIterator<Job> iterator=jobs.listIterator();
        while(iterator.hasNext()){
            Job job=iterator.next();
            if(job.getId()==id){
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateJob(long id, Job job) {
        ListIterator<Job> iterator=jobs.listIterator();
        while(iterator.hasNext()){
            Job job1=iterator.next();
            if(job1.getId()==id){
                job1.setId(id);
                job1.setTitle(job.getTitle());
                job1.setDescription(job.getDescription());
                job1.setMinSalary(job.getMinSalary());
                job1.setMaxSalary(job.getMaxSalary());
                job1.setLocation(job.getLocation());

                iterator.set(job1);
                return true;
            }
        }
        return false;
    }
}
