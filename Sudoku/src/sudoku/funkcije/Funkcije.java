package sudoku.funkcije;


import java.util.Timer;
import java.util.TimerTask;

import sudoku.generator.GeneratorProvera;
import sudoku.gui.SudokuMainWindow;

import javax.swing.JTextField;


public class Funkcije {
	
	static boolean pauza = true;

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
		Funkcije.otkljucajSvaIZakljucajGenerisana(matricaPolja, gen.getMatricaGenerisanih(), gen.getBrojGenerisanih());
		Funkcije.ispisMatriceUInterfejs(matricaPolja, gen.getMatrica());
	}
	
	public static void save() {
		
	}
	
	public static void reset() {
		
	}
	
	public static void openGame() {
		
	}
	
	public static void highScore() {
		
	}
	
	public static void otkljucajSvaIZakljucajGenerisana(JTextField[][] matricaPolja, int[][] matricaGenerisanih, int brojGenerisanih) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				matricaPolja[i][j].setEditable(true);
			}
		}
		for (int i = 0; i < brojGenerisanih; i++) {
			matricaPolja[matricaGenerisanih[0][i]][matricaGenerisanih[1][i]].setEditable(false);
		}
	}
	
	public static void ispisMatriceUInterfejs(JTextField[][] matricaPolja, int[][] matrica) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				matricaPolja[i][j].setText("");
			}
		}
		
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (matrica[i][j] != 0) {
					matricaPolja[i][j].setText(matrica[i][j] + "");
				}
			}
		}
	}
	
}