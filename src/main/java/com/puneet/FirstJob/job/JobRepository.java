package com.puneet.FirstJob.job;

import org.springframework.data.jpa.repository.JpaRepository;


public interface JobRepository  extends JpaRepository<Job, Long> {

}
