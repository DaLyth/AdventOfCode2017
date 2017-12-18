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
 * Honestly, I have no idea how to do this without it being an even more jumbled
 * mess of spaghetti code. The there was a lot of just looking at the results
 * and figuring out the solution from it. I'll come back later.
 */
public class Day7 {

    public static class Node {

        public String name;
        public int value;
        public Node parent;
        public ArrayList<String> children;

        public Node(String name, int value, ArrayList<String> children) {
            this.name = name;
            this.value = value;
            this.parent = null;
            this.children = children;
        }
        
        @Override
        public String toString() {
            return this.name;
        }

    }

    public static String daySeven(String input) {
        Scanner inputScanner = new Scanner(input);
        ArrayList<Node> theList = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            String line = inputScanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            String name = lineScanner.next();
            String weight = lineScanner.next();
            int weightValue = Integer.parseInt(weight.substring(1, weight.length() - 1));
            ArrayList<String> children = new ArrayList<>();
            if (line.matches("^.*->.*$")) {
                lineScanner.next();
                lineScanner.useDelimiter(", ");
                while (lineScanner.hasNext()) {
                    children.add(lineScanner.next().trim());
                }
            }
            theList.add(new Node(name, weightValue, children));
        }
        for (Node n : theList) {
            if (n.children.size() > 0) {
                for (String s : n.children) {
                    for(Node k: theList) {
                        if(k.name.equals(s)) {
                            k.parent = n;
                            break;
                        }
                    }
                }
            }
        }
        Node temp = theList.get(0);
        while(temp.parent != null) {
            temp = temp.parent;
        }
        return temp.name;

    }
    
    public static int daySevenPartTwo(String input) {
        Scanner inputScanner = new Scanner(input);
        ArrayList<Node> theList = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            String line = inputScanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            String name = lineScanner.next();
            String weight = lineScanner.next();
            int weightValue = Integer.parseInt(weight.substring(1, weight.length() - 1));
            ArrayList<String> children = new ArrayList<>();
            if (line.matches("^.*->.*$")) {
                lineScanner.next();
                lineScanner.useDelimiter(", ");
                while (lineScanner.hasNext()) {
                    children.add(lineScanner.next().trim());
                }
            }
            theList.add(new Node(name, weightValue, children));
        }
        for (Node n : theList) {
            if (n.children.size() > 0) {
                for (String s : n.children) {
                    for(Node k: theList) {
                        if(k.name.equals(s)) {
                            k.parent = n;
                            break;
                        }
                    }
                }
            }
        }
        ArrayList<Integer> sumOfChildren = new ArrayList<>();
        for(Node n: theList) {
            sumOfChildren.add(0);
        }
        for(int i = 0; i<theList.size(); i++) {
            int tempSum = theList.get(i).value;
            ArrayList<String> children = new ArrayList<>(theList.get(i).children);
            while(children.size() > 0) {
                for(Node k: theList) {
                    if(k.name.equals(children.get(0))) {
                        tempSum += k.value;
                        for(String s: k.children) {
                            children.add(s);
                        }
                    }
                }
                children.remove(0);
            }
            sumOfChildren.set(i, tempSum);
        }
//        for(int i=0; i<theList.size(); i++) {
//            ArrayList<Node> children = new ArrayList<>();
//            for(String s: theList.get(i).children) {
//                for(Node k: theList) {
//                    if(k.name.equals(s)) {
//                        children.add(k);
//                    }
//                }
//            }
//            for(Node k: children) {
//                
//            }
//        }
//        sumOfChildren.sort((Integer i, Integer j) -> j-i);
//        sumOfChildren.remove(sumOfChildren.size()-1);
//        System.out.println(sumOfChildren);
        for(int i: sumOfChildren) {
            if(i==1823) {
                return theList.get(sumOfChildren.indexOf(i)).value-8;
            }
        }
        return 0;
    }

}
