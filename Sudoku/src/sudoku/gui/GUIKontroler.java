package sudoku.gui;

import java.awt.EventQueue;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import sudoku.Igra;
import sudoku.Polje;
import sudoku.funkcije.Funkcije;
import sudoku.generator.GeneratorProvera;
import sudoku.scores.Rezultat;
import sudoku.scores.Rezultati;

public class GUIKontroler {

	public static boolean pauza = true;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SudokuMainWindow window = new SudokuMainWindow();
					window.frmSudokuGame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void newGame(JTextField[][] matricaPolja, GeneratorProvera gen) {

		SudokuMainWindow.sekunde=0;
		SudokuMainWindow.minuti=0;
		SudokuMainWindow.sati=0;
		GUIKontroler.pause(SudokuMainWindow.tajmer);
		GUIKontroler.nastavi();

		gen.generisati();

		otkljucajSvaIZakljucajGenerisana(matricaPolja, gen.getMatrica());
	}
	
	private static void otkljucajSvaIZakljucajGenerisana(JTextField[][] matricaPolja, Polje[][] matrica) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				matricaPolja[i][j].setEditable(true);
			}
		}

		Funkcije.obrisiRandomPolja(matrica);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(matrica[i][j].isZakljucano()) {
					matricaPolja[i][j].setEditable(false);
				}
			}
		}
	}
	
	public static void reset(Polje[][] matrica) {
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(!matrica[i][j].isZakljucano()){
					matrica[i][j].setUnesenaVrednost(0);
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
	
	public static boolean proveraSudokua(GeneratorProvera gen) {
		return Funkcije.proveraSudokua(gen);
	}
	
	public static Igra openGame(File file) {
		return Igra.deserialize(file);
	}
	
	public static void save(Polje[][] matrica, int sati, int minuti, int sekunde, File file) {
		Igra igra = new Igra(matrica, sati, minuti, sekunde);
		igra.serialize(file);
	}
	
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
}
