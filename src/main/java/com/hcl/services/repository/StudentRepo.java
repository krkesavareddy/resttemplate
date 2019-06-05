package com.hcl.services.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.services.pojo.StudentPojo;


@Repository
public interface StudentRepo extends JpaRepository<StudentPojo, Long>{

Optional<StudentPojo>	findById(Long id);
@Query("select s from StudentPojo s where s.addmissionDate=:date")
List<StudentPojo> findAllByAddmissionDate(@Param("date")Date date);
}
