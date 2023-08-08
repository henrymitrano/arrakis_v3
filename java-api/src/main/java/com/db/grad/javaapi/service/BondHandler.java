package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.repository.BondRepository;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class BondHandler implements BondService {
    private BondRepository bondRepository;

    public BondHandler(BondRepository itsBondRepository){
        bondRepository = itsBondRepository;
    }
    @Override
    public Bond addBond(Bond bond) {
        return bondRepository.save(bond);
    }

    @Override
    public boolean removeBond(long uniqueId) {
        boolean result = false;

        Optional<Bond> theBond = bondRepository.findById(uniqueId);
        if(theBond.isPresent())
        {
            bondRepository.delete(theBond.get());
            result = true;
        }

        return  result;
    }

    @Override
    public long getNumOfBonds() {
        return bondRepository.count();
    }

    @Override
    public List<Bond> getBondByIsin(String isin) {
        return bondRepository.findByIsin(isin);
    }

    @Override
    public List<Bond> getAllBonds() {
        return bondRepository.findAll();
    }

    @Override
    public List<Bond> getMaturing(String stringDate) throws ParseException{
        Date currentDate = new SimpleDateFormat("dd-MM-yyyy").parse(stringDate);
        List <Bond> bondsMatured = new ArrayList<>();
        Date futureDate = new Date();
        futureDate = DateUtils.addDays(currentDate,  6);
        for (Bond bond: bondRepository.findAll()){
            String maturityDate = bond.getMaturityDate();
            Date bondDate = new SimpleDateFormat("dd/MM/yyyy").parse(maturityDate);
            if(bondDate.after(currentDate) //Checks for within 5
                    && bondDate.before(futureDate)){
                bondsMatured.add(bond);
            }
        }
        return bondsMatured;
    }

    @Override
    public List<Bond> getMatured(String stringDate) throws ParseException {
        Date currentDate = new SimpleDateFormat("dd-MM-yyyy").parse(stringDate);
        List <Bond> bondsMatured = new ArrayList<>();
        Date pastDate = new Date();
        pastDate = DateUtils.addDays(currentDate, - 6);
        for (Bond bond: bondRepository.findAll()){
            String maturityDate = bond.getMaturityDate();
            Date bondDate = new SimpleDateFormat("dd/MM/yyyy").parse(maturityDate);
            if(bondDate.before(currentDate) //Checks for within 5
                    && bondDate.after(pastDate)){
                bondsMatured.add(bond);
            }
        }
        return bondsMatured;
    }
}
