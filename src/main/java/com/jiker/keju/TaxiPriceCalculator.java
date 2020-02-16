package com.jiker.keju;

public class TaxiPriceCalculator {
    final int basePrice = 6;
    final int baseDistance = 2;
    final int longDistance = 8;
    final double shortDistancePrice = 0.8;
    final double longDistanceExtraPrice = shortDistancePrice * 0.5;

    double getPrice(int distance, int waitMinute) {
        double price = basePrice + getPriceForOverBaseDistance(distance);
        price = price + getWaitPrice(waitMinute);
        return price;
    }

    private double getPriceForOverBaseDistance(int distance) {
        double price = 0;
        if (distance > baseDistance) {
            price = (distance - baseDistance) * shortDistancePrice + getPriceForLongDistance(distance);
        }
        return price;
    }

    private double getPriceForLongDistance(int distance) {
        double price = 0;
        if (distance >= longDistance) {
            price = (distance - longDistance) * longDistanceExtraPrice;
        }
        return price;
    }

    private double getWaitPrice(int waitMinute) {
        return waitMinute * 0.25;
    }
}
