package com.unbusy.alc4phase1;

import android.os.Parcel;
import android.os.Parcelable;

public class UserProfileInfo {
    private String mName;
    private String mSlackUsername;
    private String mTrack;
    private String mCountry;
    private String mEmailAddress;
    private String mPhoneNumber;

    public UserProfileInfo(String mName, String mSlackUsername, String mTrack, String mCountry, String mEmailAddress, String mPhoneNumber) {
        this.mName = mName;
        this.mSlackUsername = mSlackUsername;
        this.mTrack = mTrack;
        this.mCountry = mCountry;
        this.mEmailAddress = mEmailAddress;
        this.mPhoneNumber = mPhoneNumber;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmSlackUsername() {
        return mSlackUsername;
    }

    public void setmSlackUsername(String mSlackUsername) {
        this.mSlackUsername = mSlackUsername;
    }

    public String getmTrack() {
        return mTrack;
    }

    public void setmTrack(String mTrack) {
        this.mTrack = mTrack;
    }

    public String getmCountry() {
        return mCountry;
    }

    public void setmCountry(String mCountry) {
        this.mCountry = mCountry;
    }

    public String getmEmailAddress() {
        return mEmailAddress;
    }

    public void setmEmailAddress(String mEmailAddress) {
        this.mEmailAddress = mEmailAddress;
    }

    public String getmPhoneNumber() {
        return mPhoneNumber;
    }

    public void setmPhoneNumber(String mPhoneNumber) {
        this.mPhoneNumber = mPhoneNumber;
    }

    public String getFormattedSendText(){
        return "Hey there, guess what? I qualified for ALC 4.0 Phase 1 and " +
                "I am on the " + getmTrack() +
                " :). By the way, I am " + getmName() + " from " + getmCountry() +
                ". Contact me on : \nSlack : " + getmSlackUsername() +
                "\nEmail : " + getmEmailAddress() +
                "\nPhone Number : " + getmPhoneNumber();

    }

}
