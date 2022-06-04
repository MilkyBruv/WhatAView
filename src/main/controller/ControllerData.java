package main.controller;

import java.util.Hashtable;

public class ControllerData {
 
    // Code ints
    private int squareInt = 0;
    private int xInt = 1;
    private int circleInt = 2;
    private int triangleInt = 3;

    private int upInt = 2;
    private int downInt = 2;
    private int leftInt = 3;
    private int rightInt = 3;

    // Code strings
    private String squareStr = "square";
    private String xStr = "x";
    private String circleStr = "circle";
    private String triangleStr = "triangle";

    private String upStr = "up";
    private String downStr = "down";
    private String leftStr = "left";
    private String rightStr = "right";

    public Hashtable<String, Integer> codes = new Hashtable<String, Integer>();

    public ControllerData() {

        codes.put(squareStr, squareInt);
        codes.put(xStr, xInt);
        codes.put(circleStr, circleInt);
        codes.put(triangleStr, triangleInt);

        codes.put(upStr, upInt);
        codes.put(downStr, downInt);
        codes.put(leftStr, leftInt);
        codes.put(rightStr, rightInt);

    }
    
}
