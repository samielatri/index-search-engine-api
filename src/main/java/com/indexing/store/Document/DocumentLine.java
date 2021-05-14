package com.indexing.store.Document;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class DocumentLine
        implements Serializable {

    /* data members */
    public String tpepPickupDatetime;  // tpep_pickupdatetime
    public String tpepDropoffDatetime;  // tpep_dropoff_datetime
    public int passengerCount;  // passenger_count
    public float tripDistance;  // trip_distance
    public int ratecodeID;  // ratecodeID
    public String storeAndFwdFlag;  // store_and_fwd_flag
    public float pickupLongitude;  // pickup_longitude
    public float pickupLatitude;  // pickup_latitude
    public float dropoffLongitude;  // dropoff_longitude
    public float dropoffLatitude;  // dropoff_latitude
    public int paymentType;  // tpep_pickup_datetime
    public float fareAmount;  // fare_amount
    public float extra;  // extra
    public float mtaTax;  // mta_tax
    public float tipAmount;  // tip_amount
    public float tollsAmount;  // tolls_amount
    public float improvementSurcharge;  // improvement_surcharge
    public float totalAmount;  // total_amount
    public HashMap<String, Object> mapper;
    
    /* Constructors */

    /**
     * default constructor
     */
    public DocumentLine() {
        
    }

    public DocumentLine( String tpepPickupDatetime,
            String tpepDropoffDatetime,
            int passengerCount,
            float tripDistance,
            float pickupLongitude,
            float pickupLatitude,
            int ratecodeID,
            String storeAndFwdFlag,
            float dropoffLongitude,
            float dropoffLatitude,
            int paymentType,
            float fareAmount,
            float extra,
            float mtaTax,
            float tipAmount,
            float tollsAmount,
            float improvementSurcharge,
            float totalAmount ) {
        this.tpepPickupDatetime = tpepPickupDatetime;
        this.tpepDropoffDatetime = tpepDropoffDatetime;
        this.passengerCount = passengerCount;
        this.tripDistance = tripDistance;
        this.ratecodeID = ratecodeID;
        this.storeAndFwdFlag = storeAndFwdFlag;
        this.pickupLongitude = pickupLongitude;
        this.pickupLatitude = pickupLatitude;
        this.dropoffLongitude = dropoffLongitude;
        this.dropoffLatitude = dropoffLatitude;
        this.paymentType = paymentType;
        this.fareAmount = fareAmount;
        this.extra = extra;
        this.mtaTax = mtaTax;
        this.tipAmount = tipAmount;
        this.tollsAmount = tollsAmount;
        this.improvementSurcharge = improvementSurcharge;
        this.totalAmount = totalAmount;
    }

    /**
     * constructor by copy
     * @param documentLine DocumentLine from where we initialize the new one
     */
    public DocumentLine(DocumentLine documentLine){
        tpepPickupDatetime = documentLine.tpepPickupDatetime;
        tpepDropoffDatetime = documentLine.tpepDropoffDatetime;;
        passengerCount = documentLine.passengerCount;;
        tripDistance = documentLine.tripDistance;;
        ratecodeID = documentLine.ratecodeID;;
        storeAndFwdFlag = documentLine.storeAndFwdFlag;;
        pickupLongitude = documentLine.pickupLongitude;;
        pickupLatitude = documentLine.pickupLatitude;;
        dropoffLongitude = documentLine.dropoffLongitude;;
        dropoffLatitude = documentLine.dropoffLatitude;;
        paymentType = documentLine.paymentType;;
        fareAmount = documentLine.fareAmount;;
        extra = documentLine.extra;;
        mtaTax = documentLine.mtaTax;;
        tipAmount = documentLine.tipAmount;;
        tollsAmount = documentLine.tollsAmount;;
        improvementSurcharge = documentLine.improvementSurcharge;;
        totalAmount = documentLine.totalAmount;;
    }

    public String getTpepPickupDatetime() {
        return tpepPickupDatetime;
    }

    public void setTpepPickupDatetime(String tpepPickupDatetime) {
        this.tpepPickupDatetime = tpepPickupDatetime;
    }

    public String getTpepDropoffDatetime() {
        return tpepDropoffDatetime;
    }

    public void setTpepDropoffDatetime(String tpepDropoffDatetime) {
        this.tpepDropoffDatetime = tpepDropoffDatetime;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    public float getTripDistance() {
        return tripDistance;
    }

    public void setTripDistance(float tripDistance) {
        this.tripDistance = tripDistance;
    }

    public int getRatecodeID() {
        return ratecodeID;
    }

    public void setRatecodeID(int ratecodeID) {
        this.ratecodeID = ratecodeID;
    }

    public String getStoreAndFwdFlag() {
        return storeAndFwdFlag;
    }

    public void setStoreAndFwdFlag(String storeAndFwdFlag) {
        this.storeAndFwdFlag = storeAndFwdFlag;
    }

    public float getPickupLongitude() {
        return pickupLongitude;
    }

    public void setPickupLongitude(float pickupLongitude) {
        this.pickupLongitude = pickupLongitude;
    }

    public float getPickupLatitude() {
        return pickupLatitude;
    }

    public void setPickupLatitude(float pickupLatitude) {
        this.pickupLatitude = pickupLatitude;
    }

    public float getDropoffLongitude() {
        return dropoffLongitude;
    }

    public void setDropoffLongitude(float dropoffLongitude) {
        this.dropoffLongitude = dropoffLongitude;
    }

    public float getDropoffLatitude() {
        return dropoffLatitude;
    }

    public void setDropoffLatitude(float dropoffLatitude) {
        this.dropoffLatitude = dropoffLatitude;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public float getFareAmount() {
        return fareAmount;
    }

    public void setFareAmount(float fareAmount) {
        this.fareAmount = fareAmount;
    }

    public float getExtra() {
        return extra;
    }

    public void setExtra(float extra) {
        this.extra = extra;
    }

    public float getMtaTax() {
        return mtaTax;
    }

    public void setMtaTax(float mtaTax) {
        this.mtaTax = mtaTax;
    }

    public float getTipAmount() {
        return tipAmount;
    }

    public void setTipAmount(float tipAmount) {
        this.tipAmount = tipAmount;
    }

    public float getTollsAmount() {
        return tollsAmount;
    }

    public void setTollsAmount(float tollsAmount) {
        this.tollsAmount = tollsAmount;
    }

    public float getImprovementSurcharge() {
        return improvementSurcharge;
    }

    public void setImprovementSurcharge(float improvementSurcharge) {
        this.improvementSurcharge = improvementSurcharge;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public HashMap<String, Object> getMapper() {
        return mapper;
    }

    public void setMapper(HashMap<String, Object> mapper) {
        this.mapper = mapper;
    }

    @Override
    public String toString() {
        return "DocumentLine{" +
                "tpepPickupDatetime='" + tpepPickupDatetime + '\'' +
                ", tpepDropoffDatetime='" + tpepDropoffDatetime + '\'' +
                ", passengerCount=" + passengerCount +
                ", tripDistance=" + tripDistance +
                ", ratecodeID=" + ratecodeID +
                ", storeAndFwdFlag='" + storeAndFwdFlag + '\'' +
                ", pickupLongitude=" + pickupLongitude +
                ", pickupLatitude=" + pickupLatitude +
                ", dropoffLongitude=" + dropoffLongitude +
                ", dropoffLatitude=" + dropoffLatitude +
                ", paymentType=" + paymentType +
                ", fareAmount=" + fareAmount +
                ", extra=" + extra +
                ", mtaTax=" + mtaTax +
                ", tipAmount=" + tipAmount +
                ", tollsAmount=" + tollsAmount +
                ", improvementSurcharge=" + improvementSurcharge +
                ", totalAmount=" + totalAmount +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(tpepPickupDatetime, tpepDropoffDatetime, passengerCount, tripDistance, ratecodeID, storeAndFwdFlag, pickupLongitude, pickupLatitude, dropoffLongitude, dropoffLatitude, paymentType, fareAmount, extra, mtaTax, tipAmount, tollsAmount, improvementSurcharge, totalAmount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DocumentLine)) return false;
        DocumentLine that = (DocumentLine) o;
        return getPassengerCount() == that.getPassengerCount() &&
                Float.compare(that.getTripDistance(), getTripDistance()) == 0 &&
                getRatecodeID() == that.getRatecodeID() &&
                Float.compare(that.getPickupLongitude(), getPickupLongitude()) == 0 &&
                Float.compare(that.getPickupLatitude(), getPickupLatitude()) == 0 &&
                Float.compare(that.getDropoffLongitude(), getDropoffLongitude()) == 0 &&
                Float.compare(that.getDropoffLatitude(), getDropoffLatitude()) == 0 &&
                getPaymentType() == that.getPaymentType() &&
                Float.compare(that.getFareAmount(), getFareAmount()) == 0 &&
                Float.compare(that.getExtra(), getExtra()) == 0 &&
                Float.compare(that.getMtaTax(), getMtaTax()) == 0 &&
                Float.compare(that.getTipAmount(), getTipAmount()) == 0 &&
                Float.compare(that.getTollsAmount(), getTollsAmount()) == 0 &&
                Float.compare(that.getImprovementSurcharge(), getImprovementSurcharge()) == 0 &&
                Float.compare(that.getTotalAmount(), getTotalAmount()) == 0 && getTpepPickupDatetime().equals(that.getTpepPickupDatetime()) &&
                getTpepDropoffDatetime().equals(that.getTpepDropoffDatetime()) &&
                getStoreAndFwdFlag().equals(that.getStoreAndFwdFlag());
    }
}
