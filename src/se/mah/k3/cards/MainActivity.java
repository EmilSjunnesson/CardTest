package se.mah.k3.cards;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;

public class MainActivity extends Activity {
	Controller controller = new Controller();
	Deck deck = new Deck();
	ArrayList<Card> deckArray = new ArrayList<Card>();
	ArrayList<Card> activeCards = new ArrayList<Card>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		controller.placeCardsOnTable(12);
		controller.placeCardsOnTable(3);
	}

	

	

	

	

	
}
