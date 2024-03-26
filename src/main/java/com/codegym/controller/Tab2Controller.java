package com.codegym.controller;

import com.codegym.model.Tab1;
import com.codegym.model.Tab2;
import com.codegym.service.impl.Tab2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tab2s")
public class Tab2Controller {
    @Autowired
    private Tab2Service tab2Service;

    @GetMapping("")
    public ResponseEntity<Iterable<Tab2>> showAllTab1() {
        List<Tab2> tab2List = (List<Tab2>) tab2Service.findAll();
        if (tab2List.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tab2Service.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Tab2> create(@RequestBody Tab2 tab2) {
        return new ResponseEntity<>(tab2Service.save(tab2), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Tab2> update(@PathVariable Long id, @RequestBody Tab2 tab2) {
        Optional<Tab2> tab2Optional = tab2Service.findById(id);
        if (tab2Optional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tab2Service.save(tab2);
        return new ResponseEntity<>(tab2, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Tab2> deleteTab2(@PathVariable Long id) {
        Optional<Tab2> tab2Optional = tab2Service.findById(id);
        if (tab2Optional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tab2Service.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
