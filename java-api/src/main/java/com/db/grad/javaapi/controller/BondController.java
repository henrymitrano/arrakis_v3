package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.service.BondHandler;
import com.db.grad.javaapi.service.DogHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.BindHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
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

    @Value("{date}")
    private String date;

    private static String DATE_STATIC;

    @Value("{date}")
    public void setNameStatic(String date){
        BondController.DATE_STATIC = date;
    }

    @GetMapping("/bonds/maturing/{date}")
    public List <Bond> getMaturingBonds(@PathVariable(value = "date") String date) throws ParseException {
        return bondService.getMaturing(date);
    }

    @GetMapping("/bonds/matured/{date}")
    public List <Bond> getMaturedBonds(@PathVariable(value = "date") String date) throws ParseException {
        return bondService.getMatured(date);
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