package com.dustin.flux_demo.util;


import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class Util {

    public String getRandomDoubleBetweenRange(double min, double max) {
        String pattern = "###,###.##";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String format = decimalFormat.format((Math.random() * ((max - min) + 1)) + min);
        return format;
    }

    public String getStatus() {
        int i = ThreadLocalRandom.current().nextInt(0, 1 + 1);
        String status[] = { "HIGH", "LOW" };
        return status[i];
    }


}
