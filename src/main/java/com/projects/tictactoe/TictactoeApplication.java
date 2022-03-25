package com.projects.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TictactoeApplication {
	//Scanner Object Creattor
	public static Scanner getScanner()
	{
		Scanner sc = new Scanner(System.in);
		return sc;
	}

	public static void main(String[] args) {
		//Scanner Object
		Scanner scan = getScanner(); 
		//Board
		char[][] board = {{' ','|',' ','|',' '}, {'-','+','-','+','-'}, {' ','|',' ','|',' '}, {'-','+','-','+','-'}, {' ','|',' ','|',' '}};
		//Playing Object
		Tictactoe play = new Tictactoe();
		//Positions by Player
		List<Integer> player = new ArrayList<>();
		//Positions by Computer
		List<Integer> computer = new ArrayList<>();
		//String for storing result
		String result = new String("");
		while (player.size()+computer.size()<=9)
		{
			System.out.println("Enter your position(1-9) : ");

			//Position by User
			int position = scan.nextInt();

			//Case -> Where the given position is already taken
			while(player.contains(position) || computer.contains(position))
			{
				System.out.println("Position is already taken !");
				position = scan.nextInt();
			}
			player.add(position);
			play.setPiece(board, position, 1);
			play.Display(board);
			//Checking if Player is winner
			result = play.isWinner(player, computer);
			if (result.length()>0)
			{
				System.out.println(result);
				break;
			}
			//Positon by Computer, will be using random Int to generate the position
			Random rand = new Random();
			int cPosition = rand.nextInt(9)+1;
			while(player.contains(cPosition) || computer.contains(cPosition))
			{
				cPosition = rand.nextInt(9)+1;
			}
			computer.add(cPosition);
			play.setPiece(board, cPosition, 0);
			play.Display(board);
			//Checking if Computer is winner
			result = play.isWinner(player, computer);
			if (result.length()>0)
			{
				System.out.println(result);
				break;
			}
			//Displaying the Board
		 	
		}
	}

}
