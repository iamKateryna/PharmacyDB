package com.apothecary.demo.mvp.repositories;

import com.apothecary.demo.mvp.entities.Drug;
import com.apothecary.demo.mvp.entities.Order;
import com.apothecary.demo.mvp.entities.enums.DrugsTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DrugRepository extends JpaRepository<Drug, Integer>{

    //request 11
    @Query(value = "select drug.name, drug.price, technology.technology_types from drug, technology where technology.technology_types = 3 ", nativeQuery = true)
    List<Object[]> getDrugsInfoNoTechnology();
}
