package sudoku.scores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

public class Rezultati implements Serializable {
	
	private static final long serialVersionUID = -1876760401083044677L;

	private LinkedList<Rezultat> lista;
	
	public int proveriRezultat(Rezultat rez) {
		if(lista == null){
			lista = new LinkedList<Rezultat>();
		}
		
		if(lista.isEmpty()){
			return 0;
		}
		
		for(int i = 0; i < lista.size(); i++){
			
			if(lista.get(i).getSati() < rez.getSati())
				continue;
			
			if(lista.get(i).getMinuti() < rez.getMinuti())
				continue;
			
			if(lista.get(i).getSekunde() < rez.getSekunde())
				continue;
			
			return i;
		}
		
		return -1;
	
	}
	
	public void dodajRezultat(Rezultat rez, int i) {
		lista.add(i, rez);
		while(lista.size() > 10)
			lista.removeLast();
	}
	
	
	public void serialize() {
    	try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("src/sudoku/scores/Highscore")));
			out.writeObject(this);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public static Rezultati deserialize() {
    	Rezultati rezultati = null;
    	try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("src/sudoku/scores/Highscore")));
			rezultati = (Rezultati) in.readObject();
			in.close();
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
		this.lista = lista;
	}
}
