package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import metier.Client;
import service.ClientService;
import service.IClientService;

public class FenetreAvecOnglets extends JFrame {
	
	//liste des composants de l'onglet 1
	// zones de texte
	private JLabel jl1 = new JLabel("Nom");
	private JLabel jl2 = new JLabel("Prénom");
	private JLabel jl3 = new JLabel("Couleur des yeux");
	// zones de saisie de taille 20 caractères
	private JTextField jtf1 = new JTextField (20);
	private JTextField jtf2 = new JTextField (20);
	private JTextField jtf3 = new JTextField (20);
	// bouton
	private JButton jb1 = new JButton("Ajouter");
	
	//liste des composants de l'onglet 2
	private JLabel jl21 = new JLabel("ID");
	private JTextField jtf21 = new JTextField (10);
	private JButton jb21 = new JButton("Supprimer");
	
	//liste des composants de l'onglet 3
	private JLabel jl31 = new JLabel("ID");
	private JLabel jl32 = new JLabel("Nom");
	private JLabel jl33 = new JLabel("Prénom");
	private JLabel jl34 = new JLabel("Couleur des yeux");
	private JTextField jtf31 = new JTextField (10);
	private JTextField jtf32 = new JTextField (20);
	private JTextField jtf33 = new JTextField (20);
	private JTextField jtf34 = new JTextField (20);
	private JButton jb31 = new JButton("Modifier");
	
	//liste des composants de l'onglet 4
	private JScrollPane jsp;
	private JLabel jl41 = new JLabel("Mot clé");
	private JTextField jtf41 = new JTextField(12);
	private JButton jb41 = new JButton("Valider");
	private JTable jTableClients;
	private ClientModele model;
	
	private IClientService service = new ClientService();
	private Client c = new Client();
		
	public FenetreAvecOnglets(String nom) {
		super(nom);
		setSize(800,600);
		// disposition de la fenetre principale
		// ligne par ligne (BorderLayout)
		this.setLayout(new BorderLayout());
		// fermer le processus
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//Déclaration d'un JTabbedPane
		JTabbedPane onglets = new JTabbedPane(SwingConstants.TOP);
		
		//Création de l'onglet 1 AJOUTER
		
		// ajout des 4 lignes (4 containers)
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		// disposition des containers en ligne les uns
		// a la suite des autres
		jp1.setLayout(new FlowLayout());
		jp2.setLayout(new FlowLayout());
		jp3.setLayout(new FlowLayout());
		jp4.setLayout(new FlowLayout());
		// ajout des components au container
		jp1.add(jl1);jp1.add(jtf1);
		jp2.add(jl2);jp2.add(jtf2);
		jp3.add(jl3);jp3.add(jtf3);
		jp4.add(jb1);
		// ajout d'un 5e container pour regrouper les 4 créés
		JPanel jp5 = new JPanel();
		// disposition des containers les uns en dessous
		// des autres
		jp5.setLayout(new BoxLayout(jp5,BoxLayout.Y_AXIS));
		// ajout des components au container
		jp5.add(jp1);jp5.add(jp2);jp5.add(jp3);jp5.add(jp4);
		// ajout du 5e container a l'onglet 1
		JPanel onglet1 = new JPanel();
		onglet1.add(jp5, BorderLayout.NORTH);
		//onglet1.setBackground(Color.blue);
		// ajout de l'onglet1 à onglets
		onglets.addTab("AJOUTER",onglet1);
		
		//Création de l'onglet 2 SUPPRIMER
		
		// ajout de la ligne (1 containers)
		JPanel jp21 = new JPanel();
		// disposition des containers en ligne les uns
		// a la suite des autres
		jp21.setLayout(new FlowLayout());
		// ajout des components au container
		jp21.add(jl21);jp21.add(jtf21);jp21.add(jb21);
		// ajout du container a l'onglet 2
		JPanel onglet2 = new JPanel();
		onglet2.add(jp21, BorderLayout.NORTH);
		// ajout de l'onglet1 à onglets
		onglets.addTab("SUPPRIMER",onglet2);
		
		//Création de l'onglet 3 MODIFIER
		
		// ajout des 4 lignes (4 containers)
		JPanel jp31 = new JPanel();
		JPanel jp32 = new JPanel();
		JPanel jp33 = new JPanel();
		JPanel jp34 = new JPanel();
		JPanel jp35 = new JPanel();
		// disposition des containers en ligne les uns
		// a la suite des autres
		jp31.setLayout(new FlowLayout());
		jp32.setLayout(new FlowLayout());
		jp33.setLayout(new FlowLayout());
		jp34.setLayout(new FlowLayout());
		jp35.setLayout(new FlowLayout());
		// ajout des components au container
		jp31.add(jl31);jp31.add(jtf31);
		jp32.add(jl32);jp32.add(jtf32);
		jp33.add(jl33);jp33.add(jtf33);
		jp34.add(jl34);jp34.add(jtf34);
		jp35.add(jb31);
		// ajout d'un 5e container pour regrouper les 4 créés
		JPanel jp36 = new JPanel();
		// disposition des containers les uns en dessous
		// des autres
		jp36.setLayout(new BoxLayout(jp36,BoxLayout.Y_AXIS));
		// ajout des components au container
		jp36.add(jp31);jp36.add(jp32);jp36.add(jp33);jp36.add(jp34);jp36.add(jp35);
		// ajout du 6e container a l'onglet 3
		JPanel onglet3 = new JPanel();
		onglet3.add(jp36, BorderLayout.NORTH);
		// ajout de l'onglet1 à onglets
		onglets.addTab("MODIFIER",onglet3);
		
		//Création de l'onglet 4 LISTER
		
		// ajout de la ligne (1 containers)
		JPanel jp41 = new JPanel();
		// disposition des containers en ligne les uns
		// a la suite des autres
		jp41.setLayout(new FlowLayout());
		// ajout des components au container
		jp41.add(jl41);jp41.add(jtf41);jp41.add(jb41);
		// disposition de l'onglet 4
		JPanel onglet4 = new JPanel();
		onglet4.setLayout(new BoxLayout(onglet4,BoxLayout.Y_AXIS));
		// ajout du container a l'onglet 4
		onglet4.add(jp41, BorderLayout.NORTH);
		// ajout du tableau
		model = new ClientModele();
		jTableClients = new JTable(model);
		jsp = new JScrollPane(jTableClients);
		onglet4.add(jsp, BorderLayout.CENTER);
		
		// rendre le bouton VALIDER actif en lui donnant une action
		// à réaliser
		jb41.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String mc = jtf41.getText();
				model.setData((List<Client>) service.chercherParMC(mc));
			}
		});
		
		// ajout de l'onglet4 à onglets
		onglets.addTab("LISTER",onglet4);
		
		// ajout des onglets à la fenêtre
		this.add(onglets);
		
		// rendre le bouton AJOUTER actif en lui donnant une action
		// à réaliser
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// récupération des paramètres saisis par l'utilisateur
				String nom = jtf1.getText();
				String prenom = jtf2.getText();
				String couleurYeux = jtf3.getText();
				// appel de la couche service
				c.setNom(nom);
				c.setPrenom(prenom);
				c.setCouleurYeux(couleurYeux);
				service.ajouterClient(c);
				// vider les champs après ajout en base
				jtf1.setText("");
				jtf2.setText("");
				jtf3.setText("");
			}
		});
		
		// rendre le bouton SUPPRIMER actif en lui donnant une action
		// à réaliser
		jb21.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// récupération des paramètres saisis par l'utilisateur
				int id = Integer.parseInt(jtf21.getText());
				// appel de la couche service
				service.supprimerClient(id);
				// vider les champs après ajout en base
				jtf21.setText("");
				}
		});		
		
		// rendre le bouton MODIFIER actif en lui donnant une action
		// à réaliser
		jb31.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// récupération des paramètres saisis par l'utilisateur
				int id = Integer.parseInt(jtf31.getText());
				String nom = jtf32.getText();
				String prenom = jtf33.getText();
				String couleurYeux = jtf34.getText();
				// appel de la couche service
				service.modifierClient(id, nom, prenom,couleurYeux);
				// vider les champs après ajout en base
				jtf31.setText("");
				jtf32.setText("");
				jtf33.setText("");
				jtf34.setText("");
			}
		});
		
	}

}
