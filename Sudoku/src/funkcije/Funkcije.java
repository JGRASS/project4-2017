package funkcije;

public class Funkcije {
	
	static boolean pauza = true;

	public static void pauziraj() {
		if(pauza){
			stopiraj();
			pauza = false;
			return;
		}
		nastavi();
		pauza=true;
	}
	
	public static void stopiraj(){
		System.out.println("RADIIII!!!");
	};
	
	public static void nastavi(){
		
	}
	
	public static void newGame(){
		
	}
	
	public static void save(){
		
	}
	
	public static void pause(){
		
	}
	
	public static void reset(){
		
	}
	
	public static void openGame(){
		
	}
	
	public static void highScore(){
		
	}
	
	
	
}
