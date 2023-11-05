package com.gofar.citzensws.utils;

import com.gofar.ws.BloodGroup;
import com.gofar.ws.Citizen;

import java.util.List;
import java.util.Random;

public class Data {
    private Data() {
        // private default constructor
    }

    public static List<Citizen> citizens() {
        Citizen c1 = new Citizen();
        c1.setCni("2344-441-222");
        c1.setHeight(random());
        c1.setJob("Software Develop");
        c1.setBloodGroup(BloodGroup.ORP);
        c1.setLastName("Noel");
        c1.setFirstName("James");
        c1.setMotherName("Martine Fati");
        c1.setFatherName("Fern The");

        Citizen ct2 = new Citizen();
        ct2.setCni("1144-041-270");
        ct2.setHeight(random());
        ct2.setJob("Designer");
        ct2.setBloodGroup(BloodGroup.ARP);
        ct2.setLastName("Nick");
        ct2.setFirstName("Roll");
        ct2.setMotherName("Micc Toft");
        ct2.setFatherName("Yoah Sam");

        Citizen cit3 = new Citizen();
        cit3.setCni("2004-441-121");
        cit3.setHeight(random());
        cit3.setJob("Nurse");
        cit3.setBloodGroup(BloodGroup.ABRP);
        cit3.setLastName("Bob");
        cit3.setFirstName("Loll");
        cit3.setMotherName("Deh Giz");
        cit3.setFatherName("Patrick Yhe");
        return List.of(c1, ct2, cit3);
    }

    private static double random() {
        return new Random().nextDouble();
    }
}
