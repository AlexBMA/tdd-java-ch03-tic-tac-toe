package com.packtpublishing.tddjava.ch03tictactoe;


public class TicTacToe {

    private Character[][] board={{'\0','\0','\0'},{'\0','\0','\0'},{'\0','\0','\0'}};
    private char lastPlayer = '\0';

    public String play(int x, int y) {

        checkAxis(x);
        checkAxis(y);
        lastPlayer = nextPlayer();
        setBox(x,y, lastPlayer);
        for (int index = 0; index<3;index++){
            if(board[0][index] == lastPlayer && board[1][index] == lastPlayer && board[2][index] == lastPlayer){
                return lastPlayer + " is the winner";
            }
        }
        return "No winner";
    }

    private void checkAxis(int axis){
        if(axis<1 || axis>3){
            throw
            new RuntimeException("X is outside board");
        }
    }
    private void setBox(int x,int y, char lastPlayer){
        if(board[x-1][y-1] !='\0'){
            throw
            new RuntimeException("Box is occupied");
        } else {
            board[x-1][y-1] = lastPlayer;
        }
    }

    public char nextPlayer() {
        if(lastPlayer =='X'){
            return 'O';
        }
        return 'X';
    }
}
