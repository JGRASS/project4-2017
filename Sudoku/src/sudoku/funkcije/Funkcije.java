package sudoku.funkcije;

import javax.swing.JTextField;

public class Funkcije {
	
	static boolean pauza = true;

	public static void pauziraj() {
		if(pauza){
			pause();
			pauza = false;
			return;
		}
		nastavi();
		pauza=true;
	}
	
	public static void pause() {
		
	}
	
	public static void nastavi() {
		
	}
	
	public static void newGame() {
		//TODO ovde pozvati metodu otkljucajSvaIZakljucajGenerisana
	}
	
	public static void save() {
		
	}
	
	public static void reset() {
		
	}
	
	public static void openGame() {
		//TODO ovde pozvati metodu otkljucajSvaIZakljucajGenerisana
	}
	
	public static void highScore() {
		
	}
	
	public static void otkljucajSvaIZakljucajGenerisana(JTextField[][] matricaPolja, int[][] matricaGenerisanih, int brojGenerisanih) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				matricaPolja[i][j].setEnabled(true);
			}
		}
		for (int i = 0; i < brojGenerisanih; i++) {
			matricaPolja[matricaGenerisanih[0][i]][matricaGenerisanih[1][i]].setEnabled(false);
		}
	}
	
	public static void ispisMatriceUInterfejs(JTextField[][] matricaPolja, int[][] matrica) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				matricaPolja[i][j].setText(matrica[i][j] + "");
			}
		}
	}
	
}
