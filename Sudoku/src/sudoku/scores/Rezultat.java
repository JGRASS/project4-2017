package sudoku.scores;

import java.io.Serializable;

public class Rezultat implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String ime;
	private int sekunde;
	private int minuti;
	private int sati;

	public Rezultat(String ime, int sekunde, int minuti, int sati){
		this.ime=ime;
		this.sekunde=sekunde;
		this.minuti=minuti;
		this.sati=sati;
	}


	public Rezultat(int sekunde, int minuti, int sati){
		this.sekunde=sekunde;
		this.minuti=minuti;
		this.sati=sati;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public int getSekunde() {
		return sekunde;
	}

	public void setSekunde(int sekunde) {
		this.sekunde = sekunde;
	}
	
	public int getMinuti() {
		return minuti;
	}

	public void setMinuti(int minuti) {
		this.minuti = minuti;
	}
	
	public int getSati() {
		return sati;
	}
	
	public void setSati(int sati) {
		this.sati = sati;
	}

	
	public String toString(){
		
		return ime+"\t"+sati+":"+minuti+":"+sekunde;
		
	}
	
	
	
}
