package spieler;

public class Spieler {

	// Defaultname für Spieler * Änderung des Spielernamens

	private String name;
	private int punkte;
	private int health;

	public Spieler(String name, int punkte, int health) {
		super();
		this.name = name;
		this.punkte = punkte;
		this.health = health;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPunkte() {
		return punkte;
	}

	public void setPunkte(int punkte) {
		this.punkte = punkte;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	// LadeLeaderBoards

	//

}
