package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Theater implements Parcelable {
    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Theater() {
    }

    protected Theater(Parcel in) {
        name = in.readString();
        address = in.readString();
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(name);
        parcel.writeString(address);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Theater> CREATOR = new Creator<Theater>() {
        @Override
        public Theater createFromParcel(Parcel in) {
            return new Theater(in);
        }

        @Override
        public Theater[] newArray(int size) {
            return new Theater[size];
        }
    };
}
