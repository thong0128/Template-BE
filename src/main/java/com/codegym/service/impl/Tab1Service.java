package com.codegym.service.impl;

import com.codegym.model.Tab1;
import com.codegym.repository.ITab1Repository;
import com.codegym.service.ITab1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Tab1Service implements ITab1Service {
    @Autowired
    private ITab1Repository tab1Repository;

    @Override
    public Iterable<Tab1> findAll() {
        return tab1Repository.findAll();
    }

    @Override
    public Optional<Tab1> findById(Long id) {
        return tab1Repository.findById(id);
    }

    @Override
    public Tab1 save(Tab1 tab1) {
        return tab1Repository.save(tab1);
    }

    @Override
    public void remove(Long id) {
        tab1Repository.deleteById(id);
    }

    @Override
    public Optional<Tab1> findAllByTab2_Id(Long id) {
        return tab1Repository.findAllByTab2_Id(id);
    }
}
