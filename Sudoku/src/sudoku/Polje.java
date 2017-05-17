package sudoku;

import java.io.Serializable;

/**
 * Klasa koja sadrzi vrednost polja i kako je unesena ta vrednost
 * ,da li je uneta prilikom pokretanja nove igre ili od strane korisnika,
 * da li se vrednost polja moze menjati ili ne i metode za upravljanje atributima
 * @author Team4-2017
 */

public class Polje implements Serializable {
	
	private static final long serialVersionUID = 9105679343991525823L;
	/**
	 * Broj koji se prikazuje na polju prilikom zapocinjanja igre
	 * i koji nije moguce promeniti u toku igre.
	 */
	private int generisanaVrednost = 0;
	/**
	 * Broj koji korisnik unosi u polje tokom igre.
	 */
	private int unesenaVrednost = 0;
	/**
	 * Promenljiva koja govori da li se vrednosti u polju mogu menjati ili ne.
	 */
	private boolean zakljucano = false;
	
	/**
	 * Javni konstruktor klase Polje bez ulaznih parametara.
	 */
	public Polje() {
	}
	
	/**
	 * Javni konstuktor koji postavlja vrednosti atributa klase
	 * Polje na vrednosti odgovarajucih ulaznih parametara.
	 * @param generisanaVrednost
	 * 							broj koji se prikazuje na polju prilikom zapocinjanja igre
	 * 							i koji nije moguce promeniti u toku igre.
	 * @param unesenaVrednost
	 * 							broj koji korisnik unosi u polje tokom igre.	
	 * @param zakljucano
	 * 							promenljiva koja govori da li se vrednosti u polju mogu menjati ili ne.
	 */
	public Polje(int generisanaVrednost, int unesenaVrednost, boolean zakljucano) {
		this.generisanaVrednost = generisanaVrednost;
		this.unesenaVrednost = unesenaVrednost;
		this.zakljucano = zakljucano;
	}
	
	/**
	 * Metoda koja vraca vrednost koja se nalazi u polju.
	 * @return Ako se polje ne moze menjati vraca generisanu vrednost, 
	 * ako se moze vraca vrednost koju je korisnik uneo u polje.
	 */
	public int vratiBroj() {
		if(zakljucano) {
			return generisanaVrednost;
		}
		return unesenaVrednost;
	}
	
	public int getGenerisanaVrednost() {
		return generisanaVrednost;
	}
	public void setGenerisanaVrednost(int generisanaVrednost) {
		this.generisanaVrednost = generisanaVrednost;
	}
	public int getUnesenaVrednost() {
		return unesenaVrednost;
	}
	public void setUnesenaVrednost(int unesenaVrednost) {
		this.unesenaVrednost = unesenaVrednost;
	}
	public boolean isZakljucano() {
		return zakljucano;
	}
	public void setZakljucano(boolean zakljucano) {
		this.zakljucano = zakljucano;
	}

}
