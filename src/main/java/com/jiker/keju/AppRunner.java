package com.jiker.keju;

import javax.swing.text.html.parser.Parser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class AppRunner {

    public static void main(String[] args) {
        String testDataFile = args[0];
        String receipt = "";
        if(testDataFile != null && testDataFile.length() > 0) {
            receipt = getReceipt(testDataFile);
        }
        System.out.println(receipt);
    }

    private static String getReceipt(String  fileName) {
        String receipt = "";
        String input = readInput(fileName);
        String[] tests = input.split("\n");
        DistanceAndWaitParser parser = new DistanceAndWaitParser();
        TaxiPriceCalculator calculator = new TaxiPriceCalculator();

        for(String test:tests) {
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
        return testsDescription;
    }

}
