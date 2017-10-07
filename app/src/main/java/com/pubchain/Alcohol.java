package com.pubchain;

import android.os.Parcel;
import android.os.Parcelable;

public class Alcohol implements Parcelable {

    String productName;
    double beerCoinValue;
    double standardDrinks;
    long timestamp;

    public Alcohol(String productName, double beerCoinValue, double standardDrinks) {
        this.productName = productName;
        this.beerCoinValue = beerCoinValue;
        this.standardDrinks = standardDrinks;
        this.timestamp = System.currentTimeMillis() / 1000;
    }

    public Alcohol(Parcel in) {
        super();
        readFromParcel(in);
    }

    public static final Parcelable.Creator<Alcohol> CREATOR = new Parcelable.Creator<Alcohol>() {
        public Alcohol createFromParcel(Parcel in) {
            return new Alcohol(in);
        }

        public Alcohol[] newArray(int size) {

            return new Alcohol[size];
        }

    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.productName);
        parcel.writeDouble(this.beerCoinValue);
        parcel.writeDouble(this.standardDrinks);
    }

    public void readFromParcel(Parcel in) {
        productName = in.readString();
        beerCoinValue = in.readDouble();
        standardDrinks = in.readDouble();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getBeerCoinValue() {
        return beerCoinValue;
    }

    public void setBeerCoinValue(double beerCoinValue) {
        this.beerCoinValue = beerCoinValue;
    }

    public double getStandardDrinks() {
        return standardDrinks;
    }

    public void setStandardDrinks(double standardDrinks) {
        this.standardDrinks = standardDrinks;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}

