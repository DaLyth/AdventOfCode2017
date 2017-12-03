/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeadventcalendar2017;

/**
 *
 * @author Dany Lyth
 */
public class SpiralStructure {
    
    private int xPos;
    private int yPos;
    private int value;
    
    public static int position = 1;
    public static int leftToMove = 1;
    public static boolean moveX = true;

    public SpiralStructure(int xPos, int yPos, int value) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.value = value;
    }
    
    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    public static int getNextX(int x) {
        if(moveX) {
            int sign = 1;
            if(position%2 == 0) {
                sign = -1;
            }
            leftToMove--;
            if(leftToMove == 0) {
                leftToMove = position;
                moveX = false;
            }
            return sign + x;
        } else {
            return x;
        }
    }
    
    public static int getNextY(int y) {
        if(!moveX) {
            int sign = 1;
            if(position%2 == 0) {
                sign = -1;
            }
            leftToMove--;
            if(leftToMove == 0) {
                position++;
                leftToMove = position;
                moveX = true;
            }
            return sign + y;
        } else {
            return y;
        }
    }
    
}
