package com.company;


public class Main {

    public static void main(String[] args)
    {
        Rover rover = new Rover();
        rover.setGridSize(5,5);
        rover.setPosition(1, 2, 'N');
        rover.process("LMLMLMLMM");
        rover.printPosition();
        rover.setPosition(3, 3, 'E');
        rover.process("MMRMMRMRRM");
        rover.printPosition();

    }
}
