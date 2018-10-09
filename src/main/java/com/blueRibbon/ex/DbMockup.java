package com.blueRibbon.ex;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Dell on 09/10/2018.
 *
 */
public class DbMockup {


    private static DbMockup instance = null;

    private final HashSet<Integer> availableTickets;
    private final HashMap<Integer, HashSet<String>> checkedIn;
    private final HashSet<String> validCoupons;


    public static DbMockup getInstance(){
        if (instance == null){
            instance = new DbMockup();
        }
        return instance;
    }

    protected DbMockup(){
        availableTickets = new HashSet<>();
        availableTickets.add(1);
        availableTickets.add(2);
        availableTickets.add(3);
        availableTickets.add(5);
        availableTickets.add(8);
        availableTickets.add(10);

        checkedIn = new HashMap<>();
        checkedIn.put(1, new HashSet<>());
        checkedIn.put(2, new HashSet<>());
        checkedIn.put(3, new HashSet<>());

        validCoupons = new HashSet<>();
        validCoupons.add("12345");
        validCoupons.add("123456");
        validCoupons.add("1234567");
    }

    public HashSet<Integer> getAvailableTickets() {
        return availableTickets;
    }

    public HashMap<Integer, HashSet<String>> getCheckedIn() {
        return checkedIn;
    }

    public HashSet<String> getValidCoupons() {
        return validCoupons;
    }
}
