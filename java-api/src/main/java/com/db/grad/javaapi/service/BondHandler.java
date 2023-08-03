package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.repository.BondRepository;

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
    public Bond getBondByIsin(int isin) {
        return bondRepository.findByIsin(isin);
    }

    @Override
    public List<Bond> getAllBonds() {
        return bondRepository.findAll();
    }

    @Override
    public List<Bond> getMaturing(Calendar currentDate) {
        List <Bond> bondsMaturing = new ArrayList<>();
        Calendar futureDate = new GregorianCalendar();
        futureDate.add(currentDate.DAY_OF_MONTH, 6);
        for (Bond bond: bondRepository.findAll()){
            if(bond.getMaturityDate().after(currentDate) //Checks for within 5
                    && bond.getMaturityDate().before(futureDate)){
                bondsMaturing.add(bond);
            }
        }
        return bondsMaturing;
    }

    @Override
    public List<Bond> getMatured(Calendar currentDate) {
        List <Bond> bondsMatured = new ArrayList<>();
        Calendar pastDate = new GregorianCalendar();
        pastDate.add(currentDate.DAY_OF_MONTH, -6);
        for (Bond bond: bondRepository.findAll()){
            if(bond.getMaturityDate().after(currentDate) //Checks for within 5
                    && bond.getMaturityDate().before(pastDate)){
                bondsMatured.add(bond);
            }
        }
        return bondsMatured;
    }
}
