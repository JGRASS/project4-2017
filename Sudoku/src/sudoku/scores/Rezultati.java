package sudoku.scores;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

/**
 * Klasa u kojoj se nalazi lista najboljih 10 rezultata.
 * @author Team4-2017
 *
 */
public class Rezultati implements Serializable {
	
	private static final long serialVersionUID = -1876760401083044677L;
	/**
	 * Predstavlja listu sa najboljih 10 rezultata.
	 */
	private LinkedList<Rezultat> lista;
	
	/**
	 * Metoda koja vraca poziciju igraca
	 * @param rez
	 * 				Klasa koja sadrzi podatke o rezultatu datog igraca.
	 * @return vraca poziciju datog igraca
	 */
	public int proveriRezultat(Rezultat rez) {
		if(lista == null){
			lista = new LinkedList<Rezultat>();
		}
		
		if(lista.isEmpty()){
			return 0;
		}
		
		int time = rez.getSati()*3600 + rez.getMinuti()*60 + rez.getSekunde();
		for(int i = 0; i < lista.size(); i++){
			
			Rezultat rez2 = lista.get(i);
			int time2 = rez2.getSati()*3600 + rez2.getMinuti()*60 + rez2.getSekunde();
			if(time < time2) {
				return i;
			}
		}
		
		if(lista.size()<10) {
			return lista.size();
		}
		
		return -1;
	
	}
	
	/**
	 * Metoda koja postavlja igrace na date pozicije u listi.
	 * @param rez
	 * 				Klasa koja sadrzi podatke o rezultatu datog igraca.
	 * @param i
	 * 				pozicija na kojoj se nalazi dati igrac.
	 */
	public void dodajRezultat(Rezultat rez, int i) {
		lista.add(i, rez);
		while(lista.size() > 10)
			lista.removeLast();
	}
	
	/**
	 * Metoda koja serijalizuje listu igraca u fajlu Highscores.dat.
	 */
	public void serialize() {
    	try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("highscores/Highscores.dat")));
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
	 * Metoda koja deserijalizuje listu iz fajle Highscores.dat.
	 * @return
	 */
    public static Rezultati deserialize() {
    	Rezultati rezultati = null;
    	try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("highscores/Highscores.dat")));
			rezultati = (Rezultati) in.readObject();
			in.close();
    	} catch (EOFException e) {
    		rezultati = new Rezultati();
    		rezultati.setLista(new LinkedList<Rezultat>());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	return rezultati;
    }

	public LinkedList<Rezultat> getLista() {
		return lista;
	}

	public void setLista(LinkedList<Rezultat> lista) {
		if(lista == null)
			throw new RuntimeException();
		this.lista = lista;
	}
}
