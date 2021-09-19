import java.util.Scanner;

public class Bataille {
	
	private static Scanner myObj;

	public static String CreatePlayer() {
		myObj = new Scanner(System.in);
		System.out.println("Nom du joueur :");

		String userName = myObj.nextLine();
		
		return userName;
	}
	
	public static int Duel(Joueur joueur1, Joueur joueur2, int nbCarte) {
		
		//on verifie que les joueur ont assez de cartes : 
		if(joueur1.getPaquet().size()<nbCarte) {
			System.out.println(joueur1.getJoueur() + "n\'a plus de cartes.");
			return -2;
		}
		if(joueur2.getPaquet().size()<nbCarte) {
			System.out.println(joueur2.getJoueur() + "n\'a plus de cartes.");
			return -1;
		}
		
		
		//Déclaration de variables pour la lisibilité du code :
		int valeurJoueur1 = joueur1.getPaquet().get(nbCarte-1).getValeur();
		int valeurJoueur2 = joueur2.getPaquet().get(nbCarte-1).getValeur();
		
		//Affichage du duel : 
		System.out.println("***** "+joueur1.getJoueur() + " : " + joueur1.getPaquet().get(nbCarte-1).getCarte()
				+ " VS " + joueur2.getJoueur() + " : " + joueur2.getPaquet().get(nbCarte-1).getCarte()+" *****");
		
				
		if(valeurJoueur1 > valeurJoueur2) {
			System.out.println(joueur1.getJoueur() + " gagne le tour. ("+joueur1.getPaquet().size()+"-"+joueur2.getPaquet().size()+")\n");
			
			for(int i=0; i<nbCarte; i++) {
				joueur1.AjouterCarte(joueur2.getPaquet().get(i));
				joueur1.AjouterCarte(joueur1.getPaquet().get(i));
			}
			
		}
		else if(valeurJoueur1 < valeurJoueur2) {
			System.out.println(joueur2.getJoueur() + " gagne le tour. ("+joueur1.getPaquet().size()+"-"+joueur2.getPaquet().size()+")\n");

			for(int i=0; i<nbCarte; i++) {
				joueur2.AjouterCarte(joueur1.getPaquet().get(i));
				joueur2.AjouterCarte(joueur2.getPaquet().get(i));
			}
			
		}
		else {
			System.out.println("Egalite");
			return 1;
		}
		
		//On supprime les cartes : 
		for(int i=0; i<nbCarte; i++) {
			joueur1.SupprimerCarte();
			joueur2.SupprimerCarte();
		}
		
		return 0;
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
		int nbCarte=1;
		
		do {
			int duel = Duel(joueur1, joueur2, nbCarte);
			
			if(duel == 0) {
				nbCarte = 1;
			}
			else if(duel == 1) {
				nbCarte = nbCarte + 2;
			}
			
			//Verification de fin de partie : 
			if(joueur1.getPaquet().size() == 0 || duel == -2) {
				System.out.println(joueur2.getJoueur() + " à gagné la partie en "+nbTour+" tours !");
				fin = true;
			}
			if(joueur2.getPaquet().size() == 0 || duel == -1){
				System.out.println(joueur1.getJoueur() + " à gagné la partie en "+nbTour+" tours !");
				fin = true;
			}
			
			nbTour++;
		} while(!fin);
		
	}

}
