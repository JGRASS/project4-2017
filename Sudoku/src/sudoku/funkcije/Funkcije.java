package sudoku.funkcije;

import java.util.Timer;
import java.util.TimerTask;

import sudoku.gui.SudokuMainWindow;

public class Funkcije {
	
	static boolean pauza = true;

	public static void pauziraj(Timer tajmer) {
		if(pauza){
			pause(tajmer);
			pauza = false;
			return;
		}
		nastavi();
		pauza=true;
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
	
	public static void newGame() {
		
		SudokuMainWindow.sekunde=0;
		SudokuMainWindow.minuti=0;
		SudokuMainWindow.sati=0;
		pause(SudokuMainWindow.tajmer);
		nastavi();
		
	}
	
	public static void save() {
		
	}
	
	public static void reset() {
		
	}
	
	public static void openGame() {
		
	}
	
	public static void highScore() {
		
	}
	
	public static void zakljucaj() {
		
	}
	
}
