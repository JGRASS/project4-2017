package sudoku.scores;

import java.io.Serializable;

/**
 * Klasa koja sadrzi podatke o rezultatu datog igraca.
 * @author Team4-2017
 *
 */

public class Rezultat implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Predstavlja naziv igraca.
	 */
	private String ime;
	
	/**
	 * broj sekundi koji je bio potreban za resavanje igre.
	 */
	private int sekunde;
	
	/**
	 * broj minuta koji je bio potreban za resavanje igre.
	 */
	private int minuti;
	
	/**
	 * broj sati koji je bio potreban za resavanje igre.
	 */
	private int sati;
	
	/**
	 * Javni konstuktor koji postavlja vrednosti atributa klase
	 * Rezultat na vrednosti odgovarajucih ulaznih parametara.
	 * @param ime
	 * 					naziv igraca.
	 * @param sekunde
	 * 					broj sekundi koji je bio potreban za resavanje igre.
	 * @param minuti
	 * 					broj minuta koji je bio potreban za resavanje igre.
	 * @param sati
	 * 					broj sati koji je bio potreban za resavanje igre.
	 */
	public Rezultat(String ime, int sekunde, int minuti, int sati){
		this.ime=ime;
		this.sekunde=sekunde;
		this.minuti=minuti;
		this.sati=sati;
	}

	/**
	 * Javni konstuktor koji postavlja vrednosti atributa klase
	 * Rezultat na vrednosti odgovarajucih ulaznih parametara osim atributa ime.
	 * @param sekunde
	 * 					broj sekundi koji je bio potreban za resavanje igre.
	 * @param minuti
	 * 					broj minuta koji je bio potreban za resavanje igre.
	 * @param sati
	 * 					broj sati koji je bio potreban za resavanje igre.
	 */
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
