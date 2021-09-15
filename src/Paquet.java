import java.util.ArrayList;
import java.util.Collections;

public class Paquet {
	private ArrayList<Carte> paquet = new ArrayList<Carte>();
	private String couleurList[] = { "Pique", "Carreau", "Trèfle", "Coeur" };
	private ArrayList<Carte> paquet1 = new ArrayList<Carte>();
	private ArrayList<Carte> paquet2 = new ArrayList<Carte>();

	public Paquet() {
		for(String couleur : couleurList) {
			for(int valeur=2; valeur<=14; valeur++) {
				this.paquet.add(new Carte(couleur, valeur));
			}
		}
		
		//Les deux Jokers : 
		this.paquet.add(new Carte("Rouge", 15));
		this.paquet.add(new Carte("Noir", 15));
	}
	
	
	public void MelangePaquet() {
		Collections.shuffle(this.paquet);
	}
	
	public void DivisePaquet() {
		int i=0;
		for(Carte carte : this.paquet) {
			if(i<this.paquet.size()/2) {
				this.paquet1.add(carte);
			}
			else {
				this.paquet2.add(carte);
			}
			i++;
		}
	}
	
	public ArrayList<Carte> getPaquet() {
		return this.paquet;
	}
	
	public ArrayList<Carte> getPaquet1() {
		return this.paquet1;
	}
	
	public ArrayList<Carte> getPaquet2() {
		return this.paquet2;
	}
	
				
}
