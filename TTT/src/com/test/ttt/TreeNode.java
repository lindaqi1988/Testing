package com.test.ttt;

public class TreeNode {

    private Board board;
    private char nextTurn;
    private char winFor;

    /**
     * default constructor
     */
    public TreeNode() {

    }

    /**
     * constructor with board
     */
    public TreeNode(Board board) {
        this.board = board;
    }

    public void setNextTurn(char nextTurn) {
        
        this.nextTurn = nextTurn;
    }

    public char getNextTurn() {
        
        return this.nextTurn;
    }

  
    public void setWinFor(char winFor) {
        this.winFor = winFor;
    }

  
    public char getWinFor() {
        return this.winFor;
    }

    public void setNextMove(int nextMove) {

   

    }

    public int getNextMove() {
        return 0;
    }

 
    public void setChild(int pos, TreeNode child) {

    }

    public TreeNode getChild(int pos) {

        Board nextBoard = board.move(pos, nextTurn);
        TreeNode child = new TreeNode(nextBoard);
        return child;
    }



    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }


}
