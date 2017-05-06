package presentation;

import java.util.ArrayList;
import java.util.Collection;

import metier.Client;
import service.ClientService;
import service.IClientService;
import service.IClientServiceVip;

public class Lanceur {

	public static void main(String[] args) {
		
		/*
		// déclaration de l'interface
		IClientService s = new ClientService();
		IClientServiceVip sv = new ClientService();
		Client c = new Client();
		Collection<Client> col = new ArrayList<Client>();
		
		//declaration de la classe;
		ClientService cs = new ClientService();
		System.out.println("--------------CLIENT NORMAL-------------------------------");		
		// utilisation de l'interface
		s.direAurevoir();
		s.direBonjour();
		//s.jesuisVip();
		System.out.println("--------------CLIENT VIP---------------------------------");
		sv.direBonjour();
		sv.direAurevoir();
		sv.jesuisVip();
		
		//utilisation de la classe
		/*cs.direAurevoir();
		cs.direBonjour();
		cs.jesuisVip();
		
		
		//ajouter un client
		System.out.println("--------------AJOUTER UN CLIENT---------------------------------");
		c.setNom("tata");c.setPrenom("tete");
		s.ajouterClient(c);
		
		
		
		//supprimer un client
		System.out.println("--------------SUPPRIMER UN CLIENT---------------------------------");
		s.supprimerClient(c);
		
		
		//lister des clients
		System.out.println("--------------AJOUTER UN CLIENT---------------------------------");
		col = s.listerClients();
		for (Client client : col) {
			System.out.println(client);
		}
		
		//modifier un client
		System.out.println("--------------MODIFIER UN CLIENT---------------------------------");
		s.modifierClient(2, "toutou","toutou","bleu");
		
		//lister des clients
		System.out.println("--------------AJOUTER UN CLIENT---------------------------------");
		col = s.listerClients();
		for (Client client : col) {
		 System.out.println(client);
		}
		
		//retrouver un client par son id
		System.out.println("--------------RETROUVER UN CLIENT A PARTIR DE SON ID---------------------------------");
		System.out.println(s.retrouverClient(2));
		
		//supprimer un client
		System.out.println("--------------SUPPRIMER UN CLIENT---------------------------------");
		s.supprimerClient(3);
		
		//chercher un client par mot-cle de nom
		System.out.println("--------------CHERCHER PAR MOT-CLE---------------------------------");
		col=s.chercherParMC("ta");
		for (Client client : col) {
		 System.out.println(client);
		}
		
		//ajouter un client
		System.out.println("--------------AJOUTER UN CLIENT---------------------------------");
		c.setNom("tata");c.setPrenom("tete");c.setCouleurYeux("vert");
		s.ajouterClient(c);
		*/
		
		FenetreAvecOnglets f = new FenetreAvecOnglets("MA FENETRE");
		// Affichage de la fenetre
		f.setVisible(true);
		
	}
	
	 	
}
