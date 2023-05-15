package io_Quiz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class EinAusgaben {
	private String datei;
	private String kategorie;
	private String antwort;
	private BufferedReader userBuffer;
	private BufferedReader bufferRead;
	private BufferedWriter userWriter;
	private OutputStream file;
	private String fragenSatz;
	private ArrayList<String> quiz;

	public EinAusgaben() {
		super();
		this.userBuffer = new BufferedReader(new InputStreamReader(System.in));
		quiz = new ArrayList<>();
	}

	// verzeichnisErstellen

	// dateiErstellen
	public void dateiErstellen(String dateiName) {
		this.datei = dateiName;

	}

	// dateiLesen

	public ArrayList<String> dateiLaden(String kat){
		try {
			bufferRead = new BufferedReader(new FileReader("Quiz/"+kat+".txt"));
			try {
				while((fragenSatz=bufferRead.readLine())!=null) {
					quiz.add(fragenSatz);
				}				
			}
			catch(IOException e){
				e.printStackTrace();
			}
			}	catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return quiz;
    } 		
    		
    	
    

	// SpielstandSpeichern
	public void spielStandSpeichern() {

	}

	// SpielStandLaden
	public void spielStandLaden() {

	}

	// tastaturabfrage
	public String tastaturEingabe() {
		try {
			return userBuffer.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getDatei() {
		return datei;
	}

	public void setDatei(String datei) {
		this.datei = datei;
	}

	public String getKategorie() {
		return kategorie;
	}

	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}

	public String getAntwort() {
		return antwort;
	}

	public void setAntwort(String antwort) {
		this.antwort = antwort;
	}

	public BufferedReader getUserBuffer() {
		return userBuffer;
	}

	public void setUserBuffer(BufferedReader userBuffer) {
		this.userBuffer = userBuffer;
	}

	public BufferedReader getBufferRead() {
		return bufferRead;
	}

	public void setBufferRead(BufferedReader bufferRead) {
		this.bufferRead = bufferRead;
	}

	public BufferedWriter getUserWriter() {
		return userWriter;
	}

	public void setUserWriter(BufferedWriter userWriter) {
		this.userWriter = userWriter;
	}

	public OutputStream getFile() {
		return file;
	}

	public void setFile(OutputStream file) {
		this.file = file;
	}

	public String getFragenSatz() {
		return fragenSatz;
	}

	public void setFragenSatz(String fragenSatz) {
		this.fragenSatz = fragenSatz;
	}

	public ArrayList<String> getQuiz() {
		return quiz;
	}

	public void setQuiz(ArrayList<String> quiz) {
		this.quiz = quiz;
	}
	
}