package com.apothecary.demo.mvp.repositories;

import com.apothecary.demo.mvp.entities.Drug;
import com.apothecary.demo.mvp.entities.Order;
import com.apothecary.demo.mvp.entities.enums.DrugsTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer>{

    //request 1 - rabotaet
    @Query(nativeQuery = true, value = "select * from orders where orders.released = false")
    List<Order> getNotPickedUpOrders();

    //request 1 - rabotaet
    @Query(value = "select  count(*) from orders where released = false", nativeQuery = true)
    Integer getNumNotPickedUpOrders();

    //request 2 - works
    @Query(value = "select * from orders where orders.available= false", nativeQuery = true)
    List<Order> getPendingOrders();

    //request 2 - works
    @Query(value = "select orders.patient, drug.drugs_types from orders, drug where orders.available= false and drug.drugs_types= :drugsTypes", nativeQuery = true)
    List<Object[]> getPendingOrdersByType(@Param("drugsTypes") int drugsTypes);

    //request 2 - works
    @Query(value = "select count(*) from orders where orders.available= false", nativeQuery = true)
    Integer getNumPendingOrders();

    //request 4
    //@Query(value = "select * from orders where drug.drugs_types = :drugsTypes", nativeQuery = true)
    //List<Order> getTopOrdersByDrugsTypes(@Param("drugsTypes") DrugsTypes drugsTypes);

    //request 8
    @Query(value = "select * from orders where orders.processed= true", nativeQuery = true)
    List<Order> getProcessedOrders();

    //request 8
    @Query(value = "select count(*) from orders where orders.processed= true", nativeQuery = true)
    Integer getNumProcessedOrders();

    //request 12
    @Query(value = "select * from orders where drug = :drug", nativeQuery = true)
    List<Order> getOrdersByDrugName(@Param("drug") int drug);


}
