package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.repository.BondRepository;

import java.util.Optional;

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
}
