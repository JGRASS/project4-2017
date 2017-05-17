package sudoku.funkcije;


import java.util.Random;

import sudoku.Polje;
import sudoku.generator.GeneratorProvera;

/**
 * Klasa koja sadrzi funkcije za brisanje nasumicnih polja i proveru tacnosti sudokua.
 * @author Team4-2017
 *
 */
public class Funkcije {
	/**
	 * instanca klase Random koja sluzi da prilikom poziva vrati nasumican broj.
	 */
	private static Random rnd = new Random();
	

	
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
}
