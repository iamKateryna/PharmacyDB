package com.apothecary.demo.mvp.services;

import com.apothecary.demo.mvp.entities.Drug;
import com.apothecary.demo.mvp.entities.Order;
import com.apothecary.demo.mvp.entities.Prescription;
import com.apothecary.demo.mvp.entities.Storage;
import com.apothecary.demo.mvp.repositories.PrescriptionRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionService {

    private final PrescriptionRepository repository;

    @Autowired
    public PrescriptionService(PrescriptionRepository repository){ this.repository = repository;}

    @Transactional
    public List<Prescription> findAll() {
        return repository.findAll();
    }


    @Transactional
    public Prescription savePrescription(Prescription prescription) {
        return repository.save(prescription);
    }

    @Transactional
    public Prescription getById(int id) throws NotFoundException {
        Optional<Prescription> prescription = repository.findById(id);
        if (prescription.isPresent())
            return prescription.get();
        else
            throw new NotFoundException(String.format("Prescription with %s id does not exist", id));
    }
}
