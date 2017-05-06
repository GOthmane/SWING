package presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import metier.Client;
import service.ClientService;
import service.IClientService;

public class FenetreSansOnglets extends JFrame {
	
	// liste des composants de ma fenetre
	
	// zones de texte
	private JLabel jl1 = new JLabel("Nom");
	private JLabel jl2 = new JLabel("Prénom");
	private JLabel jl3 = new JLabel("Couleur des yeux");
	// zones de saisie de taille 20 caractères
	private JTextField jtf1 = new JTextField (20);
	private JTextField jtf2 = new JTextField (20);
	private JTextField jtf3 = new JTextField (20);
	
	private IClientService service = new ClientService();
	private Client c = new Client();
	
	// bouton
	public JButton jb1 = new JButton("Ajouter");
		
	public FenetreSansOnglets(String nom) {
		super(nom);
		setSize(800,600);
		// disposition de la fenetre principale
		// ligne par ligne (BorderLayout)
		this.setLayout(new BorderLayout());
		
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
		// ajout du 5e container a la fenetre
		this.add(jp5,BorderLayout.NORTH);
		
		// rendre le bouton actif en lui donnant une action
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
		
	}

}
