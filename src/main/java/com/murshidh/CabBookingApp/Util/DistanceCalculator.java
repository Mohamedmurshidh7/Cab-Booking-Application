package com.murshidh.CabBookingApp.Util;

public class DistanceCalculator {
    /*
    Since we are interested in the number of blocks away,
    This logic gives the exact number of blocks needed to reach destination
     */
    public static int calculateDistance(int[] loc1, int[] loc2) {
        int deltaX = Math.abs(loc1[0] - loc2[0]);
        int deltaY = Math.abs(loc1[1] - loc2[1]);
        return deltaX+deltaY;
    }
}
