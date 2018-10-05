package War;

import main.Deck;
import main.Player;

public class WarWithThreePeople extends War{
	Player player3;
	public WarWithThreePeople(Player player1, Player player2,Player player3, Deck gameDeck) {
		super(player1, player2, gameDeck);
		this.player3 = player3;
	}	
	
	@Override
	 protected Boolean gameNotOver(){
		 if(super.gameNotOver() && (player3.getNumOfCards()>0)){
			 return true;
		 }
		 return false;
	 }
	
	@Override
	protected Player determineWinner(){
		Player winnerBetween1and2 = super.determineWinner();
		if(winnerBetween1and2 == null){
			if(player3.getScore() > player1.getScore()){
				return player3;
			}
			else {
				return null;
			}
		}
		if(winnerBetween1and2.getScore() > player3.getScore()){
			return null;
		}
		else if (winnerBetween1and2.getScore() == player3.getScore()){
			return null;
		}
		return player3;
	}
	
	@Override
	protected Player determineRoundWinner(){
		Player winnerBetween1and2 = super.determineRoundWinner();
		if(winnerBetween1and2 == null){
			if(player3.getHand().getValue()> player1.getHand().getValue()){
				return player3;
			}
			else {
				return null;
			}
		}
		if(winnerBetween1and2.getHand().getValue() > player3.getHand().getValue()){
			return winnerBetween1and2;
		}
		else if (winnerBetween1and2.getHand().getValue() == player3.getHand().getValue()){
			return null;
		}
		return player3;
	}
	
	@Override
	protected void placeHands(){
		super.placeHands();
		winPile.addCard(player3.playCard());
	}
	
	@Override
	protected void printScore(){
		System.out.println("Score is "+player1.getName()+" "+player1.getScore()+" , "+player2.getName()+" "+player2.getScore()+" , "+player3.getName()+" "+player3.getScore());
	}
	
	@Override
	protected Boolean haveEnoughCards(){
		if(deck.getNumOfCards()>3){
			return true;
		}
		return false;
	}
	
	@Override
	protected void handOutCards(){
		super.handOutCards();
		player3.addCard(deck.drawCard());
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
