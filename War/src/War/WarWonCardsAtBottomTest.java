package War;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Card;
import main.Deck;
import main.Player;

class WarWonCardsAtBottomTest {

	Player playerOne;
	Player playerTwo;
	Player winner;
	Deck testDeck;
	
	WarWithThreePeople warTest;
	
	@Test
	void testSeperatePointsPileWar() {
		War war;
		testDeck = new Deck();
		playerOne = new Player("Hank");
		playerTwo = new Player("Marina");
		testDeck.createStandardDeck();
		testDeck.shuffleDeck();
		war = new WarWonCardsAtBottom(playerOne,playerTwo,testDeck);
		Exception result = null;
		
		try {
			war.startGame();
		}catch(Exception e){
			result = e;
		}
		assertEquals(null, result);
		
	}
	
	@Test
	void testDetermineWinner() {
		War war;
		testDeck = new Deck();
		playerOne = new Player("Hank");
		playerTwo = new Player("Marina");
		war = new WarWonCardsAtBottom(playerOne,playerTwo,testDeck);
		
		playerOne.setDeck(makeDeck(2));
		playerTwo.setDeck(makeDeck(3));
		war.startGame();
		assertEquals(playerTwo,war.determineWinner());
	}
	
	@Test
	void testTieGame() {
		War war;
		testDeck = new Deck();
		playerOne = new Player("Hank");
		playerTwo = new Player("Marina");
		war = new WarWonCardsAtBottom(playerOne,playerTwo,testDeck);
		
		Card tieCard1 = new Card(2,"DIAMONDS");
		Card tieCard2 = new Card(2,"HEARTS");
		
		playerOne.addCard(tieCard1);
		playerTwo.addCard(tieCard2);
		war.startGame();
		assertEquals(null,war.determineWinner());
	}
	
	@Test
	void testGameNotOver() {
		War war;
		testDeck = new Deck();
		playerOne = new Player("Hank");
		playerTwo = new Player("Marina");
		war = new WarWonCardsAtBottom(playerOne,playerTwo,testDeck);
		
		assertFalse(war.gameNotOver());
		
		Card card = new Card(2,"DIAMONDS");
		
		playerOne.addCard(card);
		playerTwo.addCard(card);
		
		assertTrue(war.gameNotOver());
	}

	Deck makeDeck(int value) {
		Deck newDeck = new Deck();
		Card cardOne = new Card(value,"DIAMONDS");
		Card cardTwo = new Card(value,"HEARTS");
		Card cardThree = new Card(value,"CLUBS");
		Card cardFour = new Card(value,"SPADES");
		
		newDeck.addCard(cardOne);
		newDeck.addCard(cardTwo);
		newDeck.addCard(cardThree);
		newDeck.addCard(cardFour);
		
		return newDeck;
	}

}
