/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeadventcalendar2017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author DaLyth
 */
public class Day2 {
    
    public static int dayTwo(String input) {
        int toReturn = 0;
        ArrayList<Integer> line = new ArrayList<>();
        Scanner stringScanner = new Scanner(input);
        String nextLine;
        do {
            nextLine = stringScanner.nextLine();
            Scanner lineScanner = new Scanner(nextLine);
            while(lineScanner.hasNextInt()) {
                line.add(lineScanner.nextInt());
            }
            toReturn += (Collections.max(line) - Collections.min(line));
            line.clear();
        } while (stringScanner.hasNextLine());
        return toReturn;
    }
    
    public static int dayTwoPartTwo(String input) {
        int toReturn = 0;
        ArrayList<Integer> line = new ArrayList<>();
        Scanner stringScanner = new Scanner(input);
        String nextLine;
        outer:
        do {
            nextLine = stringScanner.nextLine();
            Scanner lineScanner = new Scanner(nextLine);
            while(lineScanner.hasNextInt()) {
                int temp = lineScanner.nextInt();
                for(int i: line) {
                    if(i%temp == 0 || temp%i == 0) {
                        toReturn += Math.max(temp, i) / Math.min(temp, i);
                        continue outer;
                    }
                }
                line.add(temp);
            }
            line.clear();
        } while (stringScanner.hasNextLine());
        return toReturn;
    }
    
    public static ArrayList<ArrayList<Integer>> toArray(String input) {
        ArrayList<ArrayList<Integer>> toReturn = new ArrayList<>();
        String[] first = input.split("\n");
        ArrayList<String[]> second = new ArrayList<>();
        for(String s: first) {
            second.add(s.split(" "));
        }
        second.forEach((s) -> {
            ArrayList<Integer> temp = new ArrayList<>();
            for (String item : s) {
                temp.add(Integer.parseInt(item));
            }
            toReturn.add(temp);
        });
        return toReturn;
    }
    
}
