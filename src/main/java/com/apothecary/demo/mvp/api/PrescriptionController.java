package com.apothecary.demo.mvp.api;

import com.apothecary.demo.mvp.api.dto.DrugDTO;
import com.apothecary.demo.mvp.api.dto.PrescriptionDTO;
import com.apothecary.demo.mvp.entities.Drug;
import com.apothecary.demo.mvp.entities.Prescription;
import com.apothecary.demo.mvp.entities.Storage;
import com.apothecary.demo.mvp.services.DrugService;
import com.apothecary.demo.mvp.services.PrescriptionService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("prescriptions")
@AllArgsConstructor
public class PrescriptionController {
    private final PrescriptionService prescriptionService;
    private final DrugService drugService;

    @GetMapping
    public ResponseEntity<List<Prescription>> showPrescription() {
        return ResponseEntity.ok(prescriptionService.findAll());
    }



    @GetMapping("{id}")
    public ResponseEntity<Prescription> getPrescriptionById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(prescriptionService.getById(id));
        } catch (NotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @PostMapping
    public ResponseEntity<Prescription> addPrescription(@RequestBody PrescriptionDTO prescriptionDTO) throws NotFoundException {
        Drug drug = drugService.getById(prescriptionDTO.getDrugId());

        Prescription newPrescription = new Prescription(prescriptionDTO.getDoctor(), prescriptionDTO.getSignature(),
                prescriptionDTO.getStamp(), prescriptionDTO.getPatient(), prescriptionDTO.getAge(),
                prescriptionDTO.getDiagnosis(), drug, prescriptionDTO.getAmount());

        return ResponseEntity.ok(prescriptionService.savePrescription(newPrescription));
    }
}
