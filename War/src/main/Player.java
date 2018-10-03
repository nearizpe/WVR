package main;

public class Player {
	private Deck myDeck;

	public void addCard(Card card) {
		myDeck.addCard(card);
	}

	public Card playCard() {
		return myDeck.drawCard();
	}

	public int getNumOfCards() {
		return myDeck.getNumOfCards();
	}

}
