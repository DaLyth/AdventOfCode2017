/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeadventcalendar2017;

import java.util.ArrayList;

/**
 *
 * @author Dany Lyth
 * I did part 1 by hand, the answer is 552
 */
public class Day3 {
    
    public static boolean doesAdjacentExist(ArrayList<SpiralStructure> array, int xPos, int yPos, int xDisp, int yDisp) {
        for(SpiralStructure struct: array) {
            if(struct.getxPos() == xPos+xDisp && struct.getyPos() == yPos+yDisp) {
                return true;
            }
        }
        return false;
    }
    
    public static int getAdjacentValue(ArrayList<SpiralStructure> array, int xPos, int yPos, int xDisp, int yDisp) {
        for(SpiralStructure struct: array) {
            if(struct.getxPos() == xPos+xDisp && struct.getyPos() == yPos+yDisp) {
                return struct.getValue();
            }
        }
        return 0;
    }
    
    public static int getSumOfAdjacent(ArrayList<SpiralStructure> array, int xPos, int yPos) {
        int toReturn = 0;
        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                if(!(i == 0 && j == 0)) {
                    toReturn += getAdjacentValue(array, xPos, yPos, i, j);
                }
            }
        }
        return toReturn;
    }
    
    public static int dayThreePartTwo(int value) {
        int begin = 1;
        int xPos = 0;
        int yPos = 0;
        ArrayList<SpiralStructure> theMatrix = new ArrayList<>();
        theMatrix.add(new SpiralStructure(0,0,1));
        while (begin <= value) {
            if(!SpiralStructure.moveX) {
                xPos = SpiralStructure.getNextX(xPos);
                yPos = SpiralStructure.getNextY(yPos);
            } else {
                yPos = SpiralStructure.getNextY(yPos);
                xPos = SpiralStructure.getNextX(xPos);
            }
            begin = getSumOfAdjacent(theMatrix, xPos, yPos);
            theMatrix.add(new SpiralStructure(xPos, yPos, begin));
            //System.out.println(xPos + " " + yPos + " " + begin);
        }
        return begin;
    }
    
}
