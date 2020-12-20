package com.datahub.domain;

public class EntRoleWithBLOBs extends EntRole {
    private String name;

    private String about;

    private String aboutEn;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about == null ? null : about.trim();
    }

    public String getAboutEn() {
        return aboutEn;
    }

    public void setAboutEn(String aboutEn) {
        this.aboutEn = aboutEn == null ? null : aboutEn.trim();
    }
}