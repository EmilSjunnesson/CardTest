package se.mah.k3.cards;

import java.util.ArrayList;

import android.util.Log;

public class Controller {

	private boolean numberState;
	private boolean colorState;
	private boolean shapeState;
	private boolean fillingState;
	Deck deck = new Deck();
	ArrayList<Card> deckArray = new ArrayList<Card>();
	ArrayList<Card> activeCards = new ArrayList<Card>();

	public void placeCardsOnTable(int cardsNeeded) {
		if (deckArray.isEmpty()) {
			deck.getAllCards(deckArray);
		}
		for (int i = 0; i < cardsNeeded; i++) {
			activeCards.add(deckArray.get(0));
			deckArray.remove(0);
		}
		for (int i = 0; i < activeCards.size(); i++) {
			Log.i("TagBag", activeCards.get(i).toString());
		}
		Log.i("TagBag", "Kort kvar i deck: " + deckArray.size());
	}

	public ArrayList<Card> getActiveCards(int cardsNeeded) {
		placeCardsOnTable(cardsNeeded);
		return activeCards;

	}

	public boolean isSet(Card card1, Card card2, Card card3) {
		numberState = isSetNumber(card1, card2, card3);
		colorState = isSetColor(card1, card2, card3);
		shapeState = isSetShape(card1, card2, card3);
		fillingState = isSetFilling(card1, card2, card3);
		if (numberState && colorState && shapeState && fillingState) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isSetNumber(Card card1, Card card2, Card card3) {
		if ((card1.getNumber() == card2.getNumber() && card2.getNumber() == card3
				.getNumber())
				|| (card1.getNumber() != card2.getNumber()
						&& card2.getNumber() != card3.getNumber() && card1
						.getNumber() != card3.getNumber())) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isSetColor(Card card1, Card card2, Card card3) {
		if ((card1.getColor().equals(card2.getColor()) && card2.getColor()
				.equals(card3.getColor()))
				|| (!card1.getColor().equals(card2.getColor())
						&& !card2.getColor().equals(card3.getColor()) && !card1
						.getColor().equals(card3.getColor()))) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isSetShape(Card card1, Card card2, Card card3) {
		if ((card1.getShape().equals(card2.getShape()) && card2.getShape()
				.equals(card3.getShape()))
				|| (!card1.getShape().equals(card2.getShape())
						&& !card2.getShape().equals(card3.getShape()) && !card1
						.getShape().equals(card3.getShape()))) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isSetFilling(Card card1, Card card2, Card card3) {
		if ((card1.getFilling().equals(card2.getFilling()) && card2
				.getFilling().equals(card3.getFilling()))
				|| (!card1.getFilling().equals(card2.getFilling())
						&& !card2.getFilling().equals(card3.getFilling()) && !card1
						.getFilling().equals(card3.getFilling()))) {
			return true;
		} else {
			return false;
		}
	}

}
