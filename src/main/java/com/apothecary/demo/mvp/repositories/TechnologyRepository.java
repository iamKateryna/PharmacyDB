package com.apothecary.demo.mvp.repositories;

import com.apothecary.demo.mvp.entities.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface TechnologyRepository extends JpaRepository<Technology, Integer> {

    //request 10
    @Query(value = "select technology.components, technology.preparation_time, technology.technology_types from technology, orders where orders.processed= true", nativeQuery = true)
    List<Object[]> getTechnologiesForPending();
}
