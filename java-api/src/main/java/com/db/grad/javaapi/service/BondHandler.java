package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.repository.BondRepository;
import org.apache.commons.lang3.time.DateUtils;

import java.util.*;

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
    public List<Bond> getMaturing(Date currentDate) {
        List <Bond> bondsMaturing = new ArrayList<>();
        Date futureDate = new Date();
        futureDate = DateUtils.addDays(currentDate, 6);
        for (Bond bond: bondRepository.findAll()){
            System.out.println("Here");
            if(bond.getMaturityDate().after(currentDate) //Checks for within 5
                    && bond.getMaturityDate().before(futureDate)){
                bondsMaturing.add(bond);
            }
        }
        return bondsMaturing;
    }

    @Override
    public List<Bond> getMatured(Date currentDate) {
        List <Bond> bondsMatured = new ArrayList<>();
        Date pastDate = new Date();
        pastDate = DateUtils.addDays(currentDate, - 6);
        for (Bond bond: bondRepository.findAll()){
            if(bond.getMaturityDate().before(currentDate) //Checks for within 5
                    && bond.getMaturityDate().after(pastDate)){
                bondsMatured.add(bond);
            }
        }
        return bondsMatured;
    }
}
