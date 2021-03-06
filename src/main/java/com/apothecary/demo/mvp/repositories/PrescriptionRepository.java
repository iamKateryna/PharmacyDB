package com.apothecary.demo.mvp.repositories;

import com.apothecary.demo.mvp.entities.Order;
import com.apothecary.demo.mvp.entities.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {

}
