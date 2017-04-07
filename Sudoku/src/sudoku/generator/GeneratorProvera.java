package sudoku.generator;

import java.util.Random;

public class GeneratorProvera {
	int [][] matrica = new int [9][9];
	public boolean uRedu(int broj, int red){
		for(int i=0;i<9;i++){
			if(matrica[red][i]==broj){
				return true;
			}
		}
		return false;
		
	}
	
	public boolean uKoloni(int broj, int kolona){
		for(int i=0;i<9;i++){
			if(matrica[i][kolona]==broj){
				return true;
			}
		}
		return false;
		
	}
	public boolean uKvadratu(int broj, int red, int kolona ){
		
		if(red<3){
			if(kolona<3){
				for(int i=0;i<3;i++){
					for(int j=0;j<3;j++){
						if(matrica[i][j]==broj){
							return true;
						}
						
					}
				}
			}
			if(kolona>2 && kolona<6){
				for(int i=0;i<3;i++){
					for(int j=3;j<6;j++){
						if(matrica[i][j]==broj){
							return true;
						}
						
					}
				}
			}
			if(kolona>5){
				for(int i=0;i<3;i++){
					for(int j=6;j<9;j++){
						if(matrica[i][j]==broj){
							return true;
						}
						
					}
				}
			}
		}
		if(red>2 && red<6){
			if(kolona<3){
				for(int i=3;i<6;i++){
					for(int j=0;j<3;j++){
						if(matrica[i][j]==broj){
							return true;
						}
						
					}
				}
			}
			if(kolona>2 && kolona<6){
				for(int i=3;i<6;i++){
					for(int j=3;j<6;j++){
						if(matrica[i][j]==broj){
							return true;
						}
						
					}
				}
			}
			if(kolona>5){
				for(int i=3;i<6;i++){
					for(int j=6;j<9;j++){
						if(matrica[i][j]==broj){
							return true;
						}
						
					}
				}
			}
		}
		if(red>5){
			if(kolona<3){
				for(int i=6;i<9;i++){
					for(int j=0;j<3;j++){
						if(matrica[i][j]==broj){
							return true;
						}
						
					}
				}
			}
			if(kolona>2 && kolona<6){
				for(int i=6;i<9;i++){
					for(int j=3;j<6;j++){
						if(matrica[i][j]==broj){
							return true;
						}
						
					}
				}
			}
			if(kolona>5){
				for(int i=6;i<9;i++){
					for(int j=6;j<9;j++){
						if(matrica[i][j]==broj){
							return true;
						}
						
					}
				}
			}
		}
		return false;
		
	}
	public void generisati(){
		for (int j = 0; j < 9; j+=3) {
			for (int k = 0; k < 9; k+=3) {
			Random r = new Random();
			int a = 2 + r.nextInt(3);
			int niz[] = new int[a];
			int niz1[] = new int[a];
			int brel = 0;
			for (int i = 0; i < a; i++) {
				niz[brel] =j+ r.nextInt(3);
				niz1[brel] = k+r.nextInt(3);
				brel++;
			}
			for (int i = 0; i < a; i++) {
				int b = r.nextInt(9);
				while (uRedu(b, niz[i]) || uKoloni(b, niz1[i]) || uKvadratu(b, niz[i], niz1[i])) {
					b = r.nextInt(9);
				}
				matrica[niz[i]][niz1[i]] = b;

			} 
		}}
	}
	
	public void unesiBroj(int broj, int x, int y){
		matrica[x][y]=broj;
		
	}	
}

