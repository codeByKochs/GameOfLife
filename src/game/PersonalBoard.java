package game;
import gameoflife.GameOfLifeBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonalBoard extends GameOfLifeBoard {

    public PersonalBoard(int width, int height){
        super(width, height);
    }


    @Override
    public void initiateRandomCells(double v) {
        boolean[][] board= super.getBoard();

        for (int x = 0; x < super.getWidth(); x++) {
            for (int y = 0; y < super.getHeight(); y++) {
                board[x][y] = getRandomBoolean(v);
            }
        }
    }

    private boolean getRandomBoolean(double p){
        return new Random().nextFloat() < p;
    }

    @Override
    public boolean isAlive(int x, int y) {
        Boolean isAlive = false;
        try{
            isAlive = super.getBoard()[x][y];
        }
        catch (Exception e){
        }
        return isAlive;
    }

    @Override
    public void turnToLiving(int x, int y) {
        try{
            super.getBoard()[x][y] = true;
        }
        catch (Exception e){
        }
    }

    @Override
    public void turnToDead(int x, int y) {
        try{
            super.getBoard()[x][y] = false;
        }
        catch (Exception e){
        }
    }

    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
        int numberOfLivingNeighbours = 0;
        boolean[][] board = super.getBoard();
        List<Boolean> listOfNeighbours = new ArrayList<Boolean>();

        if (x == 0) {                                                           // check left side
            if (y == 0) {                                                       // check left upper corner
                listOfNeighbours.add(board[x+1][y]);
                listOfNeighbours.add(board[x+1][y+1]);
                listOfNeighbours.add(board[x][y+1]);
            }
            else if (y == getHeight()-1){                                         // check left lower corner
                listOfNeighbours.add(board[x][y-1]);
                listOfNeighbours.add(board[x+1][y-1]);
                listOfNeighbours.add(board[x+1][y-1]);
            }
            else {                                                              // check left side middle cells
                listOfNeighbours.add(board[x][y-1]);
                listOfNeighbours.add(board[x+1][y-1]);
                listOfNeighbours.add(board[x+1][y]);
                listOfNeighbours.add(board[x+1][y+1]);
                listOfNeighbours.add(board[x][y+1]);
            }
        }
        else if (x == getWidth()-1){                                              // check right side
            if (y == 0){                                                        // check right upper corner
                listOfNeighbours.add(board[x-1][y+1]);
                listOfNeighbours.add(board[x-1][y+1]);
                listOfNeighbours.add(board[x-1][y]);
            }
            else if (y == getHeight()-1){                                         // check right lower corner
                listOfNeighbours.add(board[x-1][y-1]);
                listOfNeighbours.add(board[x-1][y-1]);
                listOfNeighbours.add(board[x-1][y-1]);
            }
            else {                                                              // check right middle cells
                listOfNeighbours.add(board[x][y-1]);
                listOfNeighbours.add(board[x][y+1]);
                listOfNeighbours.add(board[x-1][y+1]);
                listOfNeighbours.add(board[x-1][y]);
                listOfNeighbours.add(board[x-1][y-1]);
            }
        }
        else if (y == 0){                                                       // check upper middle cells
            listOfNeighbours.add(board[x-1][y]);
            listOfNeighbours.add(board[x+1][y]);
            listOfNeighbours.add(board[x+1][y+1]);
            listOfNeighbours.add(board[x][y+1]);
            listOfNeighbours.add(board[x-1][y+1]);
        }
        else if (y == getHeight()-1){                                            // check lower middle cells
            listOfNeighbours.add(board[x-1][y]);
            listOfNeighbours.add(board[x+1][y-1]);
            listOfNeighbours.add(board[x][y-1]);
            listOfNeighbours.add(board[x+1][y-1]);
            listOfNeighbours.add(board[x+1][y]);
        }
        else{                                                                   // check cells in middle
            listOfNeighbours.add(board[x-1][y-1]);
            listOfNeighbours.add(board[x][y-1]);
            listOfNeighbours.add(board[x+1][y-1]);
            listOfNeighbours.add(board[x-1][y]);
            listOfNeighbours.add(board[x+1][y]);
            listOfNeighbours.add(board[x-1][y+1]);
            listOfNeighbours.add(board[x][y+1]);
            listOfNeighbours.add(board[x+1][y+1]);
        }

        for (Boolean bool : listOfNeighbours){
            if (bool){
                numberOfLivingNeighbours++;
            }
        }
        return numberOfLivingNeighbours;
    }




    @Override
    public void manageCell(int x, int y, int livingNeighbours) {
        boolean[][] board = super.getBoard();
        if (livingNeighbours < 2){
            board[x][y] = false;
        }
        if (livingNeighbours >= 2 && livingNeighbours <= 3){
        }
        if (livingNeighbours > 3){
            board[x][y] = false;
        }
        if (livingNeighbours == 3){
            board[x][y] = true;
        }

    }
}