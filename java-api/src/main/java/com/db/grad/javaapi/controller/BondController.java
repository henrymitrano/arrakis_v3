package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.service.BondHandler;
import com.db.grad.javaapi.service.DogHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class BondController {
    private BondHandler bondService;

    @Autowired
    public BondController(BondHandler bs)
    {
        bondService = bs;
    }

    @GetMapping("/bonds")
    public List<Bond> getAllBonds() {
        return bondService.getAllBonds();
    }


    @PostMapping("/bonds")
    public Bond createBond(@Valid @RequestBody Bond bond) {
        return bondService.addBond(bond);
    }


    @DeleteMapping("/bonds/{id}")
    public Map< String, Boolean > deleteBond(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        boolean removed = bondService.removeBond(id);

        Map < String, Boolean > response = new HashMap<>();
        if( removed )
            response.put("deleted", Boolean.TRUE);
        else
            response.put("deleted", Boolean.FALSE);

        return response;
    }
}