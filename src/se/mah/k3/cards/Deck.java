package se.mah.k3.cards;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	public ArrayList<Card> getAllCards(ArrayList<Card> deck){
		deck.add(new Card(1, "red", "triangle", "full", R.drawable.ic_launcher));
		deck.add(new Card(1, "green", "triangle", "full", R.drawable.ic_launcher));
		deck.add(new Card(1, "blue", "triangle", "full", R.drawable.ic_launcher));
		
		deck.add(new Card(1, "red", "rectangle", "full", R.drawable.ic_launcher));
		deck.add(new Card(1, "green", "rectangle", "full", R.drawable.ic_launcher));
		deck.add(new Card(1, "blue", "rectangle", "full", R.drawable.ic_launcher));
		
		deck.add(new Card(1, "red", "circle", "full", R.drawable.ic_launcher));
		deck.add(new Card(1, "green", "circle", "full", R.drawable.ic_launcher));
		deck.add(new Card(1, "blue", "circle", "full", R.drawable.ic_launcher));
		
		deck.add(new Card(2, "red", "triangle", "full", R.drawable.ic_launcher));
		deck.add(new Card(2, "green", "triangle", "full", R.drawable.ic_launcher));
		deck.add(new Card(2, "blue", "triangle", "full", R.drawable.ic_launcher));
		
		deck.add(new Card(2, "red", "rectangle", "full", R.drawable.ic_launcher));
		deck.add(new Card(2, "green", "rectangle", "full", R.drawable.ic_launcher));
		deck.add(new Card(2, "blue", "rectangle", "full", R.drawable.ic_launcher));
		
		deck.add(new Card(2, "red", "circle", "full", R.drawable.ic_launcher));
		deck.add(new Card(2, "green", "circle", "full", R.drawable.ic_launcher));
		deck.add(new Card(2, "blue", "circle", "full", R.drawable.ic_launcher));
		
		deck.add(new Card(3, "red", "triangle", "full", R.drawable.ic_launcher));
		deck.add(new Card(3, "green", "triangle", "full", R.drawable.ic_launcher));
		deck.add(new Card(3, "blue", "triangle", "full", R.drawable.ic_launcher));
		
		deck.add(new Card(3, "red", "rectangle", "full", R.drawable.ic_launcher));
		deck.add(new Card(3, "green", "rectangle", "full", R.drawable.ic_launcher));
		deck.add(new Card(3, "blue", "rectangle", "full", R.drawable.ic_launcher));
		
		deck.add(new Card(3, "red", "circle", "full", R.drawable.ic_launcher));
		deck.add(new Card(3, "green", "circle", "full", R.drawable.ic_launcher));
		deck.add(new Card(3, "blue", "circle", "full", R.drawable.ic_launcher));
		
		deck.add(new Card(1, "red", "triangle", "empty", R.drawable.ic_launcher));
		deck.add(new Card(1, "green", "triangle", "empty", R.drawable.ic_launcher));
		deck.add(new Card(1, "blue", "triangle", "empty", R.drawable.ic_launcher));
		
		deck.add(new Card(1, "red", "rectangle", "empty", R.drawable.ic_launcher));
		deck.add(new Card(1, "green", "rectangle", "empty", R.drawable.ic_launcher));
		deck.add(new Card(1, "blue", "rectangle", "empty", R.drawable.ic_launcher));
		
		deck.add(new Card(1, "red", "circle", "empty", R.drawable.ic_launcher));
		deck.add(new Card(1, "green", "circle", "empty", R.drawable.ic_launcher));
		deck.add(new Card(1, "blue", "circle", "empty", R.drawable.ic_launcher));
		
		deck.add(new Card(2, "red", "triangle", "empty", R.drawable.ic_launcher));
		deck.add(new Card(2, "green", "triangle", "empty", R.drawable.ic_launcher));
		deck.add(new Card(2, "blue", "triangle", "empty", R.drawable.ic_launcher));
		
		deck.add(new Card(2, "red", "rectangle", "empty", R.drawable.ic_launcher));
		deck.add(new Card(2, "green", "rectangle", "empty", R.drawable.ic_launcher));
		deck.add(new Card(2, "blue", "rectangle", "empty", R.drawable.ic_launcher));
		
		deck.add(new Card(2, "red", "circle", "empty", R.drawable.ic_launcher));
		deck.add(new Card(2, "green", "circle", "empty", R.drawable.ic_launcher));
		deck.add(new Card(2, "blue", "circle", "empty", R.drawable.ic_launcher));
		
		deck.add(new Card(3, "red", "triangle", "empty", R.drawable.ic_launcher));
		deck.add(new Card(3, "green", "triangle", "empty", R.drawable.ic_launcher));
		deck.add(new Card(3, "blue", "triangle", "empty", R.drawable.ic_launcher));
		
		deck.add(new Card(3, "red", "rectangle", "empty", R.drawable.ic_launcher));
		deck.add(new Card(3, "green", "rectangle", "empty", R.drawable.ic_launcher));
		deck.add(new Card(3, "blue", "rectangle", "empty", R.drawable.ic_launcher));
		
		deck.add(new Card(3, "red", "circle", "empty", R.drawable.ic_launcher));
		deck.add(new Card(3, "green", "circle", "empty", R.drawable.ic_launcher));
		deck.add(new Card(3, "blue", "circle", "empty", R.drawable.ic_launcher));
		
		deck.add(new Card(1, "red", "triangle", "striped", R.drawable.ic_launcher));
		deck.add(new Card(1, "green", "triangle", "striped", R.drawable.ic_launcher));
		deck.add(new Card(1, "blue", "triangle", "striped", R.drawable.ic_launcher));
		
		deck.add(new Card(1, "red", "rectangle", "striped", R.drawable.ic_launcher));
		deck.add(new Card(1, "green", "rectangle", "striped", R.drawable.ic_launcher));
		deck.add(new Card(1, "blue", "rectangle", "striped", R.drawable.ic_launcher));
		
		deck.add(new Card(1, "red", "circle", "striped", R.drawable.ic_launcher));
		deck.add(new Card(1, "green", "circle", "striped", R.drawable.ic_launcher));
		deck.add(new Card(1, "blue", "circle", "striped", R.drawable.ic_launcher));
		
		deck.add(new Card(2, "red", "triangle", "striped", R.drawable.ic_launcher));
		deck.add(new Card(2, "green", "triangle", "striped", R.drawable.ic_launcher));
		deck.add(new Card(2, "blue", "triangle", "striped", R.drawable.ic_launcher));
		
		deck.add(new Card(2, "red", "rectangle", "striped", R.drawable.ic_launcher));
		deck.add(new Card(2, "green", "rectangle", "striped", R.drawable.ic_launcher));
		deck.add(new Card(2, "blue", "rectangle", "striped", R.drawable.ic_launcher));
		
		deck.add(new Card(2, "red", "circle", "striped", R.drawable.ic_launcher));
		deck.add(new Card(2, "green", "circle", "striped", R.drawable.ic_launcher));
		deck.add(new Card(2, "blue", "circle", "striped", R.drawable.ic_launcher));
		
		deck.add(new Card(3, "red", "triangle", "striped", R.drawable.ic_launcher));
		deck.add(new Card(3, "green", "triangle", "striped", R.drawable.ic_launcher));
		deck.add(new Card(3, "blue", "triangle", "striped", R.drawable.ic_launcher));
		
		deck.add(new Card(3, "red", "rectangle", "striped", R.drawable.ic_launcher));
		deck.add(new Card(3, "green", "rectangle", "striped", R.drawable.ic_launcher));
		deck.add(new Card(3, "blue", "rectangle", "striped", R.drawable.ic_launcher));
		
		deck.add(new Card(3, "red", "circle", "striped", R.drawable.ic_launcher));
		deck.add(new Card(3, "green", "circle", "striped", R.drawable.ic_launcher));
		deck.add(new Card(3, "blue", "circle", "striped", R.drawable.ic_launcher));
		
		Collections.shuffle(deck);
		return deck;	
	}
	
}
