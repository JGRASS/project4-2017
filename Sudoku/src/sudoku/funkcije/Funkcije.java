package sudoku.funkcije;


import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import sudoku.Igrac;
import sudoku.Polje;
import sudoku.generator.GeneratorProvera;
import sudoku.gui.SudokuMainWindow;

import javax.swing.JTextField;


public class Funkcije {

	public static boolean pauza = true;
	static Random rnd = new Random();
	private static LinkedList<Igrac> igraci = new LinkedList<Igrac>();

	public static void setIgraci(LinkedList<Igrac> igraci) {
		Funkcije.igraci = igraci;
	}

	public static LinkedList<Igrac> getIgraci() {
		return igraci;
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

	public static void newGame(JTextField[][] matricaPolja, GeneratorProvera gen) {

		SudokuMainWindow.sekunde=0;
		SudokuMainWindow.minuti=0;
		SudokuMainWindow.sati=0;
		pause(SudokuMainWindow.tajmer);
		nastavi();

		gen.generisati();

		Funkcije.otkljucajSvaIZakljucajGenerisana(matricaPolja, GeneratorProvera.getMatrica());
		Funkcije.ispisMatriceUInterfejs(matricaPolja, GeneratorProvera.getMatrica());
	}

	public static void save() {

	}

	public static void reset(JTextField[][] matricaPolja, Polje[][] matrica) {
		
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(!matrica[i][j].isZakljucano()){
					matricaPolja[i][j].setText("");
				}
			}
		}
		
	}

	public static void openGame() {

	}

	public static void updateHighScore(Igrac ig) {
		
		if(igraci == null){
			igraci = new LinkedList<Igrac>();
		}
		
		if(igraci.isEmpty()){
			igraci.add(ig);
			return;
		}
		
		for(int i = 0; i < igraci.size(); i++){
			
			if(igraci.get(i).getSati() < ig.getSati())
				continue;
			
			if(igraci.get(i).getMinuti() < ig.getMinuti())
				continue;
			
			if(igraci.get(i).getSekunde() < ig.getSekunde())
				continue;
			
			igraci.add(i, ig);
			return;
		}
		
		igraci.add(ig);
		
		if(igraci.size()==11){
			igraci.removeLast();
			return;
		}
		
	}
	
	public static void highscore(){
		
		
		
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
				else
					return false;
			}
		}

		for (int i = 0; i < 9; i++) {
			int brojac=0;
			for (int j = 0; j < 9; j++) {
				if(gen.uRedu(Integer.parseInt(matricaPolja[i][j].getText()), i) || gen.uKoloni(Integer.parseInt(matricaPolja[i][j].getText()), j) || gen.uKvadratu(Integer.parseInt(matricaPolja[i][j].getText()), i, j)){
					brojac++;
				}


			}
			if(brojac>9){
				return false;
			}
		}

		return true;
	}

}
