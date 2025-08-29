package com.dilshad.jobapp.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping("jobs")
    public ResponseEntity<List<Job>> findAllJobs() {
        return ResponseEntity.ok(jobService.findAllJobs());
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> findJobById(@PathVariable long id) {
        Job job=jobService.findJobById(id);
        if(job!=null){
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        String msg= jobService.createJob(job);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable long id) {
        boolean result=jobService.deleteJobById(id);
        if(result){
            return new ResponseEntity<>("deleted job ",HttpStatus.OK);
        }
        return new ResponseEntity<>("not found the job with id "+id,HttpStatus.OK);
    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> updateJob(@PathVariable long id, @RequestBody Job job) {
        boolean updated=jobService.updateJob(id, job);

        if(updated){
            return new ResponseEntity<>("updated job ",HttpStatus.OK);
        }
        return new ResponseEntity<>("not found the job with id "+id,HttpStatus.BAD_REQUEST);
    }


}
