package com.datahub.domain;

public class EntApplicationInfoWithBLOBs extends EntApplicationInfo {
    private String corpSecret1;

    private String corpSecret2;

    public String getCorpSecret1() {
        return corpSecret1;
    }

    public void setCorpSecret1(String corpSecret1) {
        this.corpSecret1 = corpSecret1 == null ? null : corpSecret1.trim();
    }

    public String getCorpSecret2() {
        return corpSecret2;
    }

    public void setCorpSecret2(String corpSecret2) {
        this.corpSecret2 = corpSecret2 == null ? null : corpSecret2.trim();
    }
}