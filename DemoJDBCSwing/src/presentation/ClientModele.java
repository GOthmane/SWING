package presentation;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import metier.Client;

public class ClientModele extends AbstractTableModel {
	
	// colonnes de la table
	private String[] tableColumnNames = new String[] {"ID", "NOM", "PRENOM", "YEUX"};
	//lignes de la table - une cellule = un tableau de valeurs
	private Vector<String[]> tableValues = new Vector<String[]>();
	
	//Retourne le nombre de colonnes
	@Override
	public int getColumnCount() {
		return tableColumnNames.length;
	}
	
	//Retourne le nombre de lignes
	@Override
	public int getRowCount() {
		return tableValues.size();
	}

	//Retourne une cellule de la table
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return tableValues.get(rowIndex)[columnIndex];
	}
	
	//Retourne le nom de la colonne
	// Attention à bien mettre getColumnName
	public String getColumnName(int column)
	{
		return tableColumnNames[column];
	}
	
	//Remplit le tableau avec les données issues de la bdd
	public void setData(List<Client> clients)
	{
		tableValues = new Vector<String[]>();
		for(Client c : clients)
		{
			tableValues.add(new String[] {String.valueOf(c.getId()),
			c.getNom(),c.getPrenom(),c.getCouleurYeux()});
		}
		// fireTableChanged nécessaire pour mettre à jour dynamiquement
		//l'affichage du tableau
		fireTableChanged(null);
	}
}


