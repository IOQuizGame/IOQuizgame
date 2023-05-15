package io_Quiz;

import java.util.ArrayList;

import game.Game;
import editor.Editor;
import game.HighScore;


public class IndexSeite {

	private  ArrayList <String> indexList;
	private  EinAusgaben tast;
	private  String antwort;
	private  String index;
	private  Game spielen;
	private int c;
	private Editor edit;
	private boolean korrekt = false;

	public IndexSeite() {
		indexList = new ArrayList<>();
		indexSeite();
	}

	public void indexSeite() {
		System.out.println("\n \n");
		System.out.println("Willkommen zu unserem Wissenstest Quizzeln. \n \n");
		System.out.println("Bitte wählen Sie eine der folgenden Optionen aus. Vielen Dank! \n");
		indexList.add("Editor");
		indexList.add("Game");
		indexList.add("Highscore");
		indexList.add("Beenden");
		ausgabe();
		tastaturAbfrage();
		auswahl();
	}

	private void auswahl() {

			switch (index) {
			case "Editor":
				edit = new Editor();
				edit.frage();
				break;
			case "Game": 
				spielen = new Game();
				spielen.spielen();
				break;
			case "HighScore":System.out.println(index);
				break;
			case "Beenden":
				System.out.println("Vielen Dank, dass Sie unser Quiz gespielt haben. Bis zum nächsten Mal!");
				System.exit(c);
				break;
			}
		}
	


	private void ausgabe() {
		for (int i = 0; i < indexList.size(); i++) {
			System.out.println("\t" + (char) (i + 65) + " " + indexList.get(i));
			System.out.println();
		}

	}

	private void tastaturAbfrage() {
		tast = new EinAusgaben();

		while (korrekt == false) {
			antwort = tast.tastaturEingabe();
			if ((antwort.equalsIgnoreCase("a")) || (antwort.equalsIgnoreCase("b")) || (antwort.equalsIgnoreCase("c"))
					|| (antwort.equalsIgnoreCase("d"))) {
				c = antwort.charAt(0);
				index = indexList.get((char) (c - 97)).toString();
				korrekt = true;
			} else {
				System.out.println("Diese Eingabe war falsch " + antwort);
			}

		}
	}

	public EinAusgaben getTast() {
		return tast;
	}

	public void setTast(EinAusgaben tast) {
		this.tast = tast;
	}

	public String getAntwort() {
		return antwort;
	}

	public void setAntwort(String antwort) {
		this.antwort = antwort;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public Game getspielen() {
		return spielen;
	}

	public void setPlay(Game spielen) {
		this.spielen = spielen;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public Editor getEdit() {
		return edit;
	}

	public void setEdit(Editor edit) {
		this.edit = edit;
	}

	public ArrayList<String> getIndexList() {
		return indexList;
	}

	public void setIndexList(ArrayList<String> indexList) {
		this.indexList = indexList;
	}

}
