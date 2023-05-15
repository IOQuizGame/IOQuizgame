package io_Quiz;

import java.util.ArrayList;

import game.Game;
import editor.Editor;

public class IndexSeite {

	private static ArrayList<String> indexList;
	private static EinAusgaben tast;
	private static String antwort = "";
	private static String index;
	private static Game play;

	public IndexSeite() {
		indexList = new ArrayList<>();
	}

	public static void indexSeite() {
		System.out.println("\n \n");
		System.out.println("Willkommen zu unserem Wissenstest Quizzeln. \n \n");
		System.out.println("Bitte wählen Sie eine der folgenden Optionen aus. Vielen Dank! \n");
		indexList.add("Editor \n");
		indexList.add("Game \n");
		indexList.add("Highscore \n");
		indexList.add("Beenden \n");
		ausgabe();
		tastaturAbfrage();
		auswahl();
	}

	private static void auswahl() {

			switch (index) {
			case "Editor":
				System.out.println("Ich bin der Editor");
				break;
			case "Game":
				play.spielen();
				break;
			case "Highscore":
				break;
			case "beenden":
				break;
			}
		}

	private static void ausgabe() {
		for (int i = 0; i < indexList.size(); i++) {
			System.out.println("\t" + (char) (i + 65) + " " + indexList.get(i));
			System.out.println();
		}

	}

	private static void tastaturAbfrage() {
		tast = new EinAusgaben();

		boolean korrekt = false;
		while (korrekt == false) {
			antwort = tast.tastaturEingabe();
			if ((antwort.equalsIgnoreCase("a")) || (antwort.equalsIgnoreCase("b")) || (antwort.equalsIgnoreCase("c"))
					|| (antwort.equalsIgnoreCase("d"))) {
				char c = antwort.charAt(0);
				index = indexList.get((char) (c - 97)).toString().toLowerCase();
				korrekt = true;
			} else {
				System.out.println("Falsche Eingabe " + antwort);
			}

		}
	}

	public ArrayList<String> getIndexList() {
		return indexList;
	}

	public void setIndexList(ArrayList<String> indexList) {
		this.indexList = indexList;
	}

}
