package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.GregorianCalendar;

@Entity
@Table(name = "bonds")
public class Bond {

    @Id
    private long id;
    private int isin;
    private int cusip;
    private String bondIssuer;
    private String bondHolder;
    private GregorianCalendar maturityDate;
    private int quantity;
    private long unitPrice;
    private String currency;
    private String buyOrSell;
    private GregorianCalendar tradeDate;
    private GregorianCalendar settlementDate;
    private String bondType;
    private int faceValue;
    private long couponPercent;
    private String bondStatus;
    private String tradeStatus;

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
    public long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(long unitPrice) {
        this.unitPrice = unitPrice;
    }
    @Column(name = "currency", nullable = false)
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    @Column(name = "buy_or_sell", nullable = false)
    public String getBuyOrSell() {
        return buyOrSell;
    }

    public void setBuyOrSell(String buyOrSell) {
        this.buyOrSell = buyOrSell;
    }
    @Column(name = "trade_date", nullable = false)
    public GregorianCalendar getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(GregorianCalendar tradeDate) {
        this.tradeDate = tradeDate;
    }
    @Column(name = "settlement_date", nullable = false)
    public GregorianCalendar getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(GregorianCalendar settlementDate) {
        this.settlementDate = settlementDate;
    }
    @Column(name = "bond_type", nullable = false)
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
    public long getCouponPercent() {
        return couponPercent;
    }

    public void setCouponPercent(long couponPercent) {
        this.couponPercent = couponPercent;
    }
    @Column(name = "bond_status", nullable = false)
    public String getBondStatus() {
        return bondStatus;
    }

    public void setBond_status(String bStatus) {
        this.bondStatus = bStatus;
    }
    @Column(name = "trade_status", nullable = false)
    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTrade_status(String tStatus) {
        this.tradeStatus = tStatus;
    }

    @Column(name = "isin", nullable = false)
    public int getIsin() {
        return isin;
    }

    public void setIsin(int isin) {
        this.isin = isin;
    }
    @Column(name = "cusip", nullable = false)
    public int getCusip() {
        return cusip;
    }

    public void setCusip(int cusip) {
        this.cusip = cusip;
    }
    @Column(name = "bond_issuer", nullable = false)
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
    @Column(name = "maturity_date", nullable = false)
    public GregorianCalendar getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(GregorianCalendar date) {
        this.maturityDate = maturityDate;
    }
}
