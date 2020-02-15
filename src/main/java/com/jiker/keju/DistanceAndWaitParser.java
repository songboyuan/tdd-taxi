package com.jiker.keju;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DistanceAndWaitParser {
    int getDistance(String description) {
        int distance = 0;
        String[] descriptionArray = description.split(",");
        if(descriptionArray.length == 2) {
            distance = getNumberFromString(descriptionArray[0]);
        }
        return distance;
    }

    public int getWaitTime(String description) {
        int waitTime = 0;
        String[] descriptionArray = description.split(",");
        if(descriptionArray.length == 2) {
            waitTime = getNumberFromString(descriptionArray[1]);
        }
        return waitTime;
    }

    int getNumberFromString(String discription) {
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(discription);
        String result = m.replaceAll("").trim();
        int number = 0;
        if(result.length() > 0) {
            number = Integer.valueOf(result);
        }
        return number;
    }
}
