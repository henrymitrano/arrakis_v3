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

    public List <Bond> getBondByIsin(String isin);

    public List<Bond> getAllBonds();

    public List<Bond> getMaturing(Date currentDate);

    public List<Bond> getMatured(Date  currentDate);

}
