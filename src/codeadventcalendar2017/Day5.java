/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeadventcalendar2017;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DaLyth
 */
public class Day5 {
    
    public static int dayFive(String input) {
        int toReturn = 0;
        ArrayList<Integer> instructionList = new ArrayList<>();
        Scanner inputScanner = new Scanner(input);
        while(inputScanner.hasNextInt()) {
            instructionList.add(inputScanner.nextInt());
        }
        int i = 0;
        while(i < instructionList.size()) {
            int temp = instructionList.get(i);
            instructionList.set(i, temp+1);
            i += temp;
            toReturn++;
        }
        return toReturn;
    }
    
    public static int dayFivePartTwo(String input) {
        int toReturn = 0;
        ArrayList<Integer> instructionList = new ArrayList<>();
        Scanner inputScanner = new Scanner(input);
        while(inputScanner.hasNextInt()) {
            instructionList.add(inputScanner.nextInt());
        }
        int i = 0;
        int temp = 0;
        int offset = 0;
        while(i < instructionList.size() && i>=0) {
            temp = instructionList.get(i);
            if(temp >= 3) {
                offset = -1;
            } else {
                offset = 1;
            }
            instructionList.set(i, temp+offset);
            i += temp;
            toReturn++;
        }
        return toReturn;
    }
    
}
