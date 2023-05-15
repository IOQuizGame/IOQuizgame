package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;
import io_Quiz.*;
import spieler.Spieler;

public class Game {

	private String antwort;
	private Spieler spieler1;
	private Spieler spieler2;
	private ArrayList<Kategorien> kategorien;
	private ArrayList<String> fragen;
	private EinAusgaben tast;
	private EinAusgaben laden;
	private String kat;
	private int anzahlspieler;
	private ArrayList<Spieler> spieler;
	private int aktuellerSpieler = 0;

	public Game() {
		kategorien = new ArrayList<>();
		spieler = new ArrayList<>();
	}

	public void spielen() {
		anzahlSpieler();
		spielerErzeugen();
		kategorieAuswahl();
		kategorieLaden();
		wechselSpieler();
		fragenStellen();
		auswertung();

	}

	private void auswertung() {
		System.out.println("Auswertung");
	}

	private void kategorieLaden() {
		laden = new EinAusgaben();
		fragen = laden.dateiLaden(kat);

	}

	private void fragenStellen() {
		Collections.shuffle(fragen);
		for (int i = 0; i < fragen.size(); i++) {
			wechselSpieler();
			System.out.println("Spieler " + spieler.get(aktuellerSpieler).getName() + " ist am Zug!");
			String[] frageGesplittet = fragen.get(i).split("/");
			for (int j = 0; j < 5; j++) {
				System.out.println("\t" + frageGesplittet[j]);
				System.out.println();
			}

			System.out.println("Bitte richtige Antwort eingeben: ");
			antwort = tast.tastaturEingabe();
			if (antwort.equalsIgnoreCase(frageGesplittet[5])) {
				System.out.println("Sie sind ein Genie! Für die richtige Antwort gibt es 5 Punkte.");
				spieler.get(aktuellerSpieler).setPunkte(spieler.get(aktuellerSpieler).getPunkte() + 5);
				System.out.println("Ihre Punkteanzahl beträgt: " + spieler.get(aktuellerSpieler).getPunkte());
			} else {
				System.out.println("Sie hatten ein Lack of Intelligence. 5 Punkte Abzug für die falsche Antwort.");
				spieler.get(aktuellerSpieler).setPunkte(spieler.get(aktuellerSpieler).getPunkte() - 5);
				System.out.println("Ihre Punkteanzahl beträgt: " + spieler.get(aktuellerSpieler).getPunkte() + "\n");
				spieler.get(aktuellerSpieler).setHealth(spieler.get(aktuellerSpieler).getHealth() - 1);
				System.out.println("Ihre Lebensanzeige sinkt auf: " + spieler.get(aktuellerSpieler).getHealth() + "\n");
				int h = spieler.get(aktuellerSpieler).getHealth();
				if (h == 0) {
					System.out.println("Sie haben verloren! Das Spiel ist zuende.");
					System.exit(h);
				} else {
					int f = spieler.get(aktuellerSpieler).getPunkte();
					if (f < 0) {
						System.out.println("Sie haben verloren! Das Spiel ist zuende.");
						System.exit(f);
					}
				}
			}
		}
	}
	
	private int wechselSpieler() {
		if (anzahlspieler > 1) {
			aktuellerSpieler = (aktuellerSpieler - 1) * (-1);
		}

		return aktuellerSpieler;

	}

	public void spielerErzeugen() {
		spieler1 = new Spieler("Spieler1", 0, 3);
		spieler2 = new Spieler("Spieler2", 0, 3);

		spieler.add(spieler1);
		spieler.add(spieler2);
		if(anzahlspieler==1) {
		System.out.println("Spieler 1 heißt " + spieler1.getName());
		System.out.println("Möchten Sie diesen Namen ändern? J / N");
		}
		else if (anzahlspieler>1) {
		System.out.println("Spieler 1 heißt " + spieler1.getName());
		System.out.println("Spieler 2 heißt " + spieler2.getName());
		System.out.println("Möchten Sie die Namen ändern? J / N");
		}
		
		boolean korrekt = false;
		tast = new EinAusgaben();
		while (korrekt == false) {
			antwort = tast.tastaturEingabe();
			if (antwort.equalsIgnoreCase("j")) {
				korrekt = true;
				namenSetzen();
			} else {
				if (antwort.equalsIgnoreCase("n")) {
					korrekt = true;
				}
			}
		}
	}

	private void namenSetzen() {
		tast = new EinAusgaben();
		for (int i = 0; i < anzahlspieler; i++) {
			System.out.println("Geben Sie jetzt bitte Ihren Namen an: ");
			antwort = tast.tastaturEingabe();
			spieler.get(i).setName(antwort);
		}

	}

	// wie viele Spieler

	private void anzahlSpieler() {

		boolean iskorrekt = false;
		tast = new EinAusgaben();
		{
			while (iskorrekt == false) {
				System.out.println("Bitte Spieleranzahl angeben: Wähle 1 oder 2 Spieler");
				antwort = tast.tastaturEingabe();
				if ((antwort.equals("1")) || (antwort.equals("2"))) {
					anzahlspieler = Integer.parseInt(antwort);
					iskorrekt = true;
					System.out.println("Vielen Dank! Sie werden nun weitergeleitet ");
				} else {
					System.out.println("Es ist etwas schief gegangen. Geben Sie Ihre Antwort erneut ein");
				}
			}
		}
	}

	private void kategorieAuswahl() {
		System.out.println("Spieler " + spieler1.getName() + " bitte Kategorie wählen ");
		EnumSet<Kategorien> set = EnumSet.allOf(Kategorien.class);
		for (Kategorien kat : Kategorien.values()) {
			kategorien.add(kat);
		}
		char a = 'A';
		for (int i = 0; i < set.size(); i++) {
			System.out.println("\t" + (char) (a + i) + "\t" + kategorien.get(i).toString());
		}
		boolean korrekt = false;

		tast = new EinAusgaben();
		while (korrekt == false) {
			antwort = tast.tastaturEingabe();
			if ((antwort.equalsIgnoreCase("a")) || (antwort.equalsIgnoreCase("b")) || (antwort.equalsIgnoreCase("c"))
					|| (antwort.equalsIgnoreCase("d")) || (antwort.equalsIgnoreCase("e"))) {
				char c = antwort.charAt(0);
				kat = kategorien.get((char) (c - 97)).toString().toLowerCase();
				System.out.println("Antwort " + kategorien.get((char) (c - 97)));
				korrekt = true;
			} else {
				System.out.println("Falsche Eingabe " + antwort);
			}
		}
	}

	// Fragen initialisieren (random Fragen

	// Fragen beantworten

	// Fragenauswertung (Punkte und ein Healthsystem)

	// Spielstand speichern

	// nochMal

	public String getAntwort() {
		return antwort;
	}

	public void setAntwort(String antwort) {
		this.antwort = antwort;
	}

	public ArrayList<Kategorien> getKategorien() {
		return kategorien;
	}

	public void setKategorien(ArrayList<Kategorien> kategorien) {
		this.kategorien = kategorien;
	}

	public ArrayList<String> getFragen() {
		return fragen;
	}

	public void setFragen(ArrayList<String> fragen) {
		this.fragen = fragen;
	}

	public EinAusgaben getTast() {
		return tast;
	}

	public void setTast(EinAusgaben tast) {
		this.tast = tast;
	}

	public EinAusgaben getLaden() {
		return laden;
	}

	public void setLaden(EinAusgaben laden) {
		this.laden = laden;
	}

	public String getKat() {
		return kat;
	}

	public void setKat(String kat) {
		this.kat = kat;
	}

	public int getAnzahlspieler() {
		return anzahlspieler;
	}

	public void setAnzahlspieler(int anzahlspieler) {
		this.anzahlspieler = anzahlspieler;
	}

}