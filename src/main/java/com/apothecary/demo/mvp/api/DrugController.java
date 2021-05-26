package com.apothecary.demo.mvp.api;

import com.apothecary.demo.mvp.api.dto.DrugDTO;
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
@RequestMapping("drugs")
@AllArgsConstructor
public class DrugController {
    private final DrugService drugService;
    private final TechnologyService technologyService;

    @GetMapping
    public ResponseEntity<List<Drug>> showDrugs() {
        return ResponseEntity.ok(drugService.findAll());
    }


    @GetMapping("{id}")
    public ResponseEntity<Drug> getDrugById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(drugService.getById(id));
        } catch (NotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @PostMapping
    public ResponseEntity<Drug> addDrug(@RequestBody DrugDTO drugDTO) throws NotFoundException {
        Technology technology = technologyService.getById(drugDTO.getTechnologyId());
        Drug newDrug = new Drug(drugDTO.getName(), drugDTO.getDrugsTypes(),
                technology, drugDTO.getPrice(), drugDTO.getImgLink());

        return ResponseEntity.ok(drugService.saveDrug(newDrug));
    }

}
