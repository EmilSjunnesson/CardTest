package se.mah.k3.cards;

import java.util.ArrayList;
import java.util.Collections;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Window;

public class Controller {

	private boolean numberState;
	private boolean colorState;
	private boolean shapeState;
	private boolean fillingState;
	private int nbrOfSets = 0;
	private int hintIndex1, hintIndex2;
	Deck deck = new Deck();
	ArrayList<Card> deckArray = new ArrayList<Card>();
	ArrayList<Card> activeCards = new ArrayList<Card>();
	
	//Creates deck and places 12 cards in active
	public void placeCardsOnTable(int cardsNeeded) {
		if (deckArray.isEmpty()) {
			deck.getAllCards(deckArray);
		}
		for (int i = 0; i < cardsNeeded; i++) {
			activeCards.add(deckArray.get(0));
			deckArray.remove(0);
			activeCards.get(i).setIndex(i);
		}
		Log.i("TagBag", "Kort kvar i deck: " + deckArray.size());
	}
	
	// returns the first 12 active cards after checks and re-deals
	public ArrayList<Card> getActiveCards(int cardsNeeded) {
		placeCardsOnTable(cardsNeeded);
		checkAndRedeal();
		return activeCards;
	}

	// take cards from deck and place them in active cards
	public ArrayList<Card> getNewCards(int card1Index, int card2Index,
			int card3Index) {
		activeCards.set(card1Index, deckArray.get(0));
		activeCards.get(card1Index).setIndex(card1Index);
		deckArray.remove(0);
		activeCards.set(card2Index, deckArray.get(0));
		activeCards.get(card2Index).setIndex(card2Index);
		deckArray.remove(0);
		activeCards.set(card3Index, deckArray.get(0));
		activeCards.get(card3Index).setIndex(card3Index);
		deckArray.remove(0);
		Log.i("TagBag", "Kort kvar i deck: " + deckArray.size());
		checkAndRedeal();
		return activeCards;
	}

	// check active cards for set and re-deal if needed
	public void checkAndRedeal() {
		checkForSet();
		while (nbrOfSets <= 0) {
			Log.i("TagBag", "Inget SET");
			removeFromActive();
			Collections.shuffle(deckArray);
			placeCardsOnTable(12);
			checkForSet();
		}
	}
	
	// remove all active cards an place them back in deck
		public void removeFromActive() {
			for (int i = 0; i < activeCards.size(); i++) {
				deckArray.add(activeCards.get(0));
				activeCards.remove(0);
			}
		}

	// compare selected cards
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

	// compare for hint and re-deal logic
	public void isSetOnTable(Card card1, Card card2, Card card3) {
		numberState = isSetNumber(card1, card2, card3);
		colorState = isSetColor(card1, card2, card3);
		shapeState = isSetShape(card1, card2, card3);
		fillingState = isSetFilling(card1, card2, card3);
		if (numberState && colorState && shapeState && fillingState) {
			nbrOfSets++;
			Log.i("TagBag", "Index of SET:" + (card1.getIndex() + 1) + " | "
					+ (card2.getIndex() + 1) + " | " + (card3.getIndex() + 1));
			hintIndex1 = card1.getIndex();
			hintIndex2 = card2.getIndex();
		}
	}

	// compare number of symbols on cards
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

	// compare color of cards
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

	// compare shape of cards
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

	// compare filling of cards
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

	public int getNbrOfSets() {
		return nbrOfSets;
	}

	public int getNbrOfCardsLeft() {
		return deckArray.size();
	}

	public int getHintIndex(int number) {
		if (number == 1) {
			return hintIndex1;
		} else if (number == 2) {
			return hintIndex2;
		}
		return 0;
	}

	public ArrayList<Card> getActiveArray() {
		return activeCards;
	}

	public ArrayList<Card> getDeckArray() {
		return deckArray;
	}
	
	// creates custom transparent dialogs
		public Dialog createCustomDialog(Dialog d, int layoutId) {
			d.requestWindowFeature(Window.FEATURE_NO_TITLE);
			d.setContentView(layoutId);
			d.getWindow().setBackgroundDrawable(
					new ColorDrawable(android.graphics.Color.TRANSPARENT));
			return d;
		}
	
	// checks all cards on table for sets
	public void checkForSet() {
		nbrOfSets = 0;
		isSetOnTable(activeCards.get(0), activeCards.get(1), activeCards.get(2));
		isSetOnTable(activeCards.get(0), activeCards.get(1), activeCards.get(3));
		isSetOnTable(activeCards.get(0), activeCards.get(1), activeCards.get(4));
		isSetOnTable(activeCards.get(0), activeCards.get(1), activeCards.get(5));
		isSetOnTable(activeCards.get(0), activeCards.get(1), activeCards.get(6));
		isSetOnTable(activeCards.get(0), activeCards.get(1), activeCards.get(7));
		isSetOnTable(activeCards.get(0), activeCards.get(1), activeCards.get(8));
		isSetOnTable(activeCards.get(0), activeCards.get(1), activeCards.get(9));
		isSetOnTable(activeCards.get(0), activeCards.get(1),
				activeCards.get(10));
		isSetOnTable(activeCards.get(0), activeCards.get(1),
				activeCards.get(11));
		isSetOnTable(activeCards.get(0), activeCards.get(2), activeCards.get(3));
		isSetOnTable(activeCards.get(0), activeCards.get(2), activeCards.get(4));
		isSetOnTable(activeCards.get(0), activeCards.get(2), activeCards.get(5));
		isSetOnTable(activeCards.get(0), activeCards.get(2), activeCards.get(6));
		isSetOnTable(activeCards.get(0), activeCards.get(2), activeCards.get(7));
		isSetOnTable(activeCards.get(0), activeCards.get(2), activeCards.get(8));
		isSetOnTable(activeCards.get(0), activeCards.get(2), activeCards.get(9));
		isSetOnTable(activeCards.get(0), activeCards.get(2),
				activeCards.get(10));
		isSetOnTable(activeCards.get(0), activeCards.get(2),
				activeCards.get(11));
		isSetOnTable(activeCards.get(0), activeCards.get(3), activeCards.get(4));
		isSetOnTable(activeCards.get(0), activeCards.get(3), activeCards.get(5));
		isSetOnTable(activeCards.get(0), activeCards.get(3), activeCards.get(6));
		isSetOnTable(activeCards.get(0), activeCards.get(3), activeCards.get(7));
		isSetOnTable(activeCards.get(0), activeCards.get(3), activeCards.get(8));
		isSetOnTable(activeCards.get(0), activeCards.get(3), activeCards.get(9));
		isSetOnTable(activeCards.get(0), activeCards.get(3),
				activeCards.get(10));
		isSetOnTable(activeCards.get(0), activeCards.get(3),
				activeCards.get(11));
		isSetOnTable(activeCards.get(0), activeCards.get(4), activeCards.get(5));
		isSetOnTable(activeCards.get(0), activeCards.get(4), activeCards.get(6));
		isSetOnTable(activeCards.get(0), activeCards.get(4), activeCards.get(7));
		isSetOnTable(activeCards.get(0), activeCards.get(4), activeCards.get(8));
		isSetOnTable(activeCards.get(0), activeCards.get(4), activeCards.get(9));
		isSetOnTable(activeCards.get(0), activeCards.get(4),
				activeCards.get(10));
		isSetOnTable(activeCards.get(0), activeCards.get(4),
				activeCards.get(11));
		isSetOnTable(activeCards.get(0), activeCards.get(5), activeCards.get(6));
		isSetOnTable(activeCards.get(0), activeCards.get(5), activeCards.get(7));
		isSetOnTable(activeCards.get(0), activeCards.get(5), activeCards.get(8));
		isSetOnTable(activeCards.get(0), activeCards.get(5), activeCards.get(9));
		isSetOnTable(activeCards.get(0), activeCards.get(5),
				activeCards.get(10));
		isSetOnTable(activeCards.get(0), activeCards.get(5),
				activeCards.get(11));
		isSetOnTable(activeCards.get(0), activeCards.get(6), activeCards.get(7));
		isSetOnTable(activeCards.get(0), activeCards.get(6), activeCards.get(8));
		isSetOnTable(activeCards.get(0), activeCards.get(6), activeCards.get(9));
		isSetOnTable(activeCards.get(0), activeCards.get(6),
				activeCards.get(10));
		isSetOnTable(activeCards.get(0), activeCards.get(6),
				activeCards.get(11));
		isSetOnTable(activeCards.get(0), activeCards.get(7), activeCards.get(8));
		isSetOnTable(activeCards.get(0), activeCards.get(7), activeCards.get(9));
		isSetOnTable(activeCards.get(0), activeCards.get(7),
				activeCards.get(10));
		isSetOnTable(activeCards.get(0), activeCards.get(7),
				activeCards.get(11));
		isSetOnTable(activeCards.get(0), activeCards.get(8), activeCards.get(9));
		isSetOnTable(activeCards.get(0), activeCards.get(8),
				activeCards.get(10));
		isSetOnTable(activeCards.get(0), activeCards.get(8),
				activeCards.get(11));
		isSetOnTable(activeCards.get(0), activeCards.get(9),
				activeCards.get(10));
		isSetOnTable(activeCards.get(0), activeCards.get(9),
				activeCards.get(11));
		isSetOnTable(activeCards.get(0), activeCards.get(10),
				activeCards.get(11));
		isSetOnTable(activeCards.get(1), activeCards.get(2), activeCards.get(3));
		isSetOnTable(activeCards.get(1), activeCards.get(2), activeCards.get(4));
		isSetOnTable(activeCards.get(1), activeCards.get(2), activeCards.get(5));
		isSetOnTable(activeCards.get(1), activeCards.get(2), activeCards.get(6));
		isSetOnTable(activeCards.get(1), activeCards.get(2), activeCards.get(7));
		isSetOnTable(activeCards.get(1), activeCards.get(2), activeCards.get(8));
		isSetOnTable(activeCards.get(1), activeCards.get(2), activeCards.get(9));
		isSetOnTable(activeCards.get(1), activeCards.get(2),
				activeCards.get(10));
		isSetOnTable(activeCards.get(1), activeCards.get(2),
				activeCards.get(11));
		isSetOnTable(activeCards.get(1), activeCards.get(3), activeCards.get(4));
		isSetOnTable(activeCards.get(1), activeCards.get(3), activeCards.get(5));
		isSetOnTable(activeCards.get(1), activeCards.get(3), activeCards.get(6));
		isSetOnTable(activeCards.get(1), activeCards.get(3), activeCards.get(7));
		isSetOnTable(activeCards.get(1), activeCards.get(3), activeCards.get(8));
		isSetOnTable(activeCards.get(1), activeCards.get(3), activeCards.get(9));
		isSetOnTable(activeCards.get(1), activeCards.get(3),
				activeCards.get(10));
		isSetOnTable(activeCards.get(1), activeCards.get(3),
				activeCards.get(11));
		isSetOnTable(activeCards.get(1), activeCards.get(4), activeCards.get(5));
		isSetOnTable(activeCards.get(1), activeCards.get(4), activeCards.get(6));
		isSetOnTable(activeCards.get(1), activeCards.get(4), activeCards.get(7));
		isSetOnTable(activeCards.get(1), activeCards.get(4), activeCards.get(8));
		isSetOnTable(activeCards.get(1), activeCards.get(4), activeCards.get(9));
		isSetOnTable(activeCards.get(1), activeCards.get(4),
				activeCards.get(10));
		isSetOnTable(activeCards.get(1), activeCards.get(4),
				activeCards.get(11));
		isSetOnTable(activeCards.get(1), activeCards.get(5), activeCards.get(6));
		isSetOnTable(activeCards.get(1), activeCards.get(5), activeCards.get(7));
		isSetOnTable(activeCards.get(1), activeCards.get(5), activeCards.get(8));
		isSetOnTable(activeCards.get(1), activeCards.get(5), activeCards.get(9));
		isSetOnTable(activeCards.get(1), activeCards.get(5),
				activeCards.get(10));
		isSetOnTable(activeCards.get(1), activeCards.get(5),
				activeCards.get(11));
		isSetOnTable(activeCards.get(1), activeCards.get(6), activeCards.get(7));
		isSetOnTable(activeCards.get(1), activeCards.get(6), activeCards.get(8));
		isSetOnTable(activeCards.get(1), activeCards.get(6), activeCards.get(9));
		isSetOnTable(activeCards.get(1), activeCards.get(6),
				activeCards.get(10));
		isSetOnTable(activeCards.get(1), activeCards.get(6),
				activeCards.get(11));
		isSetOnTable(activeCards.get(1), activeCards.get(7), activeCards.get(8));
		isSetOnTable(activeCards.get(1), activeCards.get(7), activeCards.get(9));
		isSetOnTable(activeCards.get(1), activeCards.get(7),
				activeCards.get(10));
		isSetOnTable(activeCards.get(1), activeCards.get(7),
				activeCards.get(11));
		isSetOnTable(activeCards.get(1), activeCards.get(8), activeCards.get(9));
		isSetOnTable(activeCards.get(1), activeCards.get(8),
				activeCards.get(10));
		isSetOnTable(activeCards.get(1), activeCards.get(8),
				activeCards.get(11));
		isSetOnTable(activeCards.get(1), activeCards.get(9),
				activeCards.get(10));
		isSetOnTable(activeCards.get(1), activeCards.get(9),
				activeCards.get(11));
		isSetOnTable(activeCards.get(1), activeCards.get(10),
				activeCards.get(11));
		isSetOnTable(activeCards.get(2), activeCards.get(3), activeCards.get(4));
		isSetOnTable(activeCards.get(2), activeCards.get(3), activeCards.get(5));
		isSetOnTable(activeCards.get(2), activeCards.get(3), activeCards.get(6));
		isSetOnTable(activeCards.get(2), activeCards.get(3), activeCards.get(7));
		isSetOnTable(activeCards.get(2), activeCards.get(3), activeCards.get(8));
		isSetOnTable(activeCards.get(2), activeCards.get(3), activeCards.get(9));
		isSetOnTable(activeCards.get(2), activeCards.get(3),
				activeCards.get(10));
		isSetOnTable(activeCards.get(2), activeCards.get(3),
				activeCards.get(11));
		isSetOnTable(activeCards.get(2), activeCards.get(4), activeCards.get(5));
		isSetOnTable(activeCards.get(2), activeCards.get(4), activeCards.get(6));
		isSetOnTable(activeCards.get(2), activeCards.get(4), activeCards.get(7));
		isSetOnTable(activeCards.get(2), activeCards.get(4), activeCards.get(8));
		isSetOnTable(activeCards.get(2), activeCards.get(4), activeCards.get(9));
		isSetOnTable(activeCards.get(2), activeCards.get(4),
				activeCards.get(10));
		isSetOnTable(activeCards.get(2), activeCards.get(4),
				activeCards.get(11));
		isSetOnTable(activeCards.get(2), activeCards.get(5), activeCards.get(6));
		isSetOnTable(activeCards.get(2), activeCards.get(5), activeCards.get(7));
		isSetOnTable(activeCards.get(2), activeCards.get(5), activeCards.get(8));
		isSetOnTable(activeCards.get(2), activeCards.get(5), activeCards.get(9));
		isSetOnTable(activeCards.get(2), activeCards.get(5),
				activeCards.get(10));
		isSetOnTable(activeCards.get(2), activeCards.get(5),
				activeCards.get(11));
		isSetOnTable(activeCards.get(2), activeCards.get(6), activeCards.get(7));
		isSetOnTable(activeCards.get(2), activeCards.get(6), activeCards.get(8));
		isSetOnTable(activeCards.get(2), activeCards.get(6), activeCards.get(9));
		isSetOnTable(activeCards.get(2), activeCards.get(6),
				activeCards.get(10));
		isSetOnTable(activeCards.get(2), activeCards.get(6),
				activeCards.get(11));
		isSetOnTable(activeCards.get(2), activeCards.get(7), activeCards.get(8));
		isSetOnTable(activeCards.get(2), activeCards.get(7), activeCards.get(9));
		isSetOnTable(activeCards.get(2), activeCards.get(7),
				activeCards.get(10));
		isSetOnTable(activeCards.get(2), activeCards.get(7),
				activeCards.get(11));
		isSetOnTable(activeCards.get(2), activeCards.get(8), activeCards.get(9));
		isSetOnTable(activeCards.get(2), activeCards.get(8),
				activeCards.get(10));
		isSetOnTable(activeCards.get(2), activeCards.get(8),
				activeCards.get(11));
		isSetOnTable(activeCards.get(2), activeCards.get(9),
				activeCards.get(10));
		isSetOnTable(activeCards.get(2), activeCards.get(9),
				activeCards.get(11));
		isSetOnTable(activeCards.get(2), activeCards.get(10),
				activeCards.get(11));
		isSetOnTable(activeCards.get(3), activeCards.get(4), activeCards.get(5));
		isSetOnTable(activeCards.get(3), activeCards.get(4), activeCards.get(6));
		isSetOnTable(activeCards.get(3), activeCards.get(4), activeCards.get(7));
		isSetOnTable(activeCards.get(3), activeCards.get(4), activeCards.get(8));
		isSetOnTable(activeCards.get(3), activeCards.get(4), activeCards.get(9));
		isSetOnTable(activeCards.get(3), activeCards.get(4),
				activeCards.get(10));
		isSetOnTable(activeCards.get(3), activeCards.get(4),
				activeCards.get(11));
		isSetOnTable(activeCards.get(3), activeCards.get(5), activeCards.get(6));
		isSetOnTable(activeCards.get(3), activeCards.get(5), activeCards.get(7));
		isSetOnTable(activeCards.get(3), activeCards.get(5), activeCards.get(8));
		isSetOnTable(activeCards.get(3), activeCards.get(5), activeCards.get(9));
		isSetOnTable(activeCards.get(3), activeCards.get(5),
				activeCards.get(10));
		isSetOnTable(activeCards.get(3), activeCards.get(5),
				activeCards.get(11));
		isSetOnTable(activeCards.get(3), activeCards.get(6), activeCards.get(7));
		isSetOnTable(activeCards.get(3), activeCards.get(6), activeCards.get(8));
		isSetOnTable(activeCards.get(3), activeCards.get(6), activeCards.get(9));
		isSetOnTable(activeCards.get(3), activeCards.get(6),
				activeCards.get(10));
		isSetOnTable(activeCards.get(3), activeCards.get(6),
				activeCards.get(11));
		isSetOnTable(activeCards.get(3), activeCards.get(7), activeCards.get(8));
		isSetOnTable(activeCards.get(3), activeCards.get(7), activeCards.get(9));
		isSetOnTable(activeCards.get(3), activeCards.get(7),
				activeCards.get(10));
		isSetOnTable(activeCards.get(3), activeCards.get(7),
				activeCards.get(11));
		isSetOnTable(activeCards.get(3), activeCards.get(8), activeCards.get(9));
		isSetOnTable(activeCards.get(3), activeCards.get(8),
				activeCards.get(10));
		isSetOnTable(activeCards.get(3), activeCards.get(8),
				activeCards.get(11));
		isSetOnTable(activeCards.get(3), activeCards.get(9),
				activeCards.get(10));
		isSetOnTable(activeCards.get(3), activeCards.get(9),
				activeCards.get(11));
		isSetOnTable(activeCards.get(3), activeCards.get(10),
				activeCards.get(11));
		isSetOnTable(activeCards.get(4), activeCards.get(5), activeCards.get(6));
		isSetOnTable(activeCards.get(4), activeCards.get(5), activeCards.get(7));
		isSetOnTable(activeCards.get(4), activeCards.get(5), activeCards.get(8));
		isSetOnTable(activeCards.get(4), activeCards.get(5), activeCards.get(9));
		isSetOnTable(activeCards.get(4), activeCards.get(5),
				activeCards.get(10));
		isSetOnTable(activeCards.get(4), activeCards.get(5),
				activeCards.get(11));
		isSetOnTable(activeCards.get(4), activeCards.get(6), activeCards.get(7));
		isSetOnTable(activeCards.get(4), activeCards.get(6), activeCards.get(8));
		isSetOnTable(activeCards.get(4), activeCards.get(6), activeCards.get(9));
		isSetOnTable(activeCards.get(4), activeCards.get(6),
				activeCards.get(10));
		isSetOnTable(activeCards.get(4), activeCards.get(6),
				activeCards.get(11));
		isSetOnTable(activeCards.get(4), activeCards.get(7), activeCards.get(8));
		isSetOnTable(activeCards.get(4), activeCards.get(7), activeCards.get(9));
		isSetOnTable(activeCards.get(4), activeCards.get(7),
				activeCards.get(10));
		isSetOnTable(activeCards.get(4), activeCards.get(7),
				activeCards.get(11));
		isSetOnTable(activeCards.get(4), activeCards.get(8), activeCards.get(9));
		isSetOnTable(activeCards.get(4), activeCards.get(8),
				activeCards.get(10));
		isSetOnTable(activeCards.get(4), activeCards.get(8),
				activeCards.get(11));
		isSetOnTable(activeCards.get(4), activeCards.get(9),
				activeCards.get(10));
		isSetOnTable(activeCards.get(4), activeCards.get(9),
				activeCards.get(11));
		isSetOnTable(activeCards.get(4), activeCards.get(10),
				activeCards.get(11));
		isSetOnTable(activeCards.get(5), activeCards.get(6), activeCards.get(7));
		isSetOnTable(activeCards.get(5), activeCards.get(6), activeCards.get(8));
		isSetOnTable(activeCards.get(5), activeCards.get(6), activeCards.get(9));
		isSetOnTable(activeCards.get(5), activeCards.get(6),
				activeCards.get(10));
		isSetOnTable(activeCards.get(5), activeCards.get(6),
				activeCards.get(11));
		isSetOnTable(activeCards.get(5), activeCards.get(7), activeCards.get(8));
		isSetOnTable(activeCards.get(5), activeCards.get(7), activeCards.get(9));
		isSetOnTable(activeCards.get(5), activeCards.get(7),
				activeCards.get(10));
		isSetOnTable(activeCards.get(5), activeCards.get(7),
				activeCards.get(11));
		isSetOnTable(activeCards.get(5), activeCards.get(8), activeCards.get(9));
		isSetOnTable(activeCards.get(5), activeCards.get(8),
				activeCards.get(10));
		isSetOnTable(activeCards.get(5), activeCards.get(8),
				activeCards.get(11));
		isSetOnTable(activeCards.get(5), activeCards.get(9),
				activeCards.get(10));
		isSetOnTable(activeCards.get(5), activeCards.get(9),
				activeCards.get(11));
		isSetOnTable(activeCards.get(5), activeCards.get(10),
				activeCards.get(11));
		isSetOnTable(activeCards.get(6), activeCards.get(7), activeCards.get(8));
		isSetOnTable(activeCards.get(6), activeCards.get(7), activeCards.get(9));
		isSetOnTable(activeCards.get(6), activeCards.get(7),
				activeCards.get(10));
		isSetOnTable(activeCards.get(6), activeCards.get(7),
				activeCards.get(11));
		isSetOnTable(activeCards.get(6), activeCards.get(8), activeCards.get(9));
		isSetOnTable(activeCards.get(6), activeCards.get(8),
				activeCards.get(10));
		isSetOnTable(activeCards.get(6), activeCards.get(8),
				activeCards.get(11));
		isSetOnTable(activeCards.get(6), activeCards.get(9),
				activeCards.get(10));
		isSetOnTable(activeCards.get(6), activeCards.get(9),
				activeCards.get(11));
		isSetOnTable(activeCards.get(6), activeCards.get(10),
				activeCards.get(11));
		isSetOnTable(activeCards.get(7), activeCards.get(8), activeCards.get(9));
		isSetOnTable(activeCards.get(7), activeCards.get(8),
				activeCards.get(10));
		isSetOnTable(activeCards.get(7), activeCards.get(8),
				activeCards.get(11));
		isSetOnTable(activeCards.get(7), activeCards.get(9),
				activeCards.get(10));
		isSetOnTable(activeCards.get(7), activeCards.get(9),
				activeCards.get(11));
		isSetOnTable(activeCards.get(7), activeCards.get(10),
				activeCards.get(11));
		isSetOnTable(activeCards.get(8), activeCards.get(9),
				activeCards.get(10));
		isSetOnTable(activeCards.get(8), activeCards.get(9),
				activeCards.get(11));
		isSetOnTable(activeCards.get(8), activeCards.get(10),
				activeCards.get(11));
		isSetOnTable(activeCards.get(9), activeCards.get(10),
				activeCards.get(11));
		Log.i("TagBag", "SET i kort: " + nbrOfSets);
	}
}
