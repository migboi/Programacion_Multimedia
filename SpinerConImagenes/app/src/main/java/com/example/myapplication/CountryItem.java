package com.example.myapplication;

public class CountryItem {

    private String mCountryName;
    private int mFlagImage;


    public CountryItem(String mCountryName, int mFlagImage) {
        this.mCountryName = mCountryName;
        this.mFlagImage = mFlagImage;
    }

    public String getmCountryName() {
        return mCountryName;
    }

    public void setmCountryName(String mCountryName) {
        this.mCountryName = mCountryName;
    }

    public int getmFlagImage() {
        return mFlagImage;
    }

    public void setmFlagImage(int mFlagImage) {
        this.mFlagImage = mFlagImage;
    }


}
