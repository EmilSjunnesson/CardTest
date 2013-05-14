package se.mah.k3.cards;

import java.util.ArrayList;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.app.Activity;

public class MainActivity extends Activity {

	CardList cardList = new CardList();
	ArrayList<Card> cardArray = new ArrayList<Card>();
	private boolean numberState;
	private boolean colorState;
	private boolean shapeState;
	private boolean fillingState;
	private boolean setState;
    // Yepp, verkar så.
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		cardList.getAllCards(cardArray);
		Card c1 = cardArray.get(0);
		Card c2 = cardArray.get(1);
		Card c3 = cardArray.get(2);
		
		String s = Integer.toString(cardArray.size());
		Log.i("TagBag", s);
		
		setState = isSet(c1, c2, c3);
		if (setState) {
			Log.i("TagBag", "IS SET");
		}else {
			Log.i("TagBag", "NO SET");
		}
		
		ImageButton ib = (ImageButton) findViewById(R.id.imageButton1);
		ib.setImageResource(c1.getResId());
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
}
