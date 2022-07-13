package com.itsol.recruit.repository;

import com.itsol.recruit.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Job, Long>, JpaSpecificationExecutor<Job> {

    @Query("SELECT jobs FROM job jobs  ORDER BY jobs.dueDate ASC")
    List<Job> findAllOrderByDateAsc();

    Optional<Job> findById(Long id);

    Job findJobByName(String jobName);

//    void deleteById(Long id);
}
