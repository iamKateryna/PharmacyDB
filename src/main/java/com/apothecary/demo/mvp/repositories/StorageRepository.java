package com.apothecary.demo.mvp.repositories;
import com.apothecary.demo.mvp.entities.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StorageRepository extends JpaRepository<Storage, Integer>{


    //request 6 - works
    @Query(value = "select * from storage where storage.critical_amount > storage.amount", nativeQuery = true)
    List<Storage> getCriticalComponents();

    //request 7 - works
    @Query(value = "select * from storage where storage.critical_amount < storage.amount and abs(storage.amount - storage.critical_amount) <=3 ", nativeQuery = true)
    List<Storage> getMinimalComponents();

    //request 9 - 50/50
    @Query(value = "select storage.component_name, storage.drug_id from storage, orders where orders.processed = true and storage.critical_amount > storage.amount  ", nativeQuery = true)
    List<Object[]> getMissingComponents();


}
