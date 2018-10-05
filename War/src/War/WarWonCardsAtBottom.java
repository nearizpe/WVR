package War;

import main.Deck;
import main.Player;

public class WarWonCardsAtBottom extends War{

	private final int maxScore = 100;
	private Boolean maxScoreReached = false;
	
	public WarWonCardsAtBottom(Player player1, Player player2, Deck gameDeck) {
		super(player1, player2, gameDeck);
	}
	
	@Override
	public void endRound(Player winner){
		super.endRound(winner);
		if(winner == null){
			return;
		}
		while(winPile.getNumOfCards() > 0 ){
			winner.addCard(winPile.drawCard());
		}
		if(winner.getScore() >= maxScore){
			maxScoreReached = true;
		}
	}
	
	@Override
	protected Boolean gameNotOver(){
		Boolean playersHaveDeck = super.gameNotOver();
		if(playersHaveDeck && (!maxScoreReached)){
			return true;
		}
		return false;
	}
}
