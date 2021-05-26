package com.apothecary.demo;

import com.apothecary.demo.mvp.entities.Order;
import com.apothecary.demo.mvp.entities.Storage;
import com.apothecary.demo.mvp.entities.Technology;
import javassist.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemoApplicationTests extends ConfigTest {

    @BeforeEach
    void setUp() {
        testTechnologyService.saveTechnology(testTechnology);
        testDrugService.saveDrug(testDrug);
        testOrder.getDrug().add(testDrug);
        testOrderService.saveOrder(testOrder);
        testStorageService.saveStorage(testStorage);
    }

    @Test
    void getTechnologyById() throws NotFoundException {
        Technology actualTechnology =  testTechnologyService.saveTechnology(getTestTechnology());
        assertEquals(getTestTechnology(), testTechnologyService.getById(actualTechnology.getId()));
    }

    @Test
    void getCriticalComponents() {
        List<Storage> actualStorages = testStorageService.getCriticalComponents();
        actualStorages
                .forEach(storage -> assertTrue(storage.getAmount() < storage.getCriticalAmount()));
        }

    @Test
    void getPendingOrders() {
        List<Order> actualOrders =  testOrderService.getPendingOrders();
        actualOrders.forEach(order -> assertFalse(order.isAvailable()));
    }
}
