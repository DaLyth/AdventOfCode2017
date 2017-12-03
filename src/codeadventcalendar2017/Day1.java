/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeadventcalendar2017;

import java.math.BigInteger;

/**
 *
 * @author Dany Lyth
 */
public class Day1 {
    
    public static BigInteger dayOne(BigInteger number) {
        BigInteger ten = new BigInteger("10");
        BigInteger toReturn = new BigInteger("0");
        BigInteger lastDigit = number.mod(ten);
        BigInteger temp = lastDigit;
        BigInteger i = number;
        while(i.compareTo(ten) >= 0) {
            i = i.divide(ten);
            if(i.mod(ten).compareTo(temp) == 0) {
                toReturn = toReturn.add(temp);
            }
            temp = i.mod(ten);
        }
        if(lastDigit.compareTo(i) == 0) {
            toReturn = toReturn.add(temp);
        }
        return toReturn;
    }
    
    public static int dayOneString(String input) {
        int toReturn = 0;
        for(int i = 0; i<input.length(); i++) {
            if(input.charAt(i) == input.charAt((i+1)%input.length())) {
                toReturn += Integer.parseInt(input.charAt(i) + "");
            }
        }
        return toReturn;
    }
    
    public static int dayOneStringPartTwo(String input) {
        int toReturn = 0;
        for(int i = 0; i<input.length(); i++) {
            if(input.charAt(i) == input.charAt((i+(input.length()/2))%input.length())) {
                toReturn += Integer.parseInt(input.charAt(i) + "");
            }
        }
        return toReturn;
    }
    
}
