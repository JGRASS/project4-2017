package sudoku.gui;

import java.awt.EventQueue;
import java.io.File;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import sudoku.Igra;
import sudoku.Polje;
import sudoku.generator.GeneratorProvera;
import sudoku.scores.Rezultat;
import sudoku.scores.Rezultati;

/**
 * Klasa koja sadrzi metodu za pokretanje igre
 * i metode koje omogucavaju razne opcije tokom igre.
 * 
 * @author Team4-2017
 */

public class GUIKontroler {

	/**
	 * Promenljiva koja govori da li ce se igra pauzirati ili nece.
	 */
	public static boolean pauza = true;
	
	/**
	 * instanca klase Random koja sluzi da prilikom poziva vrati nasumican broj.
	 */
	private static Random rnd = new Random();
	
	/**
	 * Metoda koja pokrece igru.
	 * @param args
	 */
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
	
	/**
	 * Metoda za pravljenje nove igre.
	 * @param matricaPolja
	 * 						matrica polja u koja se unose generisane vrednosti
	 * 						i zakljucavaju ta ista polja prilikom pokretanja nove igre
	 * 						, dok su ostala prazna i sluze da ih korisnik popuni.
	 * @param gen
	 * 						klasa koja sadrzi matricu brojeva koji se koriste u trenutnoj igri, metode za
	 * 						upravljanje njome i metodu za generisanje pocetnih vrednosti u novoj igri.			
	 */
	public static void newGame(JTextField[][] matricaPolja, GeneratorProvera gen) {

		SudokuMainWindow.sekunde=0;
		SudokuMainWindow.minuti=0;
		SudokuMainWindow.sati=0;
		GUIKontroler.pause(SudokuMainWindow.tajmer);
		GUIKontroler.nastavi();

		gen.generisati();

		GUIKontroler.obrisiRandomPolja(gen.getMatrica());
		otkljucajSvaIZakljucajGenerisana(matricaPolja, gen.getMatrica());
	}
	
	/**
	 * Metoda koja brise nasumicno polja iz matrice.
	 * @param matrica
	 * 					matrica svih brojeva koji su generisani ili uneseni od strane igraca.
	 */
	public static void obrisiRandomPolja(Polje[][] matrica) {
		for (int i = 1; i <= 9; i++) {
			int count;
			switch (i) {
			case 1: 
				count = 2 + rnd.nextInt(2);
				obrisiRandomPoljaUDatomRasponu(count, 0, 0, matrica);
				break;
			case 2:  
				count = 2 + rnd.nextInt(2);
				obrisiRandomPoljaUDatomRasponu(count, 3, 0, matrica);
				break;
			case 3: 
				count = 2 + rnd.nextInt(2);
				obrisiRandomPoljaUDatomRasponu(count, 6, 0, matrica);
				break;
			case 4: 
				count = 2 + rnd.nextInt(2);
				obrisiRandomPoljaUDatomRasponu(count, 0, 3, matrica);
				break;
			case 5: 
				count = 2 + rnd.nextInt(2);
				obrisiRandomPoljaUDatomRasponu(count, 3, 3, matrica);
				break;
			case 6: 
				count = 2 + rnd.nextInt(2);
				obrisiRandomPoljaUDatomRasponu(count, 6, 3, matrica);
				break;
			case 7: 
				count = 2 + rnd.nextInt(2);
				obrisiRandomPoljaUDatomRasponu(count, 0, 6, matrica);
				break;
			case 8: 
				count = 2 + rnd.nextInt(2);
				obrisiRandomPoljaUDatomRasponu(count, 3, 6, matrica);
				break;
			case 9: 
				count = 2 + rnd.nextInt(2);
				obrisiRandomPoljaUDatomRasponu(count, 6, 6, matrica);
				break;
			default:
				break;
			}
		}
	}
	
	/**
	 * Metoda koja brise polja u datom rasponu. Dati raspon se odnosi na kvadrate 3x3 tako da vrednosti minX i minY mogu biti 0, 3 i 6.
	 * 
	 * @param count broj polja koja ce biti obrisana u odredjenom kvadratu
	 * @param minX x koordinata od koje ce poceti nasumicno brisanje (predstavlja pocetak kvadrata na x osi)
	 * @param minY y koordinata od koje ce poceti nasumicno brisanje (predstavlja pocetak kvadrata na y osi)
	 * @param matrica matrica svih brojeva koji su generisani ili uneseni od strane igraca.
	 */
	private static void obrisiRandomPoljaUDatomRasponu(int count, int minX, int minY, Polje[][] matrica) {
		while(count >= 0) {
			int x = minX + rnd.nextInt(3);
			int y = minY + rnd.nextInt(3);
			if(!matrica[x][y].isZakljucano()) {
				matrica[x][y].setZakljucano(true);
				count--;
			}
		}
	}
	
	/**
	 * Metoda koja brise nasumicno odabrane vrednosti iz polja
	 * i stavlja da se u ta polja mogu unositi i menjati vrednosti.
	 * @param matricaPolja
	 * 						matrica polja u koja se unose generisane vrednosti
	 * 						i zakljucavaju ta ista polja prilikom pokretanja nove igre
	 * 						, dok su ostala prazna i sluze da ih korisnik popuni.
	 * @param matrica
	 * 						 matrica svih brojeva koji su generisani ili uneseni od strane igraca.
	 */
	public static void otkljucajSvaIZakljucajGenerisana(JTextField[][] matricaPolja, Polje[][] matrica) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				matricaPolja[i][j].setEditable(true);
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
	
	/**
	 * Metoda koja brise sve vrednosti koje je korisnik uneo.
	 * @param matrica
	 * 	 				matrica svih brojeva koji su generisani ili uneseni od strane igraca.
	 */
	public static void reset(Polje[][] matrica) {
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(!matrica[i][j].isZakljucano()){
					matrica[i][j].setUnesenaVrednost(0);
				}
			}
		}
	}
	
	/**
	 * Metoda koja sluzi za azuriranje liste najboljih igraca.
	 * @param sati
	 * 					broj sati koji je bio potreban za resavanje igre.
	 * @param minuti
	 * 					broj miunta koji je bio potreban za resavanje igre.
	 * @param sekunde
	 * 					broj sekundi koji je bio potreban za resavanje igre.
	 */
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
	
	/**
	 * Metoda koja proverava tacnost sudokua.
	 * @param gen
	 * 				Objekat koji sadrzi matricu brojeva koji se koriste u trenutnoj igri, metode za
	 * 				upravljanje njome i metodu za generisanje pocetnih vrednosti u novoj igri.
	 * @return vraca true ako je resenje dobro, a false ako nije.
	 */
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
	
	/**
	 * Metoda koja proverava da li postoje ponavljana u zadatom kvadratu.
	 * 
	 * @param gen Objekat klase GeneratorProvera koji sadrzi matricu svih generisanih polja
	 * @param minX x koordinata od koje ce poceti nasumicno brisanje (predstavlja pocetak kvadrata na x osi)
	 * @param minY y koordinata od koje ce poceti nasumicno brisanje (predstavlja pocetak kvadrata na y osi)
	 * @return vraca false ukoliko postoje ponavljanja u zadatom kvadratu
	 */
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
	
	/**
	 * Otvara sacuvanu igru iz fajle.
	 * @param file
	 * 				predstavlja fajlu u kojoj se nalazi sacuvana partija.
	 * @return vraca igru koja se nalazi u toj fajli.
	 */
	public static Igra openGame(File file) {
		return Igra.deserialize(file);
	}
	
	/**
	 * Metoda koja sacuvava igru u fajlu.
	 * @param matrica
	 * 					matrica svih brojeva koji su generisani ili uneseni od strane igraca.
	 * @param sati
	 * 					broj sati koji je protekao tokom igre.
	 * @param minuti
	 * 					broj minuta koji je protekao tokom igre.
	 * @param sekunde
	 * 					broj sekundi koji je protekao tokom igre.
	 * @param file
	 * 					predstavlja fajlu u kojoj ce se sacuvati partija.
	 */
	public static void save(Polje[][] matrica, int sati, int minuti, int sekunde, File file) {
		Igra igra = new Igra(matrica, sati, minuti, sekunde);
		igra.serialize(file);
	}
	
	/**
	 * Metoda koja pauzira igru ako je pauza true, a u suprotnom nastavlja igru.
	 * @param tajmer
	 * 				predstavlja tajmer koji prikazuje vreme proteklo tokom igre.
	 */
	public static void pauziraj(Timer tajmer) {
		if(pauza){
			pause(tajmer);
			return;
		}
		nastavi();
	}
	
	/**
	 * Metoda koja zaustavlja tajmer i  menja vrednost pauza u false.
	 * @param tajmer
	 * 				predstavlja tajmer koji prikazuje vreme proteklo tokom igre.
	 */
	public static void pause(Timer tajmer) {
		tajmer.cancel();
		pauza=false;
	}
	
	/**
	 * Metoda koja pravi novi tajmer i nastavlja igru sa istim proteklim vremenom.
	 */
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
