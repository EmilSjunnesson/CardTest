package se.mah.k3.cards;

import java.util.ArrayList;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.app.Activity;

public class MainActivity extends Activity {
	CardCompare cardCompare= new CardCompare();
	CardList cardList = new CardList();
	ArrayList<Card> cardArray = new ArrayList<Card>();
	ArrayList<Card> activeCards = new ArrayList<Card>();
	
	private boolean setState;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		cardList.getAllCards(cardArray);
		
		
		
		for (int i = 0; i < 12; i++) {
			activeCards.add(cardArray.get(0));
			cardArray.remove(0);
		}
		for (int i = 0; i < activeCards.size(); i++) {
			Log.i("TagBag", activeCards.get(i).toString());
		}

		
		Card c1 = activeCards.get(0);
		Card c2 = activeCards.get(1);
		Card c3 = activeCards.get(2);
		
		String s = Integer.toString(cardArray.size());
		Log.i("TagBag", s);
		
		setState = cardCompare.isSet(c1, c2, c3);
		if (setState) {
			Log.i("TagBag", "IS SET");
		}else {
			Log.i("TagBag", "NO SET");
		}
		
		ImageButton ib = (ImageButton) findViewById(R.id.imageButton1);
		ib.setImageResource(c1.getResId());
	}

	

	

	

	

	
}
