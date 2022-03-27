package com.company;

public class Rover
{
    int maxX = 0;
    int maxY = 0;
    int x = 0;
    int y = 0;
    char direction = 'N';

    public Rover()
    {
    }

    public void setGridSize(int x, int y)
    {
        if(x <= 0 || y <= 0)
        {
            throw new IllegalArgumentException(Constant.ERROR_ILLEGAL_GRID_SIZE);
        }
        this.maxX = x;
        this.maxY = y;
    }

    public void setPosition(int x, int y, char direction)
    {
        if(x > this.maxX || y > this.maxY)
        {
            throw new IllegalStateException(Constant.ERROR_INITIAL_POS_OUT_GRID);
        }
        if(direction != 'N' && direction != 'E' && direction != 'S' && direction != 'W')
        {
            throw new IllegalArgumentException(Constant.ERROR_INVALID_FACING);
        }
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void printPosition()
    {
        System.out.println(x + " " + y + " " + direction);
    }

    public void process(String commands)
    {
        for(char command: commands.toCharArray())
        {
            process(command);
        }
    }

    private void process(Character command)
    {
        if (command.equals('L'))
        {
            turnLeft();
        }
        else if (command.equals('R'))
        {
            turnRight();
        }
        else if (command.equals('M'))
        {
            move();
        }
        else
        {
            throw new UnsupportedOperationException(Constant.ERROR_ILLEGAL_COMMAND);
        }

    }

    private void move()
    {
        if (direction == 'N')
        {
            this.y++;
        }
        else if (direction == 'E')
        {
            this.x++;
        }
        else if (direction == 'S')
        {
            this.y--;
        }
        else if (direction == 'W')
        {
            this.x--;
        }
        if (this.x < 0 || this.y < 0 || this.x > maxX || this.y > maxY)
        {
            throw new IllegalStateException(Constant.ERROR_OUT_OF_GRID);
        }
    }

    private void turnLeft()
    {
        switch (this.direction)
        {
            case 'N':
                this.direction = 'W';
                break;
            case 'W':
                this.direction = 'S';
                break;
            case 'S':
                this.direction = 'E';
                break;
            case 'E':
                this.direction = 'N';
                break;
            default:
                this.direction = 'N';
                break;
        }
    }

    private void turnRight()
    {
        switch (this.direction)
        {
            case 'N':
                this.direction = 'E';
                break;
            case 'E':
                this.direction = 'S';
                break;
            case 'S':
                this.direction = 'W';
                break;
            case 'W':
                this.direction = 'N';
                break;
            default:
                this.direction = 'N';
                break;
        }
    }
}
