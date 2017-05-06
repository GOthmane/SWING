package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import metier.Client;

public class Dao implements IDao {

	@Override
	public void ajouterClient(Client c) {
		
		try {
			// 1-Charger le pilote
			Class.forName("com.mysql.jdbc.Driver");
			// 2-Cr�er la connexion
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddclients","root","");
			// 3-Cr�er la requ�te
			// Le SQL recquiert des simples quotes ' => concat�nation pour avoir le bon format
			//PreparedStatement ps = conn.prepareStatement("insert into Client(nom,prenom) VALUES('"+c.getNom()+"','"+c.getPrenom()+"')");
			PreparedStatement ps = conn.prepareStatement("insert into Client(nom,prenom,couleurYeux) VALUES(?, ?, ?)");
			//setString transforme automatiquement une cha�ne de caract�res java en cha�ne de caract�res
			//au sens de sql (cad entre simple quotes)
			ps.setString(1, c.getNom());
			ps.setString(2, c.getPrenom());
			ps.setString(3, c.getCouleurYeux());
			// 4-Ex�cuter la requ�te
			ps.executeUpdate();
			// 5-Pr�senter les r�sultats
			// 6- Fermer la connexion
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//code qui est ex�cut� dans tous les cas
		}
		
	}

	@Override
	public void modifierClient(int id, String nom, String prenom, String couleurYeux) {
		try {
			// 1-Charger le pilote
			Class.forName("com.mysql.jdbc.Driver");
			// 2-Cr�er la connexion
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddclients","root","");
			// 3-Cr�er la requ�te
			// Requ�te param�tr�e � l'aide des ? et des setType
			// l'ordre des num�ros dans les setType correspond � celui des ?
			PreparedStatement ps = conn.prepareStatement("update Client set nom = ? , prenom = ?, couleurYeux = ? where id = ?");
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ps.setString(3, couleurYeux);
			ps.setInt(4, id);
			// 4-Ex�cuter la requ�te
			ps.executeUpdate();
			// 5-Pr�senter les r�sultats
			// 6- Fermer la connexion
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

	@Override
	public void supprimerClient(int id) {
		
		try {
			// 1-Charger le pilote
			Class.forName("com.mysql.jdbc.Driver");
			// 2-Cr�er la connexion
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddclients","root","");
			// 3-Cr�er la requ�te
			PreparedStatement ps = conn.prepareStatement("delete from client where id="+id);
			// 4-Ex�cuter la requ�te
			ps.executeUpdate();
			// 5-Pr�senter les r�sultats
			// 6- Fermer la connexion
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Collection<Client> listerClients() {
		Collection<Client> cl = new ArrayList<Client>();
		try {
			// 1-Charger le pilote
			Class.forName("com.mysql.jdbc.Driver");
			// 2-Cr�er la connexion
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddclients","root","");
			// 3-Cr�er la requ�te
			PreparedStatement ps = conn.prepareStatement("select * from client");
			// 4-Ex�cuter la requ�te
			ResultSet rs = ps.executeQuery();
			// 5-Pr�senter les r�sultats
			while(rs.next())
			{
				Client c = new Client();
				c.setId(rs.getInt("id"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setCouleurYeux(rs.getString("couleurYeux"));
				cl.add(c);
			}
			// 6- Fermer la connexion
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cl;
	}

	@Override
	public Collection<Client> chercherParMC(String mc) {
		Collection<Client> cl = new ArrayList<Client>();
		try {
			// 1-Charger le pilote
			Class.forName("com.mysql.jdbc.Driver");
			// 2-Cr�er la connexion
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddclients","root","");
			// 3-Cr�er la requ�te
			// Probl�me de la casse (minuscule ou majuscule) � traiter dans la couche Presentation
			PreparedStatement ps = conn.prepareStatement("select * from client where nom like ?");
			ps.setString(1, "%"+mc+"%");
			// 4-Ex�cuter la requ�te
			ResultSet rs = ps.executeQuery();
			// 5-Pr�senter les r�sultats
			while(rs.next())
			{
				Client c = new Client();
				c.setId(rs.getInt("id"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setCouleurYeux(rs.getString("couleurYeux"));
				cl.add(c);
			}
			// 6- Fermer la connexion
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cl;
	}

	@Override
	public Client retrouverClient(int id) {
		Client c = new Client();
		try {
			// 1-Charger le pilote
			Class.forName("com.mysql.jdbc.Driver");
			// 2-Cr�er la connexion
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddclients","root","");
			// 3-Cr�er la requ�te
			PreparedStatement ps = conn.prepareStatement("select * from Client where id= ?");
			ps.setInt(1, id);		
			// 4-Ex�cuter la requ�te
			ResultSet rs = ps.executeQuery();
			// 5-Pr�senter les r�sultats
			rs.next();
			c.setId(rs.getInt("id"));
			c.setNom(rs.getString("nom"));
			c.setPrenom(rs.getString("prenom"));
			c.setCouleurYeux(rs.getString("couleurYeux"));
			// 6- Fermer la connexion
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

}
