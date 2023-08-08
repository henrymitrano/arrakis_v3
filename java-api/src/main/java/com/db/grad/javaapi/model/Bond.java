package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Entity
@Table(name = "bonds")
public class Bond {

    @Id
    private long id;
    private String isin;
    private String cusip;
    private String bondIssuer;
    private String bondHolder;
    private String maturityDate;
    private int quantity;
    private double unitPrice;
    private String currency;
    private String buyOrSell;
    private String tradeDate;
    private String settlementDate;
    private String bondType;
    private int faceValue;
    private double couponPercent;
    private String bondStatus;
    private String tradeStatus;

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }
    

    @Id
    @Column(name = "bond_id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Column(name = "quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Column(name = "unit_price", nullable = false)
    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    @Column(name = "trade_currency", nullable = false)
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    @Column(name = "trade_type", nullable = false)
    public String getBuyOrSell() {
        return buyOrSell;
    }

    public void setBuyOrSell(String buyOrSell) {
        this.buyOrSell = buyOrSell;
    }
    @Column(name = "trade_date", nullable = false)
    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }
    @Column(name = "trade_settlement_date", nullable = false)
    public String getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(String settlementDate) {
        this.settlementDate = settlementDate;
    }
    @Column(name = "type", nullable = false)
    public String getBondType() {
        return bondType;
    }

    public void setBondType(String bondType) {
        this.bondType = bondType;
    }
    @Column(name = "face_value", nullable = false)
    public int getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(int faceValue) {
        this.faceValue = faceValue;
    }
    @Column(name = "coupon_percent", nullable = false)
    public double getCouponPercent() {
        return couponPercent;
    }

    public void setCouponPercent(double couponPercent) {
        this.couponPercent = couponPercent;
    }
    @Column(name = "status", nullable = false)
    public String getBondStatus() {
        return bondStatus;
    }

    public void setBondStatus(String bStatus) {
        this.bondStatus = bStatus;
    }

    @Column(name = "trade_status", nullable = false)
    public String getTradeStatus() {
        return tradeStatus;
    }


    @Column(name = "isin", nullable = false)
    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }
    @Column(name = "cusip", nullable = false)
    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }
    @Column(name = "issuer_name", nullable = false)
    public String getBondIssuer() {
        return bondIssuer;
    }

    public void setBondIssuer(String bondIssuer) {
        this.bondIssuer = bondIssuer;
    }
    @Column(name = "bond_holder", nullable = false)
    public String getBondHolder() {
        return bondHolder;
    }

    public void setBondHolder(String bondHolder) {
        this.bondHolder = bondHolder;
    }
    @Column(name = "bond_maturity_date", nullable = false)
    public String getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(String date) {
        this.maturityDate = date;
    }
}
