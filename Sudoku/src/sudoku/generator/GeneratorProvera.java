package sudoku.generator;

import java.util.Random;

/**
 * 
 * Klasa koja sadrzi matricu brojeva koji se koriste u trenutnoj igri, metode za
 * upravljanje njome i metodu za generisanje pocetnih vrednosti u novoj igri.
 * 
 * @author Team4-2017
 *
 */

public class GeneratorProvera {

	/**
	 * Matrica svih brojeva koji su generisani ili uneseni od strane igraca.
	 */
	int[][] matrica = new int[9][9];
	
	
	int[][] matricaGenerisanih;
	
	int brojGenerisanih;

	/**
	 * Metoda koja proverava da li zadati broj postoji u istom redu u matrici.
	 * 
	 * @param broj
	 *            predstavlja broj koji se pretrazuje u zadatom redu.
	 * @param red
	 *            predstavlja red na kome se vrsi pretraga.
	 * @return vraca se true ili false u zavisnosti od toga da li je takav broj
	 *         pronadjen ili nije.
	 */
	public boolean uRedu(int broj, int red) {
		for (int i = 0; i < 9; i++) {
			if (matrica[red][i] == broj) {
				return true;
			}
		}
		return false;

	}

	/**
	 * Metoda koja proverava da li zadati broj postoji u istoj koloni u matrici.
	 * 
	 * @param broj
	 *            predstavlja broj koji se pretrazuje u zadatoj koloni.
	 * @param kolona
	 *            predstavlja kolonu na kojoj se vrsi pretraga.
	 * @return vraca se true ili false u zavisnosti od toga da li je takav broj
	 *         pronadjen ili nije.
	 */
	public boolean uKoloni(int broj, int kolona) {
		for (int i = 0; i < 9; i++) {
			if (matrica[i][kolona] == broj) {
				return true;
			}
		}
		return false;

	}

	/**
	 * Metoda koja proverava da li zadati broj postoji u istom kvadaratu u
	 * matrici.
	 * 
	 * @param broj
	 *            predstavlja broj koji se pretrazuje u zadatom kvadratu.
	 * @param red
	 *            predstavlja red u kome se nalazi broj, na osnovu cega se
	 *            odredjuje kom kvadratu pripada.
	 * @param kolona
	 *            predstavlja kolonu u kojoj se nalazi broj, na osnovu cega se
	 *            odredjuje kom kvadratu pripada.
	 * @return vraca se true ili false u zavisnosti od toga da li je takav broj
	 *         pronadjen ili nije.
	 */
	public boolean uKvadratu(int broj, int red, int kolona) {

		if (red < 3) {
			if (kolona < 3) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (matrica[i][j] == broj) {
							return true;
						}

					}
				}
			}
			if (kolona > 2 && kolona < 6) {
				for (int i = 0; i < 3; i++) {
					for (int j = 3; j < 6; j++) {
						if (matrica[i][j] == broj) {
							return true;
						}

					}
				}
			}
			if (kolona > 5) {
				for (int i = 0; i < 3; i++) {
					for (int j = 6; j < 9; j++) {
						if (matrica[i][j] == broj) {
							return true;
						}

					}
				}
			}
		}
		if (red > 2 && red < 6) {
			if (kolona < 3) {
				for (int i = 3; i < 6; i++) {
					for (int j = 0; j < 3; j++) {
						if (matrica[i][j] == broj) {
							return true;
						}

					}
				}
			}
			if (kolona > 2 && kolona < 6) {
				for (int i = 3; i < 6; i++) {
					for (int j = 3; j < 6; j++) {
						if (matrica[i][j] == broj) {
							return true;
						}

					}
				}
			}
			if (kolona > 5) {
				for (int i = 3; i < 6; i++) {
					for (int j = 6; j < 9; j++) {
						if (matrica[i][j] == broj) {
							return true;
						}

					}
				}
			}
		}
		if (red > 5) {
			if (kolona < 3) {
				for (int i = 6; i < 9; i++) {
					for (int j = 0; j < 3; j++) {
						if (matrica[i][j] == broj) {
							return true;
						}

					}
				}
			}
			if (kolona > 2 && kolona < 6) {
				for (int i = 6; i < 9; i++) {
					for (int j = 3; j < 6; j++) {
						if (matrica[i][j] == broj) {
							return true;
						}

					}
				}
			}
			if (kolona > 5) {
				for (int i = 6; i < 9; i++) {
					for (int j = 6; j < 9; j++) {
						if (matrica[i][j] == broj) {
							return true;
						}

					}
				}
			}
		}
		return false;

	}

	/**
	 * Metoda koja generise pocetne vrednosti za sudoku igru.
	 */
	public void generisati() {
		obrisiMatricu();
		brojGenerisanih = 0;
		for (int j = 0; j < 9; j += 3) {
			for (int k = 0; k < 9; k += 3) {
				Random r = new Random();
				int a = 2 + r.nextInt(3);
				int niz[] = new int[a];
				int niz1[] = new int[a];
				int brel = 0;
				for (int i = 0; i < a; i++) {
					niz[brel] = j + r.nextInt(3);
					niz1[brel] = k + r.nextInt(3);
					brel++;
				}
				for (int i = 0; i < a; i++) {
					int b = r.nextInt(9);
					while (uRedu(b, niz[i]) || uKoloni(b, niz1[i]) || uKvadratu(b, niz[i], niz1[i])) {
						b = r.nextInt(9);
					}
					matrica[niz[i]][niz1[i]] = b;
					brojGenerisanih++;

				}
				napuniMatricuGenerisanih(brojGenerisanih);
			}
		}
	}

	/**
	 * Metoda koja za uneti broj i koordinate unosi dati broj na zeljeno mesto u
	 * matrici.
	 * 
	 * @param broj
	 *            predstavlja broj koji je potrebno uneti u matricu.
	 * @param x
	 *            koordinata reda gde treba uneti broj.
	 * @param y
	 *            koordinata kolone gde treba uneti broj;
	 */
	public void unesiBroj(int broj, int x, int y) {
		matrica[x][y] = broj;

	}

	/**
	 * Metoda koja postavlja vrednosti svih clanova matrice na nulu.
	 */
	public void obrisiMatricu() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				matrica[i][j] = 0;
			}
		}
	}

	/**
	 * Metoda koja vraca celokupnu matricu trenutne igre.
	 * 
	 * @return vraca se cela matrica.
	 */
	public int[][] getMatrica() {
		return matrica;
	}

	/**
	 * Metoda kojom se zadata matrica unosi u trenutnu igru.
	 * 
	 * @param matrica
	 *            zeljena matrica koja se unosi u trenutnu igru.
	 */
	public void setMatrica(int[][] matrica) {
		this.matrica = matrica;
	}

	private void napuniMatricuGenerisanih(int brojGenerisanih) {
		int trenutnaPozicija = 0;
		matricaGenerisanih = new int[2][brojGenerisanih];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(matrica[i][j] != 0) {
					matricaGenerisanih[0][trenutnaPozicija] = i;
					matricaGenerisanih[1][trenutnaPozicija] = j;
					trenutnaPozicija++;
				}
			}
		}
	}
}
