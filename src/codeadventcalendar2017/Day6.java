/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeadventcalendar2017;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 *
 * @author DaLyth
 */
public class Day6 {
    
    public static int daySix(String input) {
        int toReturn = 0;
        ArrayList<Integer> instructionList = new ArrayList<>();
        Scanner inputScanner = new Scanner(input);
        while(inputScanner.hasNextInt()) {
            instructionList.add(inputScanner.nextInt());
        }
        LinkedHashSet<ArrayList<Integer>> theSet = new LinkedHashSet<>();
        theSet.add(instructionList);
        int theSetSize;
        do {
            theSetSize = theSet.size();
            int max = 0;
            for(int t: instructionList) {
                max = Math.max(t, max);
            }
            int i = instructionList.indexOf(max);
            int value = instructionList.get(i);
            instructionList.set(i, 0);
            while(value > 0) {
                i++;
                instructionList.set(i%instructionList.size(), instructionList.get(i%instructionList.size())+1);
                value--;
            }
            theSet.add(instructionList);
            toReturn++;
        } while(theSetSize < theSet.size());
        return toReturn;
    }
    
    public static int daySixPartTwo(String input) {
        int toReturn = 0;
        ArrayList<Integer> instructionList = new ArrayList<>();
        Scanner inputScanner = new Scanner(input);
        while(inputScanner.hasNextInt()) {
            instructionList.add(inputScanner.nextInt());
        }
        LinkedHashSet<ArrayList<Integer>> theSet = new LinkedHashSet<>();
        theSet.add(instructionList);
        int theSetSize;
        do {
            theSetSize = theSet.size();
            int max = 0;
            for(int t: instructionList) {
                max = Math.max(t, max);
            }
            int i = instructionList.indexOf(max);
            int value = instructionList.get(i);
            instructionList.set(i, 0);
            while(value > 0) {
                i++;
                instructionList.set(i%instructionList.size(), instructionList.get(i%instructionList.size())+1);
                value--;
            }
            theSet.add(instructionList);
        } while(theSetSize < theSet.size());
        LinkedHashSet<ArrayList<Integer>> theSetTwo = new LinkedHashSet<>();
        theSetTwo.add(instructionList);
        do {
            theSetSize = theSetTwo.size();
            int max = 0;
            for(int t: instructionList) {
                max = Math.max(t, max);
            }
            int i = instructionList.indexOf(max);
            int value = instructionList.get(i);
            instructionList.set(i, 0);
            while(value > 0) {
                i++;
                instructionList.set(i%instructionList.size(), instructionList.get(i%instructionList.size())+1);
                value--;
            }
            theSetTwo.add(instructionList);
            toReturn++;
        } while(theSetSize < theSetTwo.size());
        return toReturn;
    }
    
}
