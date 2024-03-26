package com.codegym.service.impl;

import com.codegym.model.Tab2;
import com.codegym.repository.ITab2Repository;
import com.codegym.service.ITab2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Tab2Service implements ITab2Service {
    @Autowired
    ITab2Repository tab2Repository;

    @Override
    public Iterable<Tab2> findAll() {
        return tab2Repository.findAll();
    }

    @Override
    public Optional<Tab2> findById(Long id) {
        return tab2Repository.findById(id);
    }

    @Override
    public Tab2 save(Tab2 tab2) {
        return tab2Repository.save(tab2);
    }

    @Override
    public void remove(Long id) {
        tab2Repository.deleteById(id);
    }
}
