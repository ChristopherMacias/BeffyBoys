package com.example.androidstudo.connect4.model;

public class Board {
    public static final int COUNT_ROWS = 6;
    public static final int COUNT_COLS = 7;
    private tokencolor[][] cells = new tokencolor[COUNT_ROWS][COUNT_COLS];

    public  tokencolor getTokenColor(int row, int col){
        return cells[row][col];
    }

    public tokencolor dropToken(int col,tokencolor tokencolor){
        int row = findRow(col);
        return this.cells[row][col] = tokencolor;
    }

    private int findRow(int col){
       for (int row = COUNT_ROWS -1;row>=0;row--){
           if (this.cells[row][col] == null){
               return row;
           }
       }
       throw new IllegalArgumentException ("No available cells in col" + col);
    }

    public tokencolor get(int row, int col){
        return cells[row][col];
    }

    public boolean checkForWin(tokencolor tokencolor, int row, int col){
        if(checkForColWin(tokencolor, row, col)){
            return true;
        }
        if(checkForRowWin(tokencolor, row, col)){
            return true;
        }
        return checkForDiagonalWin(tokencolor, row, col);
    }

    public boolean checkForColWin(tokencolor tokencolor, int row, int col){
        int countConTokens = 0;
        for(int c = col; c < COUNT_COLS; c++ ){
            for (int r = row; r < COUNT_ROWS; r++){
                if (this.cells[r][c] == tokencolor){
                    countConTokens++;
                } else {
                    countConTokens = 0;
                }
                if (countConTokens >= 4){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkForRowWin(tokencolor tokencolor, int row, int col){
        int countConTokens = 0;
        for(int r = row; r <COUNT_ROWS; r++ ){
            for (int c = col; c < COUNT_COLS; c++){
                if (this.cells[r][c] == tokencolor){
                    countConTokens++;
                } else {
                    countConTokens = 0;
                }
                if (countConTokens >= 4){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkForDiagonalWin(tokencolor tokencolor, int row, int col){
        return checkForDiagonalClock2Win(tokencolor, row, col) ||
                checkForDiagonalClock4Win(tokencolor, row, col) ||
                checkForDiagonalClock8Win(tokencolor, row, col) ||
                checkForDiagonalClock10Win(tokencolor, row, col);
    }

    private boolean checkForDiagonalClock2Win(tokencolor tokencolor, int placedAtRow, int placedAtCol){
        int countConTokens = 0;
        int r, c = 0;
        for (r=placedAtRow,c = placedAtCol;r<COUNT_ROWS &&c >=0; r++,c--);
            for(int row=r,col = c;row>=0 && col < COUNT_COLS;row--,col++){
                if (this.cells[placedAtRow][placedAtCol] == tokencolor){
                    countConTokens++;
                }
                else{
                    countConTokens = 0;
                }
                if(countConTokens >= 4){
                    return true;
                }
            }
        return false;
    }

    private boolean checkForDiagonalClock4Win(tokencolor tokencolor, int placedAtRow, int placedAtCol){
        int countConTokens = 0;
        int r, c = 0;
        for (r=placedAtRow,c = placedAtCol;r<COUNT_ROWS &&c >0; r++,c--);
        for(int row=r,col = c;row>=0 && col <= COUNT_COLS;row--,col++){
            if (this.cells[row][col] == tokencolor){
                countConTokens++;
            }
            else{
                countConTokens = 0;
            }
            if(countConTokens >= 4){
                return true;
            }
        }
        return false;
    }

    private boolean checkForDiagonalClock8Win(tokencolor tokencolor, int placedAtRow, int placedAtCol){
        int countConTokens = 0;
        int r, c = 0;
        for (r=placedAtRow,c = placedAtCol;r<COUNT_ROWS &&c > 0; r++,c--);
        for(int row=r,col = c;row>=0 && col <= COUNT_COLS;row--,col++){
            if (this.cells[row][col] == tokencolor){
                countConTokens++;
            }
            else{
                countConTokens = 0;
            }
            if(countConTokens >= 4){
                return true;
            }
        }
        return false;
    }

    private boolean checkForDiagonalClock10Win(tokencolor tokencolor, int placedAtRow, int placedAtCol){
        int countConTokens = 0;
        int r, c = 0;
        for (r=placedAtRow,c = placedAtCol;r<COUNT_ROWS &&c >0; r++,c--);
        for(int row=r,col = c;row>=0 && col <= COUNT_COLS;row--,col++){
            if (this.cells[row][col] == tokencolor){
                countConTokens++;
            }
            else{
                countConTokens = 0;
            }
            if(countConTokens >= 4){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        String myReturn = "";
        for(int row=0; row<COUNT_ROWS; row++){
            for(int col=0;col<COUNT_COLS;col++){
                char output= '|';
                if(cells[row][col] == tokencolor.Red){
                    output = 'R';
                }
                else if (cells[row][col] == tokencolor.Yellow){
                    output = 'Y';
                }

                myReturn += (output + " ");
            }
            myReturn += "\n";
        }
        return myReturn;
    }

}
