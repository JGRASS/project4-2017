package sudoku;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Klasa koja sarzi podatke o trenutnoj igri.
 * @author Team4-2017
 *
 */
public class Igra implements Serializable {
	
	private static final long serialVersionUID = -3744400206205691032L;
	
	/**
	 * Matrica svih brojeva koji su generisani ili uneseni od strane igraca.
	 */
	private Polje[][] matrica;
	
	/**
	 * Broj sati proteklih tokom igre.
	 */
	private int sati;
	
	/**
	 * Broj minuta proteklih tokom igre.
	 */
	private int minuti;
	
	/**
	 * Broj sekundi proteklih tokom igre.
	 */
	private int sekunde;
	
	/**
	 * Javni konstuktor koji postavlja vrednosti atributa klase
	 * Igra na vrednosti odgovarajucih ulaznih parametara.
	 * @param matrica
	 * 					Matrica svih brojeva koji su generisani ili uneseni od strane igraca.
	 * @param sati
	 * 					Broj sati proteklih tokom igre.
	 * @param minuti
	 * 					Broj minuta proteklih tokom igre.
	 * @param sekunde
	 * 					Broj sekundi proteklih tokom igre.
	 */
	public Igra(Polje[][] matrica, int sati, int minuti, int sekunde) {
		super();
		this.matrica = matrica;
		this.sati = sati;
		this.minuti = minuti;
		this.sekunde = sekunde;
	}
	
	/**
	 * Metoda koja serijalizuje Igra u zadatu fajlu
	 * @param file
	 * 				predstavlja fajlu u koju se sacuvava partija.
	 */
	public void serialize(File file) {
    	try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(this);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
	/**
	 * Otvara sacuvanu igru iz fajle.
	 * @param file
	 * 				predstavlja fajlu u kojoj se nalazi sacuvana partija.
	 * @return vraca igru koja se nalazi u toj fajli.
	 */
    public static Igra deserialize(File file) {
    	Igra igra = null;
    	try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			igra = (Igra) in.readObject();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	return igra;
    }
	
	public Polje[][] getMatrica() {
		return matrica;
	}
	public void setMatrica(Polje[][] matrica) {
		this.matrica = matrica;
	}
	public int getSati() {
		return sati;
	}
	public void setSati(int sati) {
		this.sati = sati;
	}
	public int getMinuti() {
		return minuti;
	}
	public void setMinuti(int minuti) {
		this.minuti = minuti;
	}
	public int getSekunde() {
		return sekunde;
	}
	public void setSekunde(int sekunde) {
		this.sekunde = sekunde;
	}
}
