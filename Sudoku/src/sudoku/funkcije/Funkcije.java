package sudoku.funkcije;


import java.io.File;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import sudoku.Igra;
import sudoku.Polje;
import sudoku.generator.GeneratorProvera;
import sudoku.gui.SudokuMainWindow;
import sudoku.scores.Rezultat;
import sudoku.scores.Rezultati;

import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Funkcije {

	public static boolean pauza = true;
	static Random rnd = new Random();
	

	public static void pauziraj(Timer tajmer) {
		if(pauza){
			pause(tajmer);
			return;
		}
		nastavi();
	}

	public static void pause(Timer tajmer) {
		tajmer.cancel();
		pauza=false;
	}

	public static void nastavi() {

		SudokuMainWindow.tajmer = new Timer();
		SudokuMainWindow.ispisiVreme = new TimerTask(){

			public void run(){
				SudokuMainWindow.sekunde++;
				if(SudokuMainWindow.sekunde==60){
					SudokuMainWindow.sekunde=0;
					SudokuMainWindow.minuti++;
				}
				if(SudokuMainWindow.minuti==60){
					SudokuMainWindow.minuti=0;
					SudokuMainWindow.sati++;
				}
				SudokuMainWindow.textTimeField.setText(SudokuMainWindow.sati+":"+SudokuMainWindow.minuti+":"+SudokuMainWindow.sekunde);
			}

		};
		SudokuMainWindow.tajmer.scheduleAtFixedRate(SudokuMainWindow.ispisiVreme,1000,1000);

		pauza=true;

	}

	public static void newGame(JTextField[][] matricaPolja, GeneratorProvera gen) {

		SudokuMainWindow.sekunde=0;
		SudokuMainWindow.minuti=0;
		SudokuMainWindow.sati=0;
		pause(SudokuMainWindow.tajmer);
		nastavi();

		gen.generisati();

		Funkcije.otkljucajSvaIZakljucajGenerisana(matricaPolja, gen.getMatrica());
		Funkcije.ispisMatriceUInterfejs(matricaPolja, gen.getMatrica());
	}

	
	public static Igra openGame(File file) {
		return Igra.deserialize(file);
	}
	
	public static void save(Polje[][] matrica, int sati, int minuti, int sekunde, File file) {
		Igra igra = new Igra(matrica, sati, minuti, sekunde);
		igra.serialize(file);
		
	}

	public static void reset(JTextField[][] matricaPolja, Polje[][] matrica) {
		
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(!matrica[i][j].isZakljucano()){
					matrica[i][j].setUnesenaVrednost(0);
					matricaPolja[i][j].setText("");
				}
			}
		}
		
	}
	
	public static void updateHighscore(int sati, int minuti, int sekunde){
		Rezultati rezultati = Rezultati.deserialize();
		Rezultat rez = new Rezultat(sekunde, minuti, sati);
		int index = rezultati.proveriRezultat(rez);
		String ime = "";
		if(index != -1) {
			ime = (String)JOptionPane.showInputDialog(null, "Enter your name:", "Highscore name", 
	                JOptionPane.PLAIN_MESSAGE, null, null, "");
		}
		rez.setIme(ime);
		rezultati.dodajRezultat(rez, index);
		rezultati.serialize();
	}

	public static void otkljucajSvaIZakljucajGenerisana(JTextField[][] matricaPolja, Polje[][] matrica) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				matricaPolja[i][j].setEditable(true);
			}
		}

		for (int i = 1; i <= 9; i++) {
			int count;
			switch (i) {
			case 1: 
				count = 2 + rnd.nextInt(2);
				obrisiRandomPoljaUDatomRasponu(count, 0, 2, 0, 2, matrica);
				break;
			case 2:  
				count = 2 + rnd.nextInt(2);
				obrisiRandomPoljaUDatomRasponu(count, 3, 5, 0, 2, matrica);
				break;
			case 3: 
				count = 2 + rnd.nextInt(2);
				obrisiRandomPoljaUDatomRasponu(count, 6, 8, 0, 2, matrica);
				break;
			case 4: 
				count = 2 + rnd.nextInt(2);
				obrisiRandomPoljaUDatomRasponu(count, 0, 2, 3, 5, matrica);
				break;
			case 5: 
				count = 2 + rnd.nextInt(2);
				obrisiRandomPoljaUDatomRasponu(count, 3, 5, 3, 5, matrica);
				break;
			case 6: 
				count = 2 + rnd.nextInt(2);
				obrisiRandomPoljaUDatomRasponu(count, 6, 6, 3, 5, matrica);
				break;
			case 7: 
				count = 2 + rnd.nextInt(2);
				obrisiRandomPoljaUDatomRasponu(count, 0, 2, 6, 8, matrica);
				break;
			case 8: 
				count = 2 + rnd.nextInt(2);
				obrisiRandomPoljaUDatomRasponu(count, 3, 5, 6, 8, matrica);
				break;
			case 9: 
				count = 2 + rnd.nextInt(2);
				obrisiRandomPoljaUDatomRasponu(count, 6, 8, 6, 8, matrica);
				break;
			default:
				break;
			}
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(matrica[i][j].isZakljucano()) {
					matricaPolja[i][j].setEditable(false);
				}
			}
		}
	}

	private static void obrisiRandomPoljaUDatomRasponu(int count, int minX, int maxX, int minY, int maxY, Polje[][] matrica) {
		while(count >= 0) {
			int x = minX + rnd.nextInt(3);
			int y = minY + rnd.nextInt(3);
			if(!matrica[x][y].isZakljucano()) {
				matrica[x][y].setZakljucano(true);
				count--;
			}
		}
	}

	public static void ispisMatriceUInterfejs(JTextField[][] matricaPolja, Polje[][] matrica) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				matricaPolja[i][j].setText("");
			}
		}


		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (matrica[i][j].isZakljucano()) {
					matricaPolja[i][j].setText(matrica[i][j].getGenerisanaVrednost() + "");
				} else if(matrica[i][j].getUnesenaVrednost() != 0) {
					matricaPolja[i][j].setText(matrica[i][j].getUnesenaVrednost() + "");
				}
			}
		}
	}

	public static boolean proveraSudokua(GeneratorProvera gen){
		//red
		for (int red = 0; red < 9; red++)
			for (int i = 0; i < 9; i++)
				for (int j = 0; j < 9; j++)
					if(i!=j && gen.getMatrica()[red][i].vratiBroj() == gen.getMatrica()[red][j].vratiBroj())
						return false;
		
		//kolona
		for (int kolona = 0; kolona < 9; kolona++)
			for (int i = 0; i < 9; i++)
				for (int j = 0; j < 9; j++)
					if(i!=j && gen.getMatrica()[i][kolona].vratiBroj() == gen.getMatrica()[j][kolona].vratiBroj())
						return false;
		
		//kvadrat
		for (int kvadrat = 0; kvadrat < 9; kvadrat++)
			switch (kvadrat) {
			case 1: return proveriKvadrat(gen, 0, 0);
			case 2: return proveriKvadrat(gen, 3, 0);
			case 3: return proveriKvadrat(gen, 6, 0);
			case 4: return proveriKvadrat(gen, 0, 3);
			case 5: return proveriKvadrat(gen, 3, 3);
			case 6: return proveriKvadrat(gen, 6, 3);
			case 7: return proveriKvadrat(gen, 0, 6);
			case 8: return proveriKvadrat(gen, 3, 6);
			case 9: return proveriKvadrat(gen, 6, 6);
			default:
				break;
			}
		
		return true;
	}
	
	private static boolean proveriKvadrat(GeneratorProvera gen, int minX, int minY) {
		for (int red = minY; red < minY + 3; red++) {
			for (int kolona = minX; kolona < minX + 3; kolona++) {
				for (int i = minY; i < minY + 3; i++) {
					for (int j = minX; j < minX + 3; j++) {
						if(i != red && j != kolona && gen.getMatrica()[red][kolona].vratiBroj() == gen.getMatrica()[i][j].vratiBroj()) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
}
