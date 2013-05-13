package se.mah.k3.cards;

import java.util.ArrayList;
import java.util.Collections;

public class CardList {
	
	public ArrayList<Card> getAllCards(ArrayList<Card> cardList){
		cardList.add(new Card(2, "blue", "triangle", "half", R.drawable.ic_launcher));
		cardList.add(new Card(2, "red", "triangle", "half", R.drawable.ic_launcher));
		cardList.add(new Card(2, "green", "triangle", "half", R.drawable.ic_launcher));
		cardList.add(new Card(3, "red", "rectangle", "full", R.drawable.ic_launcher));
		cardList.add(new Card(1, "red", "circle", "empty", R.drawable.ic_launcher));
		cardList.add(new Card(1, "blue", "rectangle", "half", R.drawable.ic_launcher));
		cardList.add(new Card(1, "green", "rectangle", "full", R.drawable.ic_launcher));
		cardList.add(new Card(3, "green", "rectangle", "empty", R.drawable.ic_launcher));
		cardList.add(new Card(2, "blue", "circle", "empty", R.drawable.ic_launcher));
		cardList.add(new Card(3, "green", "circle", "full", R.drawable.ic_launcher));
		Collections.shuffle(cardList);
		return cardList;	
	}
	
}
