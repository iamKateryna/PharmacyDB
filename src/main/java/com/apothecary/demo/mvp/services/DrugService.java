package com.apothecary.demo.mvp.services;

import com.apothecary.demo.mvp.entities.Drug;
import com.apothecary.demo.mvp.repositories.DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class DrugService {
    public final DrugRepository repository;

    @Autowired
    public DrugService(DrugRepository repository){
        this.repository = repository;
    }

    @Transactional
    public List<Drug> findAll() {
        return repository.findAll();
    }

    @Transactional
    public List<Object[]> getDrugsInfoNoTechnology() {
        return repository.getDrugsInfoNoTechnology();
    }

    @Transactional
    public Drug saveDrug(Drug drug) {
        return repository.save(drug);
    }

    @Transactional
    public List<Drug> getDrugs(List<Integer> ids) throws NotFoundException {
        List<Drug> drugs = new ArrayList<>();

        for(int id: ids){

        Optional<Drug> drug = repository.findById(id);
        if (drug.isPresent())
            drugs.add(drug.get());
        else
            throw new NotFoundException(String.format("Drug with %s id does not exist", id));
    }
        return drugs;
    }

    @Transactional
    public Drug getById(int id) throws NotFoundException {
        Optional<Drug> drug = repository.findById(id);
        if (drug.isPresent())
            return drug.get();
        else
            throw new NotFoundException(String.format("Drug with %s id does not exist", id));
    }
}
