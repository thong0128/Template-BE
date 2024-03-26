package com.codegym.controller;

import com.codegym.model.Tab1;
import com.codegym.service.impl.Tab1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tab1s")
public class Tab1Controller {
    @Autowired
    private Tab1Service tab1Service;
    @GetMapping("")
    public ResponseEntity<Iterable<Tab1>> showAllTab1() {
        List<Tab1> tab1List = (List<Tab1>) tab1Service.findAll();
        if (tab1List.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tab1Service.findAll(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Tab1> create(@RequestBody Tab1 tab1){
        return new ResponseEntity<>(tab1Service.save(tab1), HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Tab1> update(@PathVariable Long id, @RequestBody Tab1 tab1){
        Optional<Tab1> tab1Optional = tab1Service.findById(id);
        if (tab1Optional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tab1Service.save(tab1);
        return new ResponseEntity<>(tab1, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Tab1> deleteTab1(@PathVariable Long id){
        Optional<Tab1> tab1Optional = tab1Service.findById(id);
        if (tab1Optional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tab1Service.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Tab1>> findTab1ByTab2Id(@PathVariable Long id){
        Optional<Tab1> tab1Optional = tab1Service.findAllByTab2_Id(id);
        if (tab1Optional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tab1Optional, HttpStatus.OK);
    }
}
