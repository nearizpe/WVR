package War;

import main.Deck;
import main.Player;

public abstract class War {
	protected Player player1;
	protected Player player2;
	protected Deck deck;
	protected Deck winPile = new Deck();
	
	public War(Player player1,Player player2,Deck gameDeck){
		this.player1 = player1;
		this.player2 = player2;
		this.deck = gameDeck;
	}

	public void startGame() {
		dealCards();
		while(gameNotOver()){
			playRound();
		}
		Player winner = determineWinner();
		printWinner(winner);
	}
	
	protected Boolean gameNotOver(){
		if(player1.getNumOfCards()>0 && player2.getNumOfCards()>0){
			return true;
		}
		return false;
	}
	
	protected void playRound() {
		placeHands();
		Player winner = determineRoundWinner();
		endRound(winner);
	}
	
	protected void dealCards(){
		deck.shuffleDeck();
		while(haveEnoughCards()){
			handOutCards();
		}
	}
	
	protected void handOutCards(){
		player1.addCard(deck.drawCard());
		player2.addCard(deck.drawCard());
	}
	
	protected Boolean haveEnoughCards(){
		if(deck.getNumOfCards()>2){
			return true;
		}
		return false;
	}
	
	protected Player determineWinner(){
		if(player1.getScore()> player2.getScore()){
			return player1;
		}
		else if (player1.getScore()< player2.getScore()){
			return player2;
		}
		else{
			return null;
		}
	}
	
	protected Player determineRoundWinner(){
		if(player1.getHand().getValue() == player2.getHand().getValue() ){
			return null;
		}
		if(player1.getHand().getValue() > player2.getHand().getValue() ){
			return player1;
		}
		else{
			return player2;
		}
	}
	
	protected void endRound(Player winner){
		if(winner == null){
			System.out.println("War!");
			playRound();
			return;
		}
		System.out.println(winner.getName()+" wins the round");
		winner.incrementScore(winPile.getNumOfCards());
		printScore();
	}
	
	protected void printWinner(Player winner){
		if(winner == null){
			System.out.println("Tie game!");
			return;
		}
		System.out.println(winner.getName()+" wins!");
	}
	
	protected void printScore(){
		System.out.println("Score is "+player1.getName()+" "+player1.getScore()+" , "+player2.getName()+" "+player2.getScore());
	}
	
	protected void placeHands(){
		winPile.addCard(player1.playCard());
		winPile.addCard(player2.playCard());
	}
}
