package com.apothecary.demo.mvp.api;

import com.apothecary.demo.mvp.api.dto.PrescriptionDTO;
import com.apothecary.demo.mvp.api.dto.StorageDTO;
import com.apothecary.demo.mvp.entities.Drug;
import com.apothecary.demo.mvp.entities.Prescription;
import com.apothecary.demo.mvp.entities.Storage;
import com.apothecary.demo.mvp.services.DrugService;
import com.apothecary.demo.mvp.services.PrescriptionService;
import com.apothecary.demo.mvp.services.StorageService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("storage")
@AllArgsConstructor
public class StorageController {
    private final StorageService storageService;
    private final DrugService drugService;


    @GetMapping
    public ResponseEntity<List<Storage>> showStorage() {
        return ResponseEntity.ok(storageService.findAll());
    }

    //request 6 - works
    @GetMapping("critical")
    public ResponseEntity<List<Storage>> getCriticalComponents(){
        return ResponseEntity.ok(storageService.getCriticalComponents());
    }


    //request 7 - works
    @GetMapping("minimal")
    public ResponseEntity<List<Storage>> getMinimalComponents(){
        return ResponseEntity.ok(storageService.getMinimalComponents());
    }


    @GetMapping("{id}")
    public ResponseEntity<Storage> getStorageById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(storageService.getById(id));
        } catch (NotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @PostMapping
    public ResponseEntity<Storage> addStorage(@RequestBody StorageDTO storageDTO) throws NotFoundException {
        Drug drug = drugService.getById(storageDTO.getDrugId());

        Storage newStorage = new Storage(drug, storageDTO.getComponentName(),
                storageDTO.getAmount(), storageDTO.getCriticalAmount(), storageDTO.getPrice());

        return ResponseEntity.ok(storageService.saveStorage(newStorage));
    }
}
