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
	
		Random r = new Random();
		int c=1;
		while (brojGenerisanih <81) {
			brojGenerisanih = 0;
			obrisiMatricu();
			int x=9;

			for (int i = 0; i < 9; i++) {
				if(x<9){break;}
				x=0;
				for (int l = 0; l < 9; l++) {
					int b = r.nextInt(9);
				int brojac = 0;
					while (uRedu(b, i) || uKoloni(b, l) || uKvadratu(b, i, l)) {
						b = 1+r.nextInt(9);
						brojac++;
						if (brojac ==20) {
							c=2;
							
							break;
						}
						c=1;
					}
					if(c==1){
					//if (!uRedu(b, i) && !uKoloni(b, l) && !uKvadratu(b, i, l)) {
						matrica[i][l] = b;
						x++;
						brojGenerisanih++;
					}//}

				}
			}

		}
		napuniMatricuGenerisanih(brojGenerisanih);
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
				if (matrica[i][j] != 0) {
					matricaGenerisanih[0][trenutnaPozicija] = i;
					matricaGenerisanih[1][trenutnaPozicija] = j;
					trenutnaPozicija++;
				}
			}
		}
	}

	public int[][] getMatricaGenerisanih() {
		return matricaGenerisanih;
	}

	public void setMatricaGenerisanih(int[][] matricaGenerisanih) {
		this.matricaGenerisanih = matricaGenerisanih;
	}

	public int getBrojGenerisanih() {
		return brojGenerisanih;
	}

	public void setBrojGenerisanih(int brojGenerisanih) {
		this.brojGenerisanih = brojGenerisanih;
	}
}
