package com.packtpublishing.tddjava.ch03tictactoe;

public class TicTacToe {

    public void play(int x, int y) {

        if(x<1 || x>3){
            throw  new RuntimeException("X outside the board");
        }
    }
}