package fcg.card;

public class Weapon extends Card {

	private int damage;

	public enum ammoTypes {
		TWENTY_TWO, FIFTY, NINE, TEN
	};

	public Weapon(String name) {
		super(name);
	}

}
