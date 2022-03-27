package com.company.test;

import com.company.Constant;
import com.company.Rover;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class RoverTest
{
    @Test
    public void Should_ReturnError_When_InvalidCommand()
    {
        Throwable exception = Assertions.assertThrows(
                UnsupportedOperationException.class, () -> {
                    Rover rover = new Rover();
                    rover.process("X");
                }
        );

        Assertions.assertEquals(Constant.ERROR_ILLEGAL_COMMAND, exception.getMessage());

    }
    @Test
    public void Should_ReturnError_When_InvalidGridSize()
    {
        Throwable exception = Assertions.assertThrows(
                IllegalArgumentException.class, () -> {
                    Rover rover = new Rover();
                    rover.setGridSize(-1, -1);
                }
        );

        Assertions.assertEquals(Constant.ERROR_ILLEGAL_GRID_SIZE, exception.getMessage());

    }

    @Test
    public void Should_ReturnError_When_InitialPosOutOfGrid()
    {
        Throwable exception = Assertions.assertThrows(
                IllegalStateException.class, () -> {
                    Rover rover = new Rover();
                    rover.setGridSize(5, 5);
                    rover.setPosition(6, 2, 'N');
                }
        );

        Assertions.assertEquals(Constant.ERROR_INITIAL_POS_OUT_GRID, exception.getMessage());

    }

    @Test
    public void Should_ReturnError_When_InvalidFacing()
    {
        Throwable exception = Assertions.assertThrows(
                IllegalArgumentException.class, () -> {
                    Rover rover = new Rover();
                    rover.setGridSize(5, 5);
                    rover.setPosition(1, 2, 'T');
                }
        );

        Assertions.assertEquals(Constant.ERROR_INVALID_FACING, exception.getMessage());

    }

    @Test
    public void Should_ReturnError_When_OutOfGrid()
    {
        Throwable exception = Assertions.assertThrows(
                IllegalStateException.class, () -> {
                    Rover rover = new Rover();
                    rover.setGridSize(5, 5);
                    rover.setPosition(4, 4, 'N');
                    rover.process("MMMM");
                }
        );

        Assertions.assertEquals(Constant.ERROR_OUT_OF_GRID, exception.getMessage());

    }

}
