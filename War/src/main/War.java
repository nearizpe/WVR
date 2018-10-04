package main;

import java.util.ArrayList;
import java.util.List;

public abstract class War {
	private List<Player> players = new ArrayList<Player>();
	private Deck gameDeck;

	public void startGame() {
		boolean gameInProgress = true;
		while(gameInProgress) {
			gameInProgress = playRound();
		}
	}
	
	public boolean playRound() {
		return true;
	}
}
