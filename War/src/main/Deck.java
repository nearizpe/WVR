package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cards = new ArrayList<Card>();

	public void addCard(Card card) {
		cards.add(card);
	}
	
	public Card drawCard() {
		return cards.get(0);
	}
	
	public void shuffleDeck() {
		Collections.shuffle(cards);
	}
	
	public int getNumOfCards() {
		return cards.size();
	}
}
