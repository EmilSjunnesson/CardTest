package se.mah.k3.cards;

public class Card {

	private int number;
	private String color;
	private String shape;
	private String filling;
	private int resId;
	private int index;

	public Card(int number, String color, String shape, String filling,
			int resId) {
		this.number = number;
		this.color = color;
		this.shape = shape;
		this.filling = filling;
		this.resId = resId;
		index = -1;
	}

	public int getNumber() {
		return number;
	}

	public String getColor() {
		return color;
	}

	public String getShape() {
		return shape;
	}

	public String getFilling() {
		return filling;
	}

	public int getResId() {
		return resId;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "Card at " + index + ": " + number + " | " + color + " | "
				+ shape + " | " + filling;
	}

}
