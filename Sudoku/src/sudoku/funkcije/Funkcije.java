package sudoku.funkcije;


import java.util.Random;

import sudoku.Polje;
import sudoku.generator.GeneratorProvera;


public class Funkcije {

	private static Random rnd = new Random();
	

	

	public static void obrisiRandomPolja(Polje[][] matrica) {
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
