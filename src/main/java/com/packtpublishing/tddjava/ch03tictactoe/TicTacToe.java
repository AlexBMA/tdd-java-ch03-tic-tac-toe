package com.packtpublishing.tddjava.ch03tictactoe;


public class TicTacToe {

    private Character[][] board={{'\0','\0','\0'},{'\0','\0','\0'},{'\0','\0','\0'}};
    private char lastPlayer = '\0';

    private static int SIZE = 3;

    public String play(int x, int y) {

        checkAxis(x);
        checkAxis(y);
        lastPlayer = nextPlayer();
        setBox(x,y, lastPlayer);
        if(isWin()){
            return lastPlayer + " is the winner";
        } else if (isDraw()) {
            return "The result is draw";
        } else {
            return "No winner";
        }
    }

    private boolean isDraw() {
        for (int x = 0; x < this.SIZE; x++) {
            for (int y = 0; y < this.SIZE; y++) {
                if (board[x][y] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isWin(){
        int playerTotal = lastPlayer * this.SIZE;
        int diagonal1 = '\0';
        int diagonal2 = '\0';
        for (int index = 0; index<this.SIZE;index++){


            diagonal1 = diagonal1 + board[index][index];
            diagonal2 = diagonal2 + board[index][this.SIZE - index -1];

            if(board[0][index] + board[1][index]+ board[2][index] == playerTotal){
                return true;
            }

            if(board[index][0] + board[index][1]+ board[index][2] == playerTotal){
                return true;
            }

            if(diagonal1 == playerTotal) return true;
            if (diagonal2 == playerTotal) return true;

        }
        return false;
    }

    private void checkAxis(int axis){
        if(axis<1 || axis>this.SIZE){
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
