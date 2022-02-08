package com.example.androidstudo.connect4.controller;

import qhough.connect4.model.*;
import qhough.connect4.view.ConnectUI;

import java.io.IOException;
import java.util.Random;

public class ConnectGame {
    private Board board = new Board();
    private Random gen = new Random();
    private player[] player = new player[2];

    private int whosTurn = 0;

    private ConnectUI ui = new ConnectUI();

    public void run() throws IOException{
        int selection = ui.promptMainMenu();
        switch (selection){
            case 1:
               player[0] = new human();
               player[1] = new human();
                break;
            case 2:
                player[0] = new human();
                player[1] = new computer();
                break;
            case 3:
                player[0] = new computer();
                player[1] = new computer();
                break;
            case 4:
                return;
        }
        player[0].setTokencolor(tokencolor.Yellow);
        player[0].setName(ui.promptForPlayerName(0));
        player[1].setTokencolor(tokencolor.Red);
        player[1].setName(ui.promptForPlayerName2(1));

    boolean megaLoop = true;


        while (megaLoop){
            System.out.println(board.toString());
            player currentplayer = player[whosTurn];
            //ui.displayBoard(this.board);
            boolean placedToken = false;
            do {
                int column = currentplayer instanceof human
                        ? ui.selectColumn(currentplayer)
                        : random();
                try {
                    board.dropToken(column, currentplayer.getTokencolor());
                    placedToken = true;
                   // ui.displayBoard(this.board);
                } catch (IllegalArgumentException ex) {
                    placedToken = false;
                    if (currentplayer instanceof human) {
                        ui.displayColumnFull(column);
                    }
                }
                board.checkForWin(currentplayer.getTokencolor(),0,0);
                if (board.checkForWin(tokencolor.Red, 0, 0)){
                    System.out.println("Red won!");
                    return;
                }
                if (board.checkForWin(tokencolor.Yellow,0,0)){
                    System.out.println("Yellow win!");
                    return;
                }
            }



            while(!placedToken);
            if(whosTurn == 0){
                whosTurn = 1;
            } else {
                whosTurn = 0;
            }//System.out.println("I am here");

        }
    }




    public int random() {
        int N = gen.nextInt(board.COUNT_COLS);
        return N;
    }






}
