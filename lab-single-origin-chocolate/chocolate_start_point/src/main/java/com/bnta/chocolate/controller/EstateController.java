package com.bnta.chocolate.controller;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("estates")
public class EstateController {
    @Autowired
    EstateRepository estateRepository;

    @GetMapping
    public ResponseEntity<List<Estate>> getAllCEstateAndFilters(
            @RequestParam(required = false, name = "country") String country

    ){
        if(country != null){
            return new ResponseEntity<>(estateRepository.findEstateByCountry(country), HttpStatus.OK);
        }
        return new ResponseEntity<>(estateRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Optional<Estate>> getChocolate(@PathVariable Long id){
        return new ResponseEntity<>(estateRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Estate> createChocolate(@RequestBody Estate newEstate){
        estateRepository.save(newEstate);
        return new ResponseEntity<>(newEstate, HttpStatus.CREATED);
    }

}
