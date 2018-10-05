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
		return cards.remove(0);
	}
	
	public void shuffleDeck() {
		Collections.shuffle(cards);
	}
	
	public int getNumOfCards() {
		return cards.size();
	}
	
	public void createStandardDeck(){
		cards = new ArrayList<Card>();
		for(int i = 1; i< 14;i++){
			if(i == 1){
				Card card = new Card(14,"DIAMONDS");
				this.addCard(card);
				continue;
			}
			Card card = new Card(i,"DIAMONDS");
			this.addCard(card);
		}
		for(int i = 1; i< 14;i++){
			if(i == 1){
				Card card = new Card(14,"HEARTS");
				this.addCard(card);
				continue;
			}
			Card card = new Card(i,"HEARTS");
			this.addCard(card);
		}
		for(int i = 1; i< 14;i++){
			if(i == 1){
				Card card = new Card(14,"CLUBS");
				this.addCard(card);
				continue;
			}
			Card card = new Card(i,"CLUBS");
			this.addCard(card);
		}
		for(int i = 1; i< 14;i++){
			if(i == 1){
				Card card = new Card(14,"CLUBS");
				this.addCard(card);
				continue;
			}
			Card card = new Card(i,"SPADES");
			this.addCard(card);
		}
	}
}
