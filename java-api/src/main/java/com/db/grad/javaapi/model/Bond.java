package com.db.grad.javaapi.model;

import java.util.Date;

public class Bond {
    private int isin;
    private int cusip;
    private String bondIssuer;
    private String bondHolder;
    private Date maturityDate;

    public Bond(int isin, int cusip, String bondIssuer, String bondHolder, Date maturityDate) {
        this.isin = isin;
        this.cusip = cusip;
        this.bondIssuer = bondIssuer;
        this.bondHolder = bondHolder;
        this.maturityDate = maturityDate;
    }

    @Override
    public String toString() {
        return "Bond{" +
                "isin=" + isin +
                ", cusip=" + cusip +
                ", bondIssuer='" + bondIssuer + '\'' +
                ", bondHolder='" + bondHolder + '\'' +
                ", maturityDate=" + maturityDate +
                '}';
    }

    public int getIsin() {
        return isin;
    }

    public void setIsin(int isin) {
        this.isin = isin;
    }

    public int getCusip() {
        return cusip;
    }

    public void setCusip(int cusip) {
        this.cusip = cusip;
    }

    public String getBondIssuer() {
        return bondIssuer;
    }

    public void setBondIssuer(String bondIssuer) {
        this.bondIssuer = bondIssuer;
    }

    public String getBondHolder() {
        return bondHolder;
    }

    public void setBondHolder(String bondHolder) {
        this.bondHolder = bondHolder;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }
}
