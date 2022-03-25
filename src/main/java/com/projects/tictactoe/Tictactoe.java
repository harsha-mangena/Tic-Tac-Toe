package com.projects.tictactoe;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tictactoe  implements ITicTacToe{

    @Override
    public void Display(char[][] board) {
        System.out.println("Current Board : ");
        System.out.println();
        for(char[] row : board)
        {
            for(char c : row)
            {
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println();
        
    }

    @Override
    public void setPiece(char[][] board, int position, int player) {
        char piece = ' ';
        if (player == 1)
        {
                piece = 'X';
        }
        else if(player == 0)
        {
                piece = 'O';
        }
        switch(position)
        {
            case 1: board[0][0] = piece;
                    break;
            case 2: board[0][2] = piece;
                    break;
            case 3: board[0][4] = piece;
                    break;
            case 4: board[2][0] = piece;
                    break;
            case 5: board[2][2] = piece;
                    break;
            case 6: board[2][4] = piece;
                    break;
            case 7: board[4][0] = piece;
                    break;
            case 8: board[4][2] = piece;
                    break;
            case 9: board[4][4] = piece;
                break;
                    
        }
        
    }

    @Override
    public String isWinner(List<Integer> positionListofPlayer, List<Integer> positionListofCpu) {
        //Winning Combinations 
        List<Integer> row1 = Arrays.asList(1,2,3);
        List<Integer> row2 = Arrays.asList(4,5,6);
        List<Integer> row3 = Arrays.asList(7,8,9);
        List<Integer> col1 = Arrays.asList(1,4,7);
        List<Integer> col2 = Arrays.asList(2,5,8);
        List<Integer> col3 = Arrays.asList(3,6,9);
        List<Integer> dig1 = Arrays.asList(1,5,9);
        List<Integer> dig2 = Arrays.asList(3,5,7);

        //List of winning Combinations
        List<List<Integer>> winner = new ArrayList<List<Integer>>();
        winner.add(row1);
        winner.add(row2);
        winner.add(row3);
        winner.add(col1);
        winner.add(col2);
        winner.add(col3);
        winner.add(dig1);
        winner.add(dig2);

        for(List l : winner)
        {
            if (positionListofPlayer.containsAll(l))
            {
                return "You Won!!!";
            }
            else if(positionListofCpu.containsAll(l))
            {
                return "Cmputer Won! :-<, Let's play Again!";
            }
            else if(positionListofPlayer.size() + positionListofCpu.size() == 9)
            {
                return "OOPS!, No winner, Play Again.";
            }
        }
        return "";
    }
    
}
