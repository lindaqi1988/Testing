package com.test.ttt;

public class GameTree {

    private TreeNode root;   

    private char[] turn; 

    public GameTree(String turns) {
        this.turn = turns.toCharArray();
    }

    public void makeGameTreeAt(TreeNode node) {

        if(node.getBoard().isDraw()) {
            node.setWinFor(' ');
        } else if(node.getBoard().isWinForX()) {
            node.setWinFor('X');
        } else if(node.getBoard().isWinForO()) {
            node.setWinFor('O');
        } else {

            if(!node.getBoard().isFull()) {
                for(int i=0; i<8; i++) {
                    if(!node.getBoard().isOccupied(i)) {
                        Board board = node.getBoard().move(i, node.getNextTurn());
                        TreeNode child = new TreeNode(board);
                        makeGameTreeAt(child);
                    }
                }
            }
        }
    }

    public char getTurn(int n) {
        return turn[n];
    }

    public char winner() {
        return ' ';
    }

    public void print() {

    }

    public void print(TreeNode node) {

    }

    public void printNode() {

    }


}
