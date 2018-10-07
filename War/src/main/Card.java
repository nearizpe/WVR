package main;

public class Card {
private int value;
private String suit;

public Card(int value, String suit){
	this.value = value;
	this.suit = suit;
}

public int getValue() {
	return value;
}
public void setValue(int value) {
	this.value = value;
}
public String getSuit() {
	return suit;
}
public String getName() {
	if(value<11) {
		return Integer.toString(value);
	}else if(value == 11) {
		return "J";
	}else if(value == 12) {
		return "Q";
	}else if(value == 13) {
		return "K";
	}else {
		return "A";
	}
}
public void setSuit(String suit) {
	this.suit = suit;
}

}
