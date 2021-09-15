import java.util.ArrayList;

public class Joueur {
	private String joueur;
	private ArrayList<Carte> paquet = new ArrayList<Carte>();
	
	public Joueur(String joueur, ArrayList<Carte> paquet) {
		this.joueur = joueur;
		this.paquet = paquet;
	}
	
	public void AjouterCarte(Carte carte) {
		this.paquet.add(carte);
	}
	
	public void SupprimerCarte() {
		this.paquet.remove(0);
	}
	
	public String getJoueur() {
		return this.joueur;
	}
	
	public ArrayList<Carte> getPaquet(){
		return this.paquet;
	}
}
