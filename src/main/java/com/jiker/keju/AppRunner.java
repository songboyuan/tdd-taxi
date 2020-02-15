package com.jiker.keju;

import javax.swing.text.html.parser.Parser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class AppRunner {

    public static void main(String[] args) {
        String testDataFile = args[0];
        try {
            String input = readInput(testDataFile);
            String[] tests = input.split("\n");
            DistanceAndWaitParser parser = new DistanceAndWaitParser();
            TaxiPriceCalculator calculator = new TaxiPriceCalculator();
            String receipt = "";
            for(String test:tests) {
                int distance = parser.getDistance(test);
                int wait = parser.getWaitTime(test);
                double price = calculator.getPrice(distance, wait);
                receipt += "收费" + Math.round(price) + "\n";
            }
            System.out.println(receipt);
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static String readInput(String testDataFile) throws IOException {

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        InputStream in = classLoader.getResourceAsStream(testDataFile);
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = in.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        return result.toString("UTF-8");
    }

}
