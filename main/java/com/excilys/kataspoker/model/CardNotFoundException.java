package main.java.com.excilys.kataspoker.model;

public class CardNotFoundException extends Throwable {
	public CardNotFoundException() {
		super("Card Not Found in the deck");
	}
}
