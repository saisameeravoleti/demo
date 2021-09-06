package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Students, Integer > {

    /*@Query(value = "select * from students rn where rn.rollno=?1 and rn.section=?2 ", nativeQuery = true)
    public List<Students> userGetRepo(int rollno, String section);*/

    public List<Students> findByRollnoAndSection(int rollno, String section);


}
