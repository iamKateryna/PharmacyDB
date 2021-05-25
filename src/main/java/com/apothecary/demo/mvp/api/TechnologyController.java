package com.apothecary.demo.mvp.api;

import com.apothecary.demo.mvp.api.dto.DrugDTO;
import com.apothecary.demo.mvp.api.dto.TechnologyDTO;
import com.apothecary.demo.mvp.entities.Drug;
import com.apothecary.demo.mvp.entities.Technology;
import com.apothecary.demo.mvp.services.DrugService;
import com.apothecary.demo.mvp.services.TechnologyService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("technology")
@AllArgsConstructor
public class TechnologyController {
    private final TechnologyService technologyService;


    //request 10 - works
    @GetMapping
    public ResponseEntity<List<Technology>> showTechnologies() {
        return ResponseEntity.ok(technologyService.findAll());
    }

    //request 10 - works
    @GetMapping("tech-pending")
    public ResponseEntity<List<Object[]>> getTechnologiesForPending() {
        return ResponseEntity.ok(technologyService.getTechnologiesForPending());
    }

    @GetMapping("{id}")
    public ResponseEntity<Technology> getTechnologyById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(technologyService.getById(id));
        } catch (NotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @PostMapping
    public ResponseEntity<Technology> addTechnology(@RequestBody TechnologyDTO technologyDTO) {
        Technology newTechnology = new Technology(technologyDTO.getComponents(), technologyDTO.getTechnologyTypes(),
                technologyDTO.getPreparationTime());

        return ResponseEntity.ok(technologyService.saveTechnology(newTechnology));
    }
}
