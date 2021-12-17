package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Utilisateur;

public class UtilisteurDao {

	static Connection connection;
	
	
	public static boolean ajouter (Utilisateur utilisateur) {
	
//		utilisateurs.add(utilisateur);
		 connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("INSERT INTO UTILISATEUR (NOM,PRENOM,LOGIN,PASSWORD) VALUES(?,?,?,?)");
			ps.setString(1, utilisateur.getNom());
			ps.setString(2, utilisateur.getPrenom());
			ps.setString(3, utilisateur.getLogin());
			ps.setNString(4, utilisateur.getPassword());
			ps.executeUpdate();
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return true;
	}
	public static ArrayList<Utilisateur> lister(){
		  ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		 connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps= connection.prepareStatement
					("SELECT * FROM UTILISATEUR");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setId(rs.getInt("ID"));
				utilisateur.setNom(rs.getString("NOM"));
				utilisateur.setPrenom(rs.getString("PRENOM"));
				utilisateur.setLogin(rs.getString("LOGIN"));
				utilisateur.setPassword(rs.getString("PASSWORD"));
				utilisateurs.add(utilisateur);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return utilisateurs;
	}
	public static boolean supprimer(int id) {
		 connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("DELETE FROM UTILISATEUR WHERE ID=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return false;
	}
	public static Utilisateur get(int id) {
		Utilisateur utilisateur =null;
		connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps= connection.prepareStatement
					("SELECT * FROM UTILISATEUR WHERE ID=?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				utilisateur= new Utilisateur();
				utilisateur.setNom(rs.getString("NOM"));
				utilisateur.setPrenom(rs.getString("PRENOM"));
				utilisateur.setLogin(rs.getString("LOGIN"));
				utilisateur.setPassword(rs.getString("PASSWORD"));
			}
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		   return utilisateur;	
		
	}
	public static Utilisateur get(String login) {
		  ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
			 connection = SingletonConnection.getConnection();
			try {
				PreparedStatement ps= connection.prepareStatement
						("SELECT * FROM UTILISATEUR");
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					Utilisateur utilisateur = new Utilisateur();
					utilisateur.setId(rs.getInt("ID"));
					utilisateur.setNom(rs.getString("NOM"));
					utilisateur.setPrenom(rs.getString("PRENOM"));
					utilisateur.setLogin(rs.getString("LOGIN"));
					utilisateur.setPassword(rs.getString("PASSWORD"));
					utilisateurs.add(utilisateur);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		Utilisateur utilisateur =null;
		try {
			PreparedStatement ps= connection.prepareStatement
					("SELECT * FROM UTILISATEUR WHERE LOGIN=?");
			ps.setString(1,login);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				utilisateur= new Utilisateur();
				utilisateur.setNom(rs.getString("NOM"));
				utilisateur.setPrenom(rs.getString("PRENOM"));
				utilisateur.setLogin(rs.getString("LOGIN"));
				utilisateur.setPassword(rs.getString("PASSWORD"));
			}
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
			
		for(Utilisateur user: utilisateurs) {
			if(user.getLogin().equals(utilisateur.getLogin())) {
				return user;
			}	
		}
		return null ;
	}
	public static boolean modifier(Utilisateur utilisateur) {
//		for (Utilisateur utilisateur2: utilisateurs) {
//			if(utilisateur2.getId() == utilisateur.getId()) {
//				
//				utilisateur2.setNom(utilisateur.getNom());
//				utilisateur2.setPrenom(utilisateur.getPrenom());
//				utilisateur2.setLogin(utilisateur.getLogin());
//				utilisateur2.setPassword(utilisateur.getPassword());
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("UPDATE UTILISATEUR SET NOM=?,PRENOM=?,LOGIN=?,PASSWORD=? WHERE ID=?");
				ps.setString(1, utilisateur.getNom());
				ps.setString(2, utilisateur.getPrenom());
				ps.setString(3, utilisateur.getLogin());
				ps.setString(4, utilisateur.getPassword());
				ps.setLong(5, utilisateur.getId());
				ps.executeUpdate();
				ps.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return false;
	}
	
}
