package com.test.ttt;


import javax.swing.border.Border;

public class Board {

    /**
     * position
     * 0 1 2
     * 3 4 5
     * 6 7 8
     */
    private char[] position;

    /**
     * default constructor
     */
    public Board() {

    }

    /**
     * constructor with a string
     * @param s board position
     */
    public Board(String s) {
        if(s == null) {
            this.position = null;
        } else {
            this.position = s.toCharArray();
        }
    }

    public boolean isWinForX() {
        return isWinFor('X');
    }

    public boolean isWinForO() {
        return isWinFor('O');
    }

    public boolean isDraw() {

        return isFull() && !isWinForX() && !isWinForO();
    }

    /**
     * check whether the panel is full
     * @return true or false
     */
    public boolean isFull() {
        boolean t = true;
        for(char c : position) {
            if(c == ' ') {
                return false;
            }
        }
        return t;
    }

    public boolean isGameOver() {
        
        return isDraw() || isWinForX() || isWinForO();
    }

    /**
     * judge the position is occupied or not
     * @param pos
     * @return return true or false
     */
    public boolean isOccupied(int pos) {

        return position[pos] != ' ';
    }

    public Board move(int pos, char c) {

        if(isOccupied(pos)) {
            return null;
        } else {
            char[] newCharArray = position.clone();
            newCharArray[pos] = c;
            return new Board(newCharArray.toString());
        }
    }

    public void print() {


        System.out.println(convertPosition(position));

    }

    public void printWithNumbers() {

        char[] a = position.clone();
        char[] temp = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8'};
        for(int i=0; i<=8; i++) {
            if(a[i] == ' ') {
                a[i] = temp[i];
            }
        }

        System.out.println(convertPosition(a));

    }

    private String convertPosition(char[] position) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" ").append(position[0]).append(" | ").append(position[1]).append(" | ").append(position[2]).append(" \n").
                append("---+---+---\n").
                append(" ").append(position[3]).append(" ").append("|").append(" ").append(position[4]).append(" ").append("|").append(" ").append(position[5]).append(" \n").
                append("---+---+---\n").
                append(" ").append(position[6]).append(" | ").append(position[7]).append(" | ").append(position[8]).append(" ");

        return stringBuilder.toString();
    }



    public boolean isWinFor(char c) {
        boolean t = false;
        if(position[0] == c && position[1] == c && position[2] == c) {
            t = true;
        } else if(position[3] == c && position[4] == c && position[5] == c) {
            t = true;
        }else if(position[6] == c && position[7] == c && position[8] == c) {
            t = true;
        }else if(position[0] == c && position[3] == c && position[6] == c) {
            t = true;
        }else if(position[1] == c && position[4] == c && position[7] == c) {
            t = true;
        }else if(position[2] == c && position[5] == c && position[8] == c) {
            t = true;
        }else if(position[0] == c && position[4] == c && position[8] == c) {
            t = true;
        }else if(position[2] == c && position[4] == c && position[6] == c) {
            t = true;
        }
        return t;
    }

    public static void main(String[] args) {
       String s = "XOOOXOOOX";
       new Board(s).print();
       Board board = new Board(s);
       boolean isWinForX = board.isWinForX();
       boolean isWinForO = board.isWinForO();
       boolean isGameOver = board.isGameOver();
      
       System.out.println("Is WinFor X: "+ isWinForX);
       System.out.println("Is WinFor O: "+ isWinForO);
       System.out.println("Is GameOver:" + isGameOver);
       
       // new Board(s).printWithNumbers();

    }
}

