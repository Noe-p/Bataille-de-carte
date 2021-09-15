
public class Carte {
	private int valeur ;
	private String couleur;
	
	public Carte(String couleur, int valeur) {
		this.valeur = valeur;
		this.couleur = couleur;
	}
	
	public int getValeur() {
		return this.valeur;
	}
	
	public String getCarte() {
		switch(this.valeur) {
			case 11 : 
				return "Valet de "+this.couleur;
			
			case 12 :
				return "Dame de "+this.couleur;
			
			case 13 : 
				return "Roi de "+this.couleur;

			case 14 : 
				return "As de "+this.couleur;
				
			case 15 : 
				return "Joker "+this.couleur;

			default : 
				return this.valeur +" de "+ this.couleur;

		}
	}
	
}
