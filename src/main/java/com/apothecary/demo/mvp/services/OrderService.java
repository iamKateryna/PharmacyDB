package com.apothecary.demo.mvp.services;

import com.apothecary.demo.mvp.entities.Order;
import com.apothecary.demo.mvp.repositories.OrderRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class OrderService {
    public final OrderRepository repository;

    @Autowired
    public OrderService(OrderRepository repository){
        this.repository = repository;
    }

    @Transactional
    public List<Order> findAll() {
        return repository.findAll();
    }

    //request 1 - works
    @Transactional
    public List<Order> getNotPickedUpOrders(){
        return repository.getNotPickedUpOrders(); }

    @Transactional
    public Integer getNumNotPickedUpOrders(){
        return repository.getNumNotPickedUpOrders(); }

    //request 2 - works
    @Transactional
    public List<Order> getPendingOrders(){
        return repository.getPendingOrders(); }

    @Transactional
    public Integer getNumPendingOrders(){
        return repository.getNumPendingOrders(); }

    @Transactional
    public List<Object[]> getPendingOrdersByType(int type){
        return repository.getPendingOrdersByType(type); }

    //request 8 - works
    @Transactional
    public List<Order> getProcessedOrders(){
        return repository.getProcessedOrders(); }

    @Transactional
    public Integer getNumProcessedOrders(){
        return repository.getNumProcessedOrders(); }

    //request 13 - works
    @Transactional
    public List<Order> getOrdersByDrugName(int drug){
        return repository.getOrdersByDrugName(drug); }

    @Transactional
    public Order saveOrder(Order order) {
        return repository.save(order);
    }

    @Transactional
    public Order getById(int id) throws NotFoundException {
        Optional<Order> order = repository.findById(id);
        if (order.isPresent())
            return order.get();
        else
            throw new NotFoundException(String.format("Order with %s id does not exist", id));
    }


}
