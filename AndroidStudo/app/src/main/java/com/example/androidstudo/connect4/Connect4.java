package com.example.androidstudo.connect4;

import qhough.connect4.controller.ConnectGame;
import qhough.connect4.model.Board;

import java.io.IOException;

public class Connect4 {
    public static void main(String[] args) throws IOException {
       Board b = new Board();
        ConnectGame g = new ConnectGame();
        g.run();
        b.toString();
    }
}
