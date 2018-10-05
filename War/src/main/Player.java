package main;

public class Player {
	private Deck myDeck;
	private Card hand = null;
	private String name;
	private int score = 0;
	
	public Player (String name){
		this.name = name;
		this.myDeck = new Deck();
	}
	
	public int getScore(){
		return score;
	}
	
	public void setScore(int score){
		this.score = score;
	}
	
	public void incrementScore(int amount){
		score += amount;
	}
	
	public String getName(){
		return name;
	}

	public void addCard(Card card) {
		myDeck.addCard(card);
	}
	
	public Card playCard() {
		hand =  myDeck.drawCard();
		System.out.println(name+ " plays "+ hand.getValue() +" of "+hand.getSuit() +" as up card");
		return hand;
	}

	public int getNumOfCards() {
		return myDeck.getNumOfCards();
	}
	
	public Card getHand(){
		return hand;
	}

}
