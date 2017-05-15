package sudoku;

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
	
	public String getIme() {
		return ime;
	}

	public int getSekunde() {
		return sekunde;
	}

	public int getMinuti() {
		return minuti;
	}

	public int getSati() {
		return sati;
	}

	public Rezultat(String ime, int sekunde, int minuti, int sati){
		
		this.ime=ime;
		this.sekunde=sekunde;
		this.minuti=minuti;
		this.sati=sati;
		
	}
	
	public String toString(){
		
		return ime+"\t"+sati+":"+minuti+":"+sekunde;
		
	}
	
	
	
}
