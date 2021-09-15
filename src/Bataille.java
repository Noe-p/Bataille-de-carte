import java.util.Scanner;

public class Bataille {
	
	private static Scanner myObj;

	public static String CreatePlayer() {
		myObj = new Scanner(System.in);
		System.out.println("Nom du joueur :");

		String userName = myObj.nextLine();
		
		return userName;
	}
	
	public static void main(String[] args) {
		
		// On créer le paquet :
		Paquet paquet = new Paquet();
	    paquet.MelangePaquet();
	    paquet.DivisePaquet();
	    
	    
	    //On créer les joueurs :
		Joueur joueur1 = new Joueur(CreatePlayer(), paquet.getPaquet1());
		Joueur joueur2 = new Joueur(CreatePlayer(), paquet.getPaquet2());
		
		
		//Début du jeu : 
		boolean fin = false;
		int nbTour=0;
		do {
			
			//Déclaration de variables pour la lisibilité du code :
			int valeurJoueur1 = joueur1.getPaquet().get(0).getValeur();
			int valeurJoueur2 = joueur2.getPaquet().get(0).getValeur();
			
			//Affichage du duel : 
			System.out.println("***** "+joueur1.getJoueur() + " : " + joueur1.getPaquet().get(0).getCarte()
					+ " VS " + joueur2.getJoueur() + " : " + joueur2.getPaquet().get(0).getCarte()+" *****");
			
			
			//On regarde le gagnant du tour, et on lui ajoute les deux premieres carte dans son paquet : 
			if(valeurJoueur1 > valeurJoueur2) {
				System.out.println(joueur1.getJoueur() + " gagne le tour.\n");
				joueur1.AjouterCarte(joueur2.getPaquet().get(0));
				joueur1.AjouterCarte(joueur1.getPaquet().get(0));
			}
			else if(valeurJoueur1 < valeurJoueur2) {
				System.out.println(joueur2.getJoueur() + " gagne le tour.\n");
				joueur2.AjouterCarte(joueur1.getPaquet().get(0));
				joueur2.AjouterCarte(joueur2.getPaquet().get(0));
			}
			else {
				joueur2.AjouterCarte(joueur2.getPaquet().get(0));
				joueur1.AjouterCarte(joueur1.getPaquet().get(0));
			}
			
			//On supprime les cartes : 
			joueur1.SupprimerCarte();
			joueur2.SupprimerCarte();
			
			
			
			//Verification de fin de partie : 
			if(joueur1.getPaquet().size() == 0) {
				System.out.println(joueur2.getJoueur() + " à gagné la partie en "+nbTour+" tours !");
				fin = true;
			}
			if(joueur2.getPaquet().size() == 0){
				System.out.println(joueur1.getJoueur() + " à gagné la partie en "+nbTour+" tours !");
				fin = true;
			}
			nbTour++;
		} while(!fin);
		
	}

}
