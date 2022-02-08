package com.example.androidstudo.connect4.model;

import java.util.Random;

public class computer extends player{
    private Board board = new Board();


    public computer(String name, tokencolor tokencolor){
        this.setName(name);
        this.setTokencolor(tokencolor);
    }

    public computer(){}


}


