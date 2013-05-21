package se.mah.k3.cards;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	public ArrayList<Card> getAllCards(ArrayList<Card> deck){
		deck.add(new Card(1, "red", "triangle", "full", R.drawable.card1));
		deck.add(new Card(1, "green", "triangle", "full", R.drawable.card2));
		deck.add(new Card(1, "blue", "triangle", "full", R.drawable.card3));
		
		deck.add(new Card(1, "red", "diamond", "full", R.drawable.card4));
		deck.add(new Card(1, "green", "diamond", "full", R.drawable.card5));
		deck.add(new Card(1, "blue", "diamond", "full", R.drawable.card6));
		
		deck.add(new Card(1, "red", "moon", "full", R.drawable.card7));
		deck.add(new Card(1, "green", "moon", "full", R.drawable.card8));
		deck.add(new Card(1, "blue", "moon", "full", R.drawable.card9));
		
		deck.add(new Card(2, "red", "triangle", "full", R.drawable.card10));
		deck.add(new Card(2, "green", "triangle", "full", R.drawable.card11));
		deck.add(new Card(2, "blue", "triangle", "full", R.drawable.card12));
		
		deck.add(new Card(2, "red", "diamond", "full", R.drawable.card13));
		deck.add(new Card(2, "green", "diamond", "full", R.drawable.card14));
		deck.add(new Card(2, "blue", "diamond", "full", R.drawable.card15));
		
		deck.add(new Card(2, "red", "moon", "full", R.drawable.card16));
		deck.add(new Card(2, "green", "moon", "full", R.drawable.card17));
		deck.add(new Card(2, "blue", "moon", "full", R.drawable.card18));
		
		deck.add(new Card(3, "red", "triangle", "full", R.drawable.card19));
		deck.add(new Card(3, "green", "triangle", "full", R.drawable.card20));
		deck.add(new Card(3, "blue", "triangle", "full", R.drawable.card21));
		
		deck.add(new Card(3, "red", "diamond", "full", R.drawable.card22));
		deck.add(new Card(3, "green", "diamond", "full", R.drawable.card23));
		deck.add(new Card(3, "blue", "diamond", "full", R.drawable.card24));
		
		deck.add(new Card(3, "red", "moon", "full", R.drawable.card25));
		deck.add(new Card(3, "green", "moon", "full", R.drawable.card26));
		deck.add(new Card(3, "blue", "moon", "full", R.drawable.card27));
		
		deck.add(new Card(1, "red", "triangle", "empty", R.drawable.card28));
		deck.add(new Card(1, "green", "triangle", "empty", R.drawable.card29));
		deck.add(new Card(1, "blue", "triangle", "empty", R.drawable.card30));
		
		deck.add(new Card(1, "red", "diamond", "empty", R.drawable.card31));
		deck.add(new Card(1, "green", "diamond", "empty", R.drawable.card32));
		deck.add(new Card(1, "blue", "diamond", "empty", R.drawable.card33));
		
		deck.add(new Card(1, "red", "moon", "empty", R.drawable.card34));
		deck.add(new Card(1, "green", "moon", "empty", R.drawable.card35));
		deck.add(new Card(1, "blue", "moon", "empty", R.drawable.card36));
		
		deck.add(new Card(2, "red", "triangle", "empty", R.drawable.card37));
		deck.add(new Card(2, "green", "triangle", "empty", R.drawable.card38));
		deck.add(new Card(2, "blue", "triangle", "empty", R.drawable.card39));
		
		deck.add(new Card(2, "red", "diamond", "empty", R.drawable.card40));
		deck.add(new Card(2, "green", "diamond", "empty", R.drawable.card41));
		deck.add(new Card(2, "blue", "diamond", "empty", R.drawable.card42));
		
		deck.add(new Card(2, "red", "moon", "empty", R.drawable.card43));
		deck.add(new Card(2, "green", "moon", "empty", R.drawable.card44));
		deck.add(new Card(2, "blue", "moon", "empty", R.drawable.card45));
		
		deck.add(new Card(3, "red", "triangle", "empty", R.drawable.card46));
		deck.add(new Card(3, "green", "triangle", "empty", R.drawable.card47));
		deck.add(new Card(3, "blue", "triangle", "empty", R.drawable.card48));
		
		deck.add(new Card(3, "red", "diamond", "empty", R.drawable.card49));
		deck.add(new Card(3, "green", "diamond", "empty", R.drawable.card50));
		deck.add(new Card(3, "blue", "diamond", "empty", R.drawable.card51));
		
		deck.add(new Card(3, "red", "moon", "empty", R.drawable.card52));
		deck.add(new Card(3, "green", "moon", "empty", R.drawable.card53));
		deck.add(new Card(3, "blue", "moon", "empty", R.drawable.card54));
		
		deck.add(new Card(1, "red", "triangle", "striped", R.drawable.card55));
		deck.add(new Card(1, "green", "triangle", "striped", R.drawable.card56));
		deck.add(new Card(1, "blue", "triangle", "striped", R.drawable.card57));
		
		deck.add(new Card(1, "red", "diamond", "striped", R.drawable.card58));
		deck.add(new Card(1, "green", "diamond", "striped", R.drawable.card59));
		deck.add(new Card(1, "blue", "diamond", "striped", R.drawable.card60));
		
		deck.add(new Card(1, "red", "moon", "striped", R.drawable.card61));
		deck.add(new Card(1, "green", "moon", "striped", R.drawable.card62));
		deck.add(new Card(1, "blue", "moon", "striped", R.drawable.card63));
		
		deck.add(new Card(2, "red", "triangle", "striped", R.drawable.card64));
		deck.add(new Card(2, "green", "triangle", "striped", R.drawable.card65));
		deck.add(new Card(2, "blue", "triangle", "striped", R.drawable.card66));
		
		deck.add(new Card(2, "red", "diamond", "striped", R.drawable.card67));
		deck.add(new Card(2, "green", "diamond", "striped", R.drawable.card68));
		deck.add(new Card(2, "blue", "diamond", "striped", R.drawable.card69));
		
		deck.add(new Card(2, "red", "moon", "striped", R.drawable.card70));
		deck.add(new Card(2, "green", "moon", "striped", R.drawable.card71));
		deck.add(new Card(2, "blue", "moon", "striped", R.drawable.card72));
		
		deck.add(new Card(3, "red", "triangle", "striped", R.drawable.card73));
		deck.add(new Card(3, "green", "triangle", "striped", R.drawable.card74));
		deck.add(new Card(3, "blue", "triangle", "striped", R.drawable.card75));
		
		deck.add(new Card(3, "red", "diamond", "striped", R.drawable.card76));
		deck.add(new Card(3, "green", "diamond", "striped", R.drawable.card77));
		deck.add(new Card(3, "blue", "diamond", "striped", R.drawable.card78));
		
		deck.add(new Card(3, "red", "moon", "striped", R.drawable.card79));
		deck.add(new Card(3, "green", "moon", "striped", R.drawable.card80));
		deck.add(new Card(3, "blue", "moon", "striped", R.drawable.card81));
		
		Collections.shuffle(deck);
		return deck;	
	}
	
}
