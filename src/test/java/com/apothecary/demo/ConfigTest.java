package com.apothecary.demo;

import com.apothecary.demo.mvp.entities.Drug;
import com.apothecary.demo.mvp.entities.Order;
import com.apothecary.demo.mvp.entities.Storage;
import com.apothecary.demo.mvp.entities.Technology;
import com.apothecary.demo.mvp.entities.enums.DrugsTypes;
import com.apothecary.demo.mvp.entities.enums.TechnologyTypes;
import com.apothecary.demo.mvp.services.DrugService;
import com.apothecary.demo.mvp.services.OrderService;
import com.apothecary.demo.mvp.services.StorageService;
import com.apothecary.demo.mvp.services.TechnologyService;
import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Component
public class ConfigTest {
    protected Technology testTechnology = new Technology(
            "calendula, water, alcohol", TechnologyTypes.FILTRATION, 168);

    protected Drug testDrug = new Drug(
            "calendula_tincture", DrugsTypes.TINCTURE, testTechnology, 10, "testLink");

    protected Storage testStorage = new Storage(
            testDrug, "calendula", 5, 10, 2);

    protected List<Drug> testListOfDrugs = new ArrayList<>();

    protected  Order testOrder = new Order(
            "Vasia", "12345", "Kyiv",
            testListOfDrugs, false, 3,"23/05/21");

    @Autowired
    protected TechnologyService testTechnologyService;

    @Autowired
    protected StorageService testStorageService;

    @Autowired
    protected DrugService testDrugService;

    @Autowired
    protected OrderService testOrderService;
}
