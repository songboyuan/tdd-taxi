package com.jiker.keju;

public class TaxiPriceCalculator {
    final static int BASE_PRICE = 6;
    final static int BASE_DISTANCE = 2;
    final static int LONG_DISTANCE = 8;
    final static double SHORT_DISTANCE_PRICE = 0.8;
    final static double LONG_DISTANCE_EXTRA_PRICE = SHORT_DISTANCE_PRICE * 0.5;

    double getPrice(int distance, int waitMinute ) {

        double price = BASE_PRICE + getPriceForOverBaseDistance(distance);
        price = price + getWaitPrice(waitMinute);

        return price;
    }

    private double getPriceForOverBaseDistance(int distance) {
        double price = 0;
        if(distance > BASE_DISTANCE) {
            price = (distance - BASE_DISTANCE) * SHORT_DISTANCE_PRICE + getPriceForLongDistance(distance);
        }
        return price;
    }

    private double getPriceForLongDistance(int distance) {
        double price = 0;
        if (distance >= LONG_DISTANCE) {
            price = (distance - LONG_DISTANCE) * LONG_DISTANCE_EXTRA_PRICE;
        }
        return price;
    }

    private double getWaitPrice(int waitMinute) {
        return waitMinute * 0.25;
    }
}
