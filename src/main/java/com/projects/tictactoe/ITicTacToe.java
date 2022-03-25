package com.projects.tictactoe;

import java.util.List;

public interface ITicTacToe {
    //For Displaying Borad
    public void Display(char[][] board);
    //For Setting the mark for the position by Computer
    public void setPiece(char[][] board, int position, int player); 
    //Checking Winner
    public String isWinner(List<Integer> positionListofPlayer, List<Integer> positionListofCpu);
}
