package com.jiker.keju;

import javax.swing.text.html.parser.Parser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class AppRunner {

    public static void main(String[] args) {
        String receipt;
        if(args != null && args.length != 0 && args[0] != null && args[0].length() > 0) {
            String testDataFile = args[0];
            receipt = getReceipt(testDataFile);
            System.out.println(receipt);
        }
    }

    public static String getReceipt(String  fileName) {
        String receipt = "";
        String input = readInput(fileName);
        DistanceAndWaitParser parser = new DistanceAndWaitParser();
        TaxiPriceCalculator calculator = new TaxiPriceCalculator();
        String[] tests;

        tests = input.split("\n");
        for (String test : tests) {
            int distance = parser.getDistance(test);
            int wait = parser.getWaitTime(test);
            double price = calculator.getPrice(distance, wait);
            receipt += "收费" + Math.round(price) + "\n";
        }

        return receipt;

    }


    private static String readInput(String testDataFile) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        byte[] buffer = new byte[1024];
        ByteArrayOutputStream testCases = new ByteArrayOutputStream();
        String testsDescription = "";
        try {
            InputStream in = classLoader.getResourceAsStream(testDataFile);
            int length;
            while ((length = in.read(buffer)) != -1) {
                testCases.write(buffer, 0, length);
            }
            testsDescription = testCases.toString("UTF-8");
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return testsDescription.trim();
    }

}
