package main;

import java.util.Scanner;

import War.War;
import War.WarSeperatePointsPile;
import War.WarWithThreePeople;
import War.WarWonCardsAtBottom;

public class Main {
	/*TODO: change numbers like 1 to print ace
	 * Do testing
	 * 
	 * update uml 
	 * 
	 * point out the OO tequniques
	 * 
	 * make sure nothing is missing
	 * 
	 * Double check games work
	 * 
	 * Does main count as 8? otherwise we have 7
	 * 
	 * forgot to ask haveEnoughCards in War is using 2 (3 for 3 person) as the minimum amount 
	 * of cards a deck must have to keep distributing to players. So no one gets an extra card. You think thats good?
	 * 
	 */
	public static void main(String args[]) {
		War war;
		Scanner scan = new Scanner(System.in);
		System.out.println("Which variation would you like to play, A B or C?");
		String game = scan.next();
		System.out.println("What is the name of the first player?");
		String player1Name = scan.next();
		System.out.println("What is the name of the second player?");
		String player2Name = scan.next();
		Player player1 = new Player(player1Name);
		Player player2 = new Player(player2Name);
		Deck gameDeck = new Deck();
		gameDeck.createStandardDeck();
		gameDeck.shuffleDeck();
		if(game.equals("A")){
			war = new WarWonCardsAtBottom(player1,player2,gameDeck);
		}
		else if (game.equals("B")){
			war = new WarSeperatePointsPile(player1,player2,gameDeck);
		}
		else if(game.equals("C")){
			System.out.println("What is the name of the third player?");
			String player3Name = scan.next();
			Player player3 = new Player(player3Name);
			war = new WarWithThreePeople(player1, player2,player3,gameDeck);
		}
		else {
			System.out.println("Please pick an appropritae response");
			return;
		}
		war.startGame();
	}
}
