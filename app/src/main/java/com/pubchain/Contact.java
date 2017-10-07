package com.pubchain;

import android.os.Parcel;
import android.os.Parcelable;

public class Contact implements Parcelable {

    String name;
    String nxtAddr;

    public Contact(String name, String nxtAddr) {
        this.name = name;
        this.nxtAddr = nxtAddr;
    }

    public Contact(Parcel in) {
        super();
        readFromParcel(in);
    }

    public static final Parcelable.Creator<Contact> CREATOR = new Parcelable.Creator<Contact>() {
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        public Contact[] newArray(int size) {

            return new Contact[size];
        }

    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.nxtAddr);
    }

    public void readFromParcel(Parcel in) {
        name = in.readString();
        nxtAddr = in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNxtAddr() {
        return nxtAddr;
    }

    public void setNxtAddr(String nxtAddr) {
        this.nxtAddr = nxtAddr;
    }
}

