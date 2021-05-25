package com.apothecary.demo.mvp.api;

import com.apothecary.demo.mvp.api.dto.DrugDTO;
import com.apothecary.demo.mvp.api.dto.OrderDTO;
import com.apothecary.demo.mvp.entities.Drug;
import com.apothecary.demo.mvp.entities.Order;
import com.apothecary.demo.mvp.entities.Prescription;
import com.apothecary.demo.mvp.entities.Technology;
import com.apothecary.demo.mvp.entities.enums.DrugsTypes;
import com.apothecary.demo.mvp.services.DrugService;
import com.apothecary.demo.mvp.services.OrderService;
import com.apothecary.demo.mvp.services.PrescriptionService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("orders")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final PrescriptionService prescriptionService;
    private final DrugService drugService;

    @GetMapping
    public ResponseEntity<List<Order>> showOrders() {

        return ResponseEntity.ok(orderService.findAll());
    }

    //request 1 - works
    @GetMapping("not-picked-up")
    public ResponseEntity<List<Order>> getNotPickedUpOrders(){
        return ResponseEntity.ok(orderService.getNotPickedUpOrders());
    }

    //request 1 - works
    @GetMapping("num-not-picked-up")
    public ResponseEntity<Integer> getNumNotPickedUpOrders(){
        return ResponseEntity.ok(orderService.getNumNotPickedUpOrders());
    }

    //request 2 - works
    @GetMapping("pending")
    public ResponseEntity<List<Order>> getPendingOrders(){
        return ResponseEntity.ok(orderService.getPendingOrders());
    }

    //request 2 - works
    @GetMapping("num-pending")
    public ResponseEntity<Integer> getNumPendingOrders(){
        return ResponseEntity.ok(orderService.getNumPendingOrders());
    }

    //request 2 - works
    @GetMapping("pending/{type}")
    public ResponseEntity<List<Object[]>> getPendingOrdersByType(@PathVariable int type){
        return ResponseEntity.ok(orderService.getPendingOrdersByType(type));
    }

    //request 8 - works
    @GetMapping("processed")
    public ResponseEntity<List<Order>> getProcessedOrders(){
        return ResponseEntity.ok(orderService.getProcessedOrders());
    }

    //request 8 - works
    @GetMapping("num-processed")
    public ResponseEntity<Integer> getNumProcessedOrders(){
        return ResponseEntity.ok(orderService.getNumProcessedOrders());
    }

    //request 13 - works
    @GetMapping("by-drug-id")
    public ResponseEntity<List<Order>> getOrdersByDrugName(@PathVariable int drug){
        return ResponseEntity.ok(orderService.getOrdersByDrugName(drug));
    }

    @GetMapping("{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(orderService.getById(id));
        } catch (NotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody OrderDTO orderDTO) throws NotFoundException {

        List<Drug> drugs = drugService.getDrugs(orderDTO.getDrugId());
        Order newOrder = new Order(orderDTO.getPatient(), orderDTO.getPhoneNumber(),
                orderDTO.getAdress(), drugs,
                orderDTO.isAvailable(), orderDTO.getAmount(),
                orderDTO.getCreateOrderDate());

        return ResponseEntity.ok(orderService.saveOrder(newOrder));
    }


}
