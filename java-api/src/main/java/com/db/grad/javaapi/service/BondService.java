package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public interface BondService {
    public Bond addBond(Bond bond);

    public boolean removeBond(long UniqueID);

    public long getNumOfBonds();

    public Bond getBondByIsin(int isin);

    public List<Bond> getAllBonds();

    public List<Bond> getMaturing(Calendar currentDate);

    public List<Bond> getMatured(Calendar  currentDate);

}
