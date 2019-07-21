package com.example.flag;

import java.io.Serializable;

public class Flag implements Serializable {
    private String flagEngName;
    private String flagKorName;
    private String flagCode;
    private String flagShortName;
    private int rid;

    public Flag() {

    }
    public Flag(String flagEngName, String flagShortName, String flagCode, String flagKorName, int rid) {
        this.flagEngName = flagEngName;
        this.flagKorName = flagKorName;
        this.flagCode = flagCode;
        this.flagShortName = flagShortName;
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "Flag{" +
                "flagEngName='" + flagEngName + '\'' +
                ", flagKorName='" + flagKorName + '\'' +
                ", flagCode='" + flagCode + '\'' +
                ", flagShortName='" + flagShortName + '\'' +
                ", rid=" + rid +
                '}';
    }

    public String getFlagEngName() {
        return flagEngName;
    }

    public void setFlagEngName(String flagEngName) {
        this.flagEngName = flagEngName;
    }

    public String getFlagKorName() {
        return flagKorName;
    }

    public void setFlagKorName(String flagKorName) {
        this.flagKorName = flagKorName;
    }

    public String getFlagCode() {
        return flagCode;
    }

    public void setFlagCode(String flagCode) {
        this.flagCode = flagCode;
    }

    public String getFlagShortName() {
        return flagShortName;
    }

    public void setFlagShortName(String flagShortName) {
        this.flagShortName = flagShortName;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }
}
