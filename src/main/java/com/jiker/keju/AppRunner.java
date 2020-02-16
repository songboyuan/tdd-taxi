package com.jiker.keju;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class AppRunner {
    static DistanceAndWaitParser parser = new DistanceAndWaitParser();
    static TaxiPriceCalculator calculator = new TaxiPriceCalculator();
    static ByteArrayOutputStream testCases = new ByteArrayOutputStream();

    public static void main(String[] args) {
        if (args != null && args.length >= 1) {
            String receipt = getReceipt(args[0]);
            System.out.println(receipt);
        }
    }

    private static String getReceipt(String  fileName) {
        String receipt = "";
        String[] tests = getInputFromFile(fileName).split("\n");
        for (String test : tests) {
            double price = calculator.getPrice(parser.getDistance(test), parser.getWaitTime(test));
            receipt += "收费" + Math.round(price) + "元\n";
        }
        return receipt;
    }

    private static String getInputFromFile(String testDataFile) {
        String testInput = "";
        try {
            testInput = readInput(testDataFile);
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return testInput;
    }

    private static String readInput(String testDataFile) throws IOException {
        byte[] buffer = new byte[1024];
        InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(testDataFile);
        int length;
        while ((length = in.read(buffer)) != -1) {
            testCases.write(buffer, 0, length);
        }
        String testsDescription  = testCases.toString("UTF-8");
        return testsDescription.trim();
    }

}
