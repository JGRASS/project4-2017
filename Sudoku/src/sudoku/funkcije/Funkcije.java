package sudoku.funkcije;


import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import sudoku.Polje;
import sudoku.generator.GeneratorProvera;
import sudoku.gui.SudokuMainWindow;

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
	
	public static void save() {
		
	}
	
	public static void reset() {
		
	}
	
	public static void openGame() {
		
	}
	
	public static void highScore() {
		
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
					count = 3 + rnd.nextInt(1);
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
				}
			}
		}
	}
	
	public static boolean proveraSudokua(JTextField[][] matricaPolja){
		GeneratorProvera gen = new GeneratorProvera();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(!(matricaPolja[i][j].getText().equals(""))){
				gen.unesiBroj(Integer.parseInt(matricaPolja[i][j].getText()), i, j);
				gen.unesiBrojG(Integer.parseInt(matricaPolja[i][j].getText()), i, j);
			}
				else{return false;
					
				}}
		}
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(gen.uRedu(gen.vratiBroj(i, j), i) || gen.uKoloni(gen.vratiBroj(i, j), j) || gen.uKvadratu(gen.vratiBroj(i, j), i, j)){
					return false;
				}
						
						
		}}
		
		return true;
	}
	
}
