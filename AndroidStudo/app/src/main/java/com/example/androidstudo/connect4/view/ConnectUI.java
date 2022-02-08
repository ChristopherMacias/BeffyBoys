package com.example.androidstudo.connect4.view;

import com.example.androidstudo.connect4.model.Board;
import com.example.androidstudo.connect4.model.player;
import com.example.androidstudo.connect4.model.tokencolor;

import java.io.IOException;

public class ConnectUI {

    ConnectIO io = new ConnectIO();

    Board board = new Board();

    public int selectColumn(player currentplayer) throws IOException {
        System.out.println(currentplayer.getName() + " select your column between 1 and " + board.COUNT_COLS + "!");
        int selection = io.promptForInt(1, board.COUNT_COLS);
        return selection - 1;
    }


    public String promptForPlayerName(int i) throws IOException {
        return io.promptForString("Enter name for player 1!");
    }
    public String promptForPlayerName2(int i) throws IOException {
        return io.promptForString("Enter name for player 2!");
    }

    public void displayColumnFull(int column) {
        System.out.println(board.COUNT_COLS + " is already full!");
    }

    public int promptMainMenu() throws IOException {

        ConnectIO ConnectIO = new ConnectIO();

        System.out.println(
                        "1 - PVP \n" +
                        "2 - PVC \n" +
                        "3 - CVC \n" +
                        "4 - Exit \n");
        int selection = ConnectIO.promptForInt(1, 4);
        return selection;
    }

    public void displayBoard(Board board) {
        for (int row = 0; row < Board.COUNT_ROWS; row++) {
            for (int col = 0; col < Board.COUNT_COLS; col++) {
                System.out.print("|"+board.get(row,col)+"|");
//                if (board.get(row, col)== tokencolor.Red) {
//                    System.out.println(" R ");
//                } else if (board.get(row, col) == tokencolor.Yellow){
//                    System.out.print(" Y ");
//                }
}
            System.out.println();
//            System.out.println("------------");
        }
        System.out.println(" ");
    }
}