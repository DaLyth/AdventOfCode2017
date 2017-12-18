/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeadventcalendar2017;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 *
 * @author DaLyth
 */
public class Day4 {
    
    public static int dayFour(String input) {
        int toReturn = 0;
        Scanner inputScanner = new Scanner(input);
        LinkedHashSet<String> set = new LinkedHashSet<>();
        while(inputScanner.hasNextLine()) {
            Scanner lineScanner = new Scanner(inputScanner.nextLine());
            int temp = 0;
            while(lineScanner.hasNext()) {
                set.add(lineScanner.next());
                temp++;
            }
            if(set.size() == temp) {
                toReturn++;
            }
            set.clear();
        }
        return toReturn;
    }
    
    public static int dayFourPartTwo(String input) {
        int toReturn = 0;
        Scanner inputScanner = new Scanner(input);
        LinkedHashSet<String> set = new LinkedHashSet<>();
        while(inputScanner.hasNextLine()) {
            Scanner lineScanner = new Scanner(inputScanner.nextLine());
            int temp = 0;
            while(lineScanner.hasNext()) {
                char[] tempArray = lineScanner.next().toCharArray();
                Arrays.sort(tempArray);
                String toAdd = new String(tempArray);
                set.add(toAdd);
                temp++;
            }
            if(set.size() == temp) {
                toReturn++;
            }
            set.clear();
        }
        return toReturn;
    }
    
}
