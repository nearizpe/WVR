package War;

import main.Deck;
import main.Player;

public class WarSeperatePointsPile extends War {

	public WarSeperatePointsPile(Player player1, Player player2, Deck gameDeck) {
		super(player1, player2, gameDeck);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void endRound(Player winner){
		super.endRound(winner);
		if(winner == null){
			return;
		}
		while(winPile.getNumOfCards() > 0 ){
			winPile.drawCard();
		}
	}
}
