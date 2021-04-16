package com.bootcamp.avengers.model.repository;

import com.bootcamp.avengers.model.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    @Query("select a from Activity a where a.idCategory = ?1")
    List<Activity> findAllByCategory(Long idCategory);
}
