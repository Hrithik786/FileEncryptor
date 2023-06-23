package service;

import java.util.Random;

public class GenerateOTP {
    public static String getOTP(){
        Random random = new Random();
        //generated a Random number
        return String.format("%04d", random.nextInt(10000));
        //return it with the limit of 4 digits
    }
}
