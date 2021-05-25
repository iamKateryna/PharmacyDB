package com.apothecary.demo.mvp.services;

import com.apothecary.demo.mvp.entities.Drug;
import com.apothecary.demo.mvp.entities.Prescription;
import com.apothecary.demo.mvp.entities.Technology;
import com.apothecary.demo.mvp.repositories.TechnologyRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TechnologyService {

    private final TechnologyRepository repository;

    @Autowired
    public TechnologyService(TechnologyRepository repository){ this.repository = repository;}

    @Transactional
    public List<Technology> findAll() {
        return repository.findAll();
    }

    //request 10
    @Transactional
    public List<Object[]> getTechnologiesForPending(){
        return repository.getTechnologiesForPending(); }

    @Transactional
    public Technology saveTechnology(Technology technology) {
        return repository.save(technology);
    }

    @Transactional
    public Technology getById(int id) throws NotFoundException {
        Optional<Technology> technology = repository.findById(id);
        if (technology.isPresent())
            return technology.get();
        else
            throw new NotFoundException(String.format("Prescription with %s id does not exist", id));
    }
}
