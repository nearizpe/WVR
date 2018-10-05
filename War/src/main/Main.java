package main;

import java.util.Scanner;

import War.War;
import War.WarSeperatePointsPile;
import War.WarWonCardsAtBottom;

public class Main {
	
	public static void main(String args[]) {
		War war;
		Scanner scan = new Scanner(System.in);
		System.out.println("Which variation would you like to play, A B or C?");
		String game = scan.next();
		if(game.equals("A") || game.equals("B")){
			System.out.println("What is the name of the first player?");
			String player1Name = scan.next();
			System.out.println("What is the name of the second player?");
			String player2Name = scan.next();
			Player player1 = new Player(player1Name);
			Player player2 = new Player(player2Name);
			Deck gameDeck = new Deck();
			gameDeck.createStandardDeck();
			if(game.equals("A")){
				war = new WarWonCardsAtBottom(player1,player2,gameDeck);
			}
			else{
				war = new WarSeperatePointsPile(player1,player2,gameDeck);
			}
			war.startGame();
		}
		else if(game.equals("C")){
			
		}
		else{
			System.out.println("Please pick an appropritae response");
		}
	}
}
