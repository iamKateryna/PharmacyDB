package com.apothecary.demo.mvp.services;

import com.apothecary.demo.mvp.entities.Drug;
import com.apothecary.demo.mvp.entities.Order;
import com.apothecary.demo.mvp.entities.Prescription;
import com.apothecary.demo.mvp.entities.Storage;
import com.apothecary.demo.mvp.repositories.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StorageService {

    private final StorageRepository repository;

    @Autowired
    public StorageService(StorageRepository repository){ this.repository = repository;}

    //request 6
    @Transactional
    public List<Storage> getCriticalComponents(){
        return repository.getCriticalComponents(); }

    //request 7
    @Transactional
    public List<Storage> getMinimalComponents(){
        return repository.getMinimalComponents(); }


    @Transactional
    public List<Storage> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Storage saveStorage(Storage storage) {
        return repository.save(storage);
    }

    @Transactional
    public Storage getById(int id) throws NotFoundException {
        Optional<Storage> storage = repository.findById(id);
        if (storage.isPresent())
            return storage.get();
        else
            throw new NotFoundException(String.format("Storage with %s id does not exist", id));
    }
}
