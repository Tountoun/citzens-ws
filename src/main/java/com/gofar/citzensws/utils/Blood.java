package com.gofar.citzensws.utils;

public enum Blood {
    ARP("A+"),
    BRP("B+"),
    ORP("O+"),
    ABRP("AB+"),
    ARN("A-"),
    BRN("B-"),
    ORN("O-"),
    ABRN("AB-");

    private final String group;

    Blood(String group) {
        this.group = group;
    }

    public String getGroup() {
        return group;
    }
}
