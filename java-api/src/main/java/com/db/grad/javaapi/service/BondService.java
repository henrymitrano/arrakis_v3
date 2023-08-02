package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;

public interface BondService {
    public Bond addBond(Bond bond);

    public boolean removeBond(long UniqueID);

    public Bond getBondByIsin(int isin);
    public Bond getBondByCusip(int cusip);
    public Bond getBondByHolder(String holderName);
}
