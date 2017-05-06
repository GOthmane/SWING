package presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Fenetre extends JFrame {
	
	// liste des composants de ma fenetre
	
	// zone de texte "Récepteur"
	private JLabel jl = new JLabel("Récepteur");
	// zone de saisie de taille 12 caractères
	private JTextField jtf1 = new JTextField (12);
	// boutons 
	public JButton jb1 = new JButton("ajouter");
	public JButton jb2 = new JButton("déplacer");
	public JButton jb3 = new JButton("vider");
	// listes
	private List liste1 = new List();
	private List liste2 = new List();
	
	public Fenetre(String nom) {
		super(nom);
		setSize(800,600);
		// disposition de la fenetre principale
		// ligne par ligne (BorderLayout)
		this.setLayout(new BorderLayout());
		
		// ajout de la premiere ligne (1er container)
		JPanel jp1 = new JPanel();
		// disposition du container en ligne les uns
		// a la suite des autres
		jp1.setLayout(new FlowLayout());
		// ajout des components au container
		jp1.add(jl);jp1.add(jtf1);jp1.add(jb1);jp1.add(jb2);jp1.add(jb3);
		// ajout du container a la fenetre
		this.add(jp1,BorderLayout.NORTH);
		
		JPanel jp2 = new JPanel();
		jp2.setLayout(new GridLayout());
		jp2.add(liste1);jp2.add(liste2);
		this.add(jp2,BorderLayout.CENTER);
		
	}

}
