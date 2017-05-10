package sudoku;

public class Polje {
	
	private int generisanaVrednost = 0;
	private int unesenaVrednost = 0;
	private boolean zakljucano = false;
	
	public Polje() {
	}
	
	public Polje(int generisanaVrednost, int unesenaVrednost, boolean zakljucano) {
		this.generisanaVrednost = generisanaVrednost;
		this.unesenaVrednost = unesenaVrednost;
		this.zakljucano = zakljucano;
	}
	
	public int vratiBroj() {
		if(zakljucano) {
			return generisanaVrednost;
		}
		return unesenaVrednost;
	}
	
	public int getGenerisanaVrednost() {
		return generisanaVrednost;
	}
	public void setGenerisanaVrednost(int generisanaVrednost) {
		this.generisanaVrednost = generisanaVrednost;
	}
	public int getUnesenaVrednost() {
		return unesenaVrednost;
	}
	public void setUnesenaVrednost(int unesenaVrednost) {
		this.unesenaVrednost = unesenaVrednost;
	}
	public boolean isZakljucano() {
		return zakljucano;
	}
	public void setZakljucano(boolean zakljucano) {
		this.zakljucano = zakljucano;
	}

}
