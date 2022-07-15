package com.itsol.recruit.repository;

import com.itsol.recruit.entity.JobRegister;
import com.itsol.recruit.repository.repoext.JobRegisterRepositoryExt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRegisterRepository extends JpaRepository<JobRegister, Long>, JobRegisterRepositoryExt {

    @Query("SELECT  jobRegister FROM job_register jobRegister")
    Page<JobRegister> findAllOrderByDateAsc(Pageable pageable, Specification<JobRegister> where);
    Optional<JobRegister> findById(Long id);

//    JobRegister findByOneId(Long id);
    @Query(value = "select count(*)  from job_register", nativeQuery = true)
    int countAll();

    @Query(value = "select count(*)  from job_register j where j.status_id = :statusId" +
            " and  ( ( TO_DATE((:smallDate),'DD/MON/YY')  < j.DATE_INTERVIEW \n" +
            "and j.DATE_INTERVIEW <  TO_DATE((:bigDate),'DD/MON/YY')) \n" +
            "or ( TO_DATE((:smallDate),'DD/MON/YY')  < j.DATE_INTERVIEW \n" +
            "and j.date_register <  TO_DATE((:bigDate),'DD/MON/YY')))", nativeQuery = true)
    int countJobRegisterByStatus(Long statusId,String smallDate, String bigDate);




}
